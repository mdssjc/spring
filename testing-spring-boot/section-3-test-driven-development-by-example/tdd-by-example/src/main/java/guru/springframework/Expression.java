package guru.springframework;

/**
 * @author Marcelo dos Santos
 */
public interface Expression {

    Money reduce(Bank bank, String to);
}
