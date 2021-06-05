package guru.springframework;

/**
 * @author Marcelo dos Santos
 */
public class Bank {

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }
}
