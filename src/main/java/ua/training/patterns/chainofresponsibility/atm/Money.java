package ua.training.patterns.chainofresponsibility.atm;

/**
 * <p> The class describes Money which can be granted from AMT.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class Money {
    private int amount;

    Money(int amount) {
        setAmount(amount);
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        if (amount > 0 && amount <= 20_000 && amount%Note.UAH10 == 0) {
            this.amount = amount;
        } else {
            throw new RuntimeException("Cash amount have to be less then 20`000 and divisible by 10");
        }
    }
}
