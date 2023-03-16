package BusinessLayer;

import java.io.Serializable;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class User implements Serializable {
    private String name;
    private char[] password;
    private static int nr = 1;
    private int ID;
    private int frequency;

    public User(String name, char[] password) {
        this.name = name;
        this.password = password;
        this.ID = nr;
        nr ++;
        this.frequency = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getFunction(){
        if(name.equals("mada@admin"))
            return new String("mada@admin");
        if(name.contains("@employee"))
            return new String("employee");
        return new String("client");
    }

    public int getID() {
        return ID;
    }

    public void setFrequency(int nr) {
        this.frequency = nr;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                "}\n";
    }
}
