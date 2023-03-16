package PresentationLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class AdminView {

    private static JFrame frame;
    private JTextField nameText;
    private JTextField caloriesText;
    private JTextField proteinText;
    private JTextField fatText;
    private JTextField sodiumText;
    private JTextField priceText;
    private JTextField ratingText;
    private JButton btnDelete;
    private JButton btnInsert;
    private JButton btnInsertComposite;
    private JButton btnUpdate;
    private JList list;
    private JButton btnGenerateReports;
    private JButton btnLogOut;
    private JButton select;
    private JTextField menuName;
    private JLabel lblNewLabel_1_7;
    private DeliveryService deliveryService;

    public AdminView(DeliveryService deliveryService) {

        this.deliveryService = deliveryService;

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1177, 655);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("ADMINISTRATOR");
        lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 60));
        lblNewLabel.setBounds(121, 34, 487, 69);
        frame.getContentPane().add(lblNewLabel);

        btnInsert = new JButton("Insert");
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnInsert.setBackground(new Color(255, 228, 225));
        btnInsert.setBounds(353, 165, 148, 59);
        frame.getContentPane().add(btnInsert);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnDelete.setBackground(new Color(255, 228, 225));
        btnDelete.setBounds(353, 249, 148, 59);
        frame.getContentPane().add(btnDelete);

        nameText = new JTextField();
        nameText.setBounds(123, 165, 158, 39);
        frame.getContentPane().add(nameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(34, 165, 96, 39);
        frame.getContentPane().add(lblNewLabel_1);

        ratingText = new JTextField();
        ratingText.setColumns(10);
        ratingText.setBounds(123, 215, 158, 39);
        frame.getContentPane().add(ratingText);

        caloriesText = new JTextField();
        caloriesText.setColumns(10);
        caloriesText.setBounds(123, 265, 158, 39);
        frame.getContentPane().add(caloriesText);

        proteinText = new JTextField();
        proteinText.setColumns(10);
        proteinText.setBounds(123, 315, 158, 39);
        frame.getContentPane().add(proteinText);

        fatText = new JTextField();
        fatText.setColumns(10);
        fatText.setBounds(123, 366, 158, 39);
        frame.getContentPane().add(fatText);

        sodiumText = new JTextField();
        sodiumText.setColumns(10);
        sodiumText.setBounds(123, 416, 158, 39);
        frame.getContentPane().add(sodiumText);

        priceText = new JTextField();
        priceText.setColumns(10);
        priceText.setBounds(123, 466, 158, 39);
        frame.getContentPane().add(priceText);

        JLabel lblNewLabel_1_1 = new JLabel("Rating:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_1.setBounds(34, 215, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Calories:");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_2.setBounds(34, 265, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Protein:");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_3.setBounds(34, 315, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Fat:");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_4.setBounds(34, 366, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Sodium:");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_5.setBounds(34, 416, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("Price:");
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_6.setBounds(34, 466, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_6);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnUpdate.setBackground(new Color(255, 228, 225));
        btnUpdate.setBounds(353, 336, 148, 59);
        frame.getContentPane().add(btnUpdate);

        btnInsertComposite = new JButton("Insert Menu");
        btnInsertComposite.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnInsertComposite.setBackground(new Color(255, 228, 225));
        btnInsertComposite.setBounds(956, 435, 148, 59);
        frame.getContentPane().add(btnInsertComposite);

        String[] myProducts = new String[deliveryService.getProducts().size()];
        int i = 0;
        for(MenuItem item: deliveryService.getProducts()){
            myProducts[i] = item.toString();
            i ++;
        }

        list = new JList(myProducts);
        list.setBounds(569, 197, 315, 394);

        JScrollPane scrollBar = new JScrollPane(list);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(569, 197, 315, 394);
        frame.getContentPane().add(scrollBar);

        JLabel lblNewLabel_2 = new JLabel("MENU ITEMS");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(653, 152, 168, 32);
        frame.getContentPane().add(lblNewLabel_2);

        btnGenerateReports = new JButton("Generate reports");
        btnGenerateReports.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnGenerateReports.setBackground(new Color(255, 228, 225));
        btnGenerateReports.setBounds(907, 314, 233, 69);
        frame.getContentPane().add(btnGenerateReports);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogOut.setBackground(new Color(255, 228, 225));
        btnLogOut.setBounds(353, 499, 148, 59);
        frame.getContentPane().add(btnLogOut);

        select = new JButton("Select");
        select.setFont(new Font("Tahoma", Font.BOLD, 25));
        select.setBackground(new Color(255, 228, 225));
        select.setBounds(353, 416, 148, 59);
        frame.getContentPane().add(select);

        menuName = new JTextField();
        menuName.setColumns(10);
        menuName.setBounds(123, 524, 158, 39);
        frame.getContentPane().add(menuName);

        lblNewLabel_1_7 = new JLabel("Menu:");
        lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1_7.setBounds(34, 524, 96, 39);
        frame.getContentPane().add(lblNewLabel_1_7);

        frame.setVisible(true);
    }

    public void addIntoJList(DeliveryService deliveryService){

        String[] myProducts = new String[deliveryService.getProducts().size()];
        int i = 0;
        for(MenuItem item: deliveryService.getProducts()){
            myProducts[i] = item.toString();
            i ++;
        }

        list.setListData(myProducts);
    }

    public void addLogOutListener(ActionListener mal){btnLogOut.addActionListener(mal);}
    public void addDeleteListener(ActionListener mal){btnDelete.addActionListener(mal);}
    public void addInsertListener(ActionListener mal){btnInsert.addActionListener(mal);}
    public void addUpdateListener(ActionListener mal){btnUpdate.addActionListener(mal);}
    public void addGenerateRepListener(ActionListener mal){btnGenerateReports.addActionListener(mal);}
    public void addSelectListener(ActionListener mal){select.addActionListener(mal);}
    public void addCompositeListener(ActionListener mal){btnInsertComposite.addActionListener(mal);}

    public String getMenuNameText() {
        return menuName.getText();
    }

    public String getNameText() {
        return nameText.getText();
    }

    public int getCaloriesText() {
        return Integer.parseInt(caloriesText.getText());
    }

    public int getProteinText() {
        return Integer.parseInt(proteinText.getText());
    }

    public int getFatText() {
        return Integer.parseInt(fatText.getText());
    }

    public int getSodiumText() {
        return Integer.parseInt(sodiumText.getText());
    }

    public int getPriceText() {
        return Integer.parseInt(priceText.getText());

    }

    public Float getRatingText() {
        return Float.parseFloat(caloriesText.getText());

    }

    public JList getList() {
        return list;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }

}
