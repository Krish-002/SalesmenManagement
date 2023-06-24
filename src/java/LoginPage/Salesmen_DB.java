/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Krish
 */
public class Salesmen_DB {
    
    Connection connection;
    
    private int ID;
    private String Email;
    private String DaleOfSales;
    private int Amount;
    private int Quantity;
    private String Brand;
    private String ProductDetails;
    private String Retailer;
    
    public Salesmen_DB (){}

    public Salesmen_DB(int ID, String EMAIL, String DOS, int AMT, int QUA, String BRA, String PD, String RET){
        this.ID = ID;
        this.Email = EMAIL;
        this.DaleOfSales = DOS;
        this.Amount = AMT;
        this.Quantity = QUA;
        this.Brand = BRA;
        this.ProductDetails = PD;
        this.Retailer = RET;
}
//getter and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDaleOfSales() {
        return DaleOfSales;
    }

    public void setDaleOfSales(String DaleOfSales) {
        this.DaleOfSales = DaleOfSales;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getProductDeatails() {
        return ProductDetails;
    }

    public void setProductDeatails(String ProductDeatails) {
        this.ProductDetails = ProductDeatails;
    }


    public String getRetailer() {
        return Retailer;
    }

    public void setRetailer(String Retailer) {
        this.Retailer = Retailer;
    }
    
    
    
    
    public static void UpdateSale(Salesmen_DB sale)
    {
        Connection con = My_CNX.getConnection();
        PreparedStatement ps;
        //update method to update sales details for a salesmen
        try {
            ps = con.prepareStatement("UPDATE `sales` SET `ID`=?,`DateOfSales`=?,`Amount`=?, Retailer`=? WHERE `Email` = ?");
            ps.setInt(1, sale.getID());
            ps.setString(2, sale.getDaleOfSales());
            ps.setInt(3, sale.getAmount());
            ps.setString(4, sale.getRetailer());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "sale Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Salesmen_DB> QuantityList(String S, String B){
        
        ArrayList<Salesmen_DB> QuantityList = new ArrayList();
        connection = My_CNX.getConnection();
//method to get the sales by a salesmen for a particular brand in terms of quantity (2 inputs)
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT * FROM `sales` WHERE `Email` = ? AND `Brand` = ?");
            ps.setString(1 ,S);
            ps.setString(2, B);
        rs = ps.executeQuery();
           
            Salesmen_DB quantity;
            while(rs.next()){
                quantity = new Salesmen_DB(
                        rs.getInt("ID"),
                        rs.getString("Email"),
                        rs.getString("DateOfSales"),
                        rs.getInt("Amount"),
                        rs.getInt("Quantity"),
                        rs.getString("Brand"),
                        rs.getString("ProductDetails"),
                        rs.getString("Retailer")
                                );
                QuantityList.add(quantity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return QuantityList;
        
    }
        
       
    }


