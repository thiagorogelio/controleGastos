/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;

/**
 *
 * @author maxx
 */
public class Conection {
    private static String driver;
    private static String serverName;
    private static String mydatabase;
    private static String url;
    private static String username;
    private static String password;
    private static Boolean status;
    private static Connection connection;
    
    public Conection() {
        driver = "com.mysql.jdbc.Driver"; 
        serverName = "localhost"; 
        mydatabase = "controle";
        url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
        username = "root";
        password = "";
        status = null;
    }
   
    public static java.sql.Connection connect() { 
        try { 
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            if (connection != null) { 
                status = true;
            } 
            else { 
                status = false;
            }
        } catch (SQLException e) { 
                System.out.println(e); 
                return null; 
        } 
        return connection;
    }
    
    public static ResultSet sql(String SQL){
        try {
            if(status == null)
                connect();
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) { 
                System.out.println(e); 
        }
            return null;
    }
    
    public static void update(String SQL){
        try {
            if(status == null)
                connect();
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) { 
                System.out.println(e); 
        }
    }
    
    public static boolean FecharConexao() { 
        try { 
            Conection.connection.close();
            return true; 
        } catch (SQLException e) { 
            return false; 
        } 
    }
}