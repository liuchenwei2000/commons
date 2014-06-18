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
 * ����Դ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-5
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
		// ExtendedBaseRules����չ�˻�����ƥ������ṩ�˸�ͨ�õ�ͨ���ƥ�����
		digester.setRules(new ExtendedBaseRules());
		digester.push(this);// �����������ջ����Ϊ�������
		digester.addObjectCreate("data-sources/dataSource", DataSourceVO.class);
		digester.addSetProperties("data-sources/dataSource");
		// ʹ��ͨ�������Ϊ data-sources/dataSource �����е�������ֵ����������һһָ�������÷���ķ�ʽ��
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
