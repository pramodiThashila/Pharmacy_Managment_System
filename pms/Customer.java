package pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer extends Person {

    Customer(String name, String telephone_no) {
        super(name, telephone_no);

    }

    @Override
    public void add_person() {
        try {
            Connection con = Pharmacy_Management_System.getConnection();

            Statement stm = con.createStatement();

            String sql = "INSERT INTO customer VALUES('" + getName() + "', '" + getTelephone_no() + "')";

            int rowsAffected = stm.executeUpdate(sql);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Recorde added");
            } else {
                JOptionPane.showMessageDialog(null, "record added unsuccsesful");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e);

        } catch (Exception e) {
            e.printStackTrace();
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

            String sql = "SELECT COUNT(*) FROM customer WHERE Name = ? OR PhoneNo = ?";
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
