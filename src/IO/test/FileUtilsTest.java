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
 * FileUtilsʾ��
 * <p>
 * FileUtils ʵ��Ŀ¼���ļ��Ĵ�����ɾ������ա����ƵȲ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-6
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
			// ���ж�ȡ�ļ��е����ݣ�����ָ���ַ���
			List<String> lines = FileUtils.readLines(file, "GBK");
			for (String line : lines) {
				System.out.println(line);
			}

			// �����ļ���ÿ�����ݵĵ�����
			LineIterator it = FileUtils.lineIterator(file);
			try {
				while (it.hasNext()) {
					String line = it.nextLine();
					System.out.println(line);
				}
			} finally {
				LineIterator.closeQuietly(it);
			}

			// �����ļ�
			FileUtils.copyFile(file, file2);
			// ���ļ����Ƶ���һ��Ŀ¼��
			FileUtils.copyFileToDirectory(file, new File(basePath + "bak"
					+ File.separator), true);
			// ��java.net.URL���contentд��ָ���ļ���
			FileUtils.copyURLToFile(new URL(url), new File(basePath
					+ "baidu.html"));
			// ��InputStream�е�����д��ָ�����ļ���
			FileUtils.copyInputStreamToFile(new URL(url).openStream(),
					new File(basePath + "baidu2.html"));
			// ����һ��Ŀ¼�µ��������ݵ���һĿ¼��
			FileUtils.copyDirectory(new File(basePath + "bak"), new File(
					basePath + "bak2"));
			// ɾ��Ŀ¼����������
			FileUtils.deleteDirectory(new File(basePath + "bak"));
			// ��ָ����Ŀ¼�в�����չ��Ϊָ���������ļ��������������Ƿ�ݹ����
			Collection<File> subFiles = FileUtils.listFiles(new File(basePath),
					new String[] { "html" }, false);
			System.out.println(subFiles.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
