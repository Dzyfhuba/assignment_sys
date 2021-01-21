/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packA;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafidz Ubaidillah
 */
public abstract class Account {

    private int acc_id;
    private String username;
    private String password;
    private int role_id;
    private String role_name;
    private String email;

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List login(String username, String password)
            throws ClassNotFoundException, SQLException {
        Config config = new Config();
        ResultSet query = config.read("SELECT username, password, role_name "
                + "FROM account WHERE "
                + "username = \"" + username
                + "\" and password = \"" + password + "\""
        );

        List list = new ArrayList();
        if (query.next()) {
            list.add(query.getString(1));
            list.add(query.getString(2));
            list.add(query.getString(3));
        } else {
            list.add("username or password is wrong");
        }
        return list;
    }

    abstract void register(String fullname, String email, String username,
            String password, String role);
}
