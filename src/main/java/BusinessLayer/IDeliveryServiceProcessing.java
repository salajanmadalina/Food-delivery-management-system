package BusinessLayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public interface IDeliveryServiceProcessing {

    public void importProducts() throws FileNotFoundException;

    public void addProduct(MenuItem i);

    public void deleteProduct(int i);

    public void editProduct(MenuItem i2, int i);

    public Order createOrder(String name);

    public void createBill(Order order);

    public ArrayList<MenuItem> search(String criteria, String s1);

    public void addCompositeProduct(CompositeProduct myProduct);

    public void report1(int start, int end);

    public void report2(int nr);

    public void report3(int minNrOfOrders, int minPrice);

    public void report4(String date);
}
