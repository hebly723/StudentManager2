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

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import po.Activity;
import po.Sign;
import service.ActivityService;
import service.SignService;
import service.FileService;
import service.TaskService;
import utils.Page;
import utils.PropertiesUtil;

@Controller
public class SignController {
	@Autowired
	private SignService service;
	@Autowired
	private FileService fileservice;
	@Autowired
	private ActivityService acservice;
	@Autowired
	private PropertiesUtil p;
	@Autowired
	private TaskService taskService;
	@RequestMapping("/signFileUpload")
	public  @ResponseBody List signFileUpload(HttpServletRequest request,HttpServletResponse response,Sign sign) throws Exception{
		List list = fileservice.fileUpload(request, response,"sign");
		String message = (String) request.getAttribute("message");
		if(list!=null){
			if(list.size()>0){
				sign.setSigDocId((String)list.get(0));
			}
			if(list.size()>1){
				sign.setSigDoc1Name((String)list.get(1));
			}
			if(list.size()>2){
				sign.setSigDoc2Name((String)list.get(2));
			}
			if(list.size()>3){
				sign.setSigDoc3Name((String)list.get(3));
			}
			service.updateSign(sign);
		}
		if(message!=null&&message!=""){
			list.add(message);
		}
		return list;
	}
	@RequestMapping("/signFileTransferTemp")
	public  @ResponseBody List signFileTransferTemp(HttpServletRequest request, HttpServletResponse response,List<FileItem> list,Sign sign){
		List list2 = fileservice.TransferTemp(request, response, "sign", list);
		String message = (String) request.getAttribute("message");
		if(list2!=null){
			if(list2.size()>0){
				sign.setSigDocId((String)list2.get(0));
			}
			if(list2.size()>1){
				sign.setSigDoc1Name((String)list2.get(1));
			}
			if(list2.size()>2){
				sign.setSigDoc2Name((String)list2.get(2));
			}
			if(list2.size()>3){
				sign.setSigDoc3Name((String)list2.get(3));
			}
			service.updateSign(sign);
		}
		if(message!=null&&message!=""){
			list2.add(message);
		}
		return list2;
	}
	@RequestMapping("/SignfileDownload")
	public void SignfileDownload(String fileName,Integer sigId,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String sigDocId = service.selectDocIdById(sigId);
		fileName=new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		String path=p.readValue("path")+"sign"+System.getProperty("file.separator")+sigDocId;
	    fileservice.fileDownload(fileName, path, request, response);
	}
//	@RequestMapping("/teacher/SignUnhandled")
//	public @ResponseBody List teacherSignUnhandled(Integer pageNow,Integer acId){
//		Page page = null;  
//	    int totalCount = service.selectSignUnhandledByAcIdCount(acId);  
//	    List signList = null;
//	    if (pageNow!=null) {  
//	        page = new Page(totalCount, pageNow);  
//	        signList = service.selectSignUnhandledByAcIdAndTeacherId(page.getStartPos(), page.getPageSize(),acId, null);  
//	    } else {  
//	        page = new Page(totalCount, 1);  
//	        signList = service.selectSignUnhandledByAcId(page.getStartPos(), page.getPageSize(),acId);  
//	       
//	    }  
//	    signList.add(page);
//	    return signList;	
//	}
	@RequestMapping("/teacher/SignUnhandled")
	public @ResponseBody List teacherSignUnhandled(Integer pageNow,Integer acId, String userId,Integer pageSize){
		Page page = null;  
		int totalCount = service.selectSignUnhandledByAcIdAndTeacherIdCount(acId, userId);
	    List signList = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        signList = service.selectSignUnhandledByAcIdAndTeacherId(page.getStartPos(), page.getPageSize(),acId, userId);  
	    } else {  
	        page = new Page(totalCount, 1);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        signList = service.selectSignUnhandledByAcIdAndTeacherId(page.getStartPos(), page.getPageSize(),acId,userId);  
	       
	    }  
	    signList.add(page);
	    return signList;	
	}

	@RequestMapping("/boss/SignUnhandled")
	public @ResponseBody List bossSignUnhandled(Integer pageNow,Integer acId,Integer pageSize){
		Page page = null;  
	    int totalCount = service.selectSignUnhandledByAcIdCount(acId);  
	    List signList = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        signList = service.selectSignUnhandledByAcId(page.getStartPos(), page.getPageSize(),acId);  
	    } else {  
	        page = new Page(totalCount, 1);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        signList = service.selectSignUnhandledByAcId(page.getStartPos(), page.getPageSize(),acId);  
	       
	    }  
	    signList.add(page);
	    return signList;	
	}
	@RequestMapping("/teacher/Signhandled")
	public @ResponseBody List teacherSignHandled(Integer pageNow,Integer acId, String userId,Integer pageSize){
		Page page = null;  
	    int totalCount = service.selectSignHandledByAcIdAndTeacherIdCount(acId, userId);
	    List signList = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        signList = service.selectSignHandledByAcIdAndTeacherId(page.getStartPos(), page.getPageSize(),acId,userId);
	    } else {  
	        page = new Page(totalCount, 1);
	        if(pageSize!=null&&pageSize>0l){
	        	page.setPageSize(pageSize);
	        }
	        signList = service.selectSignHandledByAcIdAndTeacherId(page.getStartPos(), page.getPageSize(),acId,userId);  
	       
	    }  
	    signList.add(page);
	    return signList;	
	}
	@RequestMapping("/boss/Signhandled")
	public @ResponseBody List bossSignHandled(Integer pageNow,Integer acId,Integer pageSize){
		Page page = null;  
	    int totalCount = service.selectSignHandledByAcIdCount(acId);  
	    List signList = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        signList = service.selectSignHandledByAcId(page.getStartPos(), page.getPageSize(),acId);
	    } else {  
	        page = new Page(totalCount, 1);  
	        signList = service.selectSignHandledByAcId(page.getStartPos(), page.getPageSize(),acId);  
	       
	    }  
	    if(pageSize!=null&&pageSize>0l){
        	page.setPageSize(pageSize);
        }
	    signList.add(page);
	    return signList;	
	}
	@RequestMapping("/student/signed")
	public @ResponseBody List studentSigns(Integer pageNow,String sigPerId,Integer pageSize){
		Page page = null;  
	    int totalCount = service.selectSignBySigPerIdCount(sigPerId);  
	    List signList = new ArrayList();
	    if (pageNow!=null) {  
	        page = new Page(totalCount, pageNow);  
	        signList.add(0, service.selectSignBySigPerId(page.getStartPos(), page.getPageSize(),sigPerId));
	    } else {  
	        page = new Page(totalCount, 1);  
	        signList.add(0, service.selectSignBySigPerId(page.getStartPos(), page.getPageSize(),sigPerId));
	    } 
	    if(pageSize!=null&&pageSize>0l){
        	page.setPageSize(pageSize);
        }
	    signList.add(1,page);
	    return signList;
	}
	@RequestMapping("/student/checkSign")
	public @ResponseBody Map checkSign(
			@RequestBody Sign sign){
		String uuid = UUID.randomUUID().toString();
		sign.setSigDocId(uuid);
//		String filename1=fileservice.SaveFile(file1, uuid,"sign");
//		String filename2=fileservice.SaveFile(file2, uuid, "sign");
//		String filename3=fileservice.SaveFile(file3, uuid, "sign");
//		if(filename1!=null){
//			sign.setSigDoc1Name(filename1);
//		}
//		if(filename2!=null){
//			sign.setSigDoc2Name(filename2);
//		}
//		if(filename3!=null){
//			sign.setSigDoc3Name(filename3);
//		}
		boolean flag2 =  acservice.ifDueExist(sign);
		Map map = new HashMap<String, Boolean>();
		map.put("success", flag2);
		return map;
		//		int flag = 0;
//		if (flag2)
//		flag =service.insertSign(sign);
//		else
//			return 2;
//		if(flag==1){
//			return 1;
//		}else{
//			return 0;
//		}
	}
	@RequestMapping("/student/insertSign")
	public @ResponseBody int insertSign(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,Sign sign){
		String uuid = UUID.randomUUID().toString();
		sign.setSigDocId(uuid);
		String filename1=fileservice.SaveFile(file1, uuid,"sign");
		String filename2=fileservice.SaveFile(file2, uuid, "sign");
		String filename3=fileservice.SaveFile(file3, uuid, "sign");
		if(filename1!=null){
			sign.setSigDoc1Name(filename1);
		}
		if(filename2!=null){
			sign.setSigDoc2Name(filename2);
		}
		if(filename3!=null){
			sign.setSigDoc3Name(filename3);
		}
		boolean flag2 =  acservice.ifDueExist(sign);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(flag2);
		int flag = 0;
		if (flag2)
		flag =service.insertSign(sign);
		else
			return 2;
		if(flag==1){
			return 1;
		}else{
			return 0;
		}
	}
	@RequestMapping("/student/updateSign")
	public @ResponseBody int updateSign(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,Sign sign,Integer pageNow) throws IOException{
		String uuid = service.selectDocIdById(sign.getSigId());
		String path = p.readValue("path") + "sign"
				+ System.getProperty("file.separator") + uuid;
		Sign sign2 = service.selectSignById(sign.getSigId());
		if(sign.getSigPerId().equals(sign2.getSigPerId())){
			if(sign2.getSigStatus().equals("0")){
				String filename1=fileservice.SaveFile(file1, uuid,"sign");
				String filename2=fileservice.SaveFile(file2, uuid, "sign");
				String filename3=fileservice.SaveFile(file3, uuid, "sign");
				List<String> filenamelist = new ArrayList<String>();
				if(filename1!=null){
					filenamelist.add(sign2.getSigDoc1Name());
					sign.setSigDoc1Name(filename1);
				}
				if(filename2!=null){
					filenamelist.add(sign2.getSigDoc2Name());
					sign.setSigDoc2Name(filename2);
				}
				if(filename3!=null){
					filenamelist.add(sign2.getSigDoc3Name());
					sign.setSigDoc3Name(filename3);
				}
				boolean f = fileservice.deleteFiles(filenamelist, path);
				if(f==true){
					int flag=service.updateSign(sign);
					if(flag==1){
						return 1;
					}
					
				}
			}
			
			
		}
		return 0;
		
	}
	
	@RequestMapping("/student/signAgain")
	public @ResponseBody int signAgain(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3,Sign sign) throws IOException{
		Sign sign2 = service.selectSignBysigPerId(sign.getSigPerId());
		String uuid = sign2.getSigDocId();
		int sigId = sign2.getSigId();
		sign.setSigId(sigId);
		sign.setSigDocId(uuid);
		String path = p.readValue("path") + "sign"
				+ System.getProperty("file.separator") + uuid;
		if(sign2.getSigStatus().equals("2")){
			boolean f = fileservice.delAllFile(path);
			if(f==true){
				sign.setSigStatus("0");
				int flag=service.updateSignAll(sign);
				if(flag==1){
					return 1;
				}	
			}
		}
		return 0;
		
	}
	
	@RequestMapping("/teacher/updateSignStatus")
	public @ResponseBody int updateSignStatus(@RequestBody Sign sign){
		int flag= service.updateSign(sign);
		if(flag==1){
			if(sign.getSigStatus().equals("1")){
				flag=acservice.updateActivityNum(sign.getSigAcId());
			}
		}
		return flag;
	}
	@RequestMapping("/teacher/students")
	public List<Sign> selectStudentByAcId(Integer acId){
		if(acId!=null){
			return service.selectSignByAcId(acId);
		}
		return null;
	}
}
