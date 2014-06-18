/**
 * 
 */
package closure;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Closureʾ��
 * <p>
 * Closure �ṩһ�����������execute������Ϊ�����ڴ���һϵ�ж���ʱ���Խ������߼����������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-29
 */
public class ClosureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * ����:
		 * �����еĹ�ԱEmployee��н20%��
		 */
		Employee[] employees = new Employee[]{
				new Employee("Tom",Type.DEV,1200),
				new Employee("Jimmy",Type.QA,1000),
				new Employee("Ann",Type.PM,1400),
		};
		List<Employee> employeeList = Arrays.asList(employees);
		System.out.println("before salary increase��" + employeeList);
		
		
		Closure<Employee> salaryIncreaseClosure = new Closure<Employee>() {

			@Override
			public void execute(Employee employee) {
				employee.setSalary(employee.getSalary() * 1.2);
			}
		};
		
		CollectionUtils.forAllDo(employeeList, salaryIncreaseClosure);
		System.out.println(" after salary increase��" + employeeList);
		/*
		 * ��Closure ���ﻹ��һЩ�ܷ�����࣬�磺
		 * ChainedClosure ���԰�װһ��Closure��Ϊ����ִ�С�
		 * IfClosure �ڴ���ʱ��Ҫ�ṩ����һ��Predicate������Closure��ִ��ʱ����Predicate�ж��پ���ִ����һ��Closure��
		 * SwitchClosure ���ݴ���ʱ�����Predicate���Closure���Ӧִ�С�
		 * WhileClosure ���ݴ���ʱ�����Predicate���жϣ����Ϊtrue��ִ��Closure��ֱ��Predicate����false��
		 **/
	}
}
