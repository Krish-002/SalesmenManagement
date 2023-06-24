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
public class SalesmenSale_DB {
     Connection connection;
     
     private String Email; //creating private variables
     private int TotalSales;
     private int SalesTarget;
 
     public SalesmenSale_DB(){}
     
     //Constructor
     public SalesmenSale_DB(String EMA, int TS, int ST){
         
         this.Email = EMA;
         this.TotalSales = TS;
         this.SalesTarget = ST;
     }

    SalesmenSale_DB(int SalesTarget, int TotalSales, String Email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // getter and setters
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(int TotalSales) {
        this.TotalSales = TotalSales;
    }

    public int getSalesTarget() {
        return SalesTarget;
    }

    public void setSalesTarget(int SalesTarget) {
        this.SalesTarget = SalesTarget;
    }
     
    
    public static void updateSalesmenSale(SalesmenSale_DB sale) //update method
    {
        Connection con = My_CNX.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("UPDATE `salesmen` SET `SalesTarget`=?,`TotalSales`=? WHERE `Email` = ?");
            ps.setInt(1, sale.getSalesTarget());
            ps.setInt(2, sale.getTotalSales());
            ps.setString(3, sale.getEmail());
   

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Salesmen Detail Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, " Error");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public ArrayList<SalesmenSale_DB> SalesmenSaleList(String email){
         // List of details by a salesmen's email (Primary Key Field) 
        
        ArrayList<SalesmenSale_DB> SalesmenSaleList = new ArrayList();
        connection = My_CNX.getConnection();

        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT * FROM `salesmen` WHERE `Email` = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
           
            SalesmenSale_DB sale;
            while(rs.next()){
                sale = new SalesmenSale_DB(
                                 rs.getString("Email"), 
                                 rs.getInt("TotalSales"),
                                 rs.getInt("SalesTraget")
                                 );
                
                SalesmenSaleList.add(sale);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SalesmenSaleList;
        
    }
      
      public ArrayList<SalesmenSale_DB> AllSalesmenSaleList(){
        //List of salesmen who have met or exceeded thir targets ordered from highest to lowest
        ArrayList<SalesmenSale_DB> AllSalesmenSaleList = new ArrayList();
        connection = My_CNX.getConnection();

        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT * FROM `salesmen` WHERE `TotalSales`>= `SalesTarget` ORDER BY `TotalSales` DESC  ";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            SalesmenSale_DB sale;
            while(rs.next()){
                sale = new SalesmenSale_DB(
                                 rs.getString("Email"), 
                                 rs.getInt("TotalSales"),
                                 rs.getInt("SalesTarget")
                                 );
                
                AllSalesmenSaleList.add(sale);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AllSalesmenSaleList;
        
    }
}
