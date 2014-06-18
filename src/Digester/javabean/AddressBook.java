/**
 * 
 */
package javabean;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址簿
 * <p>
 * 与 files/address-book.xml 映射
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-10
 */
public class AddressBook {

	private List<Contact> contacts;

	public AddressBook() {
		this.contacts = new ArrayList<Contact>();
	}
	
	public void addContact(Contact contact){
		contacts.add(contact);
	}
	
	public void removeContact(Contact contact){
		contacts.remove(contact);
	}
	
	public Contact[] getContacts(){
		return contacts.toArray(new Contact[0]);
	}
}
