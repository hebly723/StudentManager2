package controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Announcement;
import po.User;
import service.ActivityService;
import service.AnnouncementService;
import service.InfoService;
import service.UserService;
import service.impl.Academy;

@Controller
public class LoginContorller {
	@Autowired
	private UserService userservice;
	@Autowired
	private AnnouncementService announcementService;
	@Autowired
	private ActivityService activityService;
	@RequestMapping("/Login")
	public @ResponseBody String Login(HttpSession session,  String userId, String password, String role){
		//String userId = ;
		//String password = "lingdao1";
		//System.out.println(userId);
		//System.out.println(password);
		if (userId != null)
		{
			List<User> users = userservice.loginValidation(userId, password, role);
			if (!(users.isEmpty()))
			{
				User user = (User)(users.toArray())[0];
				//System.out.println(user.getUserName());
				session.setAttribute("loginuser", user);
				List list = new ArrayList() ;
				list.add(0, user);
				
				if (user.getUserRole().equals("0"))
					return "redirect:/student/student.html";
				else if (user.getUserRole().equals("1"))
					return "redirect:/teacher/teacher.html";
				else if (user.getUserRole().equals("2"))
					return "redirect:/boss/boss.html";
			}
		}
		
		if (session.getAttribute("loginuser")!=null)
		{
			User user = (User)session.getAttribute("loginuser");
			if (user.getUserRole().equals("0"))
				return "redirect:/student/student.html";
			else if (user.getUserRole().equals("1"))
				return "redirect:/teacher/teacher.html";
			else if (user.getUserRole().equals("2"))
				return "redirect:/boss/boss.html";
		}
		//session.setAttribute("loginuser", user);
		return "redirect:login.html";
	}
	@RequestMapping("/LoginValidation")
	public @ResponseBody Map LoginValidation(
			@RequestBody User data,
			HttpSession session)
	{
		//System.out.println(data);
//		String userId = (String)data.get("userId");
//		String password = (String)data.get("password");
//		String role = (String)data.get("role");
		String userId = data.getUserId();
		String  password = data.getUserPassword();
		String role = data.getUserRole();
		Map map = new HashMap();
		System.out.println(userId);
		System.out.println(password);
		System.out.println(role);
		if (userId != null)
		{
			List<User> users = userservice.loginValidation(userId, password, role);
			if (!(users.isEmpty()))
			{
				User user = (User)(users.toArray())[0];
				map.put("success", "true");
				map.put("user", user);
				List<Announcement> list = announcementService.getAn();
//				map.put("announcement", list);
				session.setAttribute("loginuser", user);
				/*if(user.getUserRole().equals("0")){
					
				}*/
			}
			else{
				map.put("success", "false");
			}
		}
		else
		{
			map.put("success", "false");
		}
		return map;
	}//www.ly723.site:2048/StudentManager2/updateUserInfo.action
	@RequestMapping("/Loginout")
	public String Loginout(HttpSession session){
		session.invalidate();
		//session.removeAttribute("loginuser");
		return "redirect:/Login.action";
	}
//	www.ly723.site:2048/StudentManager2/updateUserInfo.action
	@RequestMapping("/updateUserInfo")
	public @ResponseBody User updateUserInfo(@RequestBody User user){
		User userOut = userservice.selectOne(user.getUserId());
		userOut.setUserMailBox(user.getUserMailBox());
		userOut.setUserQq(user.getUserQq());
		userOut.setUserTel(user.getUserTel());
//		InfoService infoService = new Academy();
		/**
		 * 截止时间
		 */
//		userOut.setUserAcademy(infoService.covert(user.getUserId()));
		userservice.updateUser(userOut);
		return userOut;
	}
}
