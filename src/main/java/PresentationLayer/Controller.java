package PresentationLayer;

import BusinessLayer.*;
import DataLayer.Serializator;

import javax.swing.*;
import java.util.ArrayList;

public class Controller{
    private LogInView logInView;
    private AdminView adminView;
    private ClientView clientView;
    private EmployeeView employeeView;
    private DeliveryService deliveryService;
    private ReportsView reportsView;
    private ArrayList<MenuItem> newMenu;

    /**
     * @Author: Salajan Madalina-Maria
     * @Since: May 18, 2022
     */
    public Controller(){
        deliveryService = (DeliveryService) Serializator.deserialization();
        //deliveryService = new DeliveryService();
        employeeView = new EmployeeView(deliveryService, false);

        logInView = new LogInView();
        logInView.addLogListener(e->{
            String userName = logInView.getUserName();
            char[] password = logInView.getUserPass();

            //deliveryService.importProducts();

            if(deliveryService.isRegistered(userName, password) == true) {
                if (deliveryService.alreadyExists(new User(userName, password)).equals("mada@admin")) {
                    assert deliveryService.wellForm(userName) == true;
                    adminView = new AdminView(deliveryService);
                    adminView.addInsertListener(e1 -> {
                        BaseProduct product = new BaseProduct(adminView.getNameText(), adminView.getRatingText(), adminView.getCaloriesText(), adminView.getProteinText(), adminView.getFatText(), adminView.getSodiumText(), adminView.getPriceText());
                        deliveryService.addProduct(product);
                        adminView.addIntoJList(deliveryService);
                        Serializator.serialization(deliveryService);
                    });
                    adminView.addDeleteListener(e1 -> {
                        deliveryService.deleteProduct(adminView.getSelectedIndex());
                        adminView.addIntoJList(deliveryService);
                        Serializator.serialization(deliveryService);
                    });
                    adminView.addUpdateListener(e1 -> {
                        BaseProduct product = new BaseProduct(adminView.getNameText(), adminView.getRatingText(), adminView.getCaloriesText(), adminView.getProteinText(), adminView.getFatText(), adminView.getSodiumText(), adminView.getPriceText());
                        deliveryService.editProduct(product, adminView.getSelectedIndex());
                        adminView.addIntoJList(deliveryService);
                        Serializator.serialization(deliveryService);
                    });
                    adminView.addLogOutListener(e1 -> {
                        adminView.getFrame().setVisible(false);
                    });

                    newMenu = new ArrayList<>();
                    adminView.addSelectListener(e1 -> {
                        newMenu.add(deliveryService.getObjectAtIndex(adminView.getSelectedIndex()));
                    });

                    adminView.addCompositeListener(e1 -> {
                        CompositeProduct product = new CompositeProduct(adminView.getMenuNameText(), newMenu);

                        deliveryService.addCompositeProduct(product);
                        newMenu = new ArrayList<>();
                        Serializator.serialization(deliveryService);
                    });

                    adminView.addGenerateRepListener(e1 -> {
                        reportsView = new ReportsView();
                        reportsView.addBackListener(e2 -> {
                            reportsView.getFrame().setVisible(false);
                        });
                        reportsView.addRep1Listener(e2 -> {
                            deliveryService.report1(reportsView.getStartText(), reportsView.getEndText());
                        });
                        reportsView.addRep2Listener(e2 -> {
                            deliveryService.report2(reportsView.getNrOfOrdersText());
                        });
                        reportsView.addRep3Listener(e2 -> {
                            deliveryService.report3(reportsView.getNrOfClient(), reportsView.getMinPriceText());
                        });
                        reportsView.addRep4Listener(e2 -> {
                            deliveryService.report4(reportsView.getDateText());
                        });
                        reportsView.addGenerateListener(e2 -> {
                            deliveryService.report1(reportsView.getStartText(), reportsView.getEndText());
                            deliveryService.report2(reportsView.getNrOfOrdersText());
                            deliveryService.report3(reportsView.getNrOfClient(), reportsView.getMinPriceText());
                            deliveryService.report4(reportsView.getDateText());

                        });
                    });
                } else if (deliveryService.alreadyExists(new User(userName, password)).equals("employee")) {
                    employeeView.getFrame().setVisible(true);
                    employeeView.addLogOutListener(e1 -> {
                        employeeView.getFrame().setVisible(false);
                    });
                } else {
                    clientView = new ClientView(deliveryService);
                    clientView.addLogOutListener(e1 -> {
                        clientView.getFrame().setVisible(false);
                    });

                    clientView.addSearchListener(e1 -> {
                        String str = (String) clientView.getCriteriaBox().getSelectedItem();
                        String condition = clientView.getConditionText();

                        ArrayList<MenuItem> list = new ArrayList<>();
                        list = deliveryService.search(str, condition);
                        clientView.modifyJList(list);
                    });

                    clientView.addCancelListener(e1 -> {
                        clientView.modifyJList(deliveryService.getProducts());
                    });

                    newMenu = new ArrayList<MenuItem>();
                    clientView.addInsertListener(e1 -> {
                        newMenu.add(deliveryService.getObjectAtIndex(clientView.getSelectedIndex()));
                    });

                    clientView.addOrderListener(e1 -> {
                        deliveryService.setClientOrder(newMenu);
                        Order ord = deliveryService.createOrder(userName);

                        String str = ord.toString() + ": " + newMenu.toString() + "\n";
                        employeeView.update(deliveryService, str);

                        newMenu = new ArrayList<MenuItem>();
                        Serializator.serialization(deliveryService);
                    });
                }
            } else{
                JOptionPane.showMessageDialog(logInView.getFrame(), "The user " + userName + " does not exists. Register first!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        logInView.addRegListener(e->{
            String userName = logInView.getUserName();
            char[] password = logInView.getUserPass();

            if(deliveryService.isRegistered(userName, password) == true){
                JOptionPane.showMessageDialog(logInView.getFrame(), "The user " + userName + " already exists!");
            }
            else{
                JOptionPane.showMessageDialog(logInView.getFrame(), "The user " + userName + " was created!");
            }
        });

    }
}
