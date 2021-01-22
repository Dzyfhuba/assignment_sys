/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packA;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafidz Ubaidillah
 */
public class User extends Account{

    
    private static String fullname;

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        User.fullname = fullname;
    }
    
    @Override
    public List login(String username, String password) throws ClassNotFoundException, SQLException {
        Config config = new Config();
        ResultSet query = config.read("SELECT username, password, role_name, email, fullname "
                + "FROM account WHERE "
                + "username = \"" + username
                + "\" and password = \"" + password + "\""
        );

        List list = new ArrayList();
        if (query.next()) {
            list.add(query.getString(1));
            list.add(query.getString(2));
            list.add(query.getString(3));
            list.add(query.getString(4));
            list.add(query.getString(5));
        } else {
            list.add("username or password is wrong");
        }
        return list;
    }
    
    @Override
    public void register(String fullname, String email, String username, String password, String role) {
        this.fullname = fullname;
        try {
            Config config = new Config();
            String sql = "INSERT INTO account VALUES (NULL, ?, ?, ?, ?, ?, NULL)";
            PreparedStatement statement = config.conn().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);
            statement.setString(4, email);
            statement.setString(5, fullname);
            config.create(statement);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
