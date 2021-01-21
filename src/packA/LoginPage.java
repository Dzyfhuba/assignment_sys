/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ubaid
 */
public class LoginPage extends JFrame {

    private JTextField username_field;
    private JPasswordField password_field;
    private JPanel content_pane;
    private JButton btn_submit;
    private JButton btn_to_register_page;

    LoginPage() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1000, 600);
        setResizable(false);
        content_pane = new JPanel();
        content_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(content_pane);
        content_pane.setLayout(null);

        JLabel lbl_title = new JLabel("Login");
        lbl_title.setForeground(Color.black);
        lbl_title.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lbl_title.setBounds(425, 15, 275, 90);
        content_pane.add(lbl_title);

        username_field = new JTextField();
        username_field.setFont(new Font("Arial", Font.PLAIN, 32));
        username_field.setBounds(480, 200, 280, 60);
        content_pane.add(username_field);

        password_field = new JPasswordField();
        password_field.setFont(new Font("Arial", Font.PLAIN, 32));
        password_field.setBounds(480, 290, 280, 60);
        content_pane.add(password_field);

        JLabel lbl_username = new JLabel("Username");
        lbl_username.setFont(new Font("Arial", Font.PLAIN, 32));
        lbl_username.setBounds(250, 200, 200, 50);
        content_pane.add((lbl_username));

        JLabel lbl_password = new JLabel("Password");
        lbl_password.setFont(new Font("Arial", Font.PLAIN, 32));
        lbl_password.setBounds(250, 290, 200, 50);
        content_pane.add(lbl_password);

        btn_submit = new JButton("Submit");
        btn_submit.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_submit.setBounds(565,
                 425, 190, 50);
        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = username_field.getText();
                    String password = new String(password_field.getPassword());
                    
                    User user = new User();
                    List list = user.login(username, password);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    dispose();
                    
                    String role = (String) list.get(2);
                    if ("sender".equals(role)) {
                        SenderPage sender_page = new SenderPage();
                        sender_page.setVisible(true);
                    } else if ("receiver".equals(role)) {
                        ReceiverPage receiver_page = new ReceiverPage();
                        receiver_page.setVisible(true);
                    }
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content_pane.add(btn_submit);

        btn_to_register_page = new JButton("To Register Page");
        btn_to_register_page.setFont(new Font("Arial", Font.BOLD, 12));
        btn_to_register_page.setBounds(5, 5, 200, 40);
        btn_to_register_page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                RegisterPage register_page = new RegisterPage();
                register_page.setVisible(true);
            }
        });
        content_pane.add(btn_to_register_page);

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                LoginPage f = new LoginPage();

                f.setVisible(true);
            }
        };

        EventQueue.invokeLater(runnable);
    }

}
