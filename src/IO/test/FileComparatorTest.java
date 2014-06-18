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
 * commons-IO 中有一些常见的Comparator可供文件排序使用。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-6
 */
public class FileComparatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("files");
		File[] files = dir.listFiles();
		// 文件名排序器
		Arrays.sort(files, new NameFileComparator());
		System.out.println("sort by name:" + Arrays.asList(files));
		// 文件大小排序器
		Arrays.sort(files, new SizeFileComparator());
		System.out.println("sort by size:" + Arrays.asList(files));
		// 文件最后修改时间排序器
		Arrays.sort(files, new LastModifiedFileComparator());
		System.out.println("sort by ts:" + Arrays.asList(files));
	}
}
