/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packA;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hafidz Ubaidillah
 */
public class Config {

    private Statement stmt;
    private ResultSet query;
    private Connection con;

    Config() throws ClassNotFoundException, SQLException {

//        Class.forName("com.mysql.jdbc.Driver");
        this.con = DriverManager.getConnection(
                "jdbc:mysql://localhost:1111/assignment_sys_db",
                "root",
                "plmoknijb");
        this.stmt = con.createStatement();

    }

    ResultSet setQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }
}
