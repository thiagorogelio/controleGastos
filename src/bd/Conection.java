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
    private static String driver;// = "com.mysql.jdbc.Driver"; 
    private static String serverName;// = "localhost"; 
    private static String mydatabase;// = "controle";
    private static String url;// = "jdbc:mysql://" + serverName + "/" + mydatabase; 
    private static String username;// = "root";
    private static String password;// = "furmdjcj";
    private static Boolean status;
    private static Connection connection;// = null;
    
    public Conection() {
        driver = "com.mysql.jdbc.Driver"; 
        serverName = "localhost"; 
        mydatabase = "controle";
        url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
        username = "root";
        password = "furmdjcj";
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