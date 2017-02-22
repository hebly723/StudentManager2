package service;

import java.util.List;

import po.Announcement;
import po.User;

public interface UserService {
	public User selectOne(String userId);
	public List<User> loginValidation(String userId, String password, String role);
	public List<User> selectByRole(String role);
	public List<User> selectTeacherAndBoss();
	public int updateUser(User user);
	public Integer countUserAcademy(String academy);
	public Integer countUserDegree(String degree);
//	public Integer countUserDegree(String degree) 
	public List<String> selectStudentMailboxes();
	 public List<User> selectTaskByAcdemy(String acdemy );
}