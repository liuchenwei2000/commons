/**
 * 
 */
package map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.LazyMap;

/**
 * LazyMapʾ��
 * <p>
 * Map�еļ�/ֵ��һ��ʼ�������ڣ��������õ�ʱ�Ŵ����� 
 * <p>
 * ������Ҫһ��Map���������ڴ�����Ա�ķ����ܡ��ء����������ݿ���ʣ�����������ֻ���ڵ���get()ʱ��֪����δ�����
 * ����Map�г��ֵĿ����Ժܶ�ܶ࣬�����޷���get()֮ǰ������п��ܳ��ֵļ�/ֵ�ԣ������κ��������͵�ͨ��ԭ��
 * ���Ǿ���û�б�Ҫȥ��ʼ��һ��Map����ϣ���������ڱ�Ҫʱ�Զ������������ɵĻ���LazyMap�ͱ�ú������ˡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��28��
 */
public class LazyMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory<Date> dateFactory = new Factory<Date>() {

			@Override
			public Date create() {
				return new Date();
			}
		};
		// ������mapװ�γ���ʵ������map
		LazyMap<String, Date> lazyMap = LazyMap.lazyMap(
				new HashMap<String, Date>(), dateFactory);
		System.out.println("before call get(key), map is " + lazyMap);
		// ������ get(key) ����ʱ��map�Ż�ʹ�� factory ���� value������ key-value ��ӳ�佨����
		System.out.println(lazyMap.get("now"));
		System.out.println("after call get(key), map is " + lazyMap);

		/**
		 * ����Ҳ��Ϊ�˽���������ִ�ͳ�÷��Ĵ��븴�Ӷ�����
		 */
		Map<String, Date> map = new HashMap<String, Date>();
		if (map.get("now") == null) {
			map.put("now", new Date());
		}
		Date date = map.get("now");
		System.out.println(date);
	}
}
