/**
 * 
 */
package test;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.LockableFileWriter;

/**
 * ����������ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-6
 */
public class OtherUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testFileSystemUtils();
		testLockableFileWriter();
	}
	
	/**
	 * FileSystemUtils�ṩ��JDK��֧�ֵķ�������Ӳ�̵�ʣ��ռ�
	 */
	private static void testFileSystemUtils() {
		try {
			// ����ָ��·����ʣ��ռ䣬��λKB
			long capcity = FileSystemUtils.freeSpaceKb("C:/");
			System.out.println(capcity / ((double) 1024 * 1024) + " GB");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * LockableFileWriter ʹ�á��ļ��������ǡ��������������ƶ��̻߳����µ�д������
	 */
	private static void testLockableFileWriter() {
		new Thread(new LockableFileWriterTestTask()).start();
		new Thread(new LockableFileWriterTestTask()).start();
	}
	
	private static class LockableFileWriterTestTask implements Runnable {

		public void run() {
			Writer writer = null;
			try {
				writer = new LockableFileWriter("files/test.txt");
				writer.write("testLockableFileWriter()");
				Thread.sleep(1000);
				writer.write(new Date().toString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
	}
}
