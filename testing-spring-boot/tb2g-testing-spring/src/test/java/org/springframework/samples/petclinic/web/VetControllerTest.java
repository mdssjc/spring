package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    ClinicService service;
    @InjectMocks
    VetController controller;

    @Mock
    Map<String, Object> model;

    List<Vet> vets = new ArrayList<>();

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        vets.add(new Vet());

        given(service.findVets()).willReturn(vets);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testControllerShowVetList() throws Exception {
        mockMvc.perform(get("/vets.html"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("vets"))
               .andExpect(view().name("vets/vetList"));
    }

    @Test
    void testShowVetList() {
        String viewName = controller.showVetList(model);

        then(service).should().findVets();
        then(model).should().put(anyString(), any());
        assertThat(viewName).isEqualTo("vets/vetList");
    }

    @Test
    void testShowResourcesVetList() {
        Vets vets = controller.showResourcesVetList();

        then(service).should().findVets();
        assertThat(vets.getVetList()).hasSize(1);
    }
}
