package payment;

public enum CoinType {

    COIN10P(0.10),
    COIN20P(0.20),
    COIN50P(0.50),
    COIN1POUND(1),
    COIN2POUND(2);

    private final double value;

    CoinType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
