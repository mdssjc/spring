package guru.springframework.msscbeerservice.services.inventory;

import java.util.UUID;

/**
 * @author Marcelo dos Santos
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
