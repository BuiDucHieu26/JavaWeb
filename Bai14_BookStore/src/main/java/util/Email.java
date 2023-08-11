package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	static final String from = "vnraizo2003@gmail.com"; 
	static final String pass = "njxxyijmiihwlkkp";
	
	public static boolean sendEmail(String to,String subJect ,String content) {
		Properties props = new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// create Authenticator
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, pass);
			}
		};
		//Phiên làm việc
		Session session = Session.getInstance(props,auth);
		//Gửi email
		//Tạo 1 tin nhắn mới
		MimeMessage msg = new MimeMessage(session);
		
		try {
			//người gửi
			msg.addHeader("content-type","text/HTML; charset = UTF-8");
			msg.setFrom(from);
			//người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			//Tiêu đề email
			msg.setSubject(subJect);
			//Quy định ngày gửi
			msg.setSentDate(new Date());
			//Quy định email phản hồi
//			msg.setReplyTo(InternetAddress.parse(from, false));
			//Nội dung email
			msg.setContent(content,"text/HTML; charset = UTF-8"); //nếu phần nội dung là đoạn code html thì dùng setContent()
			//Gửi email
			Transport.send(msg);
			System.out.println("send success");
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		// pass: njxxyijmiihwlkkp
		//email: vnraizo2003@gmail.com
		final String to = "buihieu26102003@gmail.com";
		
	}
}
