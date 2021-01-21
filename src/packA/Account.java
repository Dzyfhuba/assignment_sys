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

    private static int acc_id;
    private static String username;
    private static String password;
    private static int role_id;
    private static String role_name;
    private static String email;

    public static int getAcc_id() {
        return acc_id;
    }

    public static void setAcc_id(int acc_id) {
        Account.acc_id = acc_id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Account.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Account.password = password;
    }

    public static int getRole_id() {
        return role_id;
    }

    public static void setRole_id(int role_id) {
        Account.role_id = role_id;
    }

    public static String getRole_name() {
        return role_name;
    }

    public static void setRole_name(String role_name) {
        Account.role_name = role_name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Account.email = email;
    }

    public abstract List login(String username, String password)
            throws ClassNotFoundException, SQLException;

    public abstract void register(String fullname, String email, String username,
            String password, String role);
}
