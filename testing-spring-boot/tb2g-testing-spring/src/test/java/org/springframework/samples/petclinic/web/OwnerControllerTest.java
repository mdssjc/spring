package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
class OwnerControllerTest {

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;

    MockMvc mockMvc;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @AfterEach
    void tearDown() {
        reset(clinicService);
    }

    @Test
    void testNewOwnerPostValid() throws Exception {
        mockMvc.perform(post("/owners/new")
                                .param("firstName", "Jimmy")
                                .param("lastName", "Buffet")
                                .param("address", "123 Dual St")
                                .param("city", "Key West")
                                .param("telephone", "1231231234"))
               .andExpect(status().is3xxRedirection());
    }


    @Test
    void testNewOwnerPostNotValid() throws Exception {
        mockMvc.perform(post("/owners/new")
                                .param("firstName", "Jimmy")
                                .param("lastName", "Buffet")
                                .param("city", "Key West"))
               .andExpect(status().isOk())
               .andExpect(model().attributeHasErrors("owner"))
               .andExpect(model().attributeHasFieldErrors("owner", "address"))
               .andExpect(model().attributeHasFieldErrors("owner", "telephone"))
               .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }

    @Test
    void testFindByNameNotFound() throws Exception {
        mockMvc.perform(get("/owners")
                                .param("lastName", "Dont find me!"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/findOwners"));
    }

    @Test
    void testFindByNameNull() throws Exception {
        mockMvc.perform(get("/owners"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/findOwners"));
    }

    @Test
    void testFindByNameFound() throws Exception {
        Owner owner = new Owner();
        owner.setId(1);
        given(clinicService.findOwnerByLastName("buck")).willReturn(List.of(owner));

        mockMvc.perform(get("/owners")
                                .param("lastName", "buck"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/owners/" + owner.getId()));

        then(clinicService).should().findOwnerByLastName(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo("buck");
    }

    @Test
    void testReturnListOfOwners() throws Exception {
        List<Owner> owners = List.of(new Owner(), new Owner());
        given(clinicService.findOwnerByLastName("buck")).willReturn(owners);

        mockMvc.perform(get("/owners")
                                .param("lastName", "buck"))
               .andExpect(status().isOk())
               .andExpect(model().attribute("selections", owners))
               .andExpect(view().name("owners/ownersList"));

        then(clinicService).should().findOwnerByLastName(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo("buck");
    }

    @Test
    void initCreationFormTest() throws Exception {
        mockMvc.perform(get("/owners/new"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("owner"))
               .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }
}
