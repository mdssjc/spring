package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

/**
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        given(visitRepository.findAll()).willReturn(
                List.of(
                        new Visit(1L),
                        new Visit(2L),
                        new Visit(3L)));

        Set<Visit> results = service.findAll();

        then(visitRepository).should().findAll();
        assertThat(results).hasSize(3);
    }

    @DisplayName("Find By Id")
    @Test
    void findById() {
        given(visitRepository.findById(1L)).willReturn(Optional.of(new Visit(1L)));

        Visit visit = service.findById(1L);
        Visit visitNull = service.findById(2L);

        then(visitRepository).should(times(2)).findById(anyLong());
        assertThat(visit.getId()).isEqualTo(1L);
        assertThat(visitNull).isNull();
    }

    @DisplayName("Save")
    @Test
    void save() {
        Visit visit = new Visit();
        given(visitRepository.save(any(Visit.class))).willReturn(visit);

        Visit savedVisit = service.save(visit);

        then(visitRepository).should().save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }

    @DisplayName("Delete")
    @Test
    void delete() {
        service.delete(new Visit());

        then(visitRepository).should().delete(any(Visit.class));
    }

    @DisplayName("Delete By Id")
    @Test
    void deleteById() {
        service.deleteById(1L);

        then(visitRepository).should().deleteById(anyLong());
    }
}
