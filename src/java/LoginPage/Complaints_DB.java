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

public class Complaints_DB {
    Connection connection; //connection called
private String DateOfComplaint;
private String Complaint;

   public Complaints_DB(){}
    
    //constructor
    public Complaints_DB(String DOC, String Complaint)
    {
        this.DateOfComplaint = DOC; 
        this.Complaint = Complaint;    
    }
//get/set methods
    public String getDateOfComplaint() {
        return DateOfComplaint;
    }
    public void setDateOfComplaint(String DateOfComplaint) {
        this.DateOfComplaint = DateOfComplaint;
    }
    public String getComplaint() {
        return Complaint;
    }
    public void setComplaint(String Complaint) {
        this.Complaint = Complaint;     
    }


    //creating an array list of all complaints and dates.
    public ArrayList<Complaints_DB> ComplaintsList(){
        
        ArrayList<Complaints_DB> ComplaintsList = new ArrayList();
        connection = My_CNX.getConnection();

        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT `DataOfComplaint`, `Complaint`, `Email` FROM `complaints`"; //getting all complaints
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            Complaints_DB complaint;
            while(rs.next()){
                complaint = new Complaints_DB(
                                 rs.getString("DataOfComplaint"), 
                                 rs.getString("Complaint"));
                ComplaintsList.add(complaint);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ComplaintsList;
        
    }
}

