
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
public class Register extends javax.swing.JFrame {

    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
     PreparedStatement Pstm;

             Koneksi db = new Koneksi();

     
    public Register() {
        initComponents();
        
        setLocationRelativeTo(null);
        
         db.konek();
         con = db.conn;
         stat = db.stm;
         
         
        
        
        
        
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
        LOG_btn = new javax.swing.JButton();
        usr_id = new javax.swing.JTextField();
        usr_nik = new javax.swing.JTextField();
        usr_pass = new javax.swing.JTextField();
        REG_btn = new javax.swing.JButton();
        EXT_lable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        LOG_btn.setText("LOGIN");
        LOG_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOG_btnActionPerformed(evt);
            }
        });

        usr_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_passActionPerformed(evt);
            }
        });

        REG_btn.setText("REGIS");
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(REG_btn)
                                    .addComponent(LOG_btn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usr_id)
                                    .addComponent(usr_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(usr_nik))))
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EXT_lable)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(EXT_lable)
                .addGap(34, 34, 34)
                .addComponent(usr_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usr_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usr_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(REG_btn)
                .addGap(29, 29, 29)
                .addComponent(LOG_btn)
                .addGap(50, 50, 50))
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

    private void LOG_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOG_btnActionPerformed
       
        Login log = new Login();
        log.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_LOG_btnActionPerformed

    private void usr_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usr_passActionPerformed

    
    // REGISTER btn
    
    private void REG_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REG_btnActionPerformed
       
        String user = usr_id.getText();
        String pass = usr_pass.getText();
        Integer nik = Integer.parseInt(usr_nik.getText());
//        String nik = usr_nik.getText();
        
        
        
        String id = "NULL";
        
        try {
        
//            try {
//            sql = "INSERT INTO `tb_admin`(`nama`, `username`, `password`, `jenis_kelamin`) VALUES (?,?,?,?)";
//            String rb;
//            if (rbPria.isSelected()) {
//                rb = rbPria.getText();
//            } else {
//                rb = rbWanita.getText();
//            }
//            preparedStatement = DB.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, txtNama.getText());
//            preparedStatement.setString(2, txtUsername.getText());
//            preparedStatement.setString(3, txtPassword1.getText());
//            preparedStatement.setString(4, rb);
//
//            preparedStatement.executeUpdate();
//            
//            preparedStatement.close();
//            DB.connection.close();
//            JOptionPane.showMessageDialog(null, "Berhasil Regis");
        
//            

//            sql = "INSERT INTO pengguna VALUES ('" + user + "','" + pass + "'" + ",NULL)";
                    
             sql = "INSERT INTO `pengguna`(`username`, `password`,  `NIK`) VALUES (?,?,?)";
            
            Pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Pstm.setString(1, user);
            Pstm.setString(2, pass);
            Pstm.setInt(3, nik);
            
            Pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "berhasil membuat akun");
        
        
        
//q

        
            
        } catch (Exception exception) {
//            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "AKUN TERSEBUT SUDAH TERDAFTAR!!!"+exception.getMessage());
        }
    }//GEN-LAST:event_REG_btnActionPerformed

    private void EXT_lableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EXT_lableMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_EXT_lableMouseClicked

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EXT_lable;
    private javax.swing.JButton LOG_btn;
    private javax.swing.JButton REG_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField usr_id;
    private javax.swing.JTextField usr_nik;
    private javax.swing.JTextField usr_pass;
    // End of variables declaration//GEN-END:variables
}
