/**
 * 
 */
package test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceFileResolver;

import java.io.File;

/**
 * 4,ImageHtmlEmail示例
 * <p>
 * MultiPartEmail虽然可以将图片内嵌到html邮件中，但是这需要你提前知道所有的图片路径。
 * 当使用一个html邮件模板的时候，这种方式并不便捷。
 * ImageHtmlEmail用来解决这个问题，它可以将所有的外在图片转换成内联图片。
 * <p>
 * 本例可以将file/htmls下的welcome.html文件以html email的形式发出，并且自动将其使用到的图片内联化。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月11日
 */
public class ImageHtmlEmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// load your HTML email template
		String htmlTemplate = ImageHtmlEmailTest.class.getResource("/files/welcome.html").getPath();
		String htmlBaseDir = ImageHtmlEmailTest.class.getResource("/files").getPath();
		try {
			String htmlEmailTemplate = FileUtils.readFileToString(new File(htmlTemplate));
			// create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			// 设置一个DataSourceResolver，这里使用可以解析文件的DataSourceFileResolver，另外还有基于URL等的Resolver
			email.setDataSourceResolver(new DataSourceFileResolver(new File(htmlBaseDir)));
			email.setHostName(MailInfo.SMTP_HOST);
			email.setAuthenticator(new DefaultAuthenticator(MailInfo.USER_NAME, MailInfo.PASSWORD));
			email.setFrom(MailInfo.EMAIL, "Liu");
			email.addTo(MailInfo.TO, "Buddy");
			email.setSubject("Test email with inline image");
			// set the html message
			email.setHtmlMsg(htmlEmailTemplate);
			// set the alternative message
			email.setTextMsg("Your email client does not support HTML messages");
			// send the email
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
