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

/**
 *
 * @author Hafidz Ubaidillah
 */
public class User extends Account{

    private String codename;;
    private String fullname;
    
    @Override
    void register(String fullname, String email, String username, String password, String role) {
        this.fullname = fullname;
        this.codename = "sdr_" + username;
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
