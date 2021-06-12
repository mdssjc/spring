package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Marcelo dos Santos
 */
class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Marcelo", "dos Santos", Set.of());
        Vet vet2 = new Vet(2L, "Joe", "Buck", Set.of());

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void testListVets() {
        ModelMapImpl model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat(view).isEqualTo("vets/index");
        Set<Vet> vets = (Set<Vet>) model.getMap().get("vets");
        assertThat(vets).size().isEqualTo(2);
    }
}
