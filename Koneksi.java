
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Koneksi {
    
    Connection conn;
    Statement stm;
    
    
    public void konek(){
        String url = "jdbc:mysql://localhost:3306/rmotor";
        String user = "root";
        String pass = "";
        String regis = "com.mysql.jdbc.Driver";
        
        
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(url,user,pass);
           stm = conn.createStatement();
           
           System.out.println("berhasil terkoneksi");
           
           
       }catch (Exception exception){
           JOptionPane.showMessageDialog(null,"tidak dapat terkoneksi DB"+exception.getMessage());
       }
        
        
        
    }
    
    
    
}
