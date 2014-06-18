/**
 * 
 */
package javabean;

/**
 * 联系方式
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-10
 */
public class Contact {

	private String name;
	private String city;
	private String postalcode;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "contact: name=" + name + ", type= " + type + ", city=" + city
				+ ", postalcode=" + postalcode + ".";
	}
}
