/**
 * 
 */
package math;

import org.apache.commons.lang3.math.Fraction;

/**
 * Fraction示例
 * <p>
 * Fraction能够精确的表示分数，是Number的实现类，也是不可变类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-5-30
 */
public class FractionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 创建Fraction
		 */
		// Fraction定义了一些常用的分数对象常量
		System.out.println(Fraction.ONE_HALF);// 1/2
		// 指定分子、分母创建分数
		System.out.println(Fraction.getFraction(2, 3));// 2/3
		// 用double创建对应的分数
		System.out.println(Fraction.getFraction(0.5));// 1/2
		// 创建带分数
		System.out.println(Fraction.getFraction(2, 3, 5));// 2又3/5
		// 用字符串创建对应的分数
		System.out.println(Fraction.getFraction("3/4"));// 3/4
		// 指定分子、分母创建分数并返回约分后的结果
		System.out.println(Fraction.getReducedFraction(4, 6));// 2/3
		System.out.println();
		/**
		 * 获取Fraction信息
		 */
		Fraction fraction = Fraction.getFraction(5, 4);// 5/4
		// 返回分子
		System.out.println("分子：" + fraction.getNumerator());
		// 返回分母
		System.out.println("分母：" + fraction.getDenominator());
		// 返回整数部分，即将分数先转化为带分数形式再返回整数部分
		System.out.println("整数部分：" + fraction.getProperWhole());
		// 分数的字符串表示
		System.out.println("toString：" + fraction.toString());
		// 分数的字符串表示，带分数格式
		System.out.println("toProperString：" + fraction.toProperString());
		System.out.println();
		/**
		 * Fraction运算
		 */
		fraction = Fraction.getFraction(2, 4);// 2/4
		System.out.println("原始分数：" + fraction);
		// 1，自运算
		System.out.println(fraction.abs());// 取绝对值
		System.out.println(fraction.negate());// 取相反数
		System.out.println(fraction.invert());// 取倒数
		System.out.println(fraction.doubleValue());// 小数表示
		System.out.println(fraction.reduce());// 约分后的分数
		System.out.println();
		// 2，相互运算
		System.out.println(fraction.pow(2));// 指数
		System.out.println(fraction.add(Fraction.ONE_THIRD));// +
		System.out.println(fraction.subtract(Fraction.ONE_THIRD));// -
		System.out.println(fraction.multiplyBy(Fraction.ONE_THIRD));// *
		System.out.println(fraction.divideBy(Fraction.ONE_THIRD));// /
	}
}
