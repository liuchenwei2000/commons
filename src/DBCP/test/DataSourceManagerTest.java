/**
 * 
 */
package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DataSourceManager用法测试
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月27日
 */
public class DataSourceManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String configFile = "./test/dbcp.properties";
//		DataSourceManager dsManager = new DataSourceManager(configFile);
		
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL11g";
		String user = "nc63";
		String password = "1";
		
		DataSourceManager dsManager = new DataSourceManager(url, user, password);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dsManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from bd_currtype");
			
			int numcols = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= numcols; i++) {
					System.out.print("\t" + rs.getString(i) + "\t");
				}
				System.out.println("");
			}
			System.out.println(dsManager.getDataSourceState());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (dsManager != null) {
					dsManager.shutdownDataSource();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
