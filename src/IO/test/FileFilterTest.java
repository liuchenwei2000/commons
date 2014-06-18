/**
 * 
 */
package test;

import java.io.File;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * commons-IO ���кܶ�FileFilter��ʵ�ֹ�ʹ�á�
 * <p>
 * IOFileFilter �Ƕ� JDK ��FileFilter��FileNameFilter����ϣ�ʵ�����У�
 * DirectoryFilter Only accept directories 
 * PrefixFileFilter Filter based on a prefix
 * SuffixFileFilter Filter based on a suffix
 * NameFileFilter Filter based on a filename
 * WildcardFileFilter Filter based on wildcards
 * AgeFileFilter Filter based on last modified time of file
 * SizeFileFilter Filter based on file size
 * CanReadFileFilter based on file readable 
 * CanWriteFileFilter based on file writable  
 *
 * And there are five 'boolean' filters:
 *
 * TrueFileFilter Accept all files
 * FalseFileFilter Accept no files
 * NotFileFilter Applies a logical NOT to an existing filter
 * AndFileFilter Combines two filters using a logical AND
 * OrFileFilter Combines two filter using a logical OR
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-6
 */
public class FileFilterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("files");
		
		/*
		 * IOFileFilter �������ʹ�ã����������ҳ���
		 * ��չ��Ϊ txt ���� bak ���ļ������Ҳ���Ŀ¼�ļ�
		 */
		SuffixFileFilter txtFilter = new SuffixFileFilter(".txt");
		// ���� IOFileFilter ����Ҳ�������������ֹ��������ķ�ʽ
		IOFileFilter bakFilter = FileFilterUtils.suffixFileFilter(".bak");
		OrFileFilter txtOrBakFilter = new OrFileFilter(txtFilter, bakFilter);
		NotFileFilter notDirFilter = new NotFileFilter(DirectoryFileFilter.INSTANCE);
		AndFileFilter filter = new AndFileFilter(txtOrBakFilter, notDirFilter);
		
		String[] files = dir.list(filter);
		for (String file : files) {
			System.out.println(file);
		}
	}
}
