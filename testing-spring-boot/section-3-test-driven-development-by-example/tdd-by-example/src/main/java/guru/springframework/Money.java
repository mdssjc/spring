package guru.springframework;

/**
 * @author Marcelo dos Santos
 */
public class Money {

    protected int amount;

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount;
    }
}
