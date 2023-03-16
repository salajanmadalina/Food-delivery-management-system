package PresentationLayer;

import BusinessLayer.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class EmployeeView implements Observer {
    private static JFrame frame;
    private JButton btnLogOut;
    private JTextArea textArea;
    private DeliveryService deliveryService;

    public EmployeeView(DeliveryService deliveryService, boolean cond){

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1177, 655);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("EMPLOYEE");
        lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 60));
        lblNewLabel.setBounds(376, 34, 342, 69);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("ORDERS");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_2.setBounds(67, 151, 217, 32);
        frame.getContentPane().add(lblNewLabel_2);

       //delservice.get key set to string
        textArea = new JTextArea();
        textArea.setBounds(51, 194, 867, 398);
        textArea.setEditable(false);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogOut.setBounds(971, 337, 149, 51);
        btnLogOut.setBackground(new Color(255, 228, 225));
        frame.getContentPane().add(btnLogOut);

        JScrollPane scrollBar = new JScrollPane(textArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(51, 204, 867, 398);
        frame.getContentPane().add(scrollBar);

        frame.setVisible(cond);
    }

    public void addLogOutListener(ActionListener mal){btnLogOut.addActionListener(mal);}

    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public static JFrame getFrame() {
        return frame;
    }

    @Override
    public void update(Observable o, Object arg) {
        DeliveryService deliveryService = (DeliveryService)o;
        String str = (String)arg;
        textArea.append(str);
    }
}
