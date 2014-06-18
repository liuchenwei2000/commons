/**
 * 
 */
package test;

import java.sql.Connection;

/**
 * DBCP性能浅测
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月27日
 */
public class DBCPTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL11g";
		String user = "nc63";
		String password = "1";
		
		DataSourceManager dsManager = new DataSourceManager(url, user, password);
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Task(dsManager)).start();
		}
	}
}
class Task implements Runnable {

	private DataSourceManager dsManager;
	
	public Task(DataSourceManager dsManager) {
		this.dsManager = dsManager;
	}

	@Override
	public void run() {
		try {
			long start = System.currentTimeMillis();
			Connection conn = null;
			for (int i = 0; i < 1000; i++) {
				conn = dsManager.getConnection();
				conn.close();
			}
			long end = System.currentTimeMillis();
			System.out.println((end - start) + " ms");
			System.out.println(dsManager.getDataSourceState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}