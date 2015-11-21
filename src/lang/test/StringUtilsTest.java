/**
 * 
 */
package test;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-5-30
 */
public class StringUtilsTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "";
		String str2 = " ";
		String str3 = "\t";
		String str4 = null;
		String str5 = "123";
		String str6 = "ABCDEFG";
		String str7 = "It feels good to use Jakarta Commons.\r\n";

		// 判断是否是空串
		System.out.println("==============================");
		System.out.println("Is str1 blank? " + StringUtils.isBlank(str1));
		System.out.println("Is str2 blank? " + StringUtils.isBlank(str2));
		System.out.println("Is str3 blank? " + StringUtils.isBlank(str3));
		System.out.println("Is str4 blank? " + StringUtils.isBlank(str4));

		// 判断是否是数值
		System.out.println("==============================");
		System.out.println("Is str5 numeric? " + StringUtils.isNumeric(str5));
		System.out.println("Is str6 numeric? " + StringUtils.isNumeric(str6));

		// 翻转字符串
		System.out.println("==============================");
		System.out.println("str6: " + str6);
		System.out.println("str6 reversed: " + StringUtils.reverse(str6));
		System.out.println("str7: " + str7);
		String str8 = StringUtils.chomp(str7);
		str8 = StringUtils.reverseDelimited(str8, ' ');
		System.out.println("str7 reversed whole words : \r\n" + str8);

		// 其他用法
		System.out.println("==============================");
		System.out.println("print header:");
		// 将"="打印50次
		String padding = StringUtils.repeat("=", 50);
		// 将字符串打印在中间位置
		String msg = StringUtils.center(" Customised Header ", 50, "%");
		Object[] raw = new Object[] { padding, msg, padding };
		// 将字符串数组中的每个元素使用指定的分隔符进行连接
		String header = StringUtils.join(raw, "\r\n");
		System.out.println(header);
	}
}
