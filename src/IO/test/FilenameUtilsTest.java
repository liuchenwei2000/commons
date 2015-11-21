/**
 * 
 */
package test;

import org.apache.commons.io.FilenameUtils;

/**
 * FilenameUtils示例
 * <p>
 * FilenameUtils 是文件名和文件路径的操作工具，屏蔽不同操作系统的文件系统差异。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-6
 */
public class FilenameUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "C:/Windows/system32/./bak2/../cmd.exe";
		// 去掉字符串中的 .&&..
		System.out.println(FilenameUtils.normalize(path)); // C:\Windows\system32\cmd.exe
		// 路径前缀
		System.out.println(FilenameUtils.getPrefix(path)); // C:/
		// 文件名
		System.out.println(FilenameUtils.getBaseName(path)); // cmd
		// 文件扩展名
		System.out.println(FilenameUtils.getExtension(path)); // exe
		// 文件名+扩展名
		System.out.println(FilenameUtils.getName(path)); // cmd.exe
		// 文件全路径
		System.out.println(FilenameUtils.getFullPath(path)); // C:/Windows/system32/./bak2/../
	}
}
