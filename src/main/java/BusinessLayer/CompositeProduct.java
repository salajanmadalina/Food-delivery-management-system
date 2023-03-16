package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class CompositeProduct extends MenuItem implements Serializable {
    private ArrayList<MenuItem> products = new ArrayList<MenuItem>();
    private float rating = 0;
    private int calories = 0;
    private int protein = 0;
    private int fat = 0;
    private int sodium = 0;
    private int price = 0;
    private int orderNr = 0;

    public CompositeProduct() {super();};
    public CompositeProduct(String name, ArrayList<MenuItem> list){
        super(name);
        for(MenuItem product: products){
            this.rating += product.getRating();
            this.calories += product.getCalories();
            this.protein += product.getProtein();
            this.fat += product.getFat();
            this.sodium += product.getSodium();
            this.price += product.getPrice();
        }
        this.rating = this.rating/products.size();
        this.products = list;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public int getFrequency() {
        return 0;
    }

    public float getRating() {
        float rating = 0.f;

        for(MenuItem product: products){
            rating += product.getRating();
        }

        return rating;
    }

    public int getCalories() {
        int calories = 0;

        for(MenuItem product: products){
            calories += product.getCalories();
        }

        return calories;
    }

    public int getProtein() {
        int protein = 0;

        for(MenuItem product: products){
            protein += product.getProtein();
        }

        return protein;
    }

    public int getFat() {
        int fat = 0;

        for(MenuItem product: products){
            fat += product.getFat();
        }

        return fat;
    }

    public int getSodium() {
        int sodium = 0;

        for(MenuItem product: products){
            sodium += product.getSodium();
        }

        return sodium;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }

    @Override
    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setFrequency(int fre) {

    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    @Override
    public String toString() {
        return "CompositeProduct{" +
                "products=" + products +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                ", orderNr=" + orderNr +
                '}';
    }
}
