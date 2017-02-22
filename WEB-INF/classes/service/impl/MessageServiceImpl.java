package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.MessageMapper;
import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Activity;
import po.MessageExample;
import po.Message;
import po.Sign;
import po.User;
import service.MessageService;

public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper mesmapper;
	@Autowired
	private UserMapper umapper;
	public List<Message> selectMessageAll(String recId) {
		MessageExample example = new MessageExample();
		example.setOrderByClause("NOT_SEN_DATE DESC");
		MessageExample.Criteria criteria = example.createCriteria();
		criteria.andNotRecIdEqualTo(recId);
		return mesmapper.selectByExample(example);
	}

	public List<Message> selectMessageUnread(String recId) {
		MessageExample example = new MessageExample();
		example.setOrderByClause("NOT_SEN_DATE DESC");
		MessageExample.Criteria criteria = example.createCriteria();
		criteria.andNotRecIdEqualTo(recId);
		criteria.andNotStatusEqualTo("0");
		return mesmapper.selectByExample(example);
	}

	public List<Message> selectMessageAlread(String recId) {
		MessageExample example = new MessageExample();
		example.setOrderByClause("NOT_SEN_DATE DESC");
		MessageExample.Criteria criteria = example.createCriteria();
		criteria.andNotRecIdEqualTo(recId);
		criteria.andNotStatusEqualTo("1");
		return mesmapper.selectByExample(example);
	}

	public int insertMessage(Message message) {
		return mesmapper.insertSelective(message);
	}

	public int updateMessage(Message message) {
		return mesmapper.updateByPrimaryKeySelective(message);
	}

	public int insertMessages(Message[] message) {
		List list = new ArrayList<Message>();
		for (Message mes : message) {
			list.add(mes);
		}
		return mesmapper.insertMessages(list);
	}

	@Override
	public List<Message> selectMessageAlreadByNotRecId(Integer startPos,
			Integer pageSize, String notRecId) {
		return mesmapper.selectMessageAlreadByNotRecId(startPos, pageSize, notRecId);
	}

	@Override
	public int selectMessageAlreadByNotRecIdCount(String notRecId) {
		return (int)mesmapper.selectMessageAlreadByNotRecIdCount(notRecId);
	}

	@Override
	public List<Activity> selectMessageUnreadByNotRecId(Integer startPos,
			Integer pageSize, String notRecId) {
		return mesmapper.selectMessageUnreadByNotRecId(startPos, pageSize, notRecId);
	}

	@Override
	public int selectMessageUnreadByNotRecIdCount(String notRecId) {
		return (int)mesmapper.selectMessageUnreadByNotRecIdCount(notRecId);
	}

	@Override
	public List<Activity> selectMessageByNotSenId(Integer startPos,
			Integer pageSize, String notSenId) {
		return mesmapper.selectMessageByNotSenId(startPos, pageSize, notSenId);
	}

	@Override
	public int selectMessageByNotSenIdCount(String notSenId) {
		return (int)mesmapper.selectMessageByNotSenIdCount(notSenId);
	}
	
}
