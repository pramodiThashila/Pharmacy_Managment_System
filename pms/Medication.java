package pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Medication extends Product {

    private String batchno;
    private String exp;
    private String type;

    public Medication(String icode, String name, String manufacture, String type) {
        super(icode, name, manufacture);
        this.type = type;
    }

    public Medication(String icode, String name, String manufacture) {
        super(icode, name, manufacture);
    }

    public Medication(String icode, Double purchased_price, Double selling_price, int qty, String batchno, String exp) {
        super(icode, purchased_price, selling_price, qty);
        this.batchno = batchno;
        this.exp = exp;
    }

    /**
     * @return the exp
     */
    public String getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void add_newmedicine() {

        try {
        
            Connection con = Pharmacy_Management_System.getConnection();

            Statement stmt = con.createStatement();

            String sql = "INSERT INTO drugs VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql); 
                preparedStatement.setString(1, getIcode());
                preparedStatement.setString(2, getName());
                preparedStatement.setString(3, type);
                preparedStatement.setString(4, getManufacture());

                int rowsAffected = preparedStatement.executeUpdate();
                
                if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "data added");
            } else {
                JOptionPane.showMessageDialog(null, "data adding not succesful");
            }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e);

        } catch (Exception ex) {
                Logger.getLogger(Medication.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public void remove_item() {
        Connection con = null;

        try {
            con = Pharmacy_Management_System.getConnection();

            String sql = "DELETE FROM drugs WHERE mcode = ? AND name = ? AND manufacture = ?";

            // Create PreparedStatement with SQL query
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            // Set values for parameters
            preparedStatement.setString(1, getIcode());
            preparedStatement.setString(2, getName());
            preparedStatement.setString(3, getManufacture());

            // Execute SQL query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "data deleted");
            } else {
                JOptionPane.showMessageDialog(null, "no matching data");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void Add_stock(String batchno, String Mcode, int qty, Double purchased_Price, Double selling_Price, String exp, String SCode) {
        Connection con = null;
        try {
            con = Pharmacy_Management_System.getConnection();

            Statement stmt = con.createStatement();

            String sql = "INSERT INTO stock VALUES (?, ?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, getIcode());
            preparedStatement.setString(2, batchno);
            preparedStatement.setDouble(3, purchased_Price);
            preparedStatement.setDouble(4, selling_Price);
            preparedStatement.setString(5, exp);
            preparedStatement.setInt(6, qty);
            preparedStatement.setString(7, SCode);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Added");
            } else {
                JOptionPane.showMessageDialog(null, "Data adding fail");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "error" + e);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
