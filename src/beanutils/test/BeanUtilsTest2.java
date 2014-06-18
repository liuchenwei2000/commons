/**
 * 
 */
package test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;

import bean.Address;
import bean.Customer;

/**
 * BeanUtils基本方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月26日
 */
public class BeanUtilsTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Address[] addresses = new Address[2];
			addresses[0] = new Address();
			addresses[0].setCountry("China");
			addresses[0].setCity("Beijing");
			addresses[0].setStreet("Road 1187#");

			addresses[1] = new Address();
			// 为对象的指定属性设值
			BeanUtils.setProperty(addresses[1], "country", "China");
			BeanUtils.setProperty(addresses[1], "city", "Jinan");
			BeanUtils.setProperty(addresses[1], "street", "Road WenHuaDong");

			String[] phoneNumbers = new String[] { "129837132", "394394872" };

			Customer ori = new Customer();
			ori.setId("0001");
			ori.setName("Andy Lau");
			ori.setAddresses(addresses);
			ori.setPhoneNumbers(Arrays.asList(phoneNumbers));
			System.out.println(ori);
			
			Customer dest = new Customer();
			// 将源对象的所有属性复制给目标属性，实际证明支持内置对象的浅复制
			BeanUtils.copyProperties(dest, ori);
			System.out.println(dest);
			System.out.println("ori.getAddresses() == dest.getAddresses() is " + (ori.getAddresses() == dest.getAddresses()));
			System.out.println();
			
			System.out.println(BeanUtils.getProperty(dest, "name"));
			// 可以通过这种方式访问内置集合(或数组)的元素，等价于以下代码
			// dest.getPhoneNumbers().get(0);
			System.out.println(BeanUtils.getProperty(dest, "phoneNumbers[0]"));
			// 可以通过这种方式访问内置对象的属性，等价于以下代码
			// dest.getAddresses()[1].getCity();
			System.out.println(BeanUtils.getProperty(dest, "addresses[1].city"));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
