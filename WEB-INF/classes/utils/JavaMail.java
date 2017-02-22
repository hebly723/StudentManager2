package utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
    public class JavaMail {  
    	private static Executor executor = Executors.newFixedThreadPool(10);
    	public static void sendToOne( String subject, String text, String address) throws Exception{
    		Properties props = new Properties();  
            // 开启debug调试  
            props.setProperty("mail.debug", "true");  
            // 发送服务器需要身份验证  
            props.setProperty("mail.smtp.auth", "true");  
            // 设置邮件服务器主机名  
            props.setProperty("mail.host", "smtp-mail.outlook.com");  
            // 发送邮件协议名称  
            props.setProperty("mail.transport.protocol", "smtp");  
            props.put("mail.smtp.port", "587"); 
            props.put("mail.debug", "true"); 
            props.put("mail.smtp.starttls.enable","true"); 
            props.put("mail.smtp.EnableSSL.enable","true");   
            props.setProperty("mail.smtp.socketFactory.fallback", "false");   
            props.setProperty("mail.smtp.port", "587");   
              
            // 设置环境信息  
            Session session = Session.getInstance(props);  
              
            // 创建邮件对象  
            Message msg = new MimeMessage(session);  
            msg.setSubject(subject);  
            // 设置邮件内容
            msg.setContent(text,"text/html;charset=utf-8"); 
            //msg.setText(text);  
            // 设置发件人  
            msg.setFrom(new InternetAddress("zonajenkin@outlook.com"));  
            Transport transport = session.getTransport();  
            // 连接邮件服务器  
//            transport.c
            transport.connect("zonajenkin@outlook.com", "Hebly723Free");  
            // 发送邮件  
            transport.sendMessage(msg, new Address[] {new InternetAddress(address)});  
            // 关闭连接  
            transport.close();  
    	}
    	public static void sendToMany( String subject, String text, List<String> list) throws MessagingException{
    		if(list!=null){
    			Properties props = new Properties();  
                // 开启debug调试  
                props.setProperty("mail.debug", "true");  
                // 发送服务器需要身份验证  
                props.setProperty("mail.smtp.auth", "true");  
                // 设置邮件服务器主机名  
                props.setProperty("mail.host", "smtp-mail.outlook.com");  
                // 发送邮件协议名称  
                props.setProperty("mail.transport.protocol", "smtp");  
                props.put("mail.smtp.port", "587"); 
                props.put("mail.debug", "true"); 
                props.put("mail.smtp.starttls.enable","true"); 
                props.put("mail.smtp.EnableSSL.enable","true");   
                props.setProperty("mail.smtp.socketFactory.fallback", "false");   
                props.setProperty("mail.smtp.port", "587");   
                  
                // 设置环境信息  
                Session session = Session.getInstance(props);  
                  
                // 创建邮件对象  
                Message msg = new MimeMessage(session);  
                msg.setSubject(subject);  
                // 设置邮件内容  
                msg.setContent(text,"text/html;charset=utf-8");  
                // 设置发件人  
                msg.setFrom(new InternetAddress("zonajenkin@outlook.com"));  
                
                Transport transport = session.getTransport();  
                // 连接邮件服务器  
//                transport.c
                transport.connect("zonajenkin@outlook.com", "hebly723dick");  
                // 发送邮件  
               
                Address[] address = new Address[list.size()];
                for (int i = 0;i<list.size();i++) {
                	address[i] = new InternetAddress(list.get(i));
				}
                transport.sendMessage(msg, address); 
                // 关闭连接  
                transport.close();
    		}
    		  
    	}
    	 public static void sendToManyByAsynchronous(final String subject, final String text, final List<String> list) {  
    		 Runnable task = new Runnable(){

 				@Override
 				public void run() {
 					try {
 						JavaMail.sendToMany(subject, text, list);
 					} catch (MessagingException e) {
 						e.printStackTrace();
 					}
 					
 				}
     			 
     		 }; 
     		 executor.execute(task);
    	    }  
    	 public static void sendToOneByAsynchronous( final String subject, final String text, final String address) {  
    		 Runnable task = new Runnable(){

				@Override
				public void run() {
					try {
						JavaMail.sendToOne(subject, text, address);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
    			 
    		 }; 
    		 executor.execute(task);
 	    } 
        public static void main(String[] args) throws MessagingException {
        	List<String> list = new ArrayList<String>();
        	list.add("840367769@qq.com");
        	sendToOneByAsynchronous("研究生院活动网站提醒", "您有一个新消息，请及时查看！<br/>"+"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>","840367769@qq.com");
        }
}
        	  