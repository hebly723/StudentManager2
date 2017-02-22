package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Activity;
import po.Due;
import po.ExTask;
import po.Sign;
import po.Task;
import po.User;
import service.ActivityService;
import service.DueService;
import service.ExcelService;
import service.InfoService;
import service.SignService;
import service.TaskService;
import service.UserService;
import service.impl.Academy;
import service.impl.ExcelServiceImpl.ActivityListImpl;
import service.impl.ExcelServiceImpl.ActivityMasterImpl;
import service.impl.ExcelServiceImpl.StudentInfoImpl;
import service.impl.ExcelServiceImpl.YearEndImpl;
import utils.PropertiesExcel;
import utils.PropertiesExcelLocation;
import utils.PropertyInterface;
import utils.doFile;

@Controller
public class ExcelController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private SignService signService;
	@Autowired
	private UserService userService;;
	@Autowired
	private TaskService taskService;
	@Autowired
	private DueService dueService;
	@RequestMapping("/StudentInfoExcel")
	public void  ExcelOnStudentInfoList(int activityId, HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
//		activityId = 34;
		
		List<Sign> signList = signService.selectSignByAcIdOk(activityId);
		List userInfo  = new ArrayList();
		User user = userService.selectOne(activityService.selectActivityById(activityId).getAcCreId());
		userInfo.add("("+user.getUserName()+
				")"+activityService.selectActivityById(activityId).getAcTitle());
		for (Sign sign : signList) {
			userInfo.add(userService.selectOne(sign.getSigPerId()));
		}
		ExcelService excelService = new StudentInfoImpl();
//		File file = excelService.write(userInfo);
		String sd =  excelService.write(userInfo);
		doFile df = new doFile();
//		System.out.println(file);
		df.download2("("+user.getUserName()+
				")"+activityService.selectActivityById(activityId).getAcTitle()+ ".xls",sd , request, response);
		
		/**
		 * 还余删除功能未完成
		 */
		File file = new File(sd + "("+user.getUserName()+
				")"+activityService.selectActivityById(activityId).getAcTitle()+ ".xls");
//		System.out.println("sadasd");
		file.delete();
		
	}
	@RequestMapping("/array")
	public @ResponseBody List testJsonArray( @RequestBody List list, HttpServletRequest request,
			HttpServletResponse response){
		System.out.println(list);
		return list;
	}
	@RequestMapping("/YearEndExcel")
	public @ResponseBody Map  ExcelOnYearEndImpl( @RequestBody List userList,
			HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		String userId = (String) userList.get(0);
		List addition = new ArrayList();
		addition.add(userId);
		Map map = new HashMap();
		Date date = new Date();
		/**
		 *  重名问题未解决
		 */
		PropertyInterface proInterface = new PropertiesExcel();
		Map<String, String> map2 = proInterface.readAllProperties();
		
		List<String> yearEndList = new ArrayList();
		for (int i=0;i<95;i++)
        {
        	yearEndList.add("--");
        }
//		yearEndList.size(95);
//		List<String> Label = (List) map.get("Label");
//		int i = 0;
		System.out.println(userList);
//		for (int i = 0; i<57;i++) 
//		{
////			System.out.println(i);
////			System.out.println(Label.get(i));
////			System.out.println(userList.get(i));
//			try{
//			yearEndList.set(Integer.parseInt(map2.get(i+"")), (String) userList.get(i));
//			}catch(Exception e){
//				e.printStackTrace();
//				yearEndList.set(i, "空");
//			}
//		}
//		int i = 0;
//		for (String key : map2.keySet()) {
//			yearEndList.set(Integer.parseInt(((String) (map.get(key)))), (String) userList.get(i));
//			System.out.println("key= "+ key + " and value= " + map.get(key));
//			i++;
//		}
//		for (int i = 14; i<userList.toArray().length;i++)
//		{
//			
//		}
//		String k1 = (String) userList.get(56);
//		String k2 = (String)userList.get(57);
//		String k3;
//		}
//		for (int i = 14; i<userList.toArray().length - 1;i++)
//		{
//			userList.set(i, k1);
//			
//		}
		yearEndList.set(8, (String) userList.get(1));
		yearEndList.set(9, (String) userList.get(2));
		yearEndList.set(11, (String) userList.get(3));
		yearEndList.set(12, (String) userList.get(4));
		yearEndList.set(14, (String) userList.get(5));
		yearEndList.set(15, (String) userList.get(6));
		yearEndList.set(17, (String) userList.get(7));
		yearEndList.set(18, (String) userList.get(8));
		yearEndList.set(20, (String) userList.get(9));
		yearEndList.set(21, (String) userList.get(10));
		yearEndList.set(22, (String) userList.get(11));
		yearEndList.set(23, (String) userList.get(12));
		yearEndList.set(24, (String) userList.get(13));
		yearEndList.set(25, (String) userList.get(14));
		//////////////////////////////////////////////////
		yearEndList.set(26, (String) userList.get(57));
		yearEndList.set(27, (String) userList.get(58));
		yearEndList.set(28, (String) userList.get(15));
		yearEndList.set(29, (String) userList.get(16));
		yearEndList.set(30, (String) userList.get(17));
		yearEndList.set(31, (String) userList.get(18));
		yearEndList.set(32, (String) userList.get(19));
		yearEndList.set(33, (String) userList.get(20));
		yearEndList.set(35, (String) userList.get(21));
		yearEndList.set(36, (String) userList.get(22));
		yearEndList.set(38, (String) userList.get(23));
		yearEndList.set(39, (String) userList.get(24));
		yearEndList.set(40, (String) userList.get(25));
		yearEndList.set(42, (String) userList.get(26));
		yearEndList.set(43, (String) userList.get(27));
		yearEndList.set(44, (String) userList.get(28));
		yearEndList.set(45, (String) userList.get(29));
		yearEndList.set(46, (String) userList.get(30));
		yearEndList.set(47, (String) userList.get(31));
		yearEndList.set(52, (String) userList.get(32));
//		yearEndList.set(53, (String) userList.get(33));
		yearEndList.set(55, (String) userList.get(33));
		yearEndList.set(63, (String) userList.get(34));
		yearEndList.set(63, (String) userList.get(35));
		yearEndList.set(64, (String) userList.get(36));
		yearEndList.set(65, (String) userList.get(37));
		yearEndList.set(66, (String) userList.get(38));
		yearEndList.set(67, (String) userList.get(39));

		yearEndList.set(70, (String) userList.get(40));

		yearEndList.set(71, (String) userList.get(41));
		yearEndList.set(79, (String) userList.get(42));

		yearEndList.set(80, (String) userList.get(43));
		yearEndList.set(81, (String) userList.get(44));
		yearEndList.set(82, (String) userList.get(45));
		yearEndList.set(83, (String) userList.get(46));
		yearEndList.set(84, (String) userList.get(47));
		yearEndList.set(85, (String) userList.get(48));
		yearEndList.set(86, (String) userList.get(49));
		yearEndList.set(87, (String) userList.get(50));
		yearEndList.set(88, (String) userList.get(51));
		yearEndList.set(89, (String) userList.get(52));
		yearEndList.set(91, (String) userList.get(53));
		yearEndList.set(92, (String) userList.get(54));
		yearEndList.set(93, (String) userList.get(55));
		yearEndList.set(94, (String) userList.get(56));
//				91=91
//				92=92
//				93=93
//				94=94
		yearEndList.set(0, userId + "_" + "("+ userService.selectOne((String)userList.get(0)).getUserName() + 
				")"+ date.getYear() +"年研究生思政工作数据统计.xls");
	   
		InfoService infoService = new Academy();
		yearEndList.set(1, infoService.covert(userId));
		yearEndList.set(2, userService.countUserDegree("博士").toString());
		yearEndList.set(3, userService.countUserDegree("硕士").toString());
		Integer E = activityService.countByAcType("博士") 
				+ activityService.countByAcType("硕士");
		yearEndList.set(4, E.toString());
		yearEndList.set(49,activityService.countByAcType("校内博士论坛").toString());
		yearEndList.set(50, activityService.countByAcType("模拟国际会议").toString());
		
		Integer K = (activityService.countByAcType("学术沙龙") +
				activityService.countByAcType("学术讲座"));
		yearEndList.set(51, K.toString());
		yearEndList.set(53, activityService.countByAcType("全国博士论坛").toString());
		yearEndList.set(54, activityService.countByAcType("暑期学校").toString());
		yearEndList.set(90, activityService.countByAcType("研究生人文素质讲座").toString());
		ExcelService excelService = new YearEndImpl();
		String savepath = excelService.write(yearEndList);
		doFile df = new doFile();
		try{
			map.put("url", "http://www.ly723.site:2048/StudentManager2/changeExcel.action?userId="+userId);
			System.out.println("http://www.ly723.site:2048/StudentManager2/changeExcel.action?userId="+userId);
			return map;
		}
		catch (Exception e){
			System.out.println((String)userList.get(0));
			e.printStackTrace();
			return null;
		}
		/*
		*//**
		 * 还余删除功能未完成
		 */
//		File file = new File(savepath + "("+ userService.selectOne((String)userList.get(0)).getUserName() + 
//				")"+ date.getYear() +"年研究生思政工作数据统计.xls");
/*	System.out.println("sadasd");
		file.delete();*/
		
	}
	@RequestMapping("/DownLoadExcel")
	public  void  DownLoadExcel( String savepath, String filename,
			HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
	
		doFile df = new doFile();
		df.download2(filename,savepath , request, response);
	}
	
	//参数：无
	//返回：『{老师名， 文件名，下载链接}{}』
	//。。。。或许可以用户ID_文件名来存储用户ID
	@RequestMapping("/ListYearExcel")
	public @ResponseBody List ListExcel() throws FileNotFoundException, IOException
	{
		doFile df = new doFile();
		PropertyInterface propertyInterface = new PropertiesExcelLocation();
		Map map = propertyInterface.readAllProperties();
		/**
		 * 此处有问题
		 */
		String str = (String) map.get("YearEndImplSavepath");
		String savepath = str.substring(0, str.lastIndexOf('/'));
		System.out.println(savepath);
		List<Map> list = df.ListFile(savepath);
		
		List<User> users = userService.selectByRole("teacher");
		for (User user : users) {
			int flag = 0;//先假设user不在list中
			for (Map mapp : list) {
				if(mapp.get("userId").toString().trim().equals(user.getUserId().trim())){
						flag = 1;
						break;
					}
				else
					flag = 0;
			}
			if (flag == 0)
			{
				Map map2 = new HashMap();
				 map2.put("userId", user.getUserId());
		         map2.put("username", user.getUserName());
		         map2.put("YearEndurl", "#/boss/bpersonalInfo#check");
		         map2.put("AcList", "http://www.ly723.site:2048/StudentManager2/downloadAcList.action?userId="+user.getUserId());
		         map2.put("AcMaster", "http://www.ly723.site:2048/StudentManager2/downloadAcMaster.action?userId="+user.getUserId());
		         map2.put("Yearfilename", "未提交");
		         list.add(map2);
			}
		}
		
		Map mapInit = new HashMap();
//		mapInit.put("yearEnd", list);
		
		return list;
	}
	
	//TODO
	//参数：用户名
	//返回：下载链接、文件名
	@RequestMapping("/checkExcel")
	public @ResponseBody  Map  checkExcel( @RequestBody String userId,
			HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
	
		doFile df = new doFile();
		PropertyInterface propertyInterface = new PropertiesExcelLocation();
		Map map = propertyInterface.readAllProperties();
		/**
		 * 此处有问题
		 */
		List<Map> list = df.ListFile(((String) map.get("YearEndImplSavapath")).
				substring(((String) map.get("YearEndImplSavapath")).lastIndexOf("/")));
		for (Map map2 : list) {
			if(map2.get("userId").equals(userId))
				return map2;
		}
		return null;
	}
	@RequestMapping("/downloadAcList")
	public void downloadActivityList(String userId, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException
	{
//		userId = "1133710501";
		ExcelService excelService = new ActivityListImpl();
		List<List> acList = new ArrayList<List>();
		List<Activity> seAcById = activityService.selectActivityByCreId(userId);
		System.out.println(userId);
		for (Activity activity : seAcById) {
			List<Map> newList = new ArrayList<Map>();
			List<Sign> signList = signService.selectSignByAcIdAndTeacherId(activity.getAcId(), userId);
			for (Sign sign : signList) {
				Map map = new HashMap<String, String>();
				map.put("signId", sign.getSigPerId());
				map.put("signName", sign.getSigPerName());
				map.put("excecuteTime", sign.getSigHanDate());
				map.put("signTime", sign.getSigDate());
				map.put("ActivityName", activity.getAcTitle());
				/**
				 * status 具体是什么还得问问
				 */
				map.put("result", sign.getSigStatus());
				newList.add(map);
			}
			acList.add(newList);
		}
		String goal =  excelService.write(acList);
		doFile df = new doFile();
		df.download2("活动明细表.xls", goal, request, response);
		 File file= new File(
				goal + "活动明细表.xls");
		 file.delete();
	}
	@RequestMapping("/downloadAcMaster")
	public void downloadAcMaster(String userId, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException
	{
		ExcelService excelService = new ActivityMasterImpl();
		List<List> acList = new ArrayList<List>();
		List<Task> listTask  = taskService.selectTaskByTasDueId(userId);
		List<ExTask> ex = new ArrayList<ExTask>();
		System.out.println(userId);
		int i= 0;
		for (Task task : listTask) {
//			listTask.set(index, element)task.getTasId();
//			User userCre = userService.selectOne(task.getTasCreId());
			User userDue = userService.selectOne(userId);
			/**
			 * 
			 * 
			 * 
			 * 此处要做大改动
			 * 
			 */
			
//			User userDue = userService.selectOne(task.getTasDueId());
			ExTask exTask = new ExTask();
			exTask.setTasId(task.getTasId());
		    exTask.setTasCreId(userDue.getUserId());
//		    if (userCre!=null)
		    exTask.setTasCreName(userDue.getUserName());
//		    else
//		    	exTask.setTasCreName("空");
		    exTask.setTasCreDate(task.getTasCreDate());
		    exTask.setTasDueDate(task.getTasDueDate());
		    /**
		     * 
		     * 
		     * 此处要做大改动
		     * 
		     * 
		     * 
		     * 
		     */
//		    exTask.setTasDueId(task.getTasDueId());
		    /**
		     * 
		     * 此处要做大改动
		     * 
		     * 
		     * 
		     * 
		     */
//		    exTask.setTasDueName(userDue.getUserName());
		    exTask.setTasTitle(activityService.selectActivityById(task.getTasAcId()).getAcTitle());
		    exTask.setTasDesc(task.getTasDesc());
		    exTask.setTasDocId(task.getTasDocId());
		    exTask.setTasStatus(task.getTasStatus());
		    exTask.setTasAcId(task.getTasAcId());
		    exTask.setSignNumber(signService.countSign(task.getTasAcId()));
		    exTask.setExcuNumber(signService.countExecute(task.getTasAcId()));
		    List<Due> due = dueService.selectTasDueIdByTasId(exTask.getTasAcId());
//		    for (Due due2 : due) {
		    	exTask.setTasDueId(userDue.getUserId());
		    	exTask.setTasDueName(userDue.getUserName());
		    	ex.add(exTask);
//			}
		}
		PropertyInterface pro = new PropertiesExcelLocation();
		Map map = pro.readAllProperties();
		String InputStream	= (String) map.get("AcMasterModelPath");
		String  savepath			= (String) map.get("AcMasterSavepath");
		String goal =  excelService.write(ex);
		System.out.println(goal);
		doFile df = new doFile();
		df.download2("活动总表.xls", savepath, request, response);
		 File file= new File(
				savepath + "活动总表.xls");
		 file.delete();
	}
	@RequestMapping("/changeExcel")
	public  void  changeExcel( String userId,
			HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
	
		System.out.println(userId);
		doFile df = new doFile();
		PropertyInterface propertyInterface = new PropertiesExcelLocation();
		Map map = propertyInterface.readAllProperties();
		/**
		 * 此处有问题
		 */
		String str = (String) map.get("YearEndImplSavepath");
		String str2 = str.substring(0, str.lastIndexOf('/') );
		System.out.println(str2);
		Map map3 = df.ListFile();
		System.out.println(map3);
		try {
		if(!map3.get(userId).equals(null))
			DownLoadExcel(str,(String) map3.get(userId) , request, response);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		/*
		 * map.put("Yearfilename", realName);
         String str =  file.getName().substring(0, file.getName().indexOf('_'));
         String str2 = realName.substring(realName.indexOf('(') + 1, realName.indexOf(')'));
         map.put("userId", str);
         map.put("username", str2);
         map.put("YearEndurl", "http://www.ly723.site:2048/StudentManager2/DownLoadExcel.action?savepath="+file.getPath()+"/"+
					"&filename="+file.getName());
         map.put("AcList", "http://www.ly723.site:2048/StudentManager2/downloadAcList.action?userId="+str);
         map.put("AcMaster", "http://www.ly723.site:2048/StudentManager2/downloadAcMaster.action?userId="+str);
         list.add(map);
		 */
//		System.out.println( maoL);
//		if (!maoL.get("YearEndurl").equals(null))
		
//		return null;
	}
}
