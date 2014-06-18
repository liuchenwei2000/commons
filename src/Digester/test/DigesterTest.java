/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;

import javabean.AddressBook;
import javabean.Contact;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

/**
 * Digester����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-5
 */
public class DigesterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����ʵ��
		Digester digester = new Digester();
		digester.setValidating(false);
		// ָ��ƥ��ģʽ��Ҫ�������࣬ʵ�����ǽ���XML��ǩ��Java�����ӳ��
		digester.addObjectCreate("address-book", AddressBook.class);
		digester.addObjectCreate("address-book/contact", Contact.class);
		// ���ö�������(attribute)������ <contact type="private"> �е� type attribute
		digester.addSetProperties("address-book/contact");
		// ���ö�������(property)������ <contact><name>Tom</name></contact> �е� <name> property�����÷���ķ�ʽ��
		digester.addBeanPropertySetter("address-book/contact/name");
		// ���õ�ƥ��ģʽ���ҵ�ʱҪ���õķ���������ֵҲ���������ַ�ʽ�����ã���addBeanPropertySetter�ȼ�
		digester.addCallMethod("address-book/contact/city", "setCity", 0);
		// ������ģʽ������������һ�µ����ʱ����Ҫָ�����ǵ�ӳ���ϵ
		digester.addBeanPropertySetter("address-book/contact/pcode", "postalcode");
		// ���ƶ�����һ����ǩ��ʱ�Ķ���
		digester.addSetNext("address-book/contact", "addContact");
		try {
			// ����
			AddressBook addressBook = digester.parse(new File("files/address-book.xml"));
			Contact[] contacts = addressBook.getContacts();
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
