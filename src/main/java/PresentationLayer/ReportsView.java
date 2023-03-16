package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class ReportsView {

    private static JFrame frame;
    private JTextField startText;
    private JTextField endText;
    private JTextField nrOfOrdersText;
    private JTextField minPriceText;
    private JTextField dateText;
    private JButton btnBack;
    private JButton btnReport1;
    private JButton btnReport2;
    private JButton btnReport3;
    private JButton btnReport4;
    private JButton btnGenerateAll;
    private JTextField minClientText;

    public ReportsView(){

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 1001, 614);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("REPORTS");
        lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 60));
        lblNewLabel.setBounds(121, 34, 487, 69);
        frame.getContentPane().add(lblNewLabel);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnBack.setBackground(new Color(255, 228, 225));
        btnBack.setBounds(750, 452, 148, 59);
        frame.getContentPane().add(btnBack);

        startText = new JTextField();
        startText.setBounds(172, 167, 148, 42);
        frame.getContentPane().add(startText);
        startText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Start hour:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(34, 167, 148, 42);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("End hour:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1_1.setBounds(34, 234, 148, 42);
        frame.getContentPane().add(lblNewLabel_1_1);

        endText = new JTextField();
        endText.setColumns(10);
        endText.setBounds(172, 234, 148, 42);
        frame.getContentPane().add(endText);

        btnReport1 = new JButton("Report 1");
        btnReport1.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnReport1.setBackground(new Color(255, 228, 225));
        btnReport1.setBounds(460, 180, 148, 59);
        frame.getContentPane().add(btnReport1);

        nrOfOrdersText = new JTextField();
        nrOfOrdersText.setColumns(10);
        nrOfOrdersText.setBounds(172, 307, 148, 42);
        frame.getContentPane().add(nrOfOrdersText);

        JLabel lblNewLabel_1_1_1 = new JLabel("Min for product:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1_1_1.setBounds(10, 307, 161, 42);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        btnReport2 = new JButton("Report 2");
        btnReport2.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnReport2.setBackground(new Color(255, 228, 225));
        btnReport2.setBounds(460, 266, 148, 59);
        frame.getContentPane().add(btnReport2);

        minPriceText = new JTextField();
        minPriceText.setColumns(10);
        minPriceText.setBounds(172, 436, 148, 42);
        frame.getContentPane().add(minPriceText);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Min price:");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1_1_1_1.setBounds(34, 436, 137, 42);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        btnReport3 = new JButton("Report 3");
        btnReport3.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnReport3.setBackground(new Color(255, 228, 225));
        btnReport3.setBounds(465, 360, 148, 59);
        frame.getContentPane().add(btnReport3);

        dateText = new JTextField();
        dateText.setColumns(10);
        dateText.setBounds(172, 492, 148, 42);
        frame.getContentPane().add(dateText);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date:");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1_1_1_1_1.setBounds(34, 486, 137, 42);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1);

        btnReport4 = new JButton("Report 4");
        btnReport4.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnReport4.setBackground(new Color(255, 228, 225));
        btnReport4.setBounds(465, 452, 148, 59);
        frame.getContentPane().add(btnReport4);

        btnGenerateAll = new JButton("Generate all");
        btnGenerateAll.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnGenerateAll.setBackground(new Color(255, 228, 225));
        btnGenerateAll.setBounds(721, 180, 196, 59);
        frame.getContentPane().add(btnGenerateAll);

        minClientText = new JTextField();
        minClientText.setColumns(10);
        minClientText.setBounds(172, 374, 148, 42);
        frame.getContentPane().add(minClientText);

        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Min for client:");
        lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1_1_1_1_2.setBounds(10, 374, 161, 42);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_2);

        frame.setVisible(true);
    }

    public void addBackListener(ActionListener mal){btnBack.addActionListener(mal);}
    public void addRep1Listener(ActionListener mal){btnReport1.addActionListener(mal);}
    public void addRep2Listener(ActionListener mal){btnReport2.addActionListener(mal);}
    public void addRep3Listener(ActionListener mal){btnReport3.addActionListener(mal);}
    public void addRep4Listener(ActionListener mal){btnReport4.addActionListener(mal);}
    public void addGenerateListener(ActionListener mal){btnGenerateAll.addActionListener(mal);}

    public int getStartText() {
        return Integer.parseInt(startText.getText());
    }

    public int getEndText() {
        return Integer.parseInt(endText.getText());
    }

    public int getNrOfOrdersText() {
        return Integer.parseInt(nrOfOrdersText.getText());
    }

    public int getMinPriceText() {
        return Integer.parseInt(minPriceText.getText());
    }

    public int getNrOfClient(){
        return Integer.parseInt(minClientText.getText());
    }

    public JFrame getFrame(){
        return frame;
    }
    public String getDateText() {
        return dateText.getText();
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnReport1() {
        return btnReport1;
    }

    public JButton getBtnReport2() {
        return btnReport2;
    }

    public JButton getBtnReport3() {
        return btnReport3;
    }

    public JButton getBtnReport4() {
        return btnReport4;
    }

    public JButton getBtnGenerateAll() {
        return btnGenerateAll;
    }
}
