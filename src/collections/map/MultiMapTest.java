/**
 * 
 */
package map;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 * MultiMapʾ��
 * <p>
 * ����˵һ�� key �����Ǽ򵥵�ָ��һ�����󣬶���һ�����
 * put()��ʱ�����ͨ��Map���죬ֻ����get()ʱ����һ��Collection��
 * ����MultiMap�����Ժܷ������һ��key�Ϸ����������Ķ���Ҳ��ʵ����һ�Զࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��28��
 */
public class MultiMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// MultiValueMap �� MultiMap ��һ����׼ʵ�֡�
		MultiMap<String, String> one_more_map = new MultiValueMap<String, String>();
		one_more_map.put("country", "China");
		one_more_map.put("country", "USA");
		one_more_map.put("country", "Japan");
		one_more_map.put("city", "Beijing");
		one_more_map.put("city", "Washington");
		// ����һ��Collection������ key ��Ӧ������ value 
		System.out.println("country : " + one_more_map.get("country"));
		System.out.println("city : " + one_more_map.get("city"));
		// �Ƴ� key ������ӳ���ϵ
		one_more_map.remove("city");
		System.out.println("after remove city, map : " + one_more_map);
		// �Ƴ�ָ���� key-value ӳ���ϵ
		one_more_map.removeMapping("country", "Japan");
		System.out.println("after remove Japan, map : " + one_more_map);
	}
}
