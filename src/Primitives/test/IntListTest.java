/**
 * 
 */
package test;

import org.apache.commons.collections.primitives.ArrayIntList;
import org.apache.commons.collections.primitives.IntIterator;
import org.apache.commons.collections.primitives.IntList;

/**
 * IntListʾ����������������Ҳ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-12
 */
public class IntListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ʹ�÷�ʽ���£�IntList�Ľӿ�������JDK collection�����Ƶ�
		IntList intList = new ArrayIntList();
		for (int i = 0; i < 100; i++) {
			intList.add(i);
		}
		// ������ʽ����
		IntIterator it = intList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
