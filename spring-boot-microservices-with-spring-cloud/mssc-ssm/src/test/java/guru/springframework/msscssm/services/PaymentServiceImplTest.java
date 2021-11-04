package guru.springframework.msscssm.services;

import guru.springframework.msscssm.domain.Payment;
import guru.springframework.msscssm.domain.PaymentEvent;
import guru.springframework.msscssm.domain.PaymentState;
import guru.springframework.msscssm.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService service;

    @Autowired
    PaymentRepository repository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder()
                .amount(new BigDecimal("12.99"))
                .build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = service.newPayment(this.payment);

        System.out.println("Should be NEW");
        System.out.println(savedPayment.getState());

        StateMachine<PaymentState, PaymentEvent> sm = service.preAuth(savedPayment.getId());

        Payment preAuthorizePayment = repository.getOne(savedPayment.getId());

        System.out.println("Should be PRE_AUTH or PRE_AUTH_ERROR");
        System.out.println(sm.getState().getId());

        System.out.println(preAuthorizePayment);
    }

    @Transactional
    @RepeatedTest(10)
    void testAuth() {
        Payment savedPayment = service.newPayment(payment);

        StateMachine<PaymentState, PaymentEvent> preAuthSM = service.preAuth(savedPayment.getId());

        if (preAuthSM.getState().getId() == PaymentState.PRE_AUTH) {
            System.out.println("Payment is Pre Authorized");

            StateMachine<PaymentState, PaymentEvent> authSM = service.authorizePayment(savedPayment.getId());

            System.out.println("Result of Auth: " + authSM.getState().getId());
        } else {
            System.out.println("Payment failed pre-auth...");
        }
    }
}
