/**
 * 
 */
package test;

import org.apache.commons.io.FilenameUtils;

/**
 * FilenameUtilsʾ��
 * <p>
 * FilenameUtils ���ļ������ļ�·���Ĳ������ߣ����β�ͬ����ϵͳ���ļ�ϵͳ���졣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-6
 */
public class FilenameUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "C:/Windows/system32/./bak2/../cmd.exe";
		// ȥ���ַ����е� .&&..
		System.out.println(FilenameUtils.normalize(path)); // C:\Windows\system32\cmd.exe
		// ·��ǰ׺
		System.out.println(FilenameUtils.getPrefix(path)); // C:/
		// �ļ���
		System.out.println(FilenameUtils.getBaseName(path)); // cmd
		// �ļ���չ��
		System.out.println(FilenameUtils.getExtension(path)); // exe
		// �ļ���+��չ��
		System.out.println(FilenameUtils.getName(path)); // cmd.exe
		// �ļ�ȫ·��
		System.out.println(FilenameUtils.getFullPath(path)); // C:/Windows/system32/./bak2/../
	}
}
