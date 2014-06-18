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
 * BeanUtils基本方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月26日
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
			// 将源对象的所有属性复制给目标属性
			BeanUtils.copyProperties(dest, ori);
			System.out.println(dest);
			// 返回源对象的指定属性值
			System.out.println(BeanUtils.getProperty(dest, "name"));
			System.out.println(BeanUtils.getProperty(dest, "age"));
			System.out.println(BeanUtils.getProperty(dest, "weight"));
			System.out.println();
			
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("name", "Jerry");
			properties.put("age", 18);
			properties.put("weight", 20.4);
			// 使用 属性名_属性值 的 map 对JavaBean进行属性填充
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
