import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    public Login() {
        initComponents();
        
        setLocationRelativeTo(null); // set center 
        
        
        // deklarasi koneksi class dll
        
        Koneksi db = new Koneksi();
        db.konek();
        con = db.conn;
        stat = db.stm;
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usr_id = new javax.swing.JTextField();
        usr_pass = new javax.swing.JPasswordField();
        LOG_btn = new javax.swing.JButton();
        REG_btn = new javax.swing.JButton();
        EXT_lable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        LOG_btn.setText("LOGIN");
        LOG_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOG_btnActionPerformed(evt);
            }
        });

        REG_btn.setText("REGISTER");
        REG_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REG_btnActionPerformed(evt);
            }
        });

        EXT_lable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EXT_lable.setText("x");
        EXT_lable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EXT_lableMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(176, 176, 176))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usr_id)
                    .addComponent(usr_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REG_btn)
                    .addComponent(LOG_btn))
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EXT_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EXT_lable)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(usr_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(usr_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(LOG_btn)
                .addGap(18, 18, 18)
                .addComponent(REG_btn)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /// LOGIN BTN
    
    private void LOG_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOG_btnActionPerformed
       
        Home home = new Home();
//            home.setVisible(true);
//    this.dispose();
        
        try {
        sql = "SELECT * FROM pengguna WHERE username = '"+usr_id.getText()+"'AND password = '"+usr_pass.getText()+"'";
        rs = stat.executeQuery(sql);
           if (rs.next()) {
               if(usr_id.getText().equals(rs.getString("username")) && usr_pass.getText().equals(rs.getString("password"))){
                   JOptionPane.showMessageDialog(null,"lOGIN BERHASI ");
                   
                   home.setVisible(true);
                   this.dispose();
               }
           } else{
                   JOptionPane.showMessageDialog(null, "login gagal, anda belum terdaftar");
               }
           
       }catch (Exception e){
            
            try {
            con.close();
//            stat.close();                                                     // untuk disconnect DB
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           JOptionPane.showMessageDialog(this, e.getMessage());
       }
//        try {
//            con.close();
////            stat.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }


    

        
    }//GEN-LAST:event_LOG_btnActionPerformed

    
    /// REGISTER BTN
    
    private void REG_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REG_btnActionPerformed
        
        Register reg = new Register();
        reg.setVisible(true);
//        reg.setLocationRelativeTo(null);
        
        
//        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.dispose();  // untuk menutup tab ketika membuka tab baru
    }//GEN-LAST:event_REG_btnActionPerformed

    private void EXT_lableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EXT_lableMouseClicked
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_EXT_lableMouseClicked

   
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EXT_lable;
    private javax.swing.JButton LOG_btn;
    private javax.swing.JButton REG_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField usr_id;
    private javax.swing.JPasswordField usr_pass;
    // End of variables declaration//GEN-END:variables
}
