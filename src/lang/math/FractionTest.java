/**
 * 
 */
package math;

import org.apache.commons.lang3.math.Fraction;

/**
 * Fractionʾ��
 * <p>
 * Fraction�ܹ���ȷ�ı�ʾ��������Number��ʵ���࣬Ҳ�ǲ��ɱ��ࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-5-30
 */
public class FractionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * ����Fraction
		 */
		// Fraction������һЩ���õķ���������
		System.out.println(Fraction.ONE_HALF);// 1/2
		// ָ�����ӡ���ĸ��������
		System.out.println(Fraction.getFraction(2, 3));// 2/3
		// ��double������Ӧ�ķ���
		System.out.println(Fraction.getFraction(0.5));// 1/2
		// ����������
		System.out.println(Fraction.getFraction(2, 3, 5));// 2��3/5
		// ���ַ���������Ӧ�ķ���
		System.out.println(Fraction.getFraction("3/4"));// 3/4
		// ָ�����ӡ���ĸ��������������Լ�ֺ�Ľ��
		System.out.println(Fraction.getReducedFraction(4, 6));// 2/3
		System.out.println();
		/**
		 * ��ȡFraction��Ϣ
		 */
		Fraction fraction = Fraction.getFraction(5, 4);// 5/4
		// ���ط���
		System.out.println("���ӣ�" + fraction.getNumerator());
		// ���ط�ĸ
		System.out.println("��ĸ��" + fraction.getDenominator());
		// �����������֣�����������ת��Ϊ��������ʽ�ٷ�����������
		System.out.println("�������֣�" + fraction.getProperWhole());
		// �������ַ�����ʾ
		System.out.println("toString��" + fraction.toString());
		// �������ַ�����ʾ����������ʽ
		System.out.println("toProperString��" + fraction.toProperString());
		System.out.println();
		/**
		 * Fraction����
		 */
		fraction = Fraction.getFraction(2, 4);// 2/4
		System.out.println("ԭʼ������" + fraction);
		// 1��������
		System.out.println(fraction.abs());// ȡ����ֵ
		System.out.println(fraction.negate());// ȡ�෴��
		System.out.println(fraction.invert());// ȡ����
		System.out.println(fraction.doubleValue());// С����ʾ
		System.out.println(fraction.reduce());// Լ�ֺ�ķ���
		System.out.println();
		// 2���໥����
		System.out.println(fraction.pow(2));// ָ��
		System.out.println(fraction.add(Fraction.ONE_THIRD));// +
		System.out.println(fraction.subtract(Fraction.ONE_THIRD));// -
		System.out.println(fraction.multiplyBy(Fraction.ONE_THIRD));// *
		System.out.println(fraction.divideBy(Fraction.ONE_THIRD));// /
	}
}
