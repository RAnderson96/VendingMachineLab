import products.Product;

import java.util.ArrayList;

public class Drawer {
    private Code code;
    private double price;
    private ArrayList<Product> products;

    public Drawer(Code code, double price, ArrayList<Product> products) {
        this.code = code;
        this.price = price;
        this.products = products;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProductToDrawer(Product product){
        if (products.contains(product)){
            products.add(product);
        }
        else {

            System.out.println("This is not the correct product for this drawer.");
        }
    }


}
