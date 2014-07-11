/**
 * 
 */
package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceFileResolver;

/**
 * 4,ImageHtmlEmailʾ��
 * <p>
 * MultiPartEmail��Ȼ���Խ�ͼƬ��Ƕ��html�ʼ��У���������Ҫ����ǰ֪�����е�ͼƬ·����
 * ��ʹ��һ��html�ʼ�ģ���ʱ�����ַ�ʽ������ݡ�
 * ImageHtmlEmail�������������⣬�����Խ����е�����ͼƬת��������ͼƬ��
 * <p>
 * �������Խ�file/htmls�µ�welcome.html�ļ���html email����ʽ�����������Զ�����ʹ�õ���ͼƬ��������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��7��11��
 */
public class ImageHtmlEmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// load your HTML email template
		String htmlTemplate = "files/htmls/welcome.html";
		String htmlBaseDir = "files/htmls";
		try {
			String htmlEmailTemplate = FileUtils.readFileToString(new File(htmlTemplate));
			// create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			// ����һ��DataSourceResolver������ʹ�ÿ��Խ����ļ���DataSourceFileResolver�����⻹�л���URL�ȵ�Resolver
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
