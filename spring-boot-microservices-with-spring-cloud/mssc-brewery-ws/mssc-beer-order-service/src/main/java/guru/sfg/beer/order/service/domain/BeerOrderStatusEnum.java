package guru.sfg.beer.order.service.domain;

/**
 * @author Marcelo dos Santos
 */
public enum BeerOrderStatusEnum {
    NEW,
    VALIDATED,
    VALIDATION_PENDING,
    VALIDATION_EXCEPTION,
    ALLOCATED,
    ALLOCATED_PENDING,
    ALLOCATION_EXCEPTION,
    PENDING_INVENTORY,
    READY,
    PICKED_UP,
    DELIVERED,
    DELIVERY_EXCEPTION
}
