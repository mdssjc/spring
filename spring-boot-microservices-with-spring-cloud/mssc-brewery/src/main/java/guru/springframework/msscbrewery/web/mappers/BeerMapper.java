package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @author Marcelo dos Santos
 */
@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
