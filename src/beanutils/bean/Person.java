/**
 * 
 */
package bean;

/**
 * 一个只有基本属性的JavaBean
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月26日
 */
public class Person {

	private String name;
	private int age;
	private double weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return "【Person name:"+ name + ", age:"+age+", weight:"+weight+" kg.】";
	}
}
