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
 * ����Դ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��27��
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
	 * ʹ��properties�ļ���ʼ������Դ
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
	 * ��ָ��������������Դ
	 * 
	 * @param connectURI
	 *            ���ݿ�����URL
	 * @param user
	 *            �û���
	 * @param password
	 *            ����
	 * @param initialSize
	 *            ��ʼ���ӳ����Ӹ���
	 * @param maxActive
	 *            ��󼤻�������
	 * @param maxIdle
	 *            �������������
	 * @param maxWait
	 *            ������ӵ����ȴ�������
	 * @return
	 */
	private void initDataSource(String url,String user,String password,int initialSize, int maxActive, int maxIdle, int maxWait){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(url);
		basicDataSource.setDriverClassName(getDriverClassName(url));
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(password);
		basicDataSource.setInitialSize(initialSize); // ��ʼ��������
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
				connection.setAutoCommit(false);// ���Զ��ύ�ر�
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
