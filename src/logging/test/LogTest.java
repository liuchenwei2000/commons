/**
 * 
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Log测试
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-5
 */
public class LogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log logger = LogFactory.getLog(LogTest.class);
		logger.fatal("这是第一条fatal日志");
		logger.error("这是第一条error日志");
		logger.warn("这是第一条warn日志");
		logger.info("这是第一条info日志");
		logger.debug("这是第一条debug日志");
	}
}
