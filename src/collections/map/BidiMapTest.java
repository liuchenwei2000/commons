/**
 * 
 */
package map;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * BidiMap示例
 * <p>
 * 所谓 BidiMap，直译就是双向 Map，可以通过 key 找到 value，也可以通过 value 找到 key。
 * <p>
 * 这在我们日常的编码-名称匹配的时候很方便：
 * 因为我们除了需要通过编码找到名称之外，往往也需要处理用户输入的名称，然后获取其编码。
 * 需要注意的是 BidiMap 当中不光  key 不能重复，value 也不可以。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月28日
 */
public class BidiMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DualHashBidiMap 是 BidiMap 的一个标准实现。
		BidiMap<String, String> code_name_map = new DualHashBidiMap<String, String>();
		code_name_map.put("A", "B");
		code_name_map.put("A", "C");
		// 只存在 A=C 的映射
		System.out.println(code_name_map);

		code_name_map.clear();
		code_name_map.put("B", "A");
		code_name_map.put("C", "A");
		// 只存在 C=A 的映射，证明了 value 也不可以重复。
		System.out.println(code_name_map);

		code_name_map.clear();
		code_name_map.put("BJ", "Beijing");
		code_name_map.put("SH", "Shanghai");
		code_name_map.put("GZ", "Guangzhou");
		code_name_map.put("TJ", "Tianjin");
		// 通过 key 获取 value
		System.out.println("BJ=" + code_name_map.get("BJ"));
		// 通过 value 获取 key
		System.out.println("Guangzhou=" + code_name_map.getKey("Guangzhou"));
		// 将 map 的 key-value 对进行翻转产生一个新的BidiMap并返回
		System.out.println(code_name_map.inverseBidiMap());
		// 根据指定的 value 删除一个 key-balue 对
		code_name_map.removeValue("Shanghai");
		System.out.println("remove Shanghai : " + code_name_map);
	}
}
