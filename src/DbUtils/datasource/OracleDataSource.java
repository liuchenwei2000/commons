/**
 * 
 */
package datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * DriverManagerʵ�ֵ�����Դ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-5-31
 */
public class OracleDataSource implements DataSource {
	
	private String dbUrl;
    private String user;
    private String password;
	
	public OracleDataSource(String dbUrl, String user, String password) {
		this.dbUrl = dbUrl;
		this.user = user;
		this.password = password;
		initDrivers();
	}

	private void initDrivers() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡһ�����ݿ�����
	 */
	public Connection getConnection() {
		try {
			// ÿ�ζ�����һ���µ����ݿ�����
			return DriverManager.getConnection(this.dbUrl, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ����ȫ��DataSource�ӿڵķ�����ֻʵ�ֱ����
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		try {
			return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
}