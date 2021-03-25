package org.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Sample {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","Vimal@12");
	
	String s = "select * from intel ";
	
	PreparedStatement p = connect.prepareStatement(s);
	ResultSet rs = p.executeQuery();
	ResultSetMetaData mD = rs.getMetaData();
	int cc = mD.getColumnCount();
	while (rs.next()) {
		for (int i = 1; i <= cc; i++) {
			String value = rs.getString(i);
			System.out.println("intel values:"+value);
		}
		String employee_id = rs.getString(2);
		System.out.println(employee_id);
		String first_name = rs.getString("empid");
		System.out.println(first_name);
	}
	connect.close();
}	
}

