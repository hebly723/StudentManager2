package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.User;
import po.UserExample;
import service.InfoService;
import service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;
	@Override
	public User selectOne(String userId) {
//		UserExample example = new UserExample();
//		UserExample.Criteria criteria = example.createCriteria();
//		criteria.andUserNameEqualTo(name);
		return usermapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<User> loginValidation(String userId, String password, String role) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andUserPasswordEqualTo(password);
		if (role.equals("teacher"))
		{
			criteria.andUserRoleEqualTo("1");
		}
		else if (role.equals("student"))
		{
			criteria.andUserRoleEqualTo("0");
		}
		else if (role.equals("boss"))
		{
			criteria.andUserRoleEqualTo("2");
		}
		return usermapper.selectByExample(example);
	}
	@Override
	public List<User> selectByRole(String role) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		if (role.equals("teacher"))
		{
			criteria.andUserRoleEqualTo("1");
		}
		else if (role.equals("student"))
		{
			criteria.andUserRoleEqualTo("0");
		}
		else if (role.equals("boss"))
		{
			criteria.andUserRoleEqualTo("2");
		}
		return usermapper.selectByExample(example);
	}
	@Override
	public List<User> selectTeacherAndBoss() {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserRoleNotEqualTo("0");
		return usermapper.selectByExample(example);
	}
	
	@Override
	public int updateUser(User user) {
		return usermapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public Integer countUserAcademy(String academy) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUserAcademyEqualTo(academy);
		return usermapper.countByExample(userExample);
	}
	@Override
	public Integer countUserDegree(String degree) {
		InfoService infoService = new Degree();
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUserIdIsNotNull();
//		List newList = new ArrayList();
		int i = 0;
		List<User> list = usermapper.selectByExample(userExample);
		for (User user : list) {try
		{
			if (infoService.covert(user.getUserId()).equals(degree));
			i ++;
		}catch(Exception e){
			return 0;
		}
		}
		
		return i;
	}
	@Override
	public List<String> selectStudentMailboxes() {
		return usermapper.selectStudentMailboxes();
	}
	@Override
	public List<User> selectTaskByAcdemy(String acdemy) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUserRoleEqualTo("1");
		criteria.andUserAcademyEqualTo(acdemy);
		return usermapper.selectByExample(userExample);
	}
	
}