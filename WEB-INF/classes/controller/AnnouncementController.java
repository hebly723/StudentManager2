package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Announcement;
import po.User;
import service.AnnouncementService;
import service.UserService;

@Controller
public class AnnouncementController {
	@Autowired
	private UserService userservice;
	@Autowired
	private AnnouncementService announcementService;
	@RequestMapping("/Announcement") 
	public @ResponseBody List<Announcement> getAn(HttpSession session)
	{
		//String userId = ;
		//String password = "lingdao1";
		//System.out.println(userId);
		//System.out.println(password);
		//TODO
				/*
				 * 最后加上权限验证
				 */
//		if (session.getAttribute("loginuser")!=null)
		{
			return announcementService.getAn();
		}
//		else
//			return "not login yet";
		//session.setAttribute("loginuser", user);
//		return "redirect:login.html";
	}
	@RequestMapping("/selectAnByAcademy")
	public @ResponseBody List selectAnByAcademy(@RequestBody Map type){
		/**
		 * 不知道数据库里全校公告是怎么表示的。。。
		 */
			return announcementService.selectAnByAcademy((String) type.get("type"));
	}
	@RequestMapping("/updateAn")
	public @ResponseBody Map LoginValidation(
			@RequestBody Announcement announcement,
			HttpSession session)
	{
		//System.out.println(data);
//		String userId = (String)data.get("userId");
//		String password = (String)data.get("password");
//		String role = (String)data.get("role");
//		
//TODO
		/*
		 * 最后加上权限验证
		 */
		System.out.println(announcement);
		Map map = new HashMap();
		try {
			int result = announcementService.updateAn(announcement);
			//System.out.print(result);
			map.put("success", "true");
			List<Announcement> list = announcementService.getAn();
			map.put("announcement", list);
		}catch (Exception e)
		{
			e.printStackTrace();
			map.put("success", "false");
		}
		return map;
		
		//System.out.println(userId);
		//System.out.println(password);
		//System.out.println(role);
//		if (userId != null)
//		{
//			List<User> users = userservice.loginValidation(userId, password, role);
//			if (!(users.isEmpty()))
//			{
//				User user = (User)(users.toArray())[0];
//				map.put("success", "true");
//				map.put("user", user);
//				List<Announcement> list = announcementService.getAn();
//				map.put("announcement", list);
//				session.setAttribute("loginuser", user);
//			}
//			else{
//				map.put("success", "false");
//			}
//		}
//		else
//		{
//			map.put("success", "false");
//		}
//		return map;
//	
		}
}