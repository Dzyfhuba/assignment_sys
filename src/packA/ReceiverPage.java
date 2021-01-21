/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packA;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author ubaid
 */
public class ReceiverPage extends JFrame{
    
    ReceiverPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Receiver Page");
        setBounds(10, 10, 1000, 600);
        setResizable(false);
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
