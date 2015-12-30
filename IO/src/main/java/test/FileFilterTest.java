/**
 * 
 */
package test;

import org.apache.commons.io.filefilter.*;

import java.io.File;

/**
 * commons-IO 中有很多FileFilter的实现供使用。
 * <p>
 * IOFileFilter 是对 JDK 中FileFilter和FileNameFilter的组合，实现类有：
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
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-6
 */
public class FileFilterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File(FileComparatorTest.class.getResource("/files").getPath());
		
		/*
		 * IOFileFilter 可以组合使用，本例就是找出：
		 * 扩展名为 txt 或者 bak 的文件，并且不是目录文件
		 */
		SuffixFileFilter txtFilter = new SuffixFileFilter(".txt");
		// 创建 IOFileFilter 对象也可以用下面这种工厂方法的方式
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
