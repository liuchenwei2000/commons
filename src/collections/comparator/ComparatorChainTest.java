/**
 * 
 */
package comparator;


import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.FixedOrderComparator;

/**
 * ComparatorChainʾ��
 * <p>
 * �Ƚ�����������Ӷ���Ƚ�����ֱ��
 * 1���κε����Ƚ�������һ������Ľ����Ȼ�󽫸ý�����أ���
 * 2��ComparatorChainִ�н������������㡣
 * <p>
 * ʹ�������е������SQL�еĶ�������ǳ����ƣ���������ģ����������Java����ʵ�֡�
 * ��ComparatorChain ��һ�� Comparator ������֮�󣬾Ϳ���ʵ�ַǳ����ıȽϲ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��28��
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
        // �Ȱ�owner�����ٰ� severity���ض�˳���������id����
        String[] severityOrder = {"Critical", "Major", "Minor", "Enhancement"};
        // FixedOrderComparator�����ڶ���һ�������˳�򣬶�һ��������������Զ���˳���������
        Comparator<String> severityComparator = new FixedOrderComparator<String>(severityOrder);
        // ����һ�� Comparator �������е� Comparator ����ᱻ����ִ��
        ComparatorChain<String> compChain = new ComparatorChain<String>();
        // BeanComparator������beanutils�������԰���Bean��ĳһָ�����Խ�������
        compChain.addComparator(new BeanComparator<String>("owner"));
        compChain.addComparator(new BeanComparator<String>("severity", severityComparator));  
        compChain.addComparator(new BeanComparator<String>("id"));  
        // ��������
        Arrays.sort(issues, (Comparator)compChain);
        for (int i = 0; i < issues.length; i++) {  
            System.out.println(issues[i]);  
        }  
        /**
         * ����������ʵ�֣�
         * BooleanComparator����������һ��Boolean����ָ����true������false��
         * ComparableComparator����������ʵ����java.lang.Comparable�ӿڵĶ�����String��Integer�ȵȶ�ʵ����Comparable�ӿڣ���
         * NullComparator����nullֵҲ�ɲ���Ƚϣ������趨Ϊ��null���ߺ�null��
         * ReverseComparator����ԭ�е�ComparatorЧ����ת��
         * TransformingComparator����һ��Comparatorװ��Ϊ����TransformerЧ����Comparator�� 
         */
	}
}
