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
import static org.mockito.Mockito.*;

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
        when(visitRepository.findAll()).thenReturn(
                List.of(
                        new Visit(1L),
                        new Visit(2L),
                        new Visit(3L)));

        Set<Visit> results = service.findAll();

        verify(visitRepository).findAll();
        assertThat(results).hasSize(3);
    }

    @DisplayName("Find By Id")
    @Test
    void findById() {
        when(visitRepository.findById(1L)).thenReturn(Optional.of(new Visit(1L)));

        Visit visit = service.findById(1L);
        Visit visitNull = service.findById(2L);

        verify(visitRepository, times(2)).findById(anyLong());
        assertThat(visit.getId()).isEqualTo(1L);
        assertThat(visitNull).isNull();
    }

    @DisplayName("Save")
    @Test
    void save() {
        Visit visit = new Visit();

        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(visit);

        verify(visitRepository).save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }

    @DisplayName("Delete")
    @Test
    void delete() {
        service.delete(new Visit());

        verify(visitRepository).delete(any(Visit.class));
    }

    @DisplayName("Delete By Id")
    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }
}
