/**
 * 
 */
package bean;

/**
 * һ����ͨ��JavaBean
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��26��
 */
public class Address {

	private String country;
	private String city;
	private String street;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String toString(){
		return "country:" + country + ", city:" +city + ", street:"+street;
	}
}
