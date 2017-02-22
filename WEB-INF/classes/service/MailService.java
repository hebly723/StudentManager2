package service;

import java.util.List;

public interface MailService {
	public void sendMailToOne(String subject, String text, String address) throws Exception;
	public void sendMailToMany(String subject, String text, List<String> list) throws Exception;
}
