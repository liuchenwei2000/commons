/**
 * 
 */
package map;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * BidiMapʾ��
 * <p>
 * ��ν BidiMap��ֱ�����˫�� Map������ͨ�� key �ҵ� value��Ҳ����ͨ�� value �ҵ� key��
 * <p>
 * ���������ճ��ı���-����ƥ���ʱ��ܷ��㣺
 * ��Ϊ���ǳ�����Ҫͨ�������ҵ�����֮�⣬����Ҳ��Ҫ�����û���������ƣ�Ȼ���ȡ����롣
 * ��Ҫע����� BidiMap ���в���  key �����ظ���value Ҳ�����ԡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��28��
 */
public class BidiMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DualHashBidiMap �� BidiMap ��һ����׼ʵ�֡�
		BidiMap<String, String> code_name_map = new DualHashBidiMap<String, String>();
		code_name_map.put("A", "B");
		code_name_map.put("A", "C");
		// ֻ���� A=C ��ӳ��
		System.out.println(code_name_map);

		code_name_map.clear();
		code_name_map.put("B", "A");
		code_name_map.put("C", "A");
		// ֻ���� C=A ��ӳ�䣬֤���� value Ҳ�������ظ���
		System.out.println(code_name_map);

		code_name_map.clear();
		code_name_map.put("BJ", "Beijing");
		code_name_map.put("SH", "Shanghai");
		code_name_map.put("GZ", "Guangzhou");
		code_name_map.put("TJ", "Tianjin");
		// ͨ�� key ��ȡ value
		System.out.println("BJ=" + code_name_map.get("BJ"));
		// ͨ�� value ��ȡ key
		System.out.println("Guangzhou=" + code_name_map.getKey("Guangzhou"));
		// �� map �� key-value �Խ��з�ת����һ���µ�BidiMap������
		System.out.println(code_name_map.inverseBidiMap());
		// ����ָ���� value ɾ��һ�� key-balue ��
		code_name_map.removeValue("Shanghai");
		System.out.println("remove Shanghai : " + code_name_map);
	}
}
