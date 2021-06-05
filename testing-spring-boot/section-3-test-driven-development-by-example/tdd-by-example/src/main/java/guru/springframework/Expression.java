package guru.springframework;

/**
 * @author Marcelo dos Santos
 */
public interface Expression {

    Expression plus(Expression addend);

    Expression times(int multiplier);

    Money reduce(Bank bank, String to);
}
