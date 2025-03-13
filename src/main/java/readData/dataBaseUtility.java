// jdbc url - jdbc:h2:mem:testdb, username - sa, password - empty

package readData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataBaseUtility {

	public static void main(String[] args) throws SQLException {
		
		Connection connect = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", ""); 
		Statement stmt = connect.createStatement();
		
		stmt.execute("create table employee (id int primary key, name varchar(20))");
		
		stmt.execute("insert into employee values(100, 'rakesh')");
		stmt.execute("insert into employee values(101, 'kumar')");
		
		ResultSet result = stmt.executeQuery("select * from employee");
		
		while(result.next()) {
		System.out.println("ID: " + result.getInt("id") + " & Name: " + result.getString("name"));
		}
		
		connect.close();
	}
}
