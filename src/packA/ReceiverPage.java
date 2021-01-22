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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubaid
 */
public class ReceiverPage extends JFrame {

    JPanel content_pane;
    JTextField username_field;
    JTextField email_field;
    JTextField fullname_field;

    Dictionary data;
    Config config;

    String[] storage_head = {"No.", "Nama Lengkap", "Username","Nama File", "Waktu Pengumpulan"};;

    ReceiverPage() throws ClassNotFoundException, SQLException {
        config = new Config();

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

        data = new Hashtable();

        JButton btn_refresh = new JButton("Refresh");
        btn_refresh.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        btn_refresh.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String sql = "SELECT * FROM storage";

                    Statement statement = config.conn().createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    while (result.next()) {

//                        for (int idx = 0; idx < arr.length; idx++) {
//                            Object elem = arr[idx];
//                            data.put(, result.getString(i + 1));
//                        }

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ReceiverPage.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        content_pane.add(btn_refresh);

        JTable storage_list = new JTable();
        storage_list.setBounds(10, 10, 800, 400);

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
