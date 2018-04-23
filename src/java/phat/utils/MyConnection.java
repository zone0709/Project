/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.util.logging.resources.logging;

/**
 *
 * @author user
 */
public class MyConnection implements Serializable{
    
    public static Connection getMyConnection(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Project;","sa","123456");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
