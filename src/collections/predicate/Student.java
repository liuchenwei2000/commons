/**
 * 
 */
package predicate;

/**
 * ѧ����JavaBean
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-29
 */
public class Student {

	private String name;
	private int score;// ����
	private Sex sex;

	public Student(String name, int score, Sex sex) {
		super();
		this.name = name;
		this.score = score;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public String toString(){
		return name + "/" + score;
	}
}
