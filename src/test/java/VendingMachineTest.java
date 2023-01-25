import org.junit.Before;
import org.junit.Test;
import payment.Coin;
import payment.CoinReturn;
import payment.CoinType;
import products.Crisp;
import products.Drink;
import products.Product;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class VendingMachineTest {

    VendingMachine vendingMachine;
    ArrayList<Coin> coins;
    Coin tenP;
    Coin fiftyP;
    Coin onePound;
    private Drawer drawer1;
    private Drawer drawer2;
    private Crisp crisp;
    private Drink drink;
    private ArrayList<Product> crisps;
    ArrayList<Drawer> drawers;
    ArrayList<Product> drinks;

    @Before
    public void before(){
        tenP = new Coin(CoinType.COIN10P);
        fiftyP = new Coin(CoinType.COIN50P);
        onePound = new Coin(CoinType.COIN1POUND);
        coins = new ArrayList<>(Arrays.asList(tenP, tenP, tenP, fiftyP, fiftyP, onePound));
        crisp = new Crisp("Salted","Walkers");
        drink = new Drink("Diet Coke", "Cola");
        crisps = new ArrayList<>(Arrays.asList(crisp, crisp, crisp));
        drinks = new ArrayList<>(Arrays.asList(drink, drink));
        drawer1 = new Drawer(Code.A1, 1.50, crisps);
        drawer2 = new Drawer(Code.A2, 1.50, drinks);
        drawers = new ArrayList<>(Arrays.asList(drawer1, drawer2));

        vendingMachine = new VendingMachine(drawers, coins);

    }

    @Test
    public void addCoinToMachine() {
        vendingMachine.addCoinToMachine(tenP);
        assertEquals(7, vendingMachine.getCoinsEntered().size());
    }

    @Test
    public void validCoin() {
        assertTrue(vendingMachine.validCoin(tenP));
    }

    @Test
    public void canBuyProduct(){
        vendingMachine.setCredit(2.0);
        assertEquals("Payment received", vendingMachine.buyProduct(Code.A1));
    }

    @Test
    public void cannotBuyProduct(){
        assertEquals("Refund given", vendingMachine.buyProduct(Code.A1));
    }
}