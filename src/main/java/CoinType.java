public enum CoinType {

    COIN10P(10),
    COIN20P(20),
    COIN50P(50),
    COIN1POUND(100),
    COIN2POUND(200);

    private final int value;

    CoinType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
