## Commons Email ##

Commons Email aims to provide a API for sending email. It is built on top of the Java Mail API, which it aims to simplify.

Some of the mail classes that are provided are as follows:

* SimpleEmail 

	This class is used to send basic text based emails.

* MultiPartEmail

	This class is used to send multipart messages. This allows a text message with attachments either inline or attached.

* HtmlEmail

	This class is used to send HTML formatted emails. It has all of the capabilities as MultiPartEmail allowing attachments to be easily added. It also supports embedded images.

* ImageHtmlEmail
	
	This class is used to send HTML formatted emails with inline images. It has all of the capabilities as HtmlEmail but transform all image references to inline images.

* EmailAttachment

	This is a simple container class to allow for easy handling of attachments. It is for use with instances of MultiPartEmail and HtmlEmail.
