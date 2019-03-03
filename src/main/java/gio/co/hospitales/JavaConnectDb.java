package gio.co.hospitales;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaConnectDb {
	public static Connection connectDbH(int num) {
		Connection conn = null;
		int numHospital = num;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			switch(numHospital) {
                            case 1:
                                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.66.75.32:1521:XE","c##hospital1","adminm");
                                    break;
                            case 2:
                                    //conexion del abue
                                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.65.236.60:1521:orcl","c##hospital2","adminm");
                                    break;
                            default:
                                    //por defecto es al hospital 1
                                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.66.75.32:1521:XE","c##hospital1","adminm");
                                    break;
			}
		} catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
}