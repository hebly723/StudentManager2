package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Message;
import po.SelectedIDs;
import po.User;
import service.MailService;
import service.MessageService;
import service.UserService;
import utils.Page;
/**
 * 通知控制器
 * @author 王志强
 *
 */
@Controller
public class MessageController {
	@Autowired
	private MessageService messervice;
	@Autowired
	private MailService mailservice;
	@Autowired
	private UserService Userservice;
	@RequestMapping("/MessagesAll")
	public @ResponseBody List queryMessagesAll(Integer pageNow,String notSenId,Integer pageSize) throws Exception{
		Page page = null;  
	    int totalCount = messervice.selectMessageByNotSenIdCount(notSenId);  
	    List mesList = null;
	    if (pageNow!=null) {  
	        page = new Page(totalCount,pageNow,12);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        mesList = messervice.selectMessageByNotSenId(page.getStartPos(), page.getPageSize(),notSenId);
	    } else {  
	        page = new Page(totalCount,1,12);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        mesList = messervice.selectMessageByNotSenId(page.getStartPos(), page.getPageSize(),notSenId);  
	       
	    }  
	    mesList.add(page);
	    return mesList;
	}
	@RequestMapping("/MessagesAlread")
	public @ResponseBody List queryMessagesAlread(Integer pageNow,String notRecId,Integer pageSize) throws Exception{
		Page page = null;  
	    int totalCount = messervice.selectMessageAlreadByNotRecIdCount(notRecId);  
	    List mesList = null;
	    if (pageNow!=null) {  
	        page = new Page(totalCount,pageNow,12);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        mesList = messervice.selectMessageAlreadByNotRecId(page.getStartPos(), page.getPageSize(),notRecId);  
	    } else {  
	        page = new Page(totalCount,1,12);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        mesList = messervice.selectMessageAlreadByNotRecId(page.getStartPos(), page.getPageSize(),notRecId);  
	       
	    }  
	    mesList.add(page);
	    return mesList;
	}
	@RequestMapping("/MessagesUnread")
	public @ResponseBody List<Message> queryMessagesUnread(Integer pageNow,String notRecId,Integer pageSize) throws Exception{
		Page page = null;  
	    int totalCount = messervice.selectMessageUnreadByNotRecIdCount(notRecId);  
	    List mesList = null;
	    if (pageNow!=null) {  
	        page = new Page(totalCount,pageNow,12);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        mesList = messervice.selectMessageUnreadByNotRecId(page.getStartPos(), page.getPageSize(),notRecId);  
	    } else {  
	        page = new Page(totalCount,1,12); 
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        mesList = messervice.selectMessageUnreadByNotRecId(page.getStartPos(), page.getPageSize(),notRecId);  
	       
	    }  
	    mesList.add(page);
	    return mesList;
	}
	/*@RequestMapping("/insertMessage")
	public @ResponseBody String insertMessage(@RequestBody Message message) throws Exception{
		int flag=messervice.insertMessage(message);
		List list = new ArrayList<String>();
		
		if(flag==1){
			
			return mailservice.sendMail("840367769@qq.com", "ualvrwpxkrksbddb", list, "研究生活动网站提醒", "研究生活动网站", "您有新消息请及时查看");
		}
		return null;
	}*/
	
	@RequestMapping("/insertMessage")
	public @ResponseBody int insertMessages(@RequestBody Message message) throws Exception{
		int flag=messervice.insertMessage(message);
		if(flag==1){
			User user=Userservice.selectOne(message.getNotRecId());
			String mailbox = user.getUserMailBox();
			mailservice.sendMailToOne("研究生院活动网站提醒", "您有一个新消息，请及时查看！<br/>"+"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", mailbox);
			return 1;
		}
		return 0;
	}
	@RequestMapping("/insertMessages")
	public @ResponseBody int insertMessages(@RequestBody SelectedIDs ids) throws Exception{
		Message message[] = ids.getSelectedIDs();
		int flag=messervice.insertMessages(message);
		if(flag>=1){
			List list = new ArrayList<String>();
			for (Message mes : message) {
				User user=Userservice.selectOne(mes.getNotRecId());
				list.add(user.getUserMailBox());
			}
			mailservice.sendMailToMany("研究生院活动网站提醒", "您有一个新消息，请及时查看！<br/>"+"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", list);
			return 1;
		}
		return 0;
	}
	/*@RequestMapping("/insertMessages")
	public @ResponseBody void insertMessages(@RequestBody String message) throws Exception{
		System.out.println(message);
	}*/
	@RequestMapping("/updateMessageStatus")
	public @ResponseBody int updateMessageStatus(@RequestBody Message message) throws Exception{
		int flag= messervice.updateMessage(message);
		if(flag==1){
			return 1;
		}else{
			return 0;
		}
	}
}
