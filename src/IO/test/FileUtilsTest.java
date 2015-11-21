/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * FileUtils示例
 * <p>
 * FileUtils 实现目录、文件的创建、删除、清空、复制等操作。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-6
 */
public class FileUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		String basePath = "files" + File.separator;
		File file = new File(basePath + "test.txt");
		File file2 = new File(basePath + "bak" + File.separator + "test_bak.txt");
		
		try {
			// 按行读取文件中的内容，可以指定字符集
			List<String> lines = FileUtils.readLines(file, "GBK");
			for (String line : lines) {
				System.out.println(line);
			}

			// 返回文件中每行内容的迭代器
			LineIterator it = FileUtils.lineIterator(file);
			try {
				while (it.hasNext()) {
					String line = it.nextLine();
					System.out.println(line);
				}
			} finally {
				LineIterator.closeQuietly(it);
			}

			// 复制文件
			FileUtils.copyFile(file, file2);
			// 将文件复制到另一个目录下
			FileUtils.copyFileToDirectory(file, new File(basePath + "bak"
					+ File.separator), true);
			// 将java.net.URL类的content写到指定文件中
			FileUtils.copyURLToFile(new URL(url), new File(basePath
					+ "baidu.html"));
			// 将InputStream中的内容写到指定的文件中
			FileUtils.copyInputStreamToFile(new URL(url).openStream(),
					new File(basePath + "baidu2.html"));
			// 复制一个目录下的所有内容到另一目录下
			FileUtils.copyDirectory(new File(basePath + "bak"), new File(
					basePath + "bak2"));
			// 删除目录的所有内容
			FileUtils.deleteDirectory(new File(basePath + "bak"));
			// 在指定的目录中查找扩展名为指定参数的文件，第三个参数是否递归查找
			Collection<File> subFiles = FileUtils.listFiles(new File(basePath),
					new String[] { "html" }, false);
			System.out.println(subFiles.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
