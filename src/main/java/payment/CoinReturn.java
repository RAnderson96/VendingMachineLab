package payment;

import java.util.ArrayList;

public class CoinReturn {
    private ArrayList<Coin> coins;

    public CoinReturn(ArrayList<Coin> coins) {
        this.coins = coins;
    }

    public double coinsReturned() {
        double coinsTotal = 0;
        for (Coin coin : coins) {
            coinsTotal += coin.getCoinType().getValue();
        }

        return coinsTotal;
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }
}
