package guru.springframework.msscssm.repository;

import guru.springframework.msscssm.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcelo dos Santos
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
