package pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class User extends Person{
    
    private String Password;
    
    User(String name, String telephone_no,String Password) {
        super(name, telephone_no);
        this.Password=Password;
    }
    User(String name, String telephone_no){
        super(name, telephone_no);
    }
    
    @Override
    public void add_person(){
        try {
            Connection con = Pharmacy_Management_System.getConnection();
            Statement stm = con.createStatement();
            
            String sql = "INSERT INTO USER VALUES('" + getTelephone_no() + "', '" + getName() + "', '" + Password + "', '" + Password + "')";                   

            int rowsAffected = stm.executeUpdate(sql);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successfully Registered....");
            } else {
                JOptionPane.showMessageDialog(null, "Registration is not succesfull");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "error"+e);        
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred. Please check the console for details.");      
        }
    } 
    
    @Override
    public boolean isUsernameOrPhoneAvailable(String username, String phoneNum) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean available = true;

        try {
            con = Pharmacy_Management_System.getConnection();

            String sql = "SELECT COUNT(*) FROM USER WHERE Username = ? OR Phone = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, phoneNum);
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    available = false; // Username or phone number already exists
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (pst != null) try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            //if (con != null) con.close();
        }

        return available;
    }
}
