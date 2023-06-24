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

public class C_Users {


    Connection connection; //connection called
    
    //declaring private variables as per those created in database
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Telephone;
    private String UserType;
    private byte[]Photograph;
    private String Approval;

   public C_Users(){}
    //creating a constructor
    public C_Users(String FNAME, String LNAME, String EMAIL, String PASW, String TEL, String UTYPE, byte[] Ph, String APP)
    {
        this.FirstName = FNAME;
        this.LastName = LNAME;
        this.Email = EMAIL;
        this.Password = PASW;
        this.Telephone = TEL;
        this.UserType = UTYPE;
        this.Photograph = Ph;
        this.Approval = APP;
    }

    
    //get/set methods
    
    public byte[] getPhotograph() {
        return Photograph;
    }

    public void setPhotograph(byte[] Photograph) {
        this.Photograph = Photograph;
    }
    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
   
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
       public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }


    public String getUserType() {
        return UserType;
    }

    public void setUser_Type(String UserType) {
        this.UserType = UserType;
    }
    
    public String getApproval() {
        return Approval;
    }
    
    public void setApproval(String Approval){
        this.Approval = Approval;
    }

 
    
       
    
    // get users list
    public ArrayList<C_Users> UsersList(){
        
        ArrayList<C_Users> user_list = new ArrayList();
        connection = My_CNX.getConnection();

        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT * FROM `users` ORDER BY `Approval`=\"Pending\" DESC"; 
               // query created to arrage pending users on top and then approved users
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            C_Users user; 
            while(rs.next()){
                user = new C_Users(
                                 rs.getString("FirstName"), 
                                 rs.getString("LastName"),
                                 rs.getString("Email"),
                                 rs.getString("Password"),
                                 rs.getString("Telephone"),
                                 rs.getString("UserType"),
                                 rs.getBytes("Photograph"),
                                 rs.getString("Approval")
                                 );
                user_list.add(user);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_list;
        
    }
    
    
    

      
    
     // update user
    public static void updateUser(C_Users user)
    {
        Connection con = My_CNX.getConnection();
        PreparedStatement ps;
        
        //using the update query from mysql
        try {
            ps = con.prepareStatement("UPDATE `users` SET `FirstName`=?,`LastName`=?,`Password`=?,`Telephone`=?,"
                    + "`UserType`=?,`Photograph`=?,`Approval`=? WHERE `Email`=?");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getTelephone());
            ps.setString(5, user.getUserType());
            ps.setBytes(6, user.getPhotograph());
            ps.setString(7, user.getApproval());
            ps.setString(8, user.getEmail());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "User Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //getting a list of users, who have the user type as salesmen in an arraylist
    
    public ArrayList<C_Users> SalesmenList(){
        
        ArrayList<C_Users> SalesmenList = new ArrayList();
        connection = My_CNX.getConnection();

        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT * FROM `users` WHERE `UserType` = 'Salesmen'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            C_Users user;
            while(rs.next()){
                user = new C_Users(
                                 rs.getString("FirstName"), 
                                 rs.getString("LastName"),
                                 rs.getString("Email"),
                                 rs.getString("Password"),
                                 rs.getString("Telephone"),
                                 rs.getString("UserType"),
                                 rs.getBytes("Photograph"),
                                 rs.getString("Approval")
                                 );
                
                SalesmenList.add(user);
            }     
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SalesmenList;
        
    }
    
     //getting a list of users, who have the user type as retailer in an arraylist
     public ArrayList<C_Users> RetailerList(){
        
        ArrayList<C_Users> RetailerList = new ArrayList();
        connection = My_CNX.getConnection();
        ResultSet rs;
        PreparedStatement ps;
               String query = "SELECT * FROM `users` WHERE `UserType` = 'Retailer'";       
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();         
            C_Users user;
            while(rs.next()){
                user = new C_Users(
                                 rs.getString("FirstName"), 
                                 rs.getString("LastName"),
                                 rs.getString("Email"),
                                 rs.getString("Password"),
                                 rs.getString("Telephone"),
                                 rs.getString("UserType"),
                                 rs.getBytes("Photograph"),
                                 rs.getString("Approval")
                                 );
                
                RetailerList.add(user);
            }        
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RetailerList;
        
    }
    }

   