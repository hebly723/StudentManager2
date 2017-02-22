package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.DueactivityMapper;
import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Dueactivity;
import po.DueactivityExample;
import po.User;
import po.UserExample;
import service.DueActivityService;

public class DueActivityServiceImpl implements DueActivityService {
	@Autowired
	DueactivityMapper dueactivityMapper;
	@Autowired
	UserMapper userMapper;
	
	public boolean insertDueActivity(List<Dueactivity> dueactivity) {
		boolean flag = true;
		for (Dueactivity dueactivity2 : dueactivity) {
			int cur  =  dueactivityMapper.insertSelective(dueactivity2);
			if (cur<=0)
			{
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * 格式:
	 * {
	 * 
	 * 学院名:{
	 * {
	 * 协理员1;
	 * }
	 * {
	 * 协理员2;
	 * }
	 * }
	 * }
	 */
	public Map<String, List<User>> selectUserOrderByAcademy(int acId)
	{
		DueactivityExample dueactivityExample = new DueactivityExample();
		DueactivityExample.Criteria criteria = dueactivityExample.createCriteria();
		criteria.andAcIdEqualTo(acId);
		List<Dueactivity> dueList = dueactivityMapper.selectByExample(dueactivityExample);
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		for (Dueactivity deu :dueList) {
			UserExample userExample = new UserExample();
			UserExample.Criteria criteria2 = userExample.createCriteria();
			criteria2.andUserAcademyEqualTo(deu.getAcAcademy());
			criteria2.andUserRoleEqualTo("1");
			List<User> users = userMapper.selectByExample(userExample);
			map.put(deu.getAcAcademy(),users);
		}
		return map;
	}
	public List<String> selectUserByAcId(int acId) {
		DueactivityExample dueactivityExample = new DueactivityExample();
		DueactivityExample.Criteria criteria = dueactivityExample.createCriteria();
		criteria.andAcIdEqualTo(acId);
		List<Dueactivity> dueList = dueactivityMapper.selectByExample(dueactivityExample);
		List<String> strings = new ArrayList<String>();
		for (Dueactivity deu :dueList) {
			strings.add(deu.getAcAcademy());
		}
		
		return strings;
	}

	@Override
	public boolean updateDueAvtivity(int acId, List<String> academys) {
		boolean flag = true;
		DueactivityExample dueactivityExample = new DueactivityExample();
		DueactivityExample.Criteria criteria = dueactivityExample.createCriteria();
		criteria.andAcIdEqualTo(acId);
		dueactivityMapper.deleteByExample(dueactivityExample);
		for (String string : academys) {
			Dueactivity dueactivity = new Dueactivity();
			dueactivity.setAcAcademy(string);
			dueactivity.setAcId(acId);
			int cur =  dueactivityMapper.insertSelective(dueactivity);
			if (cur <= 0 )
				flag = flag & false;
			else
				flag = flag & true;
		}
		return flag;
	}

	@Override
	public int deleteDueActivity(int acId) {
		DueactivityExample dueactivityExample = new DueactivityExample();
		DueactivityExample.Criteria criteria = dueactivityExample.createCriteria();
		criteria.andAcIdEqualTo(acId);
		
		return dueactivityMapper.deleteByExample(dueactivityExample);
	}

}
