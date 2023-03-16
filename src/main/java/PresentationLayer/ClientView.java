package PresentationLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class ClientView {
    private static JFrame frame;
    private JTextField conditionText;
    private JButton btnLogOut;
    private JButton btnOrder;
    private JButton btnS;
    private JList list;
    private JComboBox criteriaBox;
    private JButton btnInsert;
    private JButton btnCancel;

    public ClientView(DeliveryService deliveryService){

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1177, 655);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CLIENT");
        lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 60));
        lblNewLabel.setBounds(121, 34, 487, 69);
        frame.getContentPane().add(lblNewLabel);

        btnInsert = new JButton("Select");
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnInsert.setBackground(new Color(255, 228, 225));
        btnInsert.setBounds(976, 249, 148, 59);
        frame.getContentPane().add(btnInsert);

        btnS = new JButton("Search");
        btnS.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnS.setBackground(new Color(255, 228, 225));
        btnS.setBounds(42, 411, 148, 59);
        frame.getContentPane().add(btnS);

        JLabel lblNewLabel_2 = new JLabel("MENU ITEMS");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_2.setBounds(580, 71, 217, 32);
        frame.getContentPane().add(lblNewLabel_2);

        criteriaBox = new JComboBox();
        criteriaBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        criteriaBox.setModel(new DefaultComboBoxModel(new String[] {"name", "protein", "price", "fat", "sodium", "calories", "rating"}));
        criteriaBox.setSelectedIndex(1);
        criteriaBox.setBounds(114, 220, 166, 39);
        frame.getContentPane().add(criteriaBox);

        JLabel lblNewLabel_3 = new JLabel("Criteria:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_3.setBounds(114, 172, 148, 32);
        frame.getContentPane().add(lblNewLabel_3);

        conditionText = new JTextField();
        conditionText.setColumns(10);
        conditionText.setBounds(121, 331, 158, 39);
        frame.getContentPane().add(conditionText);

        JLabel lblNewLabel_3_1 = new JLabel("Condition:");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_3_1.setBounds(121, 291, 148, 32);
        frame.getContentPane().add(lblNewLabel_3_1);

        btnOrder = new JButton("Order");
        btnOrder.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnOrder.setBackground(new Color(255, 228, 225));
        btnOrder.setBounds(976, 374, 148, 59);
        frame.getContentPane().add(btnOrder);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogOut.setBackground(new Color(255, 228, 225));
        btnLogOut.setBounds(121, 518, 148, 59);
        frame.getContentPane().add(btnLogOut);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnCancel.setBackground(new Color(255, 228, 225));
        btnCancel.setBounds(224, 411, 148, 59);
        frame.getContentPane().add(btnCancel);

        String[] myProducts = new String[deliveryService.getProducts().size()];
        int i = 0;
        for(MenuItem item: deliveryService.getProducts()){
            myProducts[i] = item.toString();
            i ++;
        }

        list = new JList(myProducts);
        list.setBounds(459, 114, 479, 479);

        JScrollPane scrollBar = new JScrollPane(list);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(459, 114, 479, 479);
        frame.getContentPane().add(scrollBar);

        frame.setVisible(true);

    }

    public void addLogOutListener(ActionListener mal){btnLogOut.addActionListener(mal);}
    public void addOrderListener(ActionListener mal){btnOrder.addActionListener(mal);}
    public void addSearchListener(ActionListener mal){btnS.addActionListener(mal);}
    public void addInsertListener(ActionListener mal){btnInsert.addActionListener(mal);}
    public void addCancelListener(ActionListener mal){btnCancel.addActionListener(mal);}

    public void modifyJList(ArrayList<MenuItem> items){
        String[] myProducts = new String[items.size()];
        int i = 0;
        for(MenuItem item: items){
            myProducts[i] = item.toString();
            i ++;
        }

        list.setListData(myProducts);
    }

    public String getConditionText() {
        return conditionText.getText();
    }

    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public JButton getBtnOrder() {
        return btnOrder;
    }

    public JButton getBtnS() {
        return btnS;
    }

    public JList getList() {
        return list;
    }

    public JComboBox getCriteriaBox() {
        return criteriaBox;
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }

}
