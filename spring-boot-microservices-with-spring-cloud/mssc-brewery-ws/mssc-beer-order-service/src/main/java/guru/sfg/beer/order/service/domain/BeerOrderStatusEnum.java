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
    ALLOCATION_PENDING,
    ALLOCATION_EXCEPTION,
    CANCELLED,
    PENDING_INVENTORY,
    READY,
    PICKED_UP,
    DELIVERED,
    DELIVERY_EXCEPTION
}
