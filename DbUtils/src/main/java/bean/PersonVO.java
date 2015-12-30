/**
 * 
 */
package bean;

import java.io.Serializable;

/**
 * JavaBean
 * <p>
 * DbUtils对结果集自动封装为JavaBean是有着苛刻要求的：
 * 必须满足JavaBean规范，其次Bean的getter与setter方法的名字与结果集的列名一一对应，
 * 而不要求JavaBean的私有成员与表结果集列名一一对应。
 * <p>
 * 比如：
 * person表中有个字段叫：address，那么对应的JavaBean的Person类中必须有getAddress和setAddress两个方法，
 * 而Person类中可以将address属性命名为add，这是没问题的。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月27日
 */
public class PersonVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	/**
	 * 尽可能使用包装类型，而不要使用基本类型。
	 * 实际上就是为了保证在查询结果为null的时候，也不会因为给基本类型赋null值而发生错误。
	 */
	private Integer age;
	private String addr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return addr;
	}

	public void setAddress(String address) {
		this.addr = address;
	}
	
	public String toString() {
		return "person id=" + id + ", name=" + name + ", age=" + age
				+ ", address=" + addr + ".";
	}
}
