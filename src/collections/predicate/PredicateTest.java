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
 * Predicateʾ��
 * <p>
 * ����һ�� Object ����Ϊ����������󷵻�һ�� boolean ֵ������ĳ�������Ƿ�����ĳ��������
 * <p>
 * �� Comparator��Transformer �� Closure �ȶ���Щ����C/C++�еĺ���ָ�룬���Ƕ�ֻ���ṩ�򵥶���ȷ����ĺ������ܶ��ѡ�
 * <p>
 * һ������֤�Ϸ���(validation)����Ҫ���˹���(filtering)ʱʹ�á�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-29
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
	 * Predicate�ṩ��֤����
	 * <p>
	 * ����:
	 * ������֤��������Ƿ�Ϸ����ǿա��ַ��������ҳ�����6-10֮��
	 */
	private static void validation(){
		// �ǿ� Predicate
		Predicate<Object> nullPredicate = PredicateUtils.notNullPredicate();
		// String ʵ�� Predicate
		Predicate<Object> stringPredicate = PredicateUtils.instanceofPredicate(String.class);
		// �ַ������� Predicate
		Predicate<Object> lengthPredicate = new Predicate<Object>() {

			@Override
			public boolean evaluate(Object object) {
				String string = (String) object;
				return string.length() >= 6 && string.length() <= 10;
			}
		};
		/*
		 * Commons Collections �ṩ��һ�鶨��õ� Predicate �๩����ʹ�ã���Щ�඼���� org.apache.commons.collections4.functors ���С�
		 * ��Ȼ������Ҳ�����Զ��� Predicate��ֻҪʵ����� Predicate �ӿڼ��ɡ�
		 * �� Commons Collections ��Ҳ���Ժܷ���ʹ�õ�һ��Ԥ������� Predicate��
		 * �����ṩ 2 ���򲻶������� Predicate��Ȼ�󽻸����������԰����Ǵ��������߼���
		 * �� ��
		 * AllPredicate �������ڲ� prodicates ������ true �󣬲ŷ��� true��
		 * AnyPredicate ������ Predicate��������һ������ͷ��� true��
		 * NonePredicate �������ڲ� prodicates ʧ�ܺ󣬲ŷ��� true��
		 * OnePredicate ֻ��һ�� Predicate ���� true���ŷ��� true��
		 * AndPredicate ���� predicates �� and��ֻ�е����߶����� true �ŷ��� true��
		 * OrPredicate ���� predicates �� or��ֻҪ��һ������true �ͷ���true��
		 * EqualPredicate ���� object �� predicates ����һ��ʱ���� true��
		 * NotPredicate �� Predicate ȡ����
		 * IdentityPredicate ������ͬʱ����true��
		 * InstanceofPredicate ���ͷ���ʱ����true��
		 * NotNullPredicate �ǿ�ʱ����true��
		 * NullPredicate ��ʱ����true��
		 * NullIsFalsePredicate ������ null ���� true��
		 * NullIsTruePredicate ������ null ���� false��
		 * TruePredicate ��Զ���� true��
		 * FalsePredicate ��Զ���� false��
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
	 * Predicate�ṩ���˹���
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
		// �Ƿ���� 90+ ��Ůѧ��
		Predicate<Student> p1 = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				return student.getScore() >= 90 && student.getSex().equals(Sex.FEMALE);
			}
		};
		boolean result = CollectionUtils.exists(allStudent, p1);
		System.out.println("�Ƿ���� 90+ ��Ůѧ����" + result);
		
		// �����һ���������ѧ��
		Predicate<Student> p2 = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				return student.getScore() < 60;
			}
		};
		Student student = CollectionUtils.find(allStudent, p2);
		System.out.println("һ���������ѧ����" + student.getName());
		
		// ��������85�����ϵ�����ѧ��
		Predicate<Student> p3 = new Predicate<Student>() {

			@Override
			public boolean evaluate(Student student) {
				return student.getScore() > 85;
			}
		};
		List<Student> excellentStudents = new ArrayList<Student>(allStudent);
		CollectionUtils.filter(excellentStudents, p3);
		System.out.println("85�����ϵ�����ѧ���У�" + excellentStudents);
	}
}
