package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */

public class CreateBill implements Serializable {

    public CreateBill(){
        super();
    }

    public void createReport4(ArrayList<MenuItem> result){
        try {
            FileWriter myWriter = new FileWriter("report4.txt");
            myWriter.write("REPORT 4\n");

            for(MenuItem item: result){
                myWriter.write(item.toString() + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createReport3(ArrayList<User> result){
        try {
            FileWriter myWriter = new FileWriter("report3.txt");
            myWriter.write("REPORT 3\n");

            for(User user: result){
                myWriter.write(user.toString() + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createReport2(ArrayList<MenuItem> myProducts){
        try {
            FileWriter myWriter = new FileWriter("report2.txt");
            myWriter.write("REPORT 2\n");

            for(MenuItem item: myProducts){
                myWriter.write(item.toString() + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createReport1(ArrayList<Order> myOrders){
        try {
            FileWriter myWriter = new FileWriter("report1.txt");
            myWriter.write("REPORT 1\n");

            for(Order order: myOrders){
                myWriter.write(order.toString() + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
