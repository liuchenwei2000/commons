/**
 * 
 */
package bean;

import java.util.Arrays;
import java.util.List;

/**
 * һ���и�������(���ö��������)��JavaBean
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��26��
 */
public class Customer {

	private String name;
	private String id;
	private Address[] addresses;
	private List<String> phoneNumbers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public String toString(){
		return "��Customer name:" + name +", id="+id + 
				"\naddresses:\n"+ Arrays.asList(addresses) +
				"\nphone numbers:\n"+ phoneNumbers + "��";
	}

}
