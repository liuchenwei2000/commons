/**
 * 
 */
package bag;

import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.HashBag;

/**
 * Bag示例
 * <p>
 * 有时候需要在 Collection 中存放多个相同对象的拷贝，并且需要很方便的取得该对象拷贝的个数，Bag 提供这样的功能。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月28日
 */
public class BagTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// HashBag是Bag接口的一个标准实现。
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("a");
		bag.add("b");
		bag.add("b");
		bag.add("c");
		bag.add("c");
		bag.add("c");
		
		System.out.println("copies of a is " + bag.getCount("a"));// 获取Bag中该对象的拷贝数
		System.out.println("copies of b is " + bag.getCount("b"));
		System.out.println("copies of c is " + bag.getCount("c"));
		
		// BagUtils提供一组static的方法让调用者获取经过不同装饰后的Bag实例，类似Collections.
		Bag<String> bag2 = BagUtils.collectionBag(new HashBag<String>());
		bag2.add("book1", 100);
		bag2.add("book2", 200);
		bag2.add("book3", 300);
		
		System.out.println("number of books is " + bag2.size());
		
		// 返回Bag中所有元素的集合表示(无重复元素)
		Set<String> uniqueSet = bag2.uniqueSet();
		System.out.println("unique elements are " + uniqueSet);
	}
}
