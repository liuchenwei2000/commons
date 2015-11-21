/**
 * 
 */
package predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;

/**
 * Predicate示例
 * <p>
 * 它以一个 Object 对象为参数，处理后返回一个 boolean 值，检验某个对象是否满足某个条件。
 * <p>
 * 和 Comparator、Transformer 和 Closure 等都有些类似C/C++中的函数指针，它们都只是提供简单而明确定义的函数功能而已。
 * <p>
 * 一般在验证合法性(validation)或需要过滤功能(filtering)时使用。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-5-29
 */
public class PredicateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		validation();
		filtering();
	}

	/**
	 * Predicate提供验证功能
	 * <p>
	 * 场景:
	 * 用于验证输入参数是否合法：非空、字符串对象并且长度在6-10之间
	 */
	private static void validation(){
		// 非空 Predicate
		Predicate<Object> nullPredicate = PredicateUtils.notNullPredicate();
		// String 实例 Predicate
		Predicate<Object> stringPredicate = PredicateUtils.instanceofPredicate(String.class);
		// 字符串长度 Predicate
		Predicate<Object> lengthPredicate = new Predicate<Object>() {

			@Override
			public boolean evaluate(Object object) {
				String string = (String) object;
				return string.length() >= 6 && string.length() <= 10;
			}
		};
		/*
		 * Commons Collections 提供了一组定义好的 Predicate 类供我们使用，这些类都放在 org.apache.commons.collections4.functors 包中。
		 * 当然，我们也可以自定义 Predicate，只要实现这个 Predicate 接口即可。
		 * 在 Commons Collections 中也可以很方便使用的一组预定义组合 Predicate。
		 * 我们提供 2 个或不定数量个 Predicate，然后交给它，它可以帮我们处理额外的逻辑。
		 * 如 ：
		 * AllPredicate 当所有内部 prodicates 都返回 true 后，才返回 true。
		 * AnyPredicate 处理多个 Predicate，当其中一个满足就返回 true。
		 * NonePredicate 当所有内部 prodicates 失败后，才返回 true。
		 * OnePredicate 只有一个 Predicate 返回 true，才返回 true。
		 * AndPredicate 两个 predicates 做 and，只有当两者都返回 true 才返回 true。
		 * OrPredicate 两个 predicates 做 or，只要有一个返回true 就返回true。
		 * EqualPredicate 检查的 object 和 predicates 里面一样时返回 true。
		 * NotPredicate 对 Predicate 取反。
		 * IdentityPredicate 引用相同时返回true。
		 * InstanceofPredicate 类型符合时返回true。
		 * NotNullPredicate 非空时返回true。
		 * NullPredicate 空时返回true。
		 * NullIsFalsePredicate 输入是 null 返回 true。
		 * NullIsTruePredicate 输入是 null 返回 false。
		 * TruePredicate 永远返回 true。
		 * FalsePredicate 永远返回 false。
		 */
		@SuppressWarnings("unchecked")
		Predicate<Object> allPredicate = PredicateUtils.allPredicate(new Predicate[] { nullPredicate,
				stringPredicate, lengthPredicate });
		
		Object input = "ABCD1234";
		boolean isLegal = allPredicate.evaluate(input);
		System.out.println(input + " is " + (isLegal ? "" : "not") + " legal.");
		
		input = "ABCD";
		isLegal = allPredicate.evaluate(input);
		System.out.println(input + " is " + (isLegal ? "" : "not") + " legal.");
		
		input = null;
		isLegal = allPredicate.evaluate(input);
		System.out.println(input + " is " + (isLegal ? "" : "not") + " legal.");
		
		input = 8;
		isLegal = allPredicate.evaluate(input);
		System.out.println(input + " is " + (isLegal ? "" : "not") + " legal.");
	}
	
	/**
	 * Predicate提供过滤功能
	 */
	private static void filtering(){
		Student[] students = new Student[]{
				new Student("Tom",88,Sex.MALE),
				new Student("Ann",29,Sex.FEMALE),
				new Student("Peter",60,Sex.MALE),
				new Student("Lucy",94,Sex.FEMALE),
				new Student("Jimmy",77,Sex.MALE),
				new Student("Lily",67,Sex.FEMALE),
				new Student("Susan",46,Sex.FEMALE),
		};
		List<Student> allStudent = Arrays.asList(students);
		// 是否存在 90+ 的女学生
		Predicate<Student> p1 = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				return student.getScore() >= 90 && student.getSex().equals(Sex.FEMALE);
			}
		};
		boolean result = CollectionUtils.exists(allStudent, p1);
		System.out.println("是否存在 90+ 的女学生：" + result);
		
		// 随便找一个不及格的学生
		Predicate<Student> p2 = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				return student.getScore() < 60;
			}
		};
		Student student = CollectionUtils.find(allStudent, p2);
		System.out.println("一个不及格的学生：" + student.getName());
		
		// 查找所有85分以上的优秀学生
		Predicate<Student> p3 = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				return student.getScore() > 85;
			}
		};
		List<Student> excellentStudents = new ArrayList<Student>(allStudent);
		CollectionUtils.filter(excellentStudents, p3);
		System.out.println("85分以上的优秀学生有：" + excellentStudents);
	}
}
