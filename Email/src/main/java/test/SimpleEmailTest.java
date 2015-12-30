/**
 * 
 */
package test;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * 1,SimpleEmail示例
 * <p>
 * SimpleEmail is used to send simple internet email messages without attachments.
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月11日
 */
public class SimpleEmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Email email = new SimpleEmail();
			// sets the address of the outgoing SMTP server that will be used to send the message. 
			// If this is not set, the system property "mail.host" will be used.
			email.setHostName(MailInfo.SMTP_HOST);
			email.setSmtpPort(MailInfo.SMTP_PORT);
			email.setAuthenticator(new DefaultAuthenticator(MailInfo.USER_NAME, MailInfo.PASSWORD));
			email.setSSLOnConnect(true);
			email.setFrom(MailInfo.EMAIL);
			email.setSubject("SimpleEmailTest");
			email.setMsg("This is a SimpleEmailTest mail ... :-)");
			email.addTo(MailInfo.TO);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
