package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    BindingResult bindingResult;

    @InjectMocks
    OwnerController controller;

    @Test
    void bindingResultHasErrors() {
        Owner owner = new Owner(1L, "Marcelo", "dos Santos");
        given(bindingResult.hasErrors()).willReturn(true);

        String viewName = controller.processCreationForm(owner, bindingResult);

        assertThat(viewName).isEqualTo("owners/createOrUpdateOwnerForm");
    }

    @Test
    void bindingResultHasNoErrors() {
        Owner owner = new Owner(5L, "Marcelo", "dos Santos");
        given(bindingResult.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner);

        String viewName = controller.processCreationForm(owner, bindingResult);

        assertThat(viewName).isEqualTo("redirect:/owners/5");
        then(ownerService).should().save(any());
    }
}
