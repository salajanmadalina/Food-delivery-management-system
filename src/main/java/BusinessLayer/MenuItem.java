package BusinessLayer;

import java.io.Serializable;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public abstract class MenuItem implements Serializable {
    private String title;

    public MenuItem(String title){
        this.title = title;
    }

    public MenuItem(){
    }

    public abstract float getRating();
    public abstract int getCalories();
    public abstract int getProtein();
    public abstract int getFat();
    public abstract int getSodium();
    public abstract int getPrice();
    public abstract int getFrequency();

    public abstract void setRating(float rating);
    public abstract void setCalories(int calories);
    public abstract void setProtein(int protein);
    public abstract void setFat(int fat);
    public abstract void setSodium(int sodium);
    public abstract void setPrice(int price);
    public abstract void setFrequency(int fre);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
