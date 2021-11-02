package guru.sfg.common.events;

/**
 * @author Marcelo dos Santos
 */
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
