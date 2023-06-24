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
public class RetailerOrder_DB {
     Connection connection;//connection called
    
    private int ID;
    private String SalesmenEmail;
    private String DateOfSale;
    private int Quantity;
    private String Brand;
    private String ProductDetails;
    private String RetailerEmail;
    private String OrderStatus;
    
    public RetailerOrder_DB (){}

    //constructor
    public RetailerOrder_DB(int ID, String EMAIL, String DOS, int QUA, String BRA, String PD, String RET, String OS){
        this.ID = ID;
        this.SalesmenEmail = EMAIL;
        this.DateOfSale = DOS;
        this.Quantity = QUA;
        this.Brand = BRA;
        this.ProductDetails = PD;
        this.RetailerEmail = RET;
        this.OrderStatus = OS;
}
//getter and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSalesmenEmail() {
        return SalesmenEmail;
    }

    public void setSalesmenEmail(String SalesmenEmail) {
        this.SalesmenEmail = SalesmenEmail;
    }

    public String getDateOfSale() {
        return DateOfSale;
    }

    public void setDateOfSale(String DaleOfSales) {
        this.DateOfSale = DaleOfSales;
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

    public String getProductDetails() {
        return ProductDetails;
    }

    public void setProductDetails(String ProductDetails) {
        this.ProductDetails = ProductDetails;
    }

    public String getRetailerEmail() {
        return RetailerEmail;
    }

    public void setRetailerEmail(String RetailerEmail) {
        this.RetailerEmail = RetailerEmail;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
    
    public static void UpdateOrderStatus(RetailerOrder_DB Order)
            //update order staus functionality using the update query from mysql
    {
        Connection con = My_CNX.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("UPDATE `retailerorder` SET `SalesmenEmail`=?,"
                    + "`DateOfSale`=?,`Quantity`=?,`Brand`=?,`ProductDetails`=?,`RetailerEmail`=?,"
                    + "`OrderStatus`=? WHERE `ID` = ?");
            ps.setString(1, Order.getSalesmenEmail());
            ps.setString(2, Order.getDateOfSale());
            ps.setInt(3, Order.getQuantity());
            ps.setString(4, Order.getBrand());
            ps.setString(5, Order.getProductDetails());
            ps.setString(6, Order.getRetailerEmail());
            ps.setString(7, Order.getOrderStatus());
            ps.setInt(8, Order.getID());


            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Order Status Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong, Try Agin!");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ArrayList<RetailerOrder_DB> OrderList(String Status){ //getting an array list of orders.
        //list of orders on the basis of their orderstatus which should be inputted by the user
        ArrayList<RetailerOrder_DB> OrderList = new ArrayList();
        connection = My_CNX.getConnection();

        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT * FROM `retailerorder` WHERE `OrderStatus` = ?");
            ps.setString(1, Status);
            rs = ps.executeQuery();
           
            RetailerOrder_DB Order;
            while(rs.next()){
                Order = new RetailerOrder_DB(
                        rs.getInt("ID"),
                        rs.getString("SalesmenEmail"),
                        rs.getString("DateOfSale"),
                        rs.getInt("Quantity"),
                        rs.getString("Brand"),
                        rs.getString("ProductDetails"),
                        rs.getString("RetailerEmail"),
                        rs.getString("OrderStatus")
                                );
                OrderList.add(Order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return OrderList;
        
    }
     
     public ArrayList<RetailerOrder_DB> SalesmenOrderList(String Status, String Email){
        
        ArrayList<RetailerOrder_DB> SalesmenOrderList = new ArrayList();
        connection = My_CNX.getConnection();
//list of orders for a specific salesmen and a specific order status (2 inputs from user) 
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT * FROM `retailerorder` "
                    + "WHERE `OrderStatus` = ? AND `SalesmenEmail` = ?");
            ps.setString(1, Status);
            ps.setString(2, Email);
            rs = ps.executeQuery();
           
            RetailerOrder_DB Order;
            while(rs.next()){
                Order = new RetailerOrder_DB(
                        rs.getInt("ID"),
                        rs.getString("SalesmenEmail"),
                        rs.getString("DateOfSale"),
                        rs.getInt("Quantity"),
                        rs.getString("Brand"),
                        rs.getString("ProductDetails"),
                        rs.getString("RetailerEmail"),
                        rs.getString("OrderStatus")
                                );
                SalesmenOrderList.add(Order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return SalesmenOrderList;
        
    }
     
     public ArrayList<RetailerOrder_DB> RetailerOrderList(String Email){
        
        ArrayList<RetailerOrder_DB> RetailerOrderList = new ArrayList();
        connection = My_CNX.getConnection();
//list of orders based on just the retailers email
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT * FROM `retailerorder` WHERE `RetailerEmail` = ?");
            ps.setString(1, Email);
            rs = ps.executeQuery();
           
            RetailerOrder_DB Order;
            while(rs.next()){
                Order = new RetailerOrder_DB(
                        rs.getInt("ID"),
                        rs.getString("SalesmenEmail"),
                        rs.getString("DateOfSale"),
                        rs.getInt("Quantity"),
                        rs.getString("Brand"),
                        rs.getString("ProductDetails"),
                        rs.getString("RetailerEmail"),
                        rs.getString("OrderStatus")
                                );
                RetailerOrderList.add(Order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return RetailerOrderList;
        
    }
     
     public ArrayList<RetailerOrder_DB> SalesmenOrderList_Allstatus(String Email){
        
        ArrayList<RetailerOrder_DB> SalesmenOrderList_Allstatus = new ArrayList();
        connection = My_CNX.getConnection();
//list of orders based on just the retailers email
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT * FROM `retailerorder` WHERE `SalesmenEmail` = ?");
            ps.setString(1, Email);
            rs = ps.executeQuery();
           
            RetailerOrder_DB Order;
            while(rs.next()){
                Order = new RetailerOrder_DB(
                        rs.getInt("ID"),
                        rs.getString("SalesmenEmail"),
                        rs.getString("DateOfSale"),
                        rs.getInt("Quantity"),
                        rs.getString("Brand"),
                        rs.getString("ProductDetails"),
                        rs.getString("RetailerEmail"),
                        rs.getString("OrderStatus")
                                );
                SalesmenOrderList_Allstatus.add(Order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return SalesmenOrderList_Allstatus;
        
    }
}
