package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import po.Activity;
import po.Due;
import po.FormTask;
import po.NameAndId;
import po.Sign;
import po.Task;
import po.Task1;
import po.TaskIdentification;
import po.User;
import po.formerTask;
import service.ActivityService;
import service.DueService;
import service.FileService;
import service.MailService;
import service.SignService;
import service.TaskService;
import service.UserService;
import service.impl.Academy;
import utils.Page;
import utils.PropertiesUtil;

@Controller
public class TaskController {
	@Autowired
	private TaskService tasservice;
	@Autowired
	private FileService fileservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private SignService signservice;
	@Autowired
	private PropertiesUtil p;
	@Autowired
	private MailService mailservice;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private DueService dueService;
	@RequestMapping("/boss/insertTaskByAcdemy")
	public @ResponseBody Map insertTaskByAcdemy(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			Task task) throws Exception {
		System.out.println("\n\n\n\n\n\n");
		tasservice.updateTaskStatus();
		if (task.getTasTitle()==null)
			task.setTasTitle("任务");
		if (task.getTasDesc()==null)
			task.setTasDesc("任务");
		Activity activity2 =  activityService.selectActivityById(task.getTasAcId());
		List<User> teachers = userservice.selectTaskByAcdemy(task.getTasAcademy()); 
		task.setTasAcId(activity2.getAcId());
		List allTaskList = new ArrayList();
		String tasCreName = userservice.selectOne(task.getTasCreId()).getUserName();
		TaskIdentification taskIdentification = new TaskIdentification(task,  tasCreName);
//		tasservice.insertTask(task);
		String uuid = UUID.randomUUID().toString();
		task.setTasDocId(uuid);
		String filename1=fileservice.SaveFile(file1, uuid,"task");
		String filename2=fileservice.SaveFile(file2, uuid, "task");
		String filename3=fileservice.SaveFile(file3, uuid, "task");
		if(filename1!=null)
			task.setTasDoc1Name(filename1);
		if(filename2!=null)
			task.setTasDoc2Name(filename2);
		if(filename3!=null)
			task.setTasDoc3Name(filename3);
		List<Task> TaskBefore;
		if (task.getTasAcId()!=0)
		TaskBefore = tasservice.selectTaskByTasAcId(task.getTasAcId());
		else
			TaskBefore = new ArrayList<Task>();
		int flag=tasservice.insertTask(task);
		List<Due> dueBefore = new ArrayList<Due>();
		for (Task task3 : TaskBefore) {
			List<Due> dueBeList = dueService.selectTasDueIdByTasId(task3.getTasId());
			for (Due due2 : dueBeList) {
				dueBefore.add(due2);
			}
		}
		Map<String, String> before = new HashMap<String, String>();
		for (Due due2 : dueBefore) {
			before.put(due2.getUserId(), userservice.selectOne(due2.getUserId()).getUserName());
		}
		
		List<NameAndId> more = new ArrayList<NameAndId>();
		Map success = new HashMap();
		for (User teacher : teachers){
			Due due = new Due();
			due.setTasid(task.getTasId());
			due.setTasStatus("0");
			due.setUserId(teacher.getUserId());
			if (before == null)
			{
				dueService.insertDue(due);
			}
			else if (before.get(due.getUserId())==null)	
			{
				dueService.insertDue(due);
			}
			else
			{
				NameAndId nId = new NameAndId(due.getUserId(), before.get(due.getUserId()), due.getTasStatus());
				success.put("condition", "2");
				more.add(nId);
			}
		}
		
		if(flag==1){
			for (User teacher : teachers){
				success.put("condition", "0");
				String mailbox = userservice.selectOne(teacher.getUserId()).getUserMailBox();
				mailservice.sendMailToOne("研究生院活动网站提醒", 
						"您有一个新任务，请及时查看！<br/>"+
				"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", mailbox);
				}
//				List<Task> taskList = new ArrayList<Task>();
				int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
				Page page = new Page(totalCount, 1);  
//				taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
				
				List taskList = new ArrayList();
//				int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
//				Page page = new Page(totalCount, 1);  
//				taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
//				taskList.add(success);
//				taskList.add(page);
				
//				taskList.add(more);
				success.put("taskDue", more);
				return success;
			}
			List list = new ArrayList();
			success.put("condition", "1");
			list.add(success);
			return success;
	}
	@RequestMapping("/boss/insertTaskByList")
	public @ResponseBody Map insertTaskByList(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			FormTask task) throws Exception {
//		
//		System.out.println("\n\n\n\n\n\n");
		tasservice.updateTaskStatus();
		if (task.getTasTitle()==null)
			task.setTasTitle("任务");
		if (task.getTasDesc()==null)
			task.setTasDesc("任务");
		Activity activity2 =  activityService.selectActivityById(task.getTasAcId());
		task.setTasAcId(activity2.getAcId());
		List allTaskList = new ArrayList();
		String tasCreName = userservice.selectOne(task.getTasCreId()).getUserName();
		TaskIdentification taskIdentification = new TaskIdentification(task,  tasCreName);
//		tasservice.insertTask(task);
		String uuid = UUID.randomUUID().toString();
		task.setTasDocId(uuid);
		String filename1=fileservice.SaveFile(file1, uuid,"task");
		String filename2=fileservice.SaveFile(file2, uuid, "task");
		String filename3=fileservice.SaveFile(file3, uuid, "task");
		if(filename1!=null)
			task.setTasDoc1Name(filename1);
		if(filename2!=null)
			task.setTasDoc2Name(filename2);
		if(filename3!=null)
			task.setTasDoc3Name(filename3);
		List<String> formerTeachers = task.getUsers();
		List<User> teachers = new ArrayList<User>();
		for (String user : formerTeachers) {
			teachers.add(userservice.selectOne(user));
		}
		List<Task> TaskBefore;
		if (task.getTasAcId()!=0)
		TaskBefore = tasservice.selectTaskByTasAcId(task.getTasAcId());
		else
			TaskBefore = new ArrayList<Task>();
		int flag=tasservice.insertTask(task);
		List<Due> dueBefore = new ArrayList<Due>();
		for (Task task3 : TaskBefore) {
			List<Due> dueBeList = dueService.selectTasDueIdByTasId(task3.getTasId());
			for (Due due2 : dueBeList) {
				dueBefore.add(due2);
			}
		}
		Map<String, String> before = new HashMap<String, String>();
		for (Due due2 : dueBefore) {
			before.put(due2.getUserId(), userservice.selectOne(due2.getUserId()).getUserName());
		}
		List<NameAndId> more = new ArrayList<NameAndId>();
		Map success = new HashMap();
		for (User teacher : teachers){
			Due due = new Due();
			due.setTasid(task.getTasId());
			due.setTasStatus("0");
			due.setUserId(teacher.getUserId());
			if (before == null)
			{
				dueService.insertDue(due);
			}
			else if (before.get(due.getUserId())==null)	
			{
				dueService.insertDue(due);
			}
			else
			{
				NameAndId nId = new NameAndId(due.getUserId(), before.get(due.getUserId()), due.getTasStatus());
				success.put("condition", "2");
				more.add(nId);
			}
		}
		
		if(flag==1){
			for (User teacher : teachers){
				if (success.get("condition")!=null)
				{
					if (!success.get("condition").equals("2"))
				success.put("condition", "0");
				}
				else
				{
					success.put("condition", "0");
				}
				String mailbox = userservice.selectOne(teacher.getUserId()).getUserMailBox();
				mailservice.sendMailToOne("研究生院活动网站提醒", 
						"您有一个新任务，请及时查看！<br/>"+
				"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", mailbox);
				}
//				List<Task> taskList = new ArrayList<Task>();
				int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
				Page page = new Page(totalCount, 1);  
//				taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
				
				List taskList = new ArrayList();
//				int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
//				Page page = new Page(totalCount, 1);  
//				taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
//				taskList.add(success);
//				taskList.add(page);
				
//				taskList.add(more);
				success.put("taskDue", more);
				return success;
			}
			List list = new ArrayList();
			success.put("condition", "1");
			list.add(success);
			return success;
	}
	@RequestMapping("/boss/insertTask")
	public @ResponseBody Map insertTask(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			formerTask task) throws Exception {
		tasservice.updateTaskStatus();
		Activity activity2 =  activityService.selectActivityById(task.getTasAcId());
		task.setTasAcId(activity2.getAcId());
		String academy = null;
		String grade = null;
		User user = userservice.selectOne(task.getTasDueId());
		academy = user.getUserAcademy();
		grade = user.getUserGrade();
		//		User teacher = userservice.selectOne(task.getTasDue());
		task.setTasAcademy(academy);
		task.setTasGrade(grade);
		String uuid = UUID.randomUUID().toString();
		task.setTasDocId(uuid);
		String filename1=fileservice.SaveFile(file1, uuid,"task");
		String filename2=fileservice.SaveFile(file2, uuid, "task");
		String filename3=fileservice.SaveFile(file3, uuid, "task");
		if(filename1!=null)
			task.setTasDoc1Name(filename1);
		if(filename2!=null)
			task.setTasDoc2Name(filename2);
		if(filename3!=null)
			task.setTasDoc3Name(filename3);
//		Task task2 = task.getTask();
		
//		task.setTasAcademy(tasAcademy);
//		for ( NameAndId nId : task.getTasDue()) {
		int flag = 0;
			Due due = new Due();
			due.setTasid(task.getTasId());
			due.setTasStatus("0");
			due.setUserId(task.getTasDueId());
			List<Task> TaskBefore;
			if (task.getTasAcId()!=0)
			TaskBefore = tasservice.selectTaskByTasAcId(task.getTasAcId());
			else
				TaskBefore = new ArrayList<Task>();
			List<Due> dueBefore = new ArrayList<Due>();
			List<NameAndId> more = new ArrayList<NameAndId>();
			Map success = new HashMap();
			
			for (Task task3 : TaskBefore) {
				List<Due> dueBeList = dueService.selectTasDueIdByTasId(task3.getTasId());
				for (Due due2 : dueBeList) {
					dueBefore.add(due2);
				}
			}
			Map<String, String> before = new HashMap<String, String>();
			for (Due due2 : dueBefore) {
				before.put(due2.getUserId(), userservice.selectOne(due2.getUserId()).getUserName());
			}
			
			if (before == null)
			{
				flag=tasservice.insertTask(task);
				due.setTasid(task.getTasId());
				dueService.insertDue(due);
			}
			else if (before.get(due.getUserId())==null)
			{
				flag=tasservice.insertTask(task);
				due.setTasid(task.getTasId());
				dueService.insertDue(due);
			}
			else
			{
				NameAndId nId = new NameAndId(before.get(due.getUserId()),due.getUserId(), due.getTasStatus() );
				success.put("condition", "2");
				more.add(nId);
				success.put("taskDue", more);
				return success;
			}
		if(flag==1){
//			for (NameAndId nId:task.getTasDue()){
			if (success.get("condition")!=null)
			{
				if (!success.get("condition").equals("2"))
			success.put("condition", "0");
			}
			else
			{
				success.put("condition", "0");
			}
			String mailbox = userservice.selectOne(task.getTasDueId()).getUserMailBox();
			mailservice.sendMailToOne("研究生院活动网站提醒", 
					"您有一个新任务，请及时查看！<br/>"+
			"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", mailbox);
//			}
			List taskList = new ArrayList();
			int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
			Page page = new Page(totalCount, 1);  
//			taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
//			taskList.add(page);
			success.put("taskDue", more);
//			taskList.add(more);
//			taskList.add(success);
			return success;
		}
		List list = new ArrayList();
		success.put("condition", "1");
//		list.add(success);
		return success;
		
	}
	/*@RequestMapping("/updateTask")
	public @ResponseBody
	List<Activity> updateTask(@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			Task task) throws IOException {
		Task task2=tasservice.selectTaskByTasId(task.getTasId());
		String uuid = task2.getTasDocId();
		String tasCreId = task2.getTasCreId();
		List<String> filenamelist = new ArrayList<String>();
		filenamelist.add(task2.getTasDoc1Name());
		filenamelist.add(task2.getTasDoc2Name());
		filenamelist.add(task2.getTasDoc3Name());
		String path = p.readValue("path") + "task"
				+ System.getProperty("file.separator") + uuid;
		boolean f= fileservice.deleteFiles(filenamelist, path);
		if(f==true){
				String filename1=fileservice.SaveFile(file1, uuid,"task");
				String filename2=fileservice.SaveFile(file2, uuid, "task");
				String filename3=fileservice.SaveFile(file3, uuid, "task");
				task.setTasDoc1Name(filename1);
				task.setTasDoc2Name(filename2);
				task.setTasDoc3Name(filename3);
			}
		int flag = tasservice.updateTask(task);
		if(flag==1){
			List list = tasservice.selectTaskByTasCreId(tasCreId);
			return list;
		}
		return null;
	}
*/
	@RequestMapping("/teacher/activeTask")
	public @ResponseBody
	Map activiceTask(@RequestBody formerTask task) throws IOException {
		System.out.println(task.getTasId());
		System.out.println(task.getTasDueId());
		Due due = new Due();
		due.setTasid(task.getTasId());
		due.setUserId(task.getTasDueId());
		due.setBegin(new Date());
		Map map = new HashMap<String, String>();
		map.put("success", "false");
		List <Due> dues = dueService.selectTasDueIdByDue(due);
		if (dues != null){
		String status = dues.get(0).getTasStatus();
		if (status.equals("0")){
			int flag1 = dueService.activeTask(due);
			task.setTasStatus("1");
			int flag2 = tasservice.updateTask(task);
			if (flag1>0&&flag2>0)
				map.put("success", "true");
		}
		//TODO 在对应due的位置设置开始时间
		
		return map;
		}
//		tasservice.
		/**
		 * 这边需加上任务总表的修改
		 */
		return map;
	}
	@RequestMapping("/boss/updateTask")
	public @ResponseBody
	List updateTask(@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			formerTask task,Integer pageNow) throws IOException {
		tasservice.updateTaskStatus();
		Task task2=tasservice.selectTaskByTasId(task.getTasId());
		if(task.getTasCreId().equals(task2.getTasCreId())){
			String uuid = task2.getTasDocId();
			String tasCreId = task2.getTasCreId();
			String path = p.readValue("path") + "task"
					+ System.getProperty("file.separator") + uuid;
			String filename1=fileservice.SaveFile(file1, uuid,"task");
			String filename2=fileservice.SaveFile(file2, uuid, "task");
			String filename3=fileservice.SaveFile(file3, uuid, "task");
			List<String> filenamelist = new ArrayList<String>();
			if(filename1!=null){
				filenamelist.add(task2.getTasDoc1Name());
				task.setTasDoc1Name(filename1);
			}
			if(filename2!=null){
				filenamelist.add(task2.getTasDoc2Name());
				task.setTasDoc2Name(filename2);
			}
			if(filename3!=null){
				filenamelist.add(task2.getTasDoc3Name());
				task.setTasDoc3Name(filename3);
			}
			boolean f= fileservice.deleteFiles(filenamelist, path);
			if(f==true){
				
				Date thisDate = new Date();
				if (task.getTasDueDate()!=null)
					if(task.getTasDueDate().after(thisDate))
					{
						if (task2.getTasStatus().equals("3"))
							task.setTasStatus("1");
						List<Due> dueList = dueService.selectTasDueIdByTasId(task2.getTasId());
						for (Due due : dueList) {
							due.setTasStatus("1");
							dueService.updateDue(due);
						}
					}
				int flag = tasservice.updateTask(task);
				if(flag==1){
					List taskList = null;
					int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
					Page page = new Page(totalCount, pageNow);  
					taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
					taskList.add(page);
					return taskList;
				}
			}
	
		}
			
		return null;
	}
	@RequestMapping("/teacher/finishTask")
	public @ResponseBody
	int Taskfinish(@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			formerTask task) throws IOException {
		tasservice.updateTaskStatus();
		Task task2=tasservice.selectTaskByTasId(task.getTasId());
		List<Due> dueList = dueService.selectTasDueIdByTasId(task.getTasId());
		int flags = 0;
		for (Due due : dueList) {
			if (due.getUserId().equals(task.getTasDueId()))
					flags = 1;
		}
		if(flags == 1){
			if(task2.getTasStatus().equals("1")){
				System.out.println("In");
				List<Sign> unHandleList = signservice.selectUnhandleSigns();
//				if(unHandleList==null){
					String uuid = task2.getTasDocId();
					String tasDueId = task.getTasDueId();
					String path = p.readValue("path") + "task"
							+ System.getProperty("file.separator") + uuid;
					String filename1=fileservice.SaveFile(file1, uuid,"task");
					String filename2=fileservice.SaveFile(file2, uuid, "task");
					String filename3=fileservice.SaveFile(file3, uuid, "task");
					List<String> filenamelist = new ArrayList<String>();
					if(filename1!=null){
						filenamelist.add(task2.getTasFdoc1Name());
						task.setTasFdoc1Name(filename1);
					}
					if(filename2!=null){
						filenamelist.add(task2.getTasFdoc2Name());
						task.setTasFdoc2Name(filename2);
					}
					if(filename3!=null){
						filenamelist.add(task2.getTasFdoc3Name());
						task.setTasFdoc3Name(filename3);
					}
					boolean f= fileservice.deleteFiles(filenamelist, path);
					if(f==true){
						
						int flag = tasservice.updateTask(task);
						if(flag==1){
							Due due = new Due();
							due.setTasid(task.getTasId());
							due.setTasStatus("2");
							//TODO 在对应due的位置设置开始时间
							due.setUserId(tasDueId);
							due.setFini(new Date());
							int allFlag = 1;
							dueService.updateDue(due);
							List<Due> dueList2 = dueService.selectTasDueIdByTasId(task.getTasId());
							for (Due due2 : dueList2) {
								if (!due2.getTasStatus().equals("2"))
									allFlag = 0;
							}
							if (allFlag == 1)
							task.setTasStatus("2");
							tasservice.updateTask(task);
							return 1;
						}
					}
				}
				
//			}
			
		}
			
		return 0;
	}
	@RequestMapping("/taskfileDownload")
	public void taskfileDownload(String fileName, Integer tasId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tasDocId = tasservice.selectTaskByTasId(tasId).getTasDocId();
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		String path = p.readValue("path") + "task"
				+ System.getProperty("file.separator") + tasDocId;
		fileservice.fileDownload(fileName, path, request, response);
	}
	@RequestMapping("/teacher/TaskOverDue")
	public @ResponseBody
	List<Task> teacherTaskOverDue(Integer pageNow,String tasDueId,Integer pageSize){
		tasservice.updateTaskStatus();
		Page page = null;  
	    int totalCount = tasservice.selectTaskOverDueByTasDueIdCount(tasDueId);  
	    List<Task> tasList = null;
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        tasList = tasservice.selectTaskOverDueByTasDueId(page.getStartPos(), page.getPageSize(),tasDueId);  
	    } else {  
	        page = new Page(totalCount, 1);  
	        tasList = tasservice.selectTaskOverDueByTasDueId(page.getStartPos(), page.getPageSize(),tasDueId);  
	    }
	    if(pageSize!=null&&pageSize>0l){
        	page.setPageSize(pageSize);
        }
	    List result = new ArrayList();
	    System.out.println(tasList);
	    for (Task object : tasList) {
	    	if( object!=null)
			{
//				formerTask former = new formerTask();
//				former.setTask(object);
//				former.
				TaskIdentification tIdentification = new TaskIdentification(object,
						userservice.selectOne(object.getTasCreId()).
						getUserName());
				List<Due> duelist = dueService.selectTasDueIdByTasId(object.getTasId());
//				tIdentification.extendTask(userservice, tasDueId); 
				for (Due due : duelist) {
					tIdentification.extendTask(userservice.selectOne(due.getUserId()).getUserName(),
							due.getUserId(), due.getTasStatus());
				}
//				object.setTasSta);
				System.out.println(tIdentification.getTasAcademy());
				result.add(tIdentification);
			}
		}
	    result.add(page);
	    return result;
	}
	@RequestMapping("/teacher/TaskNotOverDue")
	public @ResponseBody
	List teacherTaskNotOverDue(Integer pageNow,String tasDueId,Integer pageSize){
		tasservice.updateTaskStatus();
		Page page = null;  
	    int totalCount = tasservice.selectTaskNotOverDueByTasDueIdCount(tasDueId);  
	    List<Task> tasList = null;
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        tasList = tasservice.selectTaskNotOverDueByTasDueId(page.getStartPos(), page.getPageSize(),tasDueId);  
	        
	    } else {  
	        page = new Page(totalCount, 1);  
	        tasList = tasservice.selectTaskNotOverDueByTasDueId(page.getStartPos(), page.getPageSize(),tasDueId);  
	    }  
	    if(pageSize!=null&&pageSize>0l){
        	page.setPageSize(pageSize);
        }
	    List result = new ArrayList();
	    System.out.println(tasList);
	    for (Task object : tasList) {
			if( object!=null)
			{
//				formerTask former = new formerTask();
//				former.setTask(object);
//				former.
				TaskIdentification tIdentification = new TaskIdentification(object,
						userservice.selectOne(object.getTasCreId()).
						getUserName());
				List<Due> duelist = dueService.selectTasDueIdByTasId(object.getTasId());
//				tIdentification.extendTask(userservice, tasDueId);
				for (Due due : duelist) {
					tIdentification.extendTask(userservice.selectOne(due.getUserId()).getUserName(),
							due.getUserId(), due.getTasStatus());
				}
				System.out.println(tIdentification.getTasAcademy());
				result.add(tIdentification);
			}
	    }
	    result.add(page);
	    return result;
	}
	
	@RequestMapping("/boss/TaskOverDue")
	public @ResponseBody
	List bossTaskOverDue(Integer pageNow,String tasCreId,Integer pageSize){
		tasservice.updateTaskStatus();
		Page page = null;  
	    int totalCount = tasservice.selectTaskOverDueByTasCreIdCount(tasCreId);  
	    List<Task> tasList = new ArrayList<Task>();
	    List result = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        tasList = tasservice.selectTaskOverDueByTasCreId(page.getStartPos(), page.getPageSize(),tasCreId);  
	        for (Task task : tasList) {
				TaskIdentification taskIdentification = new TaskIdentification(
						task, userservice.selectOne(tasCreId).getUserName());
				List<Due> due =  dueService.selectTasDueIdByTasId(task.getTasId());
				for (Due due2 : due) {
					taskIdentification.extendTask(userservice.selectOne(due2.getUserId()).getUserName(),
							due2.getUserId(), due2.getTasStatus());
				}
				result.add(taskIdentification);
			}
	    } else {
	        page = new Page(totalCount, 1);  
	        tasList = tasservice.selectTaskOverDueByTasCreId(page.getStartPos(), page.getPageSize(),tasCreId);  
	        for (Task task : tasList) {
				TaskIdentification taskIdentification = new TaskIdentification(
						task, userservice.selectOne(tasCreId).getUserName());
				List<Due> due =  dueService.selectTasDueIdByTasId(task.getTasId());
				for (Due due2 : due) {
					taskIdentification.extendTask(userservice.selectOne(due2.getUserId()).getUserName(),
							due2.getUserId(), due2.getTasStatus());
				}
				result.add(taskIdentification);
	        }
	    }  
	    if(pageSize!=null&&pageSize>0l){
        	page.setPageSize(pageSize);
        }
	    System.out.println("0****" + tasList);
	    result.add(page);
	    return result;
	}
	@RequestMapping("/boss/TaskNotOverDue")
	public @ResponseBody
	List bossTaskNotOverDue(Integer pageNow,String tasCreId,Integer pageSize){
		tasservice.updateTaskStatus();
		Page page = null;  
	    int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(tasCreId);  
	    List<Task> tasList = new ArrayList<Task>();
	    List result = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        tasList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),tasCreId);
	        for (Task task : tasList) {
				TaskIdentification taskIdentification = new TaskIdentification(
						task, userservice.selectOne(tasCreId).getUserName());
				List<Due> due =  dueService.selectTasDueIdByTasId(task.getTasId());
				for (Due due2 : due) {
					taskIdentification.extendTask(userservice.selectOne(due2.getUserId()).getUserName(),
							due2.getUserId(), due2.getTasStatus());
				}
				result.add(taskIdentification);
			}
	    } else {
	        page = new Page(totalCount, 1);  
	        tasList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),tasCreId);  
	        for (Task task : tasList) {
				TaskIdentification taskIdentification = new TaskIdentification(
						task, userservice.selectOne(tasCreId).getUserName());
				List<Due> due =  dueService.selectTasDueIdByTasId(task.getTasId());
				for (Due due2 : due) {
					taskIdentification.extendTask(userservice.selectOne(due2.getUserId()).getUserName(),
							due2.getUserId(), due2.getTasStatus());
				}
				result.add(taskIdentification);
	        }
	    }  
	    if(pageSize!=null&&pageSize>0l){
        	page.setPageSize(pageSize);
        }
	    result.add(page);
	    return result;
	}
	@RequestMapping("/boss/deleteTask")
	public @ResponseBody
	List deleteTask(@RequestBody Task1 task) throws Exception{
		tasservice.updateTaskStatus();
		System.out.println(task);
		Task a = tasservice.selectTaskByTasId(task.getTasId());
		if (a!=null)
			if(a.getTasCreId().equals(task.getTasCreId())){
				String tasCreId = a.getTasCreId();
				String path = p.readValue("path") + "task"
						+ System.getProperty("file.separator") + a.getTasDocId();
				fileservice.delFolder(path);
				dueService.deleteDueByTasId(a.getTasId());
				signservice.deleteSignByTasId(a);
				int flag = tasservice.deleteTask(a.getTasId());
				if(flag==1){
					List taskList = null;
					int totalCount = tasservice.selectTaskNotOverDueByTasCreIdCount(task.getTasCreId());
					Page page = new Page(totalCount, task.getPageNow());
					if(task.getPageNow()>page.getTotalPageCount()){
						page.setPageNow(page.getTotalPageCount());
						System.out.println("In");
					}
					if (page.getTotalPageCount()!=0)
					{
						taskList = tasservice.selectTaskNotOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
						taskList.add(page);
					}
					else
					{
						taskList = new ArrayList();
						taskList.add(page);
					}
					System.out.println(taskList);
					return taskList;
				}
			}
		return null;
	}
	@RequestMapping("/boss/deleteTaskOverDue")
	public @ResponseBody
	List deleteTaskOverDue(@RequestBody Task1 task) throws Exception{
		tasservice.updateTaskStatus();
		System.out.println(task);
		Task a = tasservice.selectTaskByTasId(task.getTasId());
//		if(a.getTasStatus().equals("0")){
		if (a!=null){
			if(a.getTasCreId().equals(task.getTasCreId())){
				String tasCreId = a.getTasCreId();
				String path = p.readValue("path") + "task"
						+ System.getProperty("file.separator") + a.getTasDocId();
				fileservice.delFolder(path);
				dueService.deleteDueByTasId(a.getTasId());
				int flag = tasservice.deleteTask(a.getTasId());
				if(flag==1){
					List taskList = null;
					
					int totalCount = tasservice.selectTaskOverDueByTasCreIdCount(task.getTasCreId());
					Page page = new Page(totalCount, task.getPageNow());
					if(task.getPageNow()>page.getTotalPageCount()){
						page.setPageNow(page.getTotalPageCount());
					}
					System.out.println(page.getPageNow());
					if (page.getTotalPageCount()!=0)
					{
						taskList = tasservice.selectTaskOverDueByTasCreId(page.getStartPos(), page.getPageSize(),task.getTasCreId());
						taskList.add(page);
					}
					else
					{
						taskList = new ArrayList();
						taskList.add(page);
					}
					System.out.println(taskList);
					return taskList;
				}
			}
		}
		
		return null;
	}

	@RequestMapping("/updateTaskStatus")
	public @ResponseBody int updateTaskStatus(@RequestBody Task task){
		return tasservice.updateTask(task);
		
	}
	@RequestMapping("/taskceshi")
	public @ResponseBody String send() throws Exception{
		String mailbox = userservice.selectOne("1143710506").getUserMailBox();
		mailservice.sendMailToOne("haha", "测试", mailbox);
		return "success";
	}
}
