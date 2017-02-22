package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapper.ActivityMapper;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import po.Activity;
import po.ActivityCustom1;
import po.Actype;
import po.Due;
import po.ExActivity;
import po.ExActivityCustom1;
import po.NameAndId;
import po.Sign;
import po.Task;
import po.TaskIdentification;
import po.User;
import po.activityTask;
import po.formerActivty;
import po.formerTask;
import service.ActivityService;
import service.DueActivityService;
import service.DueService;
import service.FileService;
import service.MailService;
import service.SignService;
import service.TaskService;
import service.UserService;
import utils.Page;
import utils.PropertiesUtil;

@Controller
public class ActivityController {
	@Autowired
	private ActivityService acservice; 
	@Autowired
	private UserService userservice;
	@Autowired
	private MailService mailservice;
	@Autowired
	private FileService fileservice;
	@Autowired
	private TaskService tasservice;
	@Autowired
	private SignService signservice;
	@Autowired
	private PropertiesUtil p;
	@Autowired
	private DueService dueService;
	@Autowired
	private DueActivityService dueActivityService;
	
	@RequestMapping("/teacher/activityFileUpload")
	public @ResponseBody
	List activityFileUpload(HttpServletRequest request,
			HttpServletResponse response, @RequestBody ExActivity activity)
			throws Exception {
		List list = fileservice.fileUpload(request, response, "activity");
		String message = (String) request.getAttribute("message");
		if (list != null) {
			if (list.size() > 0) {
				activity.setAcDocId((String) list.get(0));
			}
			if (list.size() > 1) {
				activity.setAcDoc1Name((String) list.get(1));
			}
			if (list.size() > 2) {
				activity.setAcDoc2Name((String) list.get(2));
			}
			if (list.size() > 3) {
				activity.setAcDoc3Name((String) list.get(3));
			}
			acservice.updateActivity(activity);
		}
		if (message != null && message != "") {
			list.add(message);
		}
		return list;
	}

