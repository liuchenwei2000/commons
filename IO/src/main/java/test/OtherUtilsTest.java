/**
 * 
 */
package test;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.LockableFileWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * 其他工具类示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-6
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
	 * FileSystemUtils提供了JDK不支持的方法，如硬盘的剩余空间
	 */
	private static void testFileSystemUtils() {
		try {
			// 返回指定路径的剩余空间，单位KB
			long capcity = FileSystemUtils.freeSpaceKb("C:/");
			System.out.println(capcity / ((double) 1024 * 1024) + " GB");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * LockableFileWriter 使用“文件锁”而非“对象锁”来限制多线程环境下的写动作。
	 */
	private static void testLockableFileWriter() {
		new Thread(new LockableFileWriterTestTask()).start();
		new Thread(new LockableFileWriterTestTask()).start();
	}
	
	private static class LockableFileWriterTestTask implements Runnable {

		public void run() {
			Writer writer = null;
			try {
				writer = new LockableFileWriter(OtherUtilsTest.class.getResource("files/test.txt").getPath());
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
