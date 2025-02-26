package pms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pharmacy_Management_System {
    
    private static  Connection connection;
    private static String Username;
    
    public static Connection getConnection()
    {
         try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pharmacy_Management_System.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacysystem","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(Pharmacy_Management_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static void setUsername(String adminUsername) 
    {
        Pharmacy_Management_System.Username = adminUsername;
    }
    
    public static String getUsername() 
    {
        return Username;
    }    
}
