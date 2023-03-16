package BusinessLayer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class Order implements Serializable {
    private int orderID;
    private int clientID;
    private Date orderDate;
    private int price;
    private static int nr = 1;

    public Order(int orderID, int clientID, Date date, int price) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.orderDate = date;
        this.price = price;
        nr++;
    }

    @Override
    public int hashCode(){
        return Objects.hash(orderID, clientID, orderDate);
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(getClass() != o.getClass())
            return false;
        if(o == null)
            return false;

        Order order = (Order)o;
        if(orderID == order.orderID && clientID == order.clientID && orderDate.equals(order.orderDate))
            return true;

        return false;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getNr() {
        return nr;
    }

    public static void setNr(int nr) {
        Order.nr = nr;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", orderDate=" + orderDate +
                "}";
    }
}
