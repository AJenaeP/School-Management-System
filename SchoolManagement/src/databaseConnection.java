import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class databaseConnection {
	
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/sys";
	
	final static String USER = "root";
	final static String PASS = "1111";
	
	public static Connection connection() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			return con;	
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}	
	}

}
