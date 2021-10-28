package guru.sfg.beer.order.service.web.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Marcelo dos Santos
 */
@Getter
@Setter
public class BeerDto {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private String price;
}
