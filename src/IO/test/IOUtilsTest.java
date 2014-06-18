/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * IOUtilsʾ��
 * <p>
 * IOUtils ʵ�ֶ�InputStream, OutputStream, Reader, Writer �Ķ���д�����ơ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-6
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
	 * ʹ�ô�ͳ��Java IO����ȡURL��
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
	 * ʹ�� commons-io �� IOUtils.toString����ȡURL��
	 */
	private static void readURLByCommonsIO1(String url) throws MalformedURLException,
			IOException {
		InputStream in = new URL(url).openStream();
		try {
			// ���������е�����ת���ַ������  
			String result = IOUtils.toString(in);
			System.out.println(result);
		} finally {
			/*
			 * �ж����д�ķ����������������Ĺر� InputStream, OutputStream, Reader, Writer, Socket�ȡ�
			 * һ����� finally ���С�
			 */
			IOUtils.closeQuietly(in);
		}
	}
	
	/**
	 * ʹ�� commons-io �� IOUtils.readLines ����ȡURL��
	 */
	private static void readURLByCommonsIO2(String url) throws MalformedURLException,
			IOException {
		InputStream in = new URL(url).openStream();
		try {
			// ��һ���������а��ж�ȡ������һ��List<String>
			List<String> lines = IOUtils.readLines(in);
			for (String line : lines) {
				System.out.println(line);
			}
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
	/**
	 * copy ϵ�е����ط��������Խ�������������ֱ��д�����������ȥ��
	 * InputStream||Reader --> OutputStream||Writer (��ָ���ַ���)
	 */
	private static void copyBetweenIOStream(String url) throws MalformedURLException, IOException{
		InputStream in = new URL(url).openStream();
		OutputStream out = new FileOutputStream(new File("files/result.html"));
		try {
			IOUtils.copy(in, out);
		} catch (Exception e) {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}
}
