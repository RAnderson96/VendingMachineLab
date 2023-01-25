import org.junit.Test;
import products.Crisp;
import products.Drink;
import products.Product;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DrawerTest {

    private Drawer drawer;
    private Crisp crisp;
    private Drink drink;
    private ArrayList<Product> crisps;



    @org.junit.Before
    public void setUp() throws Exception {
        crisp = new Crisp("Salted","Walkers");
        crisps = new ArrayList<>(Arrays.asList(crisp, crisp, crisp));
        drawer = new Drawer(Code.A1, 1.50, crisps);
    }

    @org.junit.Test
    public void getCode() {
        assertEquals(Code.A1, drawer.getCode());
    }

    @org.junit.Test
    public void setCode() {
        drawer.setCode(Code.A2);
        assertEquals(Code.A2, drawer.getCode());

    }

    @org.junit.Test
    public void getPrice() {
        assertEquals(1.5, drawer.getPrice(),0.01);

    }

    @org.junit.Test
    public void setPrice() {
        drawer.setPrice(2);
        assertEquals(2, drawer.getPrice(),0.01);
    }

    @org.junit.Test
    public void getProducts() {
        assertEquals(3, drawer.getProducts().size());
    }

    @org.junit.Test
    public void setProducts() {
        drink = new Drink("Diet Coke", "Cola");
        ArrayList<Product> drinks = new ArrayList<>(Arrays.asList(drink));
        drawer.setProducts(drinks);
        assertEquals(1, drawer.getProducts().size());
    }

    @Test
    public void canAddAProductToDrawer(){
        drawer.addProductToDrawer(crisp);
        assertEquals(4, drawer.getProducts().size());

    }
    @Test
    public void cannotAddAProductOfDifferentType(){
        drink = new Drink("Diet Coke", "Cola");

        drawer.addProductToDrawer(drink);
        assertEquals(3, drawer.getProducts().size());

    }
}