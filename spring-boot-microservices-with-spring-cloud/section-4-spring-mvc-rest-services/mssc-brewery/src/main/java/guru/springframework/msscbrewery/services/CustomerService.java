package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * @author Marcelo dos Santos
 */
public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
}
