package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    PetRepository petRepository;
    @InjectMocks
    ClinicServiceImpl service;

    @Test
    void testFindPetTypes() {
        List<PetType> petTypes = new ArrayList<>();
        given(petRepository.findPetTypes()).willReturn(petTypes);

        Collection<PetType> result = service.findPetTypes();

        then(petRepository).should().findPetTypes();
        assertThat(result).isEqualTo(petTypes);
    }
}
