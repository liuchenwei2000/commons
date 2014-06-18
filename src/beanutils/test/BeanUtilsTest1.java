/**
 * 
 */
package test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import bean.Person;

/**
 * BeanUtils��������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��26��
 */
public class BeanUtilsTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person ori = new Person();
		ori.setName("Tom");
		ori.setAge(20);
		ori.setWeight(100.5);
		System.out.println(ori);

		Person dest = new Person();
		try {
			// ��Դ������������Ը��Ƹ�Ŀ������
			BeanUtils.copyProperties(dest, ori);
			System.out.println(dest);
			// ����Դ�����ָ������ֵ
			System.out.println(BeanUtils.getProperty(dest, "name"));
			System.out.println(BeanUtils.getProperty(dest, "age"));
			System.out.println(BeanUtils.getProperty(dest, "weight"));
			System.out.println();
			
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("name", "Jerry");
			properties.put("age", 18);
			properties.put("weight", 20.4);
			// ʹ�� ������_����ֵ �� map ��JavaBean�����������
			BeanUtils.populate(ori, properties);
			System.out.println(ori);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}
}
