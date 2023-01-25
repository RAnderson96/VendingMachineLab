package payment;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CoinReturnTest {

     CoinReturn coinReturn;
     ArrayList<Coin> coins;
     Coin tenP;
     Coin fiftyP;
     Coin onePound;

    @Before
    public void setUp() throws Exception {
        tenP = new Coin(CoinType.COIN10P);
        fiftyP = new Coin(CoinType.COIN50P);
        onePound = new Coin(CoinType.COIN1POUND);
        coins = new ArrayList<>(Arrays.asList(tenP, tenP, tenP, fiftyP, fiftyP, onePound));
        coinReturn = new CoinReturn(coins);
    }

    @Test
    public void coinsReturned() {
        assertEquals(2.30, coinReturn.coinsReturned(), 0.01);
    }

    @Test
    public void canAddCoin() {
        coinReturn.addCoin(fiftyP);
        assertEquals(2.80, coinReturn.coinsReturned(), 0.01);
    }
}