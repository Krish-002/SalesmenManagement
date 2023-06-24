/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

/**
 *
 * @author Krish
 */
public class Salesmen_AddSale extends javax.swing.JFrame {

    /**
     * Creates new form Salesmen_AddSale
     */
    public Salesmen_AddSale() {
        initComponents();//GUI
        populateSalesmenComboBox();//Populate comboboxes
        populateRetailerComboBox();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  //date time formatter
        LocalDateTime now = LocalDateTime.now(); 
        Time_Label.setText(dtf.format(now));
    }

    public void populateSalesmenComboBox(){
    //populate combobox from methods defined in C_Users
    C_Users users = new C_Users();
        ArrayList<C_Users> SalesmenList = users.SalesmenList();
        
        for (C_Users SalesmenList1 : SalesmenList) {
            Salesmen_ComboBox.addItem(SalesmenList1.getEmail());
        }
}
    
    public void populateRetailerComboBox(){
      //populate combobox from methods defined in C_Users
    C_Users users = new C_Users();
        ArrayList<C_Users> RetailerList = users.RetailerList();
        
        for (C_Users RetailerList1 : RetailerList) {
            Retailer_ComboBox.addItem(RetailerList1.getEmail());
        }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Date_Label = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DateChoose = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        Salesmen_ComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        Retailer_ComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        Txt_Amount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Quantity_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Brand_Txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PD_Txt = new javax.swing.JTextField();
        jButton_add = new javax.swing.JButton();
        Time_Label = new javax.swing.JLabel();
        jLabel_Redirect = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 102));

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        Date_Label.setBackground(new java.awt.Color(255, 255, 255));
        Date_Label.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD SALE");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_1_60x60.png"))); // NOI18N

        jLabel2.setText("Date Of Sale:");

        jLabel4.setText("Salesmen Email:");

        jLabel5.setText("Retailer Email:");

        jLabel6.setText("Amount:");

        jLabel7.setText("Quantity:");

        Quantity_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_txtActionPerformed(evt);
            }
        });

        jLabel8.setText("Brand:");

        jLabel9.setText("Product Details: ");

        jButton_add.setText("ADD");
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        Time_Label.setText("jLabel10");

        jLabel_Redirect.setText("BACK TO DASHOBARD>>");
        jLabel_Redirect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_RedirectMouseClicked(evt);
            }
        });

        jLabel11.setText("Today's Date:");

        javax.swing.GroupLayout Date_LabelLayout = new javax.swing.GroupLayout(Date_Label);
        Date_Label.setLayout(Date_LabelLayout);
        Date_LabelLayout.setHorizontalGroup(
            Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Date_LabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Date_LabelLayout.createSequentialGroup()
                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Date_LabelLayout.createSequentialGroup()
                                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Date_LabelLayout.createSequentialGroup()
                                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(24, 24, 24)
                                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Txt_Amount)
                                            .addGroup(Date_LabelLayout.createSequentialGroup()
                                                .addComponent(Quantity_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Brand_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 17, Short.MAX_VALUE))
                                            .addComponent(DateChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(Date_LabelLayout.createSequentialGroup()
                                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(13, 13, 13)
                                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Retailer_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Salesmen_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(Date_LabelLayout.createSequentialGroup()
                                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(Date_LabelLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel11)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Time_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PD_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 15, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Date_LabelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Date_LabelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Redirect)
                .addContainerGap())
        );
        Date_LabelLayout.setVerticalGroup(
            Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Date_LabelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Salesmen_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Retailer_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_Amount)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Brand_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Quantity_txt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PD_Txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_add)
                .addGap(27, 27, 27)
                .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Redirect)
                    .addGroup(Date_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Time_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(Date_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(Date_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        
        //insert functionality to register a sale
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        String S_Email = (String)Salesmen_ComboBox.getSelectedItem(); //converting objects to strings
        String R_Email = (String)Retailer_ComboBox.getSelectedItem();
        String Date = sdf.format(DateChoose.getDate());
        int Amount = Integer.parseInt(Txt_Amount.getText());
        int Quantity = Integer.parseInt(Quantity_txt.getText());
        String Brand = Brand_Txt.getText();
        String PD= PD_Txt.getText();
        
        PreparedStatement ps;
                ResultSet rs;
                String registerUserQuery = "INSERT INTO `sales`( `Email`, `DateOfSales`, `Amount`,"
                        + " `Quantity`, `Brand`, `ProductDetails`, `Retailer`) VALUES (?,?,?,?,?,?,?)";
           
        try {
            ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
            ps.setString(1,S_Email);
            ps.setString(2,Date);
            ps.setInt(3, Amount);
            ps.setInt(4, Quantity);
            ps.setString(5, Brand);
            ps.setString(6, PD);
            ps.setString(7, R_Email);
            
            if (ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null, "Sale Added Successfully");
            }
            else {
                JOptionPane.showMessageDialog(null, "Error, Try Again.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WriteComplaints.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int Sales = 0;
        try {
            /*
            We are adding the sales amount to the total sales amount in the database
            By getting the total sales from database, storing it a variable intialised to 0
            then adding the new sale amount and then finally updating the new amount
            */
            
            ps = My_CNX.getConnection().prepareStatement("SELECT * FROM `salesmen` WHERE `Email` =?");
            ps.setString(1, S_Email);
            rs = ps.executeQuery();
            if(rs.next()){
            Sales = (rs.getInt("TotalSales")+ Amount);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_AddSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //updating the total sale amount
        
        String query = "UPDATE `salesmen` SET `TotalSales`= ? WHERE `Email` = ?";
        try {
            ps = My_CNX.getConnection().prepareStatement(query);
            ps.setInt(1, Sales);
            ps.setString(2, S_Email);
            
          if (ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null, "Total Sales updated Successfully");
            }
            else {
                JOptionPane.showMessageDialog(null, "Error, Try Again.");
          }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Salesmen_AddSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_addActionPerformed

    private void Quantity_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_txtActionPerformed

    private void jLabel_RedirectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_RedirectMouseClicked
        // TODO add your handling code here:
        this.dispose(); // redirect to dashboard
    }//GEN-LAST:event_jLabel_RedirectMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Salesmen_AddSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salesmen_AddSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salesmen_AddSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salesmen_AddSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salesmen_AddSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Brand_Txt;
    private com.toedter.calendar.JDateChooser DateChoose;
    private javax.swing.JPanel Date_Label;
    private javax.swing.JTextField PD_Txt;
    private javax.swing.JTextField Quantity_txt;
    private javax.swing.JComboBox Retailer_ComboBox;
    private javax.swing.JComboBox Salesmen_ComboBox;
    private javax.swing.JLabel Time_Label;
    private javax.swing.JTextField Txt_Amount;
    private javax.swing.JButton jButton_add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Redirect;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}