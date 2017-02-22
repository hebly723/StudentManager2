package service.impl;

import java.util.List;
import service.MailService;
import utils.JavaMail;

public class MailServiceImpl implements MailService{

	@Override
	public void sendMailToOne(String subject, String text, String address)
			throws Exception {
		JavaMail.sendToOneByAsynchronous(subject, text, address);
	}

	@Override
	public void sendMailToMany(String subject, String text, List<String> list)
			throws Exception {
		JavaMail.sendToManyByAsynchronous(subject, text, list);
	}
	
}
