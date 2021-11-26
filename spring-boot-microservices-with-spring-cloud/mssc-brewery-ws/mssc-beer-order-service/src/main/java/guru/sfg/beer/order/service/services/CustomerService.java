package guru.sfg.beer.order.service.services;

import guru.sfg.brewery.model.CustomerPagedList;
import org.springframework.data.domain.Pageable;

/**
 * @author Marcelo dos Santos
 */
public interface CustomerService {

    CustomerPagedList listCustomers(Pageable pageable);
}
