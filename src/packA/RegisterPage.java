    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
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
public class RegisterPage extends JFrame{
    private JTextField email_field;
    private JTextField username_field;
    private JPasswordField password_field;
    private JLabel label;
    private JPanel content_pane;
    private JButton btn_submit;
    private JButton btn_to_login_page;
    
    RegisterPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1000, 600);
        setResizable(false);
        content_pane = new JPanel();
        content_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(content_pane);
        content_pane.setLayout(null);
        
        JLabel lbl_title = new JLabel("Register");
        lbl_title.setForeground(Color.BLACK);
        lbl_title.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lbl_title.setBounds(425, 15, 275, 90);
        content_pane.add(lbl_title);
        
        email_field = new JTextField();
        email_field.setFont(new Font("Arial", Font.PLAIN, 32));
        email_field.setBounds(480, 150, 280, 60);
        content_pane.add(email_field);
        
        username_field = new JTextField();
        username_field.setFont(new Font("Arial", Font.PLAIN, 32));
        username_field.setBounds(480, 240, 280, 60);
        content_pane.add(username_field);
        
        password_field = new JPasswordField();
        password_field.setFont(new Font("Arial", Font.PLAIN, 32));
        password_field.setBounds(480, 330, 280, 60);
        content_pane.add(password_field);
        
        JLabel lbl_email = new JLabel("Email");
        lbl_email.setFont(new Font("Arial", Font.PLAIN, 32));
        lbl_email.setBounds(250, 155, 200, 50);
        content_pane.add(lbl_email);
        
        JLabel lbl_username = new JLabel("Username");
        lbl_username.setFont(new Font("Arial", Font.PLAIN, 32));
        lbl_username.setBounds(250, 245, 200, 50);
        content_pane.add(lbl_username);
        
        JLabel lbl_password = new JLabel("Password");
        lbl_password.setFont(new Font("Arial", Font.PLAIN, 32));
        lbl_password.setBounds(250, 335, 200, 50);
        content_pane.add(lbl_password);
        
        btn_submit = new JButton("Submit");
        btn_submit.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_submit.setBounds(565
                , 425, 190, 50);
        content_pane.add(btn_submit);
        
        btn_to_login_page = new JButton("To Login Page");
        btn_to_login_page.setFont(new Font("Arial", Font.BOLD, 12));
        btn_to_login_page.setBounds(5, 5, 120, 40);
        content_pane.add(btn_to_login_page);
    }
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Runnable runnable = new Runnable() {
//            public void run() {
//                RegisterPage f = new RegisterPage();
//                f.setTitle("Register Page");
//
//                f.setVisible(true);
//            }
//        };
//        
//        EventQueue.invokeLater(runnable);
//    }

}
