/**
 * 
 */
package test;

import java.io.File;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

/**
 * 3,HtmlEmail示例
 * <p>
 * HtmlEmail is used to send HTML formatted email. 
 * A text message can also be set for HTML unaware email clients, such as text-based email clients.
 * <p>
 * HtmlEmail class also inherits from MultiPartEmail, so it is easy to add attachments to the email.
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月11日
 */
public class HtmlEmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Create the email message
			HtmlEmail email = new HtmlEmail();
			email.setHostName(MailInfo.SMTP_HOST);
			email.setAuthenticator(new DefaultAuthenticator(MailInfo.USER_NAME, MailInfo.PASSWORD));
			email.setFrom(MailInfo.EMAIL, "Liu");
			email.addTo(MailInfo.TO, "Buddy");
			email.setSubject("Test email with inline image");

			// embed the image and get the content id
			// notice that the call to embed() returns a String. 
			// This String is a randomly generated identifier that must be used to reference the image in the image tag.
			String cid1 = email.embed(new URL("http://su.bdimg.com/static/superplus/img/logo_white.png"), "Baidu logo");
			String cid2 = email.embed(new File("C:/Users/liucw_000/Pictures/cross.png"));
			// set the html message
			email.setHtmlMsg("<html>The Baidu logo - <img src=\"cid:" + cid1
					+ "\"><img src=\"cid:" + cid2 + "\"></html>");
			// set the alternative message
			email.setTextMsg("Your email client does not support HTML messages");
			// send the email
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
