/**
 * 
 */
package bean;

/**
 * һ��ֻ�л������Ե�JavaBean
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��26��
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
		return "��Person name:"+ name + ", age:"+age+", weight:"+weight+" kg.��";
	}
}