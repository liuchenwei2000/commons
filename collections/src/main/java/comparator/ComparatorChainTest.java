/**
 *
 */
package comparator;


import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.FixedOrderComparator;

/**
 * ComparatorChain示例
 * <p>
 * 比较器链可以添加多个比较器，直到
 * 1，任何单个比较器返回一个非零的结果，然后将该结果返回，或
 * 2，ComparatorChain执行结束，并返回零。
 * <p>
 * 使用它进行的排序和SQL中的多列排序非常类似，可以理解成模拟多列排序的Java代码实现。
 * 用ComparatorChain 将一组 Comparator 串起来之后，就可以实现非常灵活的比较操作。
 *
 * @author 刘晨伟
 *
 * 创建日期：2014年5月28日
 */
public class ComparatorChainTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
        Issue[] issues = new Issue[] {
                new Issue(15102, "Major", "John"),
                new Issue(15103, "Minor", "Agnes"),
                new Issue(15104, "Critical", "Bill"),
                new Issue(15105, "Major", "John"),
                new Issue(15106, "Major", "John"),
                new Issue(15107, "Critical", "John"),
                new Issue(15108, "Major", "Agnes"),
                new Issue(15109, "Minor", "Julie"),
                new Issue(15110, "Major", "Mary"),
                new Issue(15111, "Enhancement", "Bill"),
                new Issue(15112, "Minor", "Julie"),
                new Issue(15113, "Major", "Julie")
        };
        // 先按owner排序，再按 severity的特定顺序排序，最后按id排序
        String[] severityOrder = {"Critical", "Major", "Minor", "Enhancement"};
        // FixedOrderComparator：用于定义一个特殊的顺序，对一组对象按照这样的自定义顺序进行排序。
        Comparator<String> severityComparator = new FixedOrderComparator<String>(severityOrder);
        // 定义一组 Comparator 链，链中的 Comparator 对象会被依次执行
        ComparatorChain<String> compChain = new ComparatorChain<String>();
        // BeanComparator：属于beanutils包，可以按照Bean的某一指定属性进行排序。
//        compChain.addComparator(new BeanComparator<String>("owner"));
//        compChain.addComparator(new BeanComparator<String>("severity", severityComparator));
//        compChain.addComparator(new BeanComparator<String>("id"));
        // 进行排序
        Arrays.sort(issues, (Comparator)compChain);
        for (int i = 0; i < issues.length; i++) {
            System.out.println(issues[i]);
        }
        /**
         * 其他排序器实现：
         * BooleanComparator：用于排序一组Boolean对象，指明先true还是先false。
         * ComparableComparator：用于排序实现了java.lang.Comparable接口的对象（如String、Integer等等都实现了Comparable接口）。
         * NullComparator：让null值也可参与比较，可以设定为先null或者后null。
         * ReverseComparator：将原有的Comparator效果反转。
         * TransformingComparator：将一个Comparator装饰为具有Transformer效果的Comparator。
         */
	}
}