	@RequestMapping("/teacher/dueAcademy")
	public @ResponseBody
	Map<String, List<User>> dueAcademy(HttpServletRequest request,
			HttpServletResponse response, @RequestBody ExActivity activity)
			throws Exception {
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		map = dueActivityService.selectUserOrderByAcademy(activity.getAcId());
		return map;
	}

	
	@RequestMapping("/teacher/fileOnTemp")
	public @ResponseBody
	List<FileItem> fileOnTemp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List list = fileservice.fileOnTemp(request, response);
		return list;
	}
	
	@RequestMapping("/teacher/activityFileTransferTemp")
	public @ResponseBody
	List activityFileTransferTemp(HttpServletRequest request,
			HttpServletResponse response, List<FileItem> list,
			@RequestBody Activity activity) {
		List list2 = fileservice.TransferTemp(request, response, "activity",
				list);
		String message = (String) request.getAttribute("message");
		if (list2 != null) {
			if (list2.size() > 0) {
				activity.setAcDocId((String) list2.get(0));
			}
			if (list2.size() > 1) {
				activity.setAcDoc1Name((String) list2.get(1));
			}
			if (list2.size() > 2) {
				activity.setAcDoc2Name((String) list2.get(2));
			}
			if (list2.size() > 3) {
				activity.setAcDoc3Name((String) list2.get(3));
			}
		}
		acservice.updateActivity(activity);
		if (message != null && message != "") {
			list2.add(message);
		}
		return list2;
	}

	@RequestMapping("/activityfileDownload")
	public void activityfileDownload(String fileName, Integer acId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String acDocId = acservice.selectAcDocIdById(acId);
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		String path = p.readValue("path") + "activity"
				+ System.getProperty("file.separator") + acDocId;
		fileservice.fileDownload(fileName, path, request, response);
	}
	@RequestMapping("/teacher/ActivityNotOverDue")
	public @ResponseBody
	List teacherActivityNotOverDue(Integer pageNow,String acCreId, Integer pageSize) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityNotOverDueByAcCreIdCount(acCreId);  
		    List list = new ArrayList();
		    List<ActivityCustom1> activityList1 = null;
		    List<ExActivityCustom1> exList = new ArrayList<ExActivityCustom1>();
		    if (pageNow!=null) {  
		        page = new Page(totalCount, pageNow);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityNotOverDueByAcCreId(page.getStartPos(), page.getPageSize(),acCreId);  
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    } else {  
		        page = new Page(totalCount, 1);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityNotOverDueByAcCreId(page.getStartPos(), page.getPageSize(),acCreId);  
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    }  
		    for(int i=0;i<activityList1.size();i++){
        		ActivityCustom1 activity = (ActivityCustom1)activityList1.get(i);
        		if(activity.getSigStatus()==null){
        			activity.setSigStatus("3");
        		}
			}
		    list.add(exList);
		    list.add(page);
		    return list;
	}
	@RequestMapping("/teacher/ActivityOverDue")
	public @ResponseBody
	List teacherActivityOverDue(Integer pageNow,String acCreId, Integer pageSize) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityOverDueByAcCreIdCount(acCreId);  
		    List list = new ArrayList();
		    List<ActivityCustom1> activityList1 = null;
		    List<ExActivityCustom1> exList = new ArrayList<ExActivityCustom1>();
		    if (pageNow!=null) {  
		        page = new Page(totalCount, pageNow);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityOverDueByAcCreId(page.getStartPos(), page.getPageSize(),acCreId);  
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    } else {  
		        page = new Page(totalCount, 1);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityOverDueByAcCreId(page.getStartPos(), page.getPageSize(),acCreId);  
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    }  
		    for(int i=0;i<activityList1.size();i++){
        		ActivityCustom1 activity = (ActivityCustom1)activityList1.get(i);
        		if(activity.getSigStatus()==null){
        			activity.setSigStatus("3");
        		}
			}
		    list.add(exList);
		    list.add(page);
		    return list;
	}
	@RequestMapping("/boss/ActivityNotOverDue")
	public @ResponseBody
	List bossActivityNotOverDue(Integer pageNow, Integer pageSize) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityNotOverDueCount();  
		    List list = new ArrayList();
		    List<Activity> activityList1 = null;
		    List<ExActivity> exList = new ArrayList<ExActivity>();
		    if (pageNow!=null) {  
		        page = new Page(totalCount, pageNow);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityNotOverDue(page.getStartPos(), page.getPageSize());  
		        for (Activity activityCustom1 : activityList1) {
					ExActivity exAc = new ExActivity(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    } else {  
		        page = new Page(totalCount, 1);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityNotOverDue(page.getStartPos(), page.getPageSize());  
		        for (Activity activityCustom1 : activityList1) {
					ExActivity exAc = new ExActivity(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    }  
		    list.add(exList);
		    list.add(page);
		    return list;
	}
	@RequestMapping("/boss/ActivityOverDue")
	public @ResponseBody
	List bossActivityOverDue(Integer pageNow, Integer pageSize) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityOverDueCount();  
		    List list = new ArrayList();
		    List<Activity> activityList1 = null;
		    List<ExActivity> exList = new ArrayList<ExActivity>();
		    if (pageNow!=null) {
		        page = new Page(totalCount, pageNow);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityOverDue(page.getStartPos(), page.getPageSize());  
		        for (Activity activityCustom1 : activityList1) {
					ExActivity exAc = new ExActivity(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    } else {  
		        page = new Page(totalCount, 1);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityOverDue(page.getStartPos(), page.getPageSize());  
		        for (Activity activityCustom1 : activityList1) {
					ExActivity exAc = new ExActivity(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    }  
		    list.add(exList);
		    list.add(page);
		    return list;
	}
	/*@RequestMapping("/student/ActivityNotOverDue")
	public @ResponseBody
	List studentActivityNotOverDue(Integer pageNow,String sigPerId) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityNotOverDueCount();  
		    List activityList = null;
		    if (pageNow!=null) {  
		        page = new Page(totalCount, pageNow);  
		        activityList = acservice.selectActivityNotOverDue(page.getStartPos(), page.getPageSize());
		        if(sigPerId!=null&&sigPerId!=""){
		        	for(int i=0;i<activityList.size();i++){
		        		Activity activity = (Activity)activityList.get(i);
		        		int acId = activity.getAcId();
		        		String sigStatus =signservice.selectSignByacIdAndsigPerId(acId,sigPerId);
		        		if(sigStatus!=null){
		        			activity.setSigStatus(sigStatus);
		        		}else{
		        			activity.setSigStatus("3");
		        		}
					}
		        	
		        }
		    } else {  
		        page = new Page(totalCount, 1);  
		        activityList = acservice.selectActivityNotOverDue(page.getStartPos(), page.getPageSize());
		        if(sigPerId!=null&&sigPerId!=""){
		        	for(int i=0;i<activityList.size();i++){
		        		Activity activity = (Activity)activityList.get(i);
		        		int acId = activity.getAcId();
		        		String sigStatus =signservice.selectSignByacIdAndsigPerId(acId,sigPerId);
		        		if(sigStatus!=null){
		        			activity.setSigStatus(sigStatus);
		        		}else{
		        			activity.setSigStatus("3");
		        		}
					}
		        	
		        }
	        	
	        }
		       
		    activityList.add(page);
		    return activityList;
	}*/
	@RequestMapping("/student/ActivityNotOverDue")
	public @ResponseBody
	List studentActivityNotOverDue(Integer pageNow, String sigPerId, Integer pageSize) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityNotOverDueCount();  
		    List list = new ArrayList();
		    List<ActivityCustom1> activityList1 = null;
		    List<ExActivityCustom1> exList = new ArrayList<ExActivityCustom1>();
		    if (pageNow!=null) {  
		        page = new Page(totalCount, pageNow);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityCus1NotOverDue(page.getStartPos(), page.getPageSize(),sigPerId);
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    } else {  
		        page = new Page(totalCount, 1);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityCus1NotOverDue(page.getStartPos(), page.getPageSize(),sigPerId);
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    }
		    for(int i=0;i<activityList1.size();i++){
        		ActivityCustom1 activity = (ActivityCustom1)activityList1.get(i);
        		if(activity.getSigStatus()==null){
        			activity.setSigStatus("3");
        		}
			}
		    list.add(exList);
		    list.add(page);
		    return list;
	}
	@RequestMapping("/student/ActivityOverDue")
	public @ResponseBody
	List studentActivityOverDue(Integer pageNow,String sigPerId,Integer pageSize) {
			acservice.updateAcStatus();
		  	Page page = null;  
		    int totalCount = acservice.selectActivityOverDueCount();
		    List list = new ArrayList();
		    List<ActivityCustom1> activityList1 = null;
		    List<ExActivityCustom1> exList = new ArrayList<ExActivityCustom1>();
		    if (pageNow!=null) {  
		        page = new Page(totalCount, pageNow);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityCus1OverDue(page.getStartPos(), page.getPageSize(),sigPerId);
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    } else {  
		        page = new Page(totalCount, 1);  
		        if(pageSize!=null&&pageSize>0l){
		        	page.setPageSize(pageSize);
		        }
		        activityList1 = acservice.selectActivityCus1OverDue(page.getStartPos(), page.getPageSize(),sigPerId);
		        for (ActivityCustom1 activityCustom1 : activityList1) {
					ExActivityCustom1 exAc = new ExActivityCustom1(activityCustom1);
					exAc.setAcademys(dueActivityService.selectUserByAcId(activityCustom1.getAcId()));
					exList.add(exAc);
				}
		    }
		    for(int i=0;i<activityList1.size();i++){
        		ActivityCustom1 activity = (ActivityCustom1)activityList1.get(i);
        		if(activity.getSigStatus()==null){
        			activity.setSigStatus("3");
        		}
			}
		    list.add(exList);
		    list.add(page);
		    return list;
	}
	
	@RequestMapping("/teacher/insertActivity")
	public @ResponseBody List insertActivity(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			ExActivity activity) throws Exception {
		tasservice.updateTaskStatus();
//		Task task2 = tasservice.selectTaskByTasId(task.getTasId());
//		if(task2.getTasStatus().equals("0")){
			String uuid = UUID.randomUUID().toString();
			activity.setAcDocId(uuid);
			
//			activity.setAcTasId(task.getTasId());
			String filename1=fileservice.SaveFile(file1, uuid,"activity");
			String filename2=fileservice.SaveFile(file2, uuid, "activity");
			String filename3=fileservice.SaveFile(file3, uuid, "activity");
			if(filename1!=null)
				activity.setAcDoc1Name(filename1);
			if(filename2!=null)
				activity.setAcDoc2Name(filename2);
			if(filename3!=null)
				activity.setAcDoc3Name(filename3);
			int flag=acservice.insertActivity(activity);
			
			dueActivityService.updateDueAvtivity( activity.getAcId(),activity.getAcademys());
			
			if(flag==1){
					List<String> mailList = userservice.selectStudentMailboxes();
					if(mailList!=null&&mailList.size()>0){
						mailservice.sendMailToMany("研究生院活动网站提醒", "有新活动下发，请及时查看！<br/>"+"<a href=\"http://www.ly723.site:2048/StudentManager2/login.html\">点击这里登录</a>", mailList);
					}
					List activityList = null;
					int totalCount = acservice.selectActivityNotOverDueCount();
					Page page = new Page(totalCount, 1);  
					activityList = acservice.selectActivityNotOverDueByAcCreId(page.getStartPos(), page.getPageSize(),activity.getAcCreId());
					activityList.add(page);
					return activityList;
			}
		return null;
	}
	@RequestMapping("/teacher/updateActivity")
	public @ResponseBody
	List updateActivity(@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,
			ExActivity activity,Integer pageNow) throws IOException {
		String acCreId = activity.getAcCreId();
		String uuid = acservice.selectAcDocIdById(activity.getAcId());
		Activity a2 = acservice.selectActivityById(activity.getAcId());
		if (activity.getAcademys() == null)
			dueActivityService.updateDueAvtivity(activity.getAcId(), activity.getAcademys());
		if(acCreId.equals(a2.getAcCreId())){
			String path = p.readValue("path") + "activity"
					+ System.getProperty("file.separator") + uuid;
			String filename1=fileservice.SaveFile(file1, uuid,"activity");
			String filename2=fileservice.SaveFile(file2, uuid, "activity");
			String filename3=fileservice.SaveFile(file3, uuid, "activity");
			List<String> filenamelist = new ArrayList<String>();
			if(filename1!=null){
				filenamelist.add(a2.getAcDoc1Name());
				activity.setAcDoc1Name(filename1);
			}
			if(filename2!=null){
				filenamelist.add(a2.getAcDoc2Name());
				activity.setAcDoc2Name(filename2);
			}
			if(filename3!=null){
				filenamelist.add(a2.getAcDoc3Name());
				activity.setAcDoc3Name(filename3);
			}
			boolean f = fileservice.deleteFiles(filenamelist, path);
			if(f==true){
				int flag = acservice.updateActivity(activity);
				if(flag==1){
					List activityList = null;
					int totalCount = (int) acservice.selectActivityNotOverDueCount();
					Page page = new Page(totalCount, pageNow);  
					activityList = acservice.selectActivityNotOverDueByAcCreId(page.getStartPos(), page.getPageSize(),activity.getAcCreId());
					activityList.add(page);
					return activityList;
				}
			}
		}
		
		
		return null;
	}

	@RequestMapping("/teacher/updateActivityNum")
	public @ResponseBody
	int updateActivityNum(Integer acId) {
		int flag = acservice.updateActivityNum(acId);
		return flag;
	}

	@RequestMapping("/teacher/deleteActivity")
	public @ResponseBody
	Map deleteActivity(@RequestBody Activity activity,Integer pageNow) throws Exception{
		Activity a = acservice.selectActivityById(activity.getAcId());
		String acCreId = activity.getAcCreId();
		Map map = new HashMap();
		map.put("success", "false");
//		if(acCreId.equals(a.getAcCreId())){
			String path = p.readValue("path") + "activity"
					+ System.getProperty("file.separator") + a.getAcDocId();
			fileservice.delFolder(path);
			TaskController tController = new TaskController();
			List<Task> listTask = tasservice.selectTaskByTasAcId(activity.getAcId());
			for (Task taskln : listTask) {
				System.out.println("Ln");
				List<Due> dueList =  dueService.selectTasDueIdByTasId(taskln.getTasId());
				for (Due due : dueList) {
					dueService.deleteDue(due);
				}
				tasservice.deleteTask(taskln.getTasId());
			}
			int flag = acservice.deleteActivity(a.getAcId());
			if(flag==1){
				int formerFlag = dueActivityService.deleteDueActivity(activity.getAcId());
				List activityList = null;
				int totalCount = acservice.selectActivityNotOverDueCount();
				Page page = new Page(totalCount, pageNow);
				if(pageNow>page.getTotalPageCount())
				{
					page.setPageNow(page.getTotalPageCount());
				}
				map.put("success", "true");
//				activityList = acservice.selectActivityNotOverDueByAcCreId(page.getStartPos(), page.getPageSize(),activity.getAcCreId());
//				activityList.add(page);
//				activityList.add(map);
				return map;
			}
//		}
//		List list = new ArrayList();
//		list.add(map);
		return map;
	}
	@RequestMapping("/actypes")
	public @ResponseBody
	List<Actype> selectAcTypes() {
		return acservice.selectAcType();
	}
	public void fileChannelCopy(File s, File t) {

        FileInputStream fi = null;

        FileOutputStream fo = null;

        FileChannel in = null;

        FileChannel out = null;

        try {

            fi = new FileInputStream(s);

            fo = new FileOutputStream(t);

            in = fi.getChannel();//得到对应的文件通道

            out = fo.getChannel();//得到对应的文件通道

            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                fi.close();

                in.close();

                fo.close();

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
	}
}