/**
 * 
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Log����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-5
 */
public class LogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log logger = LogFactory.getLog(LogTest.class);
		logger.fatal("���ǵ�һ��fatal��־");
		logger.error("���ǵ�һ��error��־");
		logger.warn("���ǵ�һ��warn��־");
		logger.info("���ǵ�һ��info��־");
		logger.debug("���ǵ�һ��debug��־");
	}
}
