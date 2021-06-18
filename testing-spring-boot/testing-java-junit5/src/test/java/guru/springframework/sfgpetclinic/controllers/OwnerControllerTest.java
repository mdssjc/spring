package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

/**
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    Model model;
    @Mock
    BindingResult bindingResult;

    @InjectMocks
    OwnerController controller;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @BeforeEach
    void setUp() {
        given(ownerService.findAllByLastNameLike(stringArgumentCaptor.capture())).willAnswer(invocation -> {
            List<Owner> owners = new ArrayList<>();
            switch (invocation.<String>getArgument(0)) {
                case "%Buck%":
                    owners.add(new Owner(1L, "Joe", "Buck"));
                    return owners;
                case "%DontFindMe%":
                    return owners;
                case "%FindMe%":
                    owners.add(new Owner(1L, "Joe", "Buck"));
                    owners.add(new Owner(2L, "Joe2", "Buck"));
                    return owners;
            }

            throw new RuntimeException("Invalid Argument");
        });
    }

    @Test
    void processFindFormWildcardFound() {
        Owner owner = new Owner(1L, "Joe", "FindMe");
        InOrder inOrder = inOrder(ownerService, model);

        String viewName = controller.processFindForm(owner, bindingResult, model);

        assertThat("%FindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);
        inOrder.verify(ownerService).findAllByLastNameLike(anyString());
        inOrder.verify(model).addAttribute(anyString(), anyList());
    }

    @Test
    void processFindFormWildcardStringAnnotation() {
        Owner owner = new Owner(1L, "Joe", "Buck");

        String viewName = controller.processFindForm(owner, bindingResult, null);

        assertThat("%Buck%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("redirect:/owners/1").isEqualToIgnoringCase(viewName);
    }

    @Test
    void processFindFormWildcardNotFound() {
        Owner owner = new Owner(1L, "Joe", "DontFindMe");

        String viewName = controller.processFindForm(owner, bindingResult, null);

        assertThat("%DontFindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void bindingResultHasErrors() {
        Owner owner = new Owner(1L, "Marcelo", "dos Santos");
        given(bindingResult.hasErrors()).willReturn(true);

        String viewName = controller.processCreationForm(owner, bindingResult);

        assertThat(viewName).isEqualTo("owners/createOrUpdateOwnerForm");
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void bindingResultHasNoErrors() {
        Owner owner = new Owner(5L, "Marcelo", "dos Santos");
        given(bindingResult.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner);

        String viewName = controller.processCreationForm(owner, bindingResult);

        assertThat(viewName).isEqualTo("redirect:/owners/5");
        then(ownerService).should().save(any());
    }
}
