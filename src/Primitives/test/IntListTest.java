/**
 * 
 */
package test;

import org.apache.commons.collections.primitives.ArrayIntList;
import org.apache.commons.collections.primitives.IntIterator;
import org.apache.commons.collections.primitives.IntList;

/**
 * IntList示例，其他基础类型也类似
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-12
 */
public class IntListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 使用方式如下，IntList的接口命名和JDK collection是类似的
		IntList intList = new ArrayIntList();
		for (int i = 0; i < 100; i++) {
			intList.add(i);
		}
		// 遍历方式如下
		IntIterator it = intList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
