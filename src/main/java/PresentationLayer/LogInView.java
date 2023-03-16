package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Salajan Madalina-Maria
 * @Since: May 18, 2022
 */
public class LogInView {

    private static JFrame frame;
    private JPasswordField passwordField;
    private JTextField userText;
    private JButton btnRegister;
    private JButton btnLogin;

    public LogInView(){
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 153, 153));
        frame.getContentPane().setForeground(new Color(210, 180, 140));
        frame.setBounds(100, 100, 816, 655);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("LOG IN");
        lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 60));
        lblNewLabel.setBounds(315, 56, 210, 69);
        frame.getContentPane().add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(341, 316, 236, 40);
        frame.getContentPane().add(passwordField);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1.setBounds(190, 316, 148, 40);
        frame.getContentPane().add(lblNewLabel_1);

        userText = new JTextField();
        userText.setBounds(341, 246, 236, 40);
        frame.getContentPane().add(userText);
        userText.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("User name:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1_1.setBounds(183, 246, 148, 40);
        frame.getContentPane().add(lblNewLabel_1_1);

        btnLogin = new JButton("Log in");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogin.setBackground(new Color(255, 228, 225));
        btnLogin.setBounds(239, 461, 148, 59);
        frame.getContentPane().add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnRegister.setBackground(new Color(255, 228, 225));
        btnRegister.setBounds(439, 461, 148, 59);
        frame.getContentPane().add(btnRegister);

        frame.setVisible(true);
    }

    public void addRegListener(ActionListener mal){btnRegister.addActionListener(mal);}
    public void addLogListener(ActionListener mal){btnLogin.addActionListener(mal);}

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getUserText() {
        return userText;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public String getUserName(){
        return userText.getText();
    }

    public char[] getUserPass(){
        return passwordField.getPassword();
    }

    public static JFrame getFrame() {
        return frame;
    }
}
