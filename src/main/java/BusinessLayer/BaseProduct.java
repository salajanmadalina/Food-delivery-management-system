package BusinessLayer;

import java.io.Serializable;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class BaseProduct extends MenuItem implements Serializable {
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int orderNumber = 0;
    private int frequency;

    public BaseProduct(){
        super();
    }

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price) {
        super(title);
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.frequency = 0;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return getTitle() +
                ", rating:" + rating +
                ", calories:" + calories +
                ", protein:" + protein +
                ", fat:" + fat +
                ", sodium:" + sodium +
                ", price:" + price +
                ", frequency: " + frequency + "\n";
    }
}
