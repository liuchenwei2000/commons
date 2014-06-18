/**
 * 
 */
package bean;

import java.io.Serializable;

/**
 * JavaBean
 * <p>
 * DbUtils�Խ�����Զ���װΪJavaBean�����ſ���Ҫ��ģ�
 * ��������JavaBean�淶�����Bean��getter��setter����������������������һһ��Ӧ��
 * ����Ҫ��JavaBean��˽�г�Ա�����������һһ��Ӧ��
 * <p>
 * ���磺
 * person�����и��ֶνУ�address����ô��Ӧ��JavaBean��Person���б�����getAddress��setAddress����������
 * ��Person���п��Խ�address��������Ϊadd������û����ġ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��27��
 */
public class PersonVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	/**
	 * ������ʹ�ð�װ���ͣ�����Ҫʹ�û������͡�
	 * ʵ���Ͼ���Ϊ�˱�֤�ڲ�ѯ���Ϊnull��ʱ��Ҳ������Ϊ���������͸�nullֵ����������
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
