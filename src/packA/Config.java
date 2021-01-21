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
import java.sql.PreparedStatement;

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
        this.stmt = this.con.createStatement();
    }
    
    Connection conn(){
        return this.con;
    }

    ResultSet read(String query) throws SQLException {
        return this.stmt.executeQuery(query);
    }
    
    void create(PreparedStatement statement) throws SQLException {
        int rowInserted = statement.executeUpdate();
        if (rowInserted > 0) {
            System.out.println("A new user was inserted successfully!!");
        }
    }
}
