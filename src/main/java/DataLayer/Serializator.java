package DataLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class Serializator{

    public static void serialization(DeliveryService deliveryService){

        String filename = "file.ser";
        try
        {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(deliveryService);
            out.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialization(){

        String filename = "file.ser";
        Object obj = null;

        try
        {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            obj = in.readObject();

            in.close();
            file.close();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return obj;
    }
}
