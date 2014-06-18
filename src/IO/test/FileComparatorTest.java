/**
 * 
 */
package test;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;

/**
 * commons-IO ����һЩ������Comparator�ɹ��ļ�����ʹ�á�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-6
 */
public class FileComparatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("files");
		File[] files = dir.listFiles();
		// �ļ���������
		Arrays.sort(files, new NameFileComparator());
		System.out.println("sort by name:" + Arrays.asList(files));
		// �ļ���С������
		Arrays.sort(files, new SizeFileComparator());
		System.out.println("sort by size:" + Arrays.asList(files));
		// �ļ�����޸�ʱ��������
		Arrays.sort(files, new LastModifiedFileComparator());
		System.out.println("sort by ts:" + Arrays.asList(files));
	}
}
