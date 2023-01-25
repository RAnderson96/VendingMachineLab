import payment.Coin;
import payment.CoinType;

import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Drawer> drawers;
    private ArrayList<Coin> coinsEntered;
    private ArrayList<Coin> coinsReturned;

    private double credit;

    public VendingMachine(ArrayList<Drawer> drawers, ArrayList<Coin> coinsEntered) {
        this.drawers = drawers;
        this.coinsEntered = coinsEntered;
        this.credit = 0.0;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Drawer> getDrawers() {
        return drawers;
    }

    public void setDrawers(ArrayList<Drawer> drawers) {
        this.drawers = drawers;
    }

    public ArrayList<Coin> getCoinsEntered() {
        return coinsEntered;
    }



    public ArrayList<Coin> getCoinsReturned() {
        return coinsReturned;
    }

    public void setCoinsReturned(ArrayList<Coin> coinsReturned) {
        this.coinsReturned = coinsReturned;
    }

    public void addCoinToMachine(Coin coin){
        if (validCoin(coin)){
            this.coinsEntered.add(coin);
            this.credit += coin.getCoinType().getValue();
        }
    }

    public boolean validCoin(Coin coin) {
        boolean coinValid = false;
        CoinType coinTypes[] = CoinType.values();
        for (CoinType coinType: coinTypes){
            if(coinType == coin.getCoinType()){
                coinValid = true;
            }
        }
        return coinValid;

    }

    public String buyProduct(Code code){
        for (Drawer drawer: drawers){
            if(code == drawer.getCode() && drawer.getPrice() <= this.credit && drawer.getProducts().size() != 0){
                vendProduct(drawer);
                return "Payment received";
            }
            else {
                giveRefund(credit);
                return "Refund given";
            }
        }
        return "Error";
    }

    private void giveRefund(double credit) {
        this.credit -= credit;
    }

    private String vendProduct(Drawer drawer) {
        drawers.remove(0);
        this.credit = 0;
        return "You bought " + drawer.getProducts().get(0).getName();
    }
}