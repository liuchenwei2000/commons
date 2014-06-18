/**
 * 
 */
package bean;

import java.util.Arrays;
import java.util.List;

/**
 * 一个有复杂属性(内置对象、数组等)的JavaBean
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月26日
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
		return "【Customer name:" + name +", id="+id + 
				"\naddresses:\n"+ Arrays.asList(addresses) +
				"\nphone numbers:\n"+ phoneNumbers + "】";
	}

}
