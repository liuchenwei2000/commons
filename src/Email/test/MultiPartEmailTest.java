/**
 * 
 */
package test;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

/**
 * 2,MultiPartEmail示例
 * <p>
 * MultiPartEmail is used to send multi-part internet email like messages with attachments.
 * <p>
 * To create a multi-part email, call the default constructor and then 
 * you can call setMsg() to set the message and call the different attach() methods.
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月11日
 */
public class MultiPartEmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// The simplest way to add the attachments is by using the EmailAttachment class to reference your attachments.
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:/Users/liucw_000/Pictures/cross.png");
		// 设置附件的配置：附件形式还是内联形式
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		attachment.setDisposition(EmailAttachment.INLINE);
		attachment.setDescription("Picture of Cross");
		attachment.setName("Cross Logo.png");
		
		try {
			// You can also use EmailAttachment to reference any valid URL for files that you do not have locally. 
			// When the message is sent, the file will be downloaded and attached to the message automatically.
			EmailAttachment urlAttachment = new EmailAttachment();
			urlAttachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
			urlAttachment.setDisposition(EmailAttachment.ATTACHMENT);
			urlAttachment.setDescription("Apache logo");
			urlAttachment.setName("Apache logo.gif");
			
			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName(MailInfo.SMTP_HOST);
			email.setAuthenticator(new DefaultAuthenticator(MailInfo.USER_NAME, MailInfo.PASSWORD));
			email.setFrom(MailInfo.EMAIL, "Liu");
			email.addTo(MailInfo.TO, "Buddy");
			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");
			// add the attachment
			email.attach(attachment);
			email.attach(urlAttachment);
			// send the email
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
