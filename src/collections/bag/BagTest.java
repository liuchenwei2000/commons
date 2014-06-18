/**
 * 
 */
package bag;

import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.HashBag;

/**
 * Bagʾ��
 * <p>
 * ��ʱ����Ҫ�� Collection �д�Ŷ����ͬ����Ŀ�����������Ҫ�ܷ����ȡ�øö��󿽱��ĸ�����Bag �ṩ�����Ĺ��ܡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��28��
 */
public class BagTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// HashBag��Bag�ӿڵ�һ����׼ʵ�֡�
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("a");
		bag.add("b");
		bag.add("b");
		bag.add("c");
		bag.add("c");
		bag.add("c");
		
		System.out.println("copies of a is " + bag.getCount("a"));// ��ȡBag�иö���Ŀ�����
		System.out.println("copies of b is " + bag.getCount("b"));
		System.out.println("copies of c is " + bag.getCount("c"));
		
		// BagUtils�ṩһ��static�ķ����õ����߻�ȡ������ͬװ�κ��Bagʵ��������Collections.
		Bag<String> bag2 = BagUtils.collectionBag(new HashBag<String>());
		bag2.add("book1", 100);
		bag2.add("book2", 200);
		bag2.add("book3", 300);
		
		System.out.println("number of books is " + bag2.size());
		
		// ����Bag������Ԫ�صļ��ϱ�ʾ(���ظ�Ԫ��)
		Set<String> uniqueSet = bag2.uniqueSet();
		System.out.println("unique elements are " + uniqueSet);
	}
}
