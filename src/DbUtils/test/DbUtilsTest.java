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
 * DbUtils使用示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月27日
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
	 * 插入
	 */
	private static void testInsert(DataSource ds) throws SQLException {
		// 第一种方式，完全SQL语句插入
		String sql = "INSERT INTO person (id, name, age, address) VALUES ('00001', 'Tom', 21, 'address001')";
		// 每个SQL的执行都需要用到QueryRunner，这其实是一个普通的类，非线程安全。
		// 在创建QueryRunner对象的时候，每次都要new。
		QueryRunner runner = new QueryRunner(ds);
		runner.update(sql);
		
		// 第二种方式，SQL语句+参数插入，这两种方式同样适用于CRUD四种场景
		String sql2 = "INSERT INTO person (id, name, age, address) VALUES (?, ?, ?, ?)";// ? 作为通配符
		QueryRunner runner2 = new QueryRunner(ds);
		// 通过可变参数的update方法传入参数值，顺序与上面SQL中的通配符匹配
		runner2.update(sql2, "00002", "Jerry", 16, "address002");
		
		// 批量插入，必须使用通配符形式的SQL
		String sql3 = "INSERT INTO person (id, name, age, address) VALUES (?, ?, ?, ?)";
		QueryRunner runner3 = new QueryRunner(ds);
		// 通过可变参数的update方法传入参数值，顺序与上面SQL中的通配符匹配
		Object[] row1 = new Object[] { "00003", "Lily", 17, "address003" };
		Object[] row2 = new Object[] { "00004", "Susan", 27, "address004" };
		Object[] row3 = new Object[] { "00005", "Jimmy", 12, "address005" };
		Object[][] rows = new Object[][] { row1, row2, row3 };
		runner3.batch(sql3, rows);// 批量插入三条数据
		
		System.out.println("插入成功......");
	}

	/**
	 * 更新
	 */
	private static void testUpdate(DataSource ds) throws SQLException {
		String sql = "UPDATE person SET NAME = ?, age = ?, address = ? WHERE id = ?";
		QueryRunner runner = new QueryRunner(); 
		Connection connection = ds.getConnection();
		try {
			// QueryRunner 也可以直接使用 connection 对象进行操作，而无需通过DataSource构造。
			runner.update(connection, sql, "Ann", 23, "new address", "00001");
			System.out.println("更新成功......");
		} finally {
			// 最后需要手工关闭connection，DbUtils里面提供了一些便捷方法。
			DbUtils.close(connection);
		}
	}

	/**
	 * 删除
	 */
	private static void testDelete(DataSource ds) throws SQLException {
		String sql = "DELETE FROM person WHERE id = ?";
		QueryRunner runner = new QueryRunner(ds);
		// 返回影响的行数
		int result = runner.update(sql, "00003");
		if (result == 1) {
			System.out.println("删除成功......");
		}
	}

	/**
	 * 查询
	 */
	private static void testQuery(DataSource ds) throws SQLException {
		/**
		 * DbUtils提供了一些常用的ResultSetHandler实现，可以将结果集封装为各种类型：
		 * 
		 * ArrayHandler：把结果集中的第一行数据转成对象数组。
		 * ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中。
		 * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
		 * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
		 * ColumnListHandler：将结果集中某一列的数据存放到List中。
		 * KeyedHandler：将结果集中的每一行数据都封装到一个Map里，然后再根据指定的key把每个Map再存放到一个Map里。
		 * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
		 * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List。
		 * ScalarHandler：将结果集中某一条记录的其中某一列的数据存成Object。
		 */
		String sql = "SELECT * FROM person WHERE id = ?";
		QueryRunner runner = new QueryRunner(ds);
		// BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
		ResultSetHandler<PersonVO> handler = new BeanHandler<PersonVO>(PersonVO.class);
		PersonVO person = runner.query(sql, handler, "00001");
		System.out.println("查询到id=00001的人：" + person);
		
		String sql2 = "SELECT * FROM person";
		QueryRunner runner2 = new QueryRunner(ds);
		// BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
		BeanListHandler<PersonVO> handler2 = new BeanListHandler<PersonVO>(PersonVO.class);
		List<PersonVO> persons = runner2.query(sql2, handler2);
		System.out.println("查询到所有的人：" + persons);

		
	}
	
	private static DataSource createDataSource(){
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL11g";
		String user = "nc63";
		String password = "1";
		
		return new OracleDataSource(url, user, password);
	}
}
