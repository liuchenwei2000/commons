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
 * Digester测试
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-5
 */
public class DigesterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建实例
		Digester digester = new Digester();
		digester.setValidating(false);
		// 指明匹配模式和要创建的类，实际上是建立XML标签和Java对象的映射
		digester.addObjectCreate("address-book", AddressBook.class);
		digester.addObjectCreate("address-book/contact", Contact.class);
		// 设置对象属性(attribute)，形如 <contact type="private"> 中的 type attribute
		digester.addSetProperties("address-book/contact");
		// 设置对象属性(property)，形如 <contact><name>Tom</name></contact> 中的 <name> property，采用反射的方式。
		digester.addBeanPropertySetter("address-book/contact/name");
		// 设置当匹配模式被找到时要调用的方法，属性值也可以用这种方式来设置，与addBeanPropertySetter等价
		digester.addCallMethod("address-book/contact/city", "setCity", 0);
		// 当遇到模式名和属性名不一致的情况时，需要指定它们的映射关系
		digester.addBeanPropertySetter("address-book/contact/pcode", "postalcode");
		// 当移动到下一个标签中时的动作
		digester.addSetNext("address-book/contact", "addContact");
		try {
			// 解析
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
