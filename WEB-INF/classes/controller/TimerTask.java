package controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import po.Due;
import po.Task;
import service.ActivityService;
import service.DueService;
import service.MailService;
import service.TaskService;
import service.UserService;
/**
 * 
 * 类名称：TimerTask   
 * 类描述：定时器任务
 * 创建人：yunfei.han
 * 创建时间：Aug 29, 2016 10:56:27 AM      
 * @version  V1.0
 *
 */
@Component
public class TimerTask {
	@Autowired
	private TaskService tasservice;
	@Autowired
	private ActivityService acservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private MailService mailservice;
	@Autowired
	private DueService dueService;
  /**
   * 每10分钟触发一次任务
   */
  @Scheduled(cron = "0 0/10 * * * ?")
  public void UpTaskdata()
  {
	  tasservice.updateTaskStatus();
	  dueService.updateStatusOverDue();
  }
  /**
   * 每10分钟触发一次任务
   */
  @Scheduled(cron = "0 0/10 * * * ?")
  public void UpActivitydata()
  {
	 acservice.updateAcStatus();
	 dueService.updateStatusOverDue();
  } 
  /**
   * 每2小时触发一次任务
 * @throws Exception 
   */
  @Scheduled(cron = "0 0 0/2 * * ?")
  public void NotTask() throws Exception
  {
	  List<Task> taskList = tasservice.selectTaskUnhandled();
	  if(taskList!=null&&taskList.size()>0){
		  List<String> mailboxList = new ArrayList<String>();
		  for (Task task : taskList) {
			  for (Due due : dueService.selectTasDueIdByTasId(task.getTasId())){
			String mailbox = userservice.selectOne(due.getUserId()).getUserMailBox();
			mailboxList.add(mailbox);
		  }
		  }
		  mailservice.sendMailToMany("研究生院活动网站提醒", "您有一个新任务，请及时查看！<br/>"+"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", mailboxList);
	  }
	  
  } 
}
