package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import po.User;
import service.InfoService;
import service.UserService;
import service.impl.Academy;

@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
public class UsersController {
	@Autowired
	private UserService userservice;
	@RequestMapping("/updateUser")
	public @ResponseBody int updateUser(@RequestBody User user){ 
//		InfoService infoService = new Academy();
		/**
		 * 截止时间
		 */
//		user.setUserAcademy(infoService.covert(user.getUserId()));
		int flag = userservice.updateUser(user);
		
		if(flag==1){
			return 1;	
		}
		return 0;
	}
	@RequestMapping("/queryUsers.action")
	public ModelAndView queryUsers() throws Exception{
		User user = userservice.selectOne("hh");
		System.out.println(user);
		ModelAndView modleAndView = new ModelAndView();
		modleAndView.addObject("User", user);
		modleAndView.setViewName("index2");
		return modleAndView;
	}
	@RequestMapping("/queryUsers2.action")
	public String queryUsers2(HttpServletRequest request) throws Exception{
		request.setAttribute("aaa", "网址");
		return "redirect:WEB-INF/index2.jsp";
	}
	@RequestMapping("/boss/queryTeachers")
	public @ResponseBody List<User> selectTeachers(){
		return userservice.selectByRole("teacher");
	}
	@RequestMapping("/teacher/queryStudents")
	public @ResponseBody List<User> selectStudents(){
		return userservice.selectByRole("student");
	}
	@RequestMapping("/teacher/queryBoss")
	public @ResponseBody List<User> selectBosses(){
		return userservice.selectByRole("boss");
	}
	@RequestMapping("/teacherAndBoss")
	public @ResponseBody List<User> selectTeacherAndBoss(){
		return userservice.selectTeacherAndBoss();
	}
	@RequestMapping("/loginValidation")
	public @ResponseBody List<User> loginValidation(String userId, String password, String role){
		return userservice.loginValidation(userId, password, role);
	}
}
