/**
 * 
 */
package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.PersonVO;
import datasource.OracleDataSource;

/**
 * DbUtilsʹ��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��27��
 */
public class DbUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSource ds = createDataSource();
		try {
			testInsert(ds);
			testUpdate(ds);
			testDelete(ds);
			testQuery(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 */
	private static void testInsert(DataSource ds) throws SQLException {
		// ��һ�ַ�ʽ����ȫSQL������
		String sql = "INSERT INTO person (id, name, age, address) VALUES ('00001', 'Tom', 21, 'address001')";
		// ÿ��SQL��ִ�ж���Ҫ�õ�QueryRunner������ʵ��һ����ͨ���࣬���̰߳�ȫ��
		// �ڴ���QueryRunner�����ʱ��ÿ�ζ�Ҫnew��
		QueryRunner runner = new QueryRunner(ds);
		runner.update(sql);
		
		// �ڶ��ַ�ʽ��SQL���+�������룬�����ַ�ʽͬ��������CRUD���ֳ���
		String sql2 = "INSERT INTO person (id, name, age, address) VALUES (?, ?, ?, ?)";// ? ��Ϊͨ���
		QueryRunner runner2 = new QueryRunner(ds);
		// ͨ���ɱ������update�����������ֵ��˳��������SQL�е�ͨ���ƥ��
		runner2.update(sql2, "00002", "Jerry", 16, "address002");
		
		// �������룬����ʹ��ͨ�����ʽ��SQL
		String sql3 = "INSERT INTO person (id, name, age, address) VALUES (?, ?, ?, ?)";
		QueryRunner runner3 = new QueryRunner(ds);
		// ͨ���ɱ������update�����������ֵ��˳��������SQL�е�ͨ���ƥ��
		Object[] row1 = new Object[] { "00003", "Lily", 17, "address003" };
		Object[] row2 = new Object[] { "00004", "Susan", 27, "address004" };
		Object[] row3 = new Object[] { "00005", "Jimmy", 12, "address005" };
		Object[][] rows = new Object[][] { row1, row2, row3 };
		runner3.batch(sql3, rows);// ����������������
		
		System.out.println("����ɹ�......");
	}

	/**
	 * ����
	 */
	private static void testUpdate(DataSource ds) throws SQLException {
		String sql = "UPDATE person SET NAME = ?, age = ?, address = ? WHERE id = ?";
		QueryRunner runner = new QueryRunner(); 
		Connection connection = ds.getConnection();
		try {
			// QueryRunner Ҳ����ֱ��ʹ�� connection ������в�����������ͨ��DataSource���졣
			runner.update(connection, sql, "Ann", 23, "new address", "00001");
			System.out.println("���³ɹ�......");
		} finally {
			// �����Ҫ�ֹ��ر�connection��DbUtils�����ṩ��һЩ��ݷ�����
			DbUtils.close(connection);
		}
	}

	/**
	 * ɾ��
	 */
	private static void testDelete(DataSource ds) throws SQLException {
		String sql = "DELETE FROM person WHERE id = ?";
		QueryRunner runner = new QueryRunner(ds);
		// ����Ӱ�������
		int result = runner.update(sql, "00003");
		if (result == 1) {
			System.out.println("ɾ���ɹ�......");
		}
	}

	/**
	 * ��ѯ
	 */
	private static void testQuery(DataSource ds) throws SQLException {
		/**
		 * DbUtils�ṩ��һЩ���õ�ResultSetHandlerʵ�֣����Խ��������װΪ�������ͣ�
		 * 
		 * ArrayHandler���ѽ�����еĵ�һ������ת�ɶ������顣
		 * ArrayListHandler���ѽ�����е�ÿһ�����ݶ�ת��һ���������飬�ٴ�ŵ�List�С�
		 * BeanHandler����������еĵ�һ�����ݷ�װ��һ����Ӧ��JavaBeanʵ���С�
		 * BeanListHandler����������е�ÿһ�����ݶ���װ��һ����Ӧ��JavaBeanʵ���У���ŵ�List�
		 * ColumnListHandler�����������ĳһ�е����ݴ�ŵ�List�С�
		 * KeyedHandler����������е�ÿһ�����ݶ���װ��һ��Map�Ȼ���ٸ���ָ����key��ÿ��Map�ٴ�ŵ�һ��Map�
		 * MapHandler����������еĵ�һ�����ݷ�װ��һ��Map�key��������value���Ƕ�Ӧ��ֵ��
		 * MapListHandler����������е�ÿһ�����ݶ���װ��һ��Map�Ȼ���ٴ�ŵ�List��
		 * ScalarHandler�����������ĳһ����¼������ĳһ�е����ݴ��Object��
		 */
		String sql = "SELECT * FROM person WHERE id = ?";
		QueryRunner runner = new QueryRunner(ds);
		// BeanHandler����������еĵ�һ�����ݷ�װ��һ����Ӧ��JavaBeanʵ���С�
		ResultSetHandler<PersonVO> handler = new BeanHandler<PersonVO>(PersonVO.class);
		PersonVO person = runner.query(sql, handler, "00001");
		System.out.println("��ѯ��id=00001���ˣ�" + person);
		
		String sql2 = "SELECT * FROM person";
		QueryRunner runner2 = new QueryRunner(ds);
		// BeanListHandler����������е�ÿһ�����ݶ���װ��һ����Ӧ��JavaBeanʵ���У���ŵ�List�
		BeanListHandler<PersonVO> handler2 = new BeanListHandler<PersonVO>(PersonVO.class);
		List<PersonVO> persons = runner2.query(sql2, handler2);
		System.out.println("��ѯ�����е��ˣ�" + persons);

		
	}
	
	private static DataSource createDataSource(){
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL11g";
		String user = "nc63";
		String password = "1";
		
		return new OracleDataSource(url, user, password);
	}
}
