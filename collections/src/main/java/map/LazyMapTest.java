/**
 * 
 */
package map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.LazyMap;

/**
 * LazyMap示例
 * <p>
 * Map中的键/值对一开始并不存在，当被调用到时才创建。 
 * <p>
 * 我们需要一个Map，但是由于创建成员的方法很“重”（比如数据库访问），或者我们只有在调用get()时才知道如何创建，
 * 或者Map中出现的可能性很多很多，我们无法在get()之前添加所有可能出现的键/值对，或者任何其它解释得通的原因，
 * 我们觉得没有必要去初始化一个Map而又希望它可以在必要时自动处理数据生成的话，LazyMap就变得很有用了。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月28日
 */
public class LazyMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory<Date> dateFactory = new Factory<Date>() {

			@Override
			public Date create() {
				return new Date();
			}
		};
		// 将参数map装饰成懒实例化的map
		LazyMap<String, Date> lazyMap = LazyMap.lazyMap(
				new HashMap<String, Date>(), dateFactory);
		System.out.println("before call get(key), map is " + lazyMap);
		// 当调用 get(key) 方法时，map才会使用 factory 创建 value，并把 key-value 的映射建立好
		System.out.println(lazyMap.get("now"));
		System.out.println("after call get(key), map is " + lazyMap);

		/**
		 * 可能也是为了解决下面这种传统用法的代码复杂度问题
		 */
		Map<String, Date> map = new HashMap<String, Date>();
		if (map.get("now") == null) {
			map.put("now", new Date());
		}
		Date date = map.get("now");
		System.out.println(date);
	}
}
