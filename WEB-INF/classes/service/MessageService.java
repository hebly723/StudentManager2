package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.Activity;
import po.Message;

public interface MessageService {
	public List<Message> selectMessageAll(String recId);

	public List<Message> selectMessageUnread(String recId);

	public List<Message> selectMessageAlread(String recId);

	public int insertMessage(Message message);

	public int updateMessage(Message message);

	public int insertMessages(Message[] message);

	List<Message> selectMessageAlreadByNotRecId(Integer startPos,Integer pageSize,String notRecId);
	int selectMessageAlreadByNotRecIdCount(String notRecId);

	List<Activity> selectMessageUnreadByNotRecId(Integer startPos,Integer pageSize,String notRecId);
	int selectMessageUnreadByNotRecIdCount(String notRecId);

	List<Activity> selectMessageByNotSenId(Integer startPos,Integer pageSize,String notSenId);
	int selectMessageByNotSenIdCount(String notSenId);

}
