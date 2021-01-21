/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Hafidz Ubaidillah
 */
public class SenderPage extends JFrame{
    
    JPanel content_pane;
    JTextField username_field;
    JTextField email_field;
    JTextField fullname_field;
    
    SenderPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Receiver Page");
        setBounds(10, 10, 1000, 600);
        setResizable(false);
        content_pane = new JPanel();
        content_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(content_pane);
        content_pane.setLayout(null);
        
        JTextField username_field = new JTextField();
        username_field.setText(LoginPage.username_field.getText());
        username_field.setBounds(10, 10, 200, 40);
        username_field.setFont(new Font("Arial", Font.PLAIN, 24));;
        username_field.setAlignmentX(LEFT_ALIGNMENT);
        username_field.setEditable(false);
        content_pane.add(username_field);
    }
    
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                SenderPage f = new SenderPage();
                f.setVisible(true);
            }
        };
        
        EventQueue.invokeLater(runnable);
    }
}
