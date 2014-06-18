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
 * BeanUtils��������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��26��
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
			// Ϊ�����ָ��������ֵ
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
			// ��Դ������������Ը��Ƹ�Ŀ�����ԣ�ʵ��֤��֧�����ö����ǳ����
			BeanUtils.copyProperties(dest, ori);
			System.out.println(dest);
			System.out.println("ori.getAddresses() == dest.getAddresses() is " + (ori.getAddresses() == dest.getAddresses()));
			System.out.println();
			
			System.out.println(BeanUtils.getProperty(dest, "name"));
			// ����ͨ�����ַ�ʽ�������ü���(������)��Ԫ�أ��ȼ������´���
			// dest.getPhoneNumbers().get(0);
			System.out.println(BeanUtils.getProperty(dest, "phoneNumbers[0]"));
			// ����ͨ�����ַ�ʽ�������ö�������ԣ��ȼ������´���
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
