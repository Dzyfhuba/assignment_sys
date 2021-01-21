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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ubaid
 */
public class RegisterPage extends JFrame{
    private JTextField fullname_field;
    private JTextField email_field;
    private JTextField username_field;
    private JPasswordField password_field;
    private JPanel content_pane;
    private JButton btn_submit;
    private JButton btn_to_login_page;
    
    RegisterPage() {
        setTitle("Register Page");
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
        
        fullname_field = new JTextField();
        fullname_field.setFont(new Font("Arial", Font.PLAIN, 24));
        fullname_field.setBounds(480, 150, 280, 40);
        content_pane.add(fullname_field);
        
        email_field = new JTextField();
        email_field.setFont(new Font("Arial", Font.PLAIN, 24));
        email_field.setBounds(480, 210, 280, 40);
        content_pane.add(email_field);
        
        username_field = new JTextField();
        username_field.setFont(new Font("Arial", Font.PLAIN, 24));
        username_field.setBounds(480, 270, 280, 40);
        content_pane.add(username_field);
        
        password_field = new JPasswordField();
        password_field.setFont(new Font("Arial", Font.PLAIN, 24));
        password_field.setBounds(480, 330, 280, 40);
        content_pane.add(password_field);
        
        JLabel lbl_fullname = new JLabel("Nama");
        lbl_fullname.setFont(new Font("Arial", Font.PLAIN, 24));
        lbl_fullname.setBounds(350, 153, 200, 30);
        content_pane.add(lbl_fullname);
        
        JLabel lbl_email = new JLabel("Email");
        lbl_email.setFont(new Font("Arial", Font.PLAIN, 24));
        lbl_email.setBounds(350, 213, 200, 30);
        content_pane.add(lbl_email);
        
        JLabel lbl_username = new JLabel("Username");
        lbl_username.setFont(new Font("Arial", Font.PLAIN, 24));
        lbl_username.setBounds(350, 273, 200, 30);
        content_pane.add(lbl_username);
        
        JLabel lbl_password = new JLabel("Password");
        lbl_password.setFont(new Font("Arial", Font.PLAIN, 24));
        lbl_password.setBounds(350, 333, 200, 30);
        content_pane.add(lbl_password);
        
        JRadioButton opt_sender = new JRadioButton("sender");
        JRadioButton opt_receiver = new JRadioButton("receiver");
        opt_sender.setBounds(900, 20, 100, 40);
        opt_receiver.setBounds(900, 60, 100, 40);
        opt_sender.setSelected(true);
        ButtonGroup bg_opt = new ButtonGroup();
        bg_opt.add(opt_sender); bg_opt.add(opt_receiver);
        content_pane.add(opt_sender); content_pane.add(opt_receiver);
        
        btn_submit = new JButton("Submit");
        btn_submit.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_submit.setBounds(565
                , 425, 190, 50);
        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String fullname = fullname_field.getText();
                String username = username_field.getText();
                String email = email_field.getText();
                String password = new String(password_field.getPassword());
                String role = opt_sender.isSelected() ? "sender" : "receiver";
                
                if (fullname.isBlank() || username.isBlank() || email.isBlank() || (password.length() == 0)) {
                    System.out.println("input invalid");
                } else {
                    User user = new User();
                    user.register(fullname, email, username, password, role);
                    
                    dispose();
                    if (role == "sender") {
                        SenderPage sender_page = new SenderPage();
                        sender_page.setVisible(true);
                    } else if (role == "receiver") {
                        ReceiverPage receiver_page = new ReceiverPage();
                        receiver_page.setVisible(true);
                    }
                }
            }
        });
        content_pane.add(btn_submit);
        
        btn_to_login_page = new JButton("To Login Page");
        btn_to_login_page.setFont(new Font("Arial", Font.BOLD, 12));
        btn_to_login_page.setBounds(5, 5, 120, 40);
        btn_to_login_page.addActionListener((ActionEvent ae) -> {
            dispose();
            LoginPage login_page = new LoginPage();
            login_page.setVisible(true);
        });
        content_pane.add(btn_to_login_page);
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Runnable runnable = () -> {
            RegisterPage f = new RegisterPage();
            
            f.setVisible(true);
        };
        
        EventQueue.invokeLater(runnable);
    }

}
