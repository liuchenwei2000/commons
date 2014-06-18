/**
 * 
 */
package closure;

/**
 * ��Ա����ͨ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-29
 */
public class Employee {

	private String name;
	private Type type;
	private double salary;

	public Employee(String name, Type type, double salary) {
		this.name = name;
		this.type = type;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return " name��" + name + ", type��" + type + ", salary��" + salary + ".";
	}
}
