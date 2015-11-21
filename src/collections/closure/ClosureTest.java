/**
 * 
 */
package closure;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Closure示例
 * <p>
 * Closure 提供一个操作对象的execute方法，为我们在处理一系列对象时可以将处理逻辑分离出来。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-5-29
 */
public class ClosureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 场景:
		 * 给所有的雇员Employee加薪20%。
		 */
		Employee[] employees = new Employee[]{
				new Employee("Tom",Type.DEV,1200),
				new Employee("Jimmy",Type.QA,1000),
				new Employee("Ann",Type.PM,1400),
		};
		List<Employee> employeeList = Arrays.asList(employees);
		System.out.println("before salary increase：" + employeeList);
		
		
		Closure<Employee> salaryIncreaseClosure = new Closure<Employee>() {

			@Override
			public void execute(Employee employee) {
				employee.setSalary(employee.getSalary() * 1.2);
			}
		};
		
		CollectionUtils.forAllDo(employeeList, salaryIncreaseClosure);
		System.out.println(" after salary increase：" + employeeList);
		/*
		 * 在Closure 包里还有一些很方便的类，如：
		 * ChainedClosure 可以包装一组Closure作为整体执行。
		 * IfClosure 在创建时需要提供给它一个Predicate和两个Closure，执行时先做Predicate判定再决定执行哪一个Closure。
		 * SwitchClosure 根据创建时传入的Predicate组和Closure组对应执行。
		 * WhileClosure 根据创建时传入的Predicate做判断，如果为true则执行Closure，直到Predicate返回false。
		 **/
	}
}
