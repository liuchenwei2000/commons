/**
 * 
 */
package map;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 * MultiMap示例
 * <p>
 * 就是说一个 key 不再是简单的指向一个对象，而是一组对象。
 * put()的时候跟普通的Map无异，只是在get()时返回一个Collection。
 * 利用MultiMap，可以很方便的往一个key上放数量不定的对象，也就实现了一对多。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月28日
 */
public class MultiMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// MultiValueMap 是 MultiMap 的一个标准实现。
		MultiMap<String, String> one_more_map = new MultiValueMap<String, String>();
		one_more_map.put("country", "China");
		one_more_map.put("country", "USA");
		one_more_map.put("country", "Japan");
		one_more_map.put("city", "Beijing");
		one_more_map.put("city", "Washington");
		// 返回一个Collection，包含 key 对应的所有 value 
		System.out.println("country : " + one_more_map.get("country"));
		System.out.println("city : " + one_more_map.get("city"));
		// 移除 key 的所有映射关系
		one_more_map.remove("city");
		System.out.println("after remove city, map : " + one_more_map);
		// 移除指定的 key-value 映射关系
		one_more_map.removeMapping("country", "Japan");
		System.out.println("after remove Japan, map : " + one_more_map);
	}
}
