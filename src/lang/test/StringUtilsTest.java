/**
 * 
 */
package test;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtilsʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-30
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

		// �ж��Ƿ��ǿմ�
		System.out.println("==============================");
		System.out.println("Is str1 blank? " + StringUtils.isBlank(str1));
		System.out.println("Is str2 blank? " + StringUtils.isBlank(str2));
		System.out.println("Is str3 blank? " + StringUtils.isBlank(str3));
		System.out.println("Is str4 blank? " + StringUtils.isBlank(str4));

		// �ж��Ƿ�����ֵ
		System.out.println("==============================");
		System.out.println("Is str5 numeric? " + StringUtils.isNumeric(str5));
		System.out.println("Is str6 numeric? " + StringUtils.isNumeric(str6));

		// ��ת�ַ���
		System.out.println("==============================");
		System.out.println("str6: " + str6);
		System.out.println("str6 reversed: " + StringUtils.reverse(str6));
		System.out.println("str7: " + str7);
		String str8 = StringUtils.chomp(str7);
		str8 = StringUtils.reverseDelimited(str8, ' ');
		System.out.println("str7 reversed whole words : \r\n" + str8);

		// �����÷�
		System.out.println("==============================");
		System.out.println("print header:");
		// ��"="��ӡ50��
		String padding = StringUtils.repeat("=", 50);
		// ���ַ�����ӡ���м�λ��
		String msg = StringUtils.center(" Customised Header ", 50, "%");
		Object[] raw = new Object[] { padding, msg, padding };
		// ���ַ��������е�ÿ��Ԫ��ʹ��ָ���ķָ�����������
		String header = StringUtils.join(raw, "\r\n");
		System.out.println(header);
	}
}
