/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javabean.DataSourceVO;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.ExtendedBaseRules;
import org.xml.sax.SAXException;

/**
 * 数据源集
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-5
 */
public class DataSources {

	private Map<String,DataSourceVO> dsMap = new HashMap<String,DataSourceVO>();
	
	public void register(DataSourceVO ds){
		dsMap.put(ds.getDataSourceName(), ds);
	}
	
	public void unregister(String name){
		dsMap.remove(name);
	}
	
	public void load(File file) throws IOException, SAXException{
		Digester digester = new Digester();
		digester.setValidating(false);
		// ExtendedBaseRules类扩展了基本的匹配规则，提供了更通用的通配符匹配规则
		digester.setRules(new ExtendedBaseRules());
		digester.push(this);// 将本对象放入栈，作为顶层对象
		digester.addObjectCreate("data-sources/dataSource", DataSourceVO.class);
		digester.addSetProperties("data-sources/dataSource");
		// 使用通配符将会为 data-sources/dataSource 下所有的属性设值，而不用再一一指明，采用反射的方式。
		digester.addBeanPropertySetter("data-sources/dataSource/?");
		digester.addSetNext("data-sources/dataSource", "register");
		digester.parse(file);
	}
	
	public String toString(){
		return dsMap.keySet().toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSources dataSources = new DataSources();
		try {
			dataSources.load(new File("files/datasource.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		System.out.println(dataSources);
	}
}
