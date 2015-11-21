/**
 * 
 */
package math;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * NumberUtils示例
 * <p>
 * 提供处理Number对象的功能。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-5-30
 */
public class NumberUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 根据字符串创建BigInteger
		System.out.println(NumberUtils.createBigInteger("123456789011223344"));
		// 根据字符串创建BigInteger
		System.out.println(NumberUtils.createBigDecimal("1.98765432109876544333221"));
		
		// 根据字符串创建Double对象，类似的还有int、float、long方法
		System.out.println(NumberUtils.createDouble("1.9876"));
		// 将字符串转换为double，类似的还有int、float、long、short、byte方法
		System.out.println(NumberUtils.toDouble("1.9876"));
		
		// 判断字符串是否只包含数字
		System.out.println(NumberUtils.isDigits("1.9876"));
		// 判断字符串是否是数字
		System.out.println(NumberUtils.isNumber("1.9876"));
		
		int[] array = { 52, 43, 93, 5, 62, 57, 28, 79, 20 };
		// 返回数组中的最大值，类似的还有double、float、long、short、byte方法
		System.out.println(NumberUtils.max(array));
		// 返回数组中的最小值，类似的还有double、float、long、short、byte方法
		System.out.println(NumberUtils.min(array));
	}
}
