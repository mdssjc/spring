package guru.springframework;

/**
 * @author Marcelo dos Santos
 */
public interface Expression {

    Expression plus(Expression addend);

    Money reduce(Bank bank, String to);
}
