package IT20198886;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import javax.swing.JOptionPane;


public class my_update {
	void  my_db_update(String str1, String str2,String str3,String str4, String str6, String str7) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			// database is my_tutorial, userid =root, password //
		       // Update your usrid, password and database name // 	
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/suwasetha_vaccine","root","");
			Statement st=con.createStatement();  
			int Age = Integer.parseInt(str4); // Mark is an integer
			
			// Adding record 
			String query1="INSERT INTO tbl_staffmember (Full_name,NIC,Gender,Age,Email,Password)VALUES('" +str1+"', '" +str2+"', '" +str3+"', '" +Age+"','" +str6+"' ,'" +str7+"')";
		
			st.executeUpdate(query1); // record added. 
			JOptionPane.showMessageDialog(null, "You have successfully registered");
			con.close();  
			
		}catch(Exception e){ System.out.println(e);} 
			//////////////////////////////
		}
		
}
