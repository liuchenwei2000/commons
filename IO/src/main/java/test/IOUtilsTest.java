/**
 * 
 */
package test;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * IOUtils示例
 * <p>
 * IOUtils 实现对InputStream, OutputStream, Reader, Writer 的读、写、复制。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-6
 */
public class IOUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		try {
			System.out.print("Java IO :");
			readURLByJavaIO(url);
			System.out.print("Commons-IO toString :");
			readURLByCommonsIO1(url);
			System.out.print("Commons-IO readLines :");
			readURLByCommonsIO2(url);
			System.out.print("Commons-IO copy :");
			copyBetweenIOStream(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用传统的Java IO来读取URL流
	 */
	private static void readURLByJavaIO(String url) throws MalformedURLException,
			IOException {
		InputStream in = new URL(url).openStream();
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = buffer.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			if (buffer != null) {
				buffer.close();
			}
			in.close();
		}
	}

	/**
	 * 使用 commons-io 的 IOUtils.toString来读取URL流
	 */
	private static void readURLByCommonsIO1(String url) throws MalformedURLException,
			IOException {
		InputStream in = new URL(url).openStream();
		try {
			// 将输入流中的内容转成字符串输出  
			String result = IOUtils.toString(in);
			System.out.println(result);
		} finally {
			/*
			 * 有多个重写的方法，可以无条件的关闭 InputStream, OutputStream, Reader, Writer, Socket等。
			 * 一般放在 finally 块中。
			 */
			IOUtils.closeQuietly(in);
		}
	}
	
	/**
	 * 使用 commons-io 的 IOUtils.readLines 来读取URL流
	 */
	private static void readURLByCommonsIO2(String url) throws MalformedURLException,
			IOException {
		InputStream in = new URL(url).openStream();
		try {
			// 从一个输入流中按行读取，返回一个List<String>
			List<String> lines = IOUtils.readLines(in);
			for (String line : lines) {
				System.out.println(line);
			}
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
	/**
	 * copy 系列的重载方法，可以将输入流的内容直接写到输出流里面去。
	 * InputStream||Reader --> OutputStream||Writer (可指定字符集)
	 */
	private static void copyBetweenIOStream(String url) throws MalformedURLException, IOException{
		InputStream in = new URL(url).openStream();
		OutputStream out = new FileOutputStream(new File(IOUtilsTest.class.getResource("files/result.html").getPath()));
		try
		{
			IOUtils.copy(in, out);
		} catch (Exception e)
		{
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}
}
