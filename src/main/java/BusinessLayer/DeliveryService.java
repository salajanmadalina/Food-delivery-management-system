package BusinessLayer;

import DataLayer.CreateBill;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable{

    private ArrayList<MenuItem> products;
    private ArrayList<MenuItem> clientOrder;
    private LinkedHashMap<Order, ArrayList<MenuItem>> orders;
    private ArrayList<User> users;
    private CreateBill myBill = new CreateBill();

    public DeliveryService() {
        this.products = new ArrayList<MenuItem>();
        this.clientOrder = new ArrayList<MenuItem>();
        this.orders = new LinkedHashMap<Order, ArrayList<MenuItem>>();
        this.users = new ArrayList<User>();

        char[] pass = {'a', 'd', 'm', 'i', 'n'};
        User admin = new User("mada@admin", pass);
        users.add(admin);

        char[] pass1 = {'1', '1', '1', '1'};
        User employee1 = new User("bia@employee", pass1);
        users.add(employee1);
    }

    /**
     * @return: void
     * @param: i
     * Aceasta metoda adauga un produs in meniu
     */
    @Override
    public void addProduct(MenuItem i) {
        assert i.getRating() >= 0 : "Rating can not be < 0 !";
        assert i.getCalories() >= 0 : "Calories can not be < 0 !";
        assert i.getFat() >= 0 : "Fat can not be < 0 !";
        assert i.getPrice() >= 0 : "Price can not be < 0 !";
        assert i.getSodium() >= 0 : "Sodium can not be < 0 !";
        assert i.getProtein() >= 0 : "Protein can not be < 0 !";

        ArrayList<MenuItem> list = (ArrayList<MenuItem>) products.stream().filter(e -> e.getCalories() == i.getCalories() && e.getRating() == i.getRating() && i.getFat() == e.getFat() && i.getProtein() == e.getProtein() && i.getPrice() == e.getPrice() && i.getSodium() == e.getSodium() && i.getTitle().equals(e.getTitle())).collect(Collectors.toList());

        if(list.isEmpty())
            products.add(i);

    }

    /**
     * @return: void
     * @param: i
     * Aceasta metoda sterge un produs din meniu
     */
    @Override
    public void deleteProduct(int m) {

        if(m < products.size()){
            products.remove(m);
        }
    }

    /**
     * @return: void
     * @param: i
     * Aceasta metoda adauga produsele din .csv in lista de produse, adica meniu
     */
    @Override
    public void importProducts() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\UTCN\\ANUL 2\\SEM 2\\TP\\Lab\\New folder\\PT2022_302210_Salajan_Madalina_Assignment_4\\src\\main\\resources\\products.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        try {
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(line != null){
            String[] values = line.split(",");
            String title = values[0];
            float rating = Float.parseFloat(values[1]);
            int calories = Integer.parseInt(values[2]);
            int protein = Integer.parseInt(values[3]);
            int fat = Integer.parseInt(values[4]);
            int sodium = Integer.parseInt(values[5]);
            int price = Integer.parseInt(values[6]);

            MenuItem item = new BaseProduct(title, rating, calories, protein, fat, sodium, price);
            addProduct(item);

            try {
                if((line = bufferedReader.readLine()) == null){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return: void
     * @param: oldItem, newItem
     * Aceasta metoda editeaza un produs din meniu
     */
    @Override
    public void editProduct(MenuItem newItem, int i) {
        products.get(i).setCalories(newItem.getCalories());
        products.get(i).setProtein(newItem.getProtein());
        products.get(i).setFat(newItem.getFat());
        products.get(i).setRating(newItem.getRating());
        products.get(i).setSodium(newItem.getSodium());
        products.get(i).setPrice(newItem.getPrice());
        products.get(i).setTitle(newItem.getTitle());

    }

    /**
     * @return: void
     * @param: order
     * Aceasta metoda creeaza factura pentru o comanda
     */
    @Override
    public void createBill(Order order){
        try {
            FileWriter myWriter = new FileWriter("bill.txt");
            myWriter.write("BILL\nProducts: ");

            for(MenuItem item: clientOrder){
                myWriter.write(item.getTitle() + ", ");
            }

            myWriter.write("\nPrice: " + getOrderPrice() + " RON\n");
            myWriter.write("Order ID: " + order.getOrderID() + "\n");
            myWriter.write("Client ID: " + order.getClientID() + "\n");
            myWriter.write("Date: " + order.getOrderDate());

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return: ArrayList<MenuItem>
     * @param: criteria, condition
     * Aceasta metoda cauta un produs in meniu
     */
    @Override
    public ArrayList<MenuItem> search(String criteria, String condition) {
       ArrayList<MenuItem> foundItems = new ArrayList<>();

       if(criteria.equals("price")){
           char operand = condition.charAt(0);
           int nr = Integer.parseInt(condition.substring(1));
           if(operand == '=')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getPrice() == nr).collect(Collectors.toList());
           if(operand == '<')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getPrice() < nr).collect(Collectors.toList());
           if(operand == '>')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getPrice() > nr).collect(Collectors.toList());

       }
       else if(criteria.equals("protein")){
           char operand = condition.charAt(0);
           int nr = Integer.parseInt(condition.substring(1));
           if(operand == '=')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getProtein() == nr).collect(Collectors.toList());
           if(operand == '<')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getProtein() < nr).collect(Collectors.toList());
           if(operand == '>')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getProtein() > nr).collect(Collectors.toList());
       }
       else if(criteria.equals("sodium")){
           char operand = condition.charAt(0);
           int nr = Integer.parseInt(condition.substring(1));
           if(operand == '=')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getSodium() == nr).collect(Collectors.toList());
           if(operand == '<')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getSodium() < nr).collect(Collectors.toList());
           if(operand == '>')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getSodium() > nr).collect(Collectors.toList());
       }
       else if(criteria.equals("fat")){
           char operand = condition.charAt(0);
           int nr = Integer.parseInt(condition.substring(1));
           if(operand == '=')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getFat() == nr).collect(Collectors.toList());
           if(operand == '<')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getFat() < nr).collect(Collectors.toList());
           if(operand == '>')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getFat() > nr).collect(Collectors.toList());
       }
       else if(criteria.equals("calories")){
           char operand = condition.charAt(0);
           int nr = Integer.parseInt(condition.substring(1));
           if(operand == '=')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getCalories() == nr).collect(Collectors.toList());
           if(operand == '<')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getCalories() < nr).collect(Collectors.toList());
           if(operand == '>')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getCalories() > nr).collect(Collectors.toList());
       }
       else if(criteria.equals("name")){
           foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getTitle().toLowerCase(Locale.ROOT).contains(condition.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
       }
       else if(criteria.equals("rating")){
           char operand = condition.charAt(0);
           int nr = Integer.parseInt(condition.substring(1));
           if(operand == '=')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getRating() == nr).collect(Collectors.toList());
           if(operand == '<')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getRating() < nr).collect(Collectors.toList());
           if(operand == '>')
               foundItems = (ArrayList<MenuItem>)products.stream().filter(e -> e.getRating() > nr).collect(Collectors.toList());

       }
        return foundItems;
    }

    /**
     * @return: void
     * @param: myProduct
     * Aceasta metoda adauga un produs compus in meniu
     */
    @Override
    public void addCompositeProduct(CompositeProduct myProduct) {
        products.add(myProduct);
    }

    /**
     * @return: Order
     * @param: name
     * Aceasta metoda creeaza o comanda si o adauga in lista de comenzi
     */
    @Override
    public Order createOrder(String name) {
        int clientID = getUserID(name);
        incUserFrequency(clientID);

        Date date = new Date();
        Order order = new Order(Order.getNr(), clientID, date, getOrderPrice());

        for(MenuItem item: clientOrder){
            int oldF = item.getFrequency();
            item.setFrequency(oldF + 1);
        }

        orders.put(order, clientOrder);
        createBill(order);

        return order;
    }

    /**
     * @return: void
     * @param: start, end
     * Aceasta metoda creeaza raportul 1
     */
    @Override
    public void report1(int start, int end){
        assert start >= 0 : "Start can not be < 0 !";
        assert end >= 0 : "End can not be < 0 !";
        Date startDate = new Date();
        startDate.setHours(start);

        Date endDate = new Date();
        endDate.setHours(end);

        ArrayList<Order> myOrders = new ArrayList<>();

        myOrders = (ArrayList<Order>) orders.keySet().stream().filter(e -> e.getOrderDate().after(startDate) && e.getOrderDate().before(endDate)).collect(Collectors.toList());

        myBill.createReport1(myOrders);
    }

    /**
     * @return: void
     * @param: minNrOfOrders
     * Aceasta metoda creeaza raportul 2
     */
    @Override
    public void report2(int minNrOfOrders){
        assert minNrOfOrders >= 0 : "The number of times a product has been ordered can not be < 0 !";
        ArrayList<MenuItem> myProducts = new ArrayList<>();

        myProducts = (ArrayList<MenuItem>) products.stream().filter(e -> e.getFrequency() > minNrOfOrders).collect(Collectors.toList());

        myBill.createReport2(myProducts);
    }

    /**
     * @return: void
     * @param: minNrOfOrders, minPrice
     * Aceasta metoda creeaza raportul 3
     */
    @Override
    public void report3(int minNrOfOrders, int minPrice){
        assert minNrOfOrders >= 0 : "The number of times a client placed an order can not be < 0 !";

        ArrayList<User> myUsers = new ArrayList<>();
        ArrayList<User> result = new ArrayList<>();
        ArrayList<Order> myOrders = new ArrayList<>();

        myUsers = (ArrayList<User>)users.stream().filter(e -> e.getFrequency() > minNrOfOrders).collect(Collectors.toList());
        myOrders = (ArrayList<Order>)orders.keySet().stream().filter(e -> e.getPrice() > minPrice).collect(Collectors.toList());

        for(User user1: myUsers){
            for(Order order1: myOrders){
                if(user1.getID() == order1.getClientID() && user1.getID() != 1 && user1.getID() !=2 ){
                    if(!result.contains(user1)){
                        result.add(user1);
                    }
                }
            }
        }

        myBill.createReport3(result);
    }

    /**
     * @return: void
     * @param: myDate
     * Aceasta metoda creeaza raportul 4
     */
    @Override
    public void report4(String myDate){

        String[] values = myDate.split("-");
        int day = Integer.parseInt(values[0]);
        int month = Integer.parseInt(values[1]);
        month --;
        int year = Integer.parseInt(values[2]);
        year -= 1900;
        assert day >= 0 : "Day can not be < 0 !";
        assert day <= 31 : "Day can not be > 31 !";
        assert month >= 0 : "Month can not be < 0 !";
        assert month <= 12 : "Month can not be > 12 !";
        assert year >= 0 : "Year can not be < 0 !";


        Date date = new Date();
        date.setDate(day);
        date.setMonth(month);
        date.setYear(year);

        ArrayList<Order> myOrders = new ArrayList<>();
        myOrders = (ArrayList<Order>)orders.keySet().stream().filter(e -> e.getOrderDate().getDate() == date.getDate() && e.getOrderDate().getMonth() == date.getMonth() && e.getOrderDate().getYear() == date.getYear()).collect(Collectors.toList());
        ArrayList<MenuItem> result = new ArrayList<>();

        for(Map.Entry<Order, ArrayList<MenuItem>> entry: orders.entrySet()){
            for(Order order1: myOrders){
                if(entry.getKey().getOrderID() == order1.getOrderID() && entry.getKey().getClientID() == order1.getClientID()){
                    for(MenuItem item: entry.getValue()){
                        if(!result.contains(item)){
                            result.add(item);
                            //item.toString();
                        }
                    }
                }
            }
        }

        myBill.createReport4(result);
    }

    /**
     * @return: ArrayList<MenuItem>
     * @param:
     * Aceasta metoda returneaza lista de produse din meniu
     */
    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    /**
     * @return: LinkedHashMap<Order, ArrayList<MenuItem>>
     * @param:
     * Aceasta metoda returneaza LinkedHashMap-ul de comenzi
     */
    public LinkedHashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    /**
     * @return: String
     * @param: user
     * Aceasta metoda verifica daca user-ul exista si in caz negativ, este adaugat in lista de useri si ii returneaza rolul
     */
    public String alreadyExists(User user){
        return user.getFunction();
    }

    /**
     * @return: MenuItem
     * @param: i
     * Aceasta metoda returneaza produsul de la indexul dat
     */
    public MenuItem getObjectAtIndex(int i){
        return products.get(i);
    }

    /**
     * @return: void
     * @param: clientOrder
     * Aceasta metoda seteaza lista de produse a unui client, adica comanda
     */
    public void setClientOrder(ArrayList<MenuItem> clientOrder) {
        this.clientOrder = clientOrder;
    }

    /**
     * @return: int
     * @param: name
     * Aceasta metoda returneaza ID-ul userului cu numele dat
     */
    private int getUserID(String name){
        for(User user: users){
            if(user.getName().equals(name)){
                return user.getID();
            }
        }

        return 0;
    }

    /**
     * @return: int
     * @param:
     * Aceasta metoda returneaza pretul unei comenzi abia plasate
     */
    private int getOrderPrice(){
        int sum = 0;

        for(MenuItem item: clientOrder){
            sum += item.getPrice();
        }

        return sum;
    }

    /**
     * @return: void
     * @param: id
     * Aceasta metoda creste frequency-ul unui client pe masura ce acesta adauga comenzi
     */
    private void incUserFrequency(int id){
        for(User user: users){
            if(user.getID() == id){
                int oldNr = user.getFrequency();
                user.setFrequency(oldNr + 1);
                break;
            }
        }
    }

    /**
     * @return: boolean
     * @param: user, pass
     * Aceasta metoda verifica daca exista un user si in caz contrar il creeaza
     */
    public boolean isRegistered(String user, char[] pass){
        for(User user1: users){
            if(user1.getName().equals(user))
                return true;
        }

        users.add(new User(user, pass));
        return false;
    }

    /**
     * @return: boolean
     * @param: user
     * Aceasta metoda verifica daca exista un admin
     */
    public boolean wellForm(String user){
        for(User user1: users){
            if(user1.getFunction().equals("mada@admin"))
                return true;
        }
        return false;
    }

}
