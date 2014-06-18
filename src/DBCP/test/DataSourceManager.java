/**
 * 
 */
package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据源管理器
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月27日
 */
public class DataSourceManager {

	private DataSource dataSource;
	
	public DataSourceManager(String url, String user, String password) {
		this(url, user, password, 10, 50, 10, 10000);
	}

	public DataSourceManager(String url,String user,String password,int initialSize, int maxActive, int maxIdle, int maxWait){
		initDataSource(url, user, password, initialSize, maxActive, maxIdle, maxWait);
	}
	
	/**
	 * 使用properties文件初始化数据源
	 */
	public DataSourceManager(String propertiesFile){
		Properties dsProperties = new Properties();
		try {
			dsProperties.load(DataSourceManager.class.getClassLoader().getResourceAsStream(propertiesFile));
			this.dataSource = BasicDataSourceFactory.createDataSource(dsProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用指定参数连接数据源
	 * 
	 * @param connectURI
	 *            数据库连接URL
	 * @param user
	 *            用户名
	 * @param password
	 *            密码
	 * @param initialSize
	 *            初始连接池连接个数
	 * @param maxActive
	 *            最大激活连接数
	 * @param maxIdle
	 *            最大闲置连接数
	 * @param maxWait
	 *            获得连接的最大等待毫秒数
	 * @return
	 */
	private void initDataSource(String url,String user,String password,int initialSize, int maxActive, int maxIdle, int maxWait){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(url);
		basicDataSource.setDriverClassName(getDriverClassName(url));
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(password);
		basicDataSource.setInitialSize(initialSize); // 初始的连接数
		basicDataSource.setMaxActive(maxActive);
		basicDataSource.setMaxIdle(maxIdle);
		basicDataSource.setMaxWait(maxWait);
		
		this.dataSource = basicDataSource;
	}
	
	private String getDriverClassName(String url){
		String urlLowercase = url.toLowerCase();
		if(urlLowercase.contains("oracle")){
			return "oracle.jdbc.driver.OracleDriver";
		}else if(urlLowercase.contains("sqlserver")){
			return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}else if(urlLowercase.contains("mysql")){
			return "com.mysql.jdbc.Driver";
		}else if(urlLowercase.contains("db2")){
			return "com.ibm.db2.jcc.DB2Driver";
		}
		return null;
	}
	
	public Connection getConnection(){
		if(dataSource != null){
			try {
				Connection connection = dataSource.getConnection();
				connection.setAutoCommit(false);// 把自动提交关闭
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void shutdownDataSource() throws SQLException{
		((BasicDataSource) dataSource).close();
	}
	
	private int getConnNumberOfActive(){
		return ((BasicDataSource) dataSource).getNumActive();
	}
	
	private int getConnNumberOfIdle(){
		return ((BasicDataSource) dataSource).getNumIdle();
	}
	
	public String getDataSourceState() {
		return "Active=" + getConnNumberOfActive() + "; Idle=" + getConnNumberOfIdle();
	}
}
