/**
 * 
 */
package math;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * NumberUtilsʾ��
 * <p>
 * �ṩ����Number����Ĺ��ܡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-30
 */
public class NumberUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �����ַ�������BigInteger
		System.out.println(NumberUtils.createBigInteger("123456789011223344"));
		// �����ַ�������BigInteger
		System.out.println(NumberUtils.createBigDecimal("1.98765432109876544333221"));
		
		// �����ַ�������Double�������ƵĻ���int��float��long����
		System.out.println(NumberUtils.createDouble("1.9876"));
		// ���ַ���ת��Ϊdouble�����ƵĻ���int��float��long��short��byte����
		System.out.println(NumberUtils.toDouble("1.9876"));
		
		// �ж��ַ����Ƿ�ֻ��������
		System.out.println(NumberUtils.isDigits("1.9876"));
		// �ж��ַ����Ƿ�������
		System.out.println(NumberUtils.isNumber("1.9876"));
		
		int[] array = { 52, 43, 93, 5, 62, 57, 28, 79, 20 };
		// ���������е����ֵ�����ƵĻ���double��float��long��short��byte����
		System.out.println(NumberUtils.max(array));
		// ���������е���Сֵ�����ƵĻ���double��float��long��short��byte����
		System.out.println(NumberUtils.min(array));
	}
}
