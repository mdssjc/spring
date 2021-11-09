package guru.sfg.brewery.model.events;

/**
 * @author Marcelo dos Santos
 */
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
