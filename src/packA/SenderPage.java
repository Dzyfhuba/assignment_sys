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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Hafidz Ubaidillah
 */
public class SenderPage extends JFrame implements ActionListener {

    JPanel content_pane;
    JTextField username_field;
    JTextField email_field;
    JTextField fullname_field;
    JTextField target_path_field;
    JButton btn_browse_file;
    JTextArea path_list;
    String the_list = "";
    
    Config config;
    
    SenderPage() throws ClassNotFoundException, SQLException {
        config = new Config();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sender Page");
        setBounds(10, 10, 1000, 600);
        setResizable(false);
        content_pane = new JPanel();
        content_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(content_pane);
        content_pane.setLayout(null);

        username_field = new JTextField();
        username_field.setText(LoginPage.username_field.getText());
        username_field.setBounds(10, 10, 200, 40);
        username_field.setFont(new Font("Arial", Font.PLAIN, 24));;
        username_field.setAlignmentX(LEFT_ALIGNMENT);
        username_field.setEditable(false);
        content_pane.add(username_field);

        target_path_field = new JTextField("/target/path.zip");
        target_path_field.setBounds(300, 200, 500, 50);
        target_path_field.setFont(new Font("Arial", Font.PLAIN, 32));
        target_path_field.setEditable(false);
        target_path_field.setDragEnabled(false);
        content_pane.add(target_path_field);

        btn_browse_file = new JButton("Browse");
        btn_browse_file.setBounds(100, 200, 200, 50);
        btn_browse_file.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_browse_file.addActionListener(this);
        content_pane.add(btn_browse_file);

        path_list = new JTextArea();
        path_list.setBounds(200, 300, 500, 200);
        path_list.setBorder(new BasicBorders.ButtonBorder(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
        path_list.setLineWrap(true);
        path_list.setDragEnabled(false);
        content_pane.add(path_list);

        JButton btn_add_to_list = new JButton("Add");
        btn_add_to_list.setBounds(800, 200, 100, 50);
        btn_add_to_list.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_add_to_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                the_list += target_path_field.getText() + ";";
                path_list.setText(the_list);
            }
        });
        content_pane.add(btn_add_to_list);
        
        JButton btn_clear = new JButton("Clear");
        btn_clear.setBounds(800, 300, 100, 50);
        btn_clear.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                the_list = "";
                path_list.setText("");
            }
        });
        content_pane.add(btn_clear);

        JButton btn_send = new JButton("Send");
        btn_send.setBounds(700, 450, 100, 50);
        btn_send.setFont(new Font("Arial", Font.PLAIN, 24));
        btn_send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String get_path_list = path_list.getText();
                String[] file_list = get_path_list.split(";");
                
                File[] f = new File[file_list.length];
                for (int i = 0; i < file_list.length; i++) {
                    try {
                        System.out.println(file_list.length);
                        
                        f[i] = new File(file_list[i]);
                        System.out.println(f[i].getName());
                        upload(f[i]);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(SenderPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
               
            }
        });
        content_pane.add(btn_send);

    }

    void upload(File source) throws IOException, SQLException {
        String storage = "storage/";
        File dest = new File(storage+ username_field.getText() + "_" + source.getName());
        
        Files.copy(source.toPath(), dest.toPath());
        System.out.println(source.getPath() + " uploaded");
        
        String sql = "SELECT username, email, fullname FROM account "
                + "WHERE username = \"" + username_field.getText() + "\"";
        Statement statement = config.conn().createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        int count = 0;
        
        String username = "";
        String email = "";
        String fullname = "";
        String filename = storage + username_field.getText() + "_" + source.getName();
        
        while (result.next()) {
            username += result.getString(1);
            email += result.getString(2);
            fullname += result.getString(3);
        }
        
        String sql2 = "INSERT INTO storage VALUES (NULL, ?, ?, ?, NULL)";
        PreparedStatement statement2 = config.conn().prepareStatement(sql2);
        statement2.setString(1, fullname);
        statement2.setString(2, username);
        statement2.setString(3, filename);
        
        int rowInserted = statement2.executeUpdate();
        if (rowInserted > 0) {
            System.out.println("insert into storage success");
        }
        the_list = "";
        path_list.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_browse_file) {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
//                String[] file_path = new String [f.length];
//                for (int j = 0; j < f.length; j++) {
//                    file_path[i] = f[i].getPath();
//                }
                String for_path_field = f.getPath();
//                for (int j = 0; j < file_path.length; j++) {
//                    for_path_field += file_path[i] + "; ";
//                }
                this.target_path_field.setText(for_path_field);
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    SenderPage f = new SenderPage();
                    f.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SenderPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SenderPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        EventQueue.invokeLater(runnable);
    }
}
