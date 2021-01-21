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
 * @author ubaid
 */
public class ReceiverPage extends JFrame{
    
    JPanel content_pane;
    JTextField username_field;
    JTextField email_field;
    JTextField fullname_field;
    
    ReceiverPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Receiver Page");
        setBounds(10, 10, 1000, 600);
        setResizable(false);
        content_pane = new JPanel();
        content_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(content_pane);
        content_pane.setLayout(null);
        
        JLabel lbl_title = new JLabel("Receiver");
        lbl_title.setForeground(Color.BLACK);
        lbl_title.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lbl_title.setBounds(425, 15, 275, 90);
        content_pane.add(lbl_title);
    }
    
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                RegisterPage f = new RegisterPage();
                f.setVisible(true);
            }
        };
        
        EventQueue.invokeLater(runnable);
    }

}
