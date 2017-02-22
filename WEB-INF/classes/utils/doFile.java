package utils;
import java.io.File;
import java.io.FileInputStream;
//涔嬪墠灏嗙被鍛藉悕鎴恌ile渚夸笉鑳藉鍏ヨ繖涓寘
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;

import po.Activity;

public class doFile {
		/**
	    * @Method: upload
	    * @Description: 上传文件函数	    
	    * * @Anthor:浪雁723
	    * @param request response
	    * @return Map类型的变量 
	    * {
	    *  id:String uuid;
	    *  1:{
	    *  	String filename;
	    *  	String path;
	    *  }
	    *  2:...
	    * }
	    * */ 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List upload(HttpServletRequest request, HttpServletResponse response,String folder)
            throws ServletException, IOException {
    	List<FileItem> list =  temp(request, response);
    	String message = null;
    	try {
			return transfer(request, response, folder, list, message);
		} catch (FileSizeLimitExceededException e) {
			e.printStackTrace();
		} catch (SizeLimitExceededException e) {
			e.printStackTrace();
		}
		return list;
    }
    
    /**
    * @Method: makeFileName
    * @Description: 鐢熸垚涓婁紶鏂囦欢鐨勬枃浠跺悕锛屾枃浠跺悕浠ワ細uuid+"_"+鏂囦欢鐨勫師濮嬪悕绉�    * @Anthor:瀛ゅ偛鑻嶇嫾
    * @param filename 鏂囦欢鐨勫師濮嬪悕绉�    * @return uuid+"_"+鏂囦欢鐨勫師濮嬪悕绉�    */ 
    @SuppressWarnings("unused")
	private String makeFileName(String filename){  
    	return UUID.randomUUID().toString() + "_" + filename;
    }
    
    /**
     * 涓洪槻姝竴涓洰褰曚笅闈㈠嚭鐜板お澶氭枃浠讹紝瑕佷娇鐢╤ash绠楁硶鎵撴暎瀛樺偍
    * @Method: makePath
    * @Description: 
    * @Anthor:瀛ゅ偛鑻嶇嫾
    *
    * @param filename 鏂囦欢鍚嶏紝瑕佹牴鎹枃浠跺悕鐢熸垚瀛樺偍鐩綍
    * @param savePath 鏂囦欢瀛樺偍璺緞
    * @return 鏂扮殑瀛樺偍鐩綍
    */ 
    private String makePath(String filename,String savePath, String uuid){
        
        //String dir = savePath + System.getProperty("file.separator") + dir1 + System.getProperty("file.separator") + dir2;  //upload\2\3  upload\3\5
        String dir = savePath+System.getProperty("file.separator") + uuid;
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
    /**
	    * @Method: download
	    * @Description: 下载文件函数	    
	    * * @Anthor:浪雁723
	    * @param filename 文件保存名（含UUID） path 文件路径 realname 文件真名 request response
	    * @return Map类型的变量   
	    * */ 
    public void download(String fileName, String path, HttpServletRequest request,
    		HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println(path + "/" + fileName);
    	File file = new File(path + "/" + fileName);
        System.out.println(path + "/" + fileName);
        if(!file.exists()){
        	System.out.println("您要下载的文件不存在");
            return;
        }
        System.out.println(fileName);
        response.setCharacterEncoding("UTF-8");
        String filename = fileName;
        if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {  
            filename = URLEncoder.encode(filename, "UTF-8");  
        } else {  
            filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");  
        }  
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //读取要下载的文件，保存到文件输入流
        //FileInputStream in = new FileInputStream(path + "/" + fileName);
        FileInputStream in = new FileInputStream(path + "/" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
    }
    
    /**
	    * @Method: download
	    * @Description: 下载文件函数	    
	    * * @Anthor:浪雁723
	    * @param filename 文件保存名（含UUID） path 文件路径 realname 文件真名 request response
	    * @return Map类型的变量   
	    * */ 
 public void download2(String fileName, String path, HttpServletRequest request,
 		HttpServletResponse response)
         throws ServletException, IOException {
 	System.out.println(path  + fileName);
 	File file = new File(path  + fileName);
     System.out.println(path + fileName);
     if(!file.exists()){
     	System.out.println("您要下载的文件不存在");
         return;
     }
     System.out.println(fileName);
     response.setCharacterEncoding("UTF-8");
     String filename = fileName.substring(fileName.indexOf("_")+1);
//     file.getName().substring(file.getName().indexOf("_")+1);
     if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {  
         filename = URLEncoder.encode(filename, "UTF-8");  
     } else {  
         filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");  
     }  
     response.setHeader("content-disposition", "attachment;filename=" + filename);
     //读取要下载的文件，保存到文件输入流
     //FileInputStream in = new FileInputStream(path + "/" + fileName);
     FileInputStream in = new FileInputStream(path  + fileName);
     //创建输出流
     OutputStream out = response.getOutputStream();
     //创建缓冲区
     byte buffer[] = new byte[1024];
     int len = 0;
     //循环将输入流中的内容读取到缓冲区当中
     while((len=in.read(buffer))>0){
         //输出缓冲区的内容到浏览器，实现文件下载
         out.write(buffer, 0, len);
     }
     //关闭文件输入流
     in.close();
     //关闭输出流
     out.close();
 }
    /**
    * @Method: findFileSavePathByFileName
    * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
    * @Anthor:孤傲苍狼
    * @param filename 要下载的文件名
    * @param saveRootPath 上传文件保存的根目录，也就是/WEB-INF/upload目录
    * @return 要下载的文件的存储目录
    */ 
    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  
        int dir2 = (hashcode&0xf0)>>4;  
        String dir = saveRootPath + "/" + dir1 + "/" + dir2;  
        File file = new File(dir);
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }
    /**
	    * @Method: temp
	    * @Description: 上传文件函数（zh）	    
	    * * @Anthor:浪雁723
	    * @param filename 文件保存名（含UUID） path 文件路径 realname 文件真名 request response
	    * @return Map类型的变量   
	    * */ 
    public List<FileItem> temp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
		PropertiesUtil p = new PropertiesUtil();
        String tempPath =request.getServletContext().getRealPath(System.getProperty("file.separator")+"WEB-INF"+System.getProperty("file.separator")+"temp");
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //创建临时目录
            tmpFile.mkdir();
        }
        
        //消息提示
        String message = "";
        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(0);
            factory.setRepository(tmpFile);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setProgressListener(new ProgressListener(){
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("文件大小为" + pContentLength + ",当前已处理" + pBytesRead);
                    /**
                     * 文件大小为：14608,当前已处理：4096
                        文件大小为：14608,当前已处理：7367
                        文件大小为：14608,当前已处理：11419
                        文件大小为：14608,当前已处理：14608
                     */
                }
            });
            upload.setHeaderEncoding("UTF-8"); 
            if(!ServletFileUpload.isMultipartContent(request)){
                return null;
            }
            
            upload.setFileSizeMax(1024*1024*10);
            upload.setSizeMax(1024*1024*30);
            List<FileItem> list = upload.parseRequest(request);
		    return list;
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "单个文件超出最大值！！！");
            //request.getRequestDispatcher("/message.jsp").forward(request, response);
            return null;
        }catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
            //request.getRequestDispatcher("/message.jsp").forward(request, response);
            return null;
        }catch (Exception e) {
        	message= "文件上传失败！";
            e.printStackTrace();
        }
		return null;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
   	public List transfer(HttpServletRequest request, HttpServletResponse response,String folder, 
   			List<FileItem> list, String message) throws FileUploadBase.FileSizeLimitExceededException, FileUploadBase.SizeLimitExceededException
    {
    	int i = 0;
		List ra = new ArrayList();
		String uuid = UUID.randomUUID().toString();
		ra.add(i, uuid);
    	try{
    	for(FileItem item : list){
        	Map rm =  new HashMap();

    		PropertiesUtil p = new PropertiesUtil();
    		String savePath=p.readValue("path")+folder;
            //如果fileitem中封装的是普通输入项的数据
            if(item.isFormField()){
                String name = item.getFieldName();
                //解决普通输入项的数据的中文乱码问题
                String value = item.getString("UTF-8");
                //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                System.out.println(name + "=" + value);
            }else{//如果fileitem中封装的是上传文件
                //得到上传的文件名称，
            	i++;
                String filename = item.getName();
                System.out.println(filename);
                if(filename==null || filename.trim().equals(""))
                {
                    continue;
                }
                //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
                //如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                filename = filename.substring(filename.lastIndexOf(System.getProperty("file.separator"))+1);
                /*
                 * 尝试
                 */
                System.out.println(System.getProperty("file.separator"));
                String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                System.out.println("上传的文件的扩展名是："+fileExtName);
                InputStream in = item.getInputStream();
                
                String saveFilename = filename;
                String realSavePath = makePath(saveFilename, savePath, uuid);
                FileOutputStream out = new FileOutputStream(realSavePath +
                		System.getProperty("file.separator") +
                			saveFilename);
                byte buffer[] = new byte[1024];
                int len = 0;
                while((len=in.read(buffer))>0){
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
                message = "文件上传成功";
                System.out.println(message);
                request.setAttribute("message",message);
                Map value = new HashMap();
                value.put(filename, realSavePath);
                ra.add(i, filename);
                rm.put(i, value);
                System.out.println(realSavePath);
            }
        }
    }catch (Exception e) {
    	message= "文件上传失败！";
        e.printStackTrace();
    }
    return ra;
    }
    public String SaveFile(MultipartFile file,String uuid,String folder){
    	String filename=null;
    	if(file!=null){
    		 filename = file.getOriginalFilename();
    	}
		if(file!=null&&filename!=null&&filename!=""){
			if (file.getSize() > 0&&file.getSize()<52428800) {
					String path = null;
					try {
						PropertiesUtil p = new PropertiesUtil();
						path=p.readValue("path")+folder+System.getProperty("file.separator")+uuid;
						System.out.println(path);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					File newFile = new  File(path+System.getProperty("file.separator")+filename);
					if(!newFile.exists()){
						newFile.mkdirs();
					}
						try {
							file.transferTo(newFile);
							//System.out.println(newFile);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						return filename;
			} 
		}
		return null;
	}

	// 删除文件夹
	// param folderPath 文件夹完整绝对路径
	public void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  //删除指定文件夹下所有文件
  //param path 文件夹完整绝对路径
     public boolean delAllFile(String path) {
         boolean flag = true;
         File file = new File(path);
         if (!file.exists()) {
           return false;
         }
         if (!file.isDirectory()) {
           return false;
         }
         String[] tempList = file.list();
         File temp = null;
         for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
               temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
               flag=temp.delete();
            }
            if (temp.isDirectory()) {
               delAllFile(path + File.separator  + tempList[i]);//先删除文件夹里面的文件
               delFolder(path + File.separator  + tempList[i]);//再删除空文件夹
               flag = true;
            }
         }
         return flag;
       }
     public boolean deleteFiles(List<String> filenamelist, String parentpath){
    	 boolean flag = true;
    	 if(filenamelist!=null){
    		 for (String filename : filenamelist) {
        		 if(filename!=null&&filename!=""){
        			 File file = new File(parentpath + File.separator + filename);
        				if(file.isFile()&&file.exists()){
        					flag=file.delete();
        				}
        		 }
    		}
    	 }
    	
    	 return flag;
     }
     public boolean deleteFile(String filename, String parentpath){
    	 boolean flag = true;
		 if(filename!=null&&filename!=""){
			 File file = new File(parentpath + File.separator + filename);
				if(file.isFile()&&file.exists()){
					flag=file.delete();
				}
		 }
    	 return flag;
     }
    /* public static void main(String[] args) {
		doFile d= new doFile();
		d.delFolder("C://hahaha");
	}*/

public List<Map> ListFile(String savepath){
	//获取上传文件的目录
    String uploadFilePath = savepath;
    //存储要下载的文件名
    List fileList = new ArrayList();
    //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
    listfile(new File(uploadFilePath),fileList);//File既可以代表一个文件也可以代表一个目录
    //将Map集合发送到listfile.jsp页面进行显示
    return fileList;
//    request.getRequestDispatcher("/listfile.jsp").forward(request, response);
}
public Map ListFile()
        throws ServletException, IOException {
	PropertyInterface propertyInterface = new PropertiesExcelLocation();
	Map map = propertyInterface.readAllProperties();
	/**
	 * 此处有问题
	 */
	String str = (String) map.get("YearEndImplSavepath");
	String str2 = str.substring(0, str.lastIndexOf('/') );
	String uploadFilePath = str;
	
    //获取上传文件的目录
    //String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
    //存储要下载的文件名
    Map<String,String> fileNameMap = new HashMap<String,String>();
    //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
    listfile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
    //将Map集合发送到listfile.jsp页面进行显示
//    request.setAttribute("fileNameMap", fileNameMap);
    return fileNameMap;
//    request.getRequestDispatcher("/listfile.jsp").forward(request, response);
}
/**
 * @Method: listfile
 * @Description: 递归遍历指定目录下的所有文件
 * @Anthor:孤傲苍狼
 * @param file 即代表一个文件，也代表一个文件目录
 * @param list 存储file{filename: 文件名, userId: 协理员ID, url: 下载链接}的Map集合
 */ 
 public void listfile(File file, List<Map> list){
     //如果file代表的不是一个文件，而是一个目录
     if(!file.isFile()){
         //列出该目录下的所有文件和目录
         File files[] = file.listFiles();
         //遍历files[]数组
         for(File f : files){
             //递归
             listfile(f,list);
         }
     }else{
         /**
          * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
             file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，
             如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
             那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
          */
         String realName = file.getName().substring(file.getName().indexOf('_')+1);
         //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
//         file{filename: 文件名, userId: 协理员ID, url: 下载链接}的Map集合
         Map map = new HashMap();
         map.put("Yearfilename", realName);
         String str =  file.getName().substring(0, file.getName().indexOf('_'));
         String str2 = realName.substring(realName.indexOf('(') + 1, realName.indexOf(')'));
         map.put("userId", str);
         map.put("username", str2);
         map.put("YearEndurl", "http://www.ly723.site:2048/StudentManager2/changeExcel.action?userId="+str);
         map.put("AcList", "http://www.ly723.site:2048/StudentManager2/downloadAcList.action?userId="+str);
         map.put("AcMaster", "http://www.ly723.site:2048/StudentManager2/downloadAcMaster.action?userId="+str);
         //map.put("filename", value)
         list.add(map);
//         list.put(file.getName(), realName);
     }
 }
 
 /**
  * @Method: listfile
  * @Description: 递归遍历指定目录下的所有文件
  * @Anthor:孤傲苍狼
  * @param file 即代表一个文件，也代表一个文件目录
  * @param map 存储文件名的Map集合
  */ 
  public void listfile(File file,Map<String,String> map){
      //如果file代表的不是一个文件，而是一个目录
      if(!file.isFile()){
          //列出该目录下的所有文件和目录
          File files[] = file.listFiles();
          //遍历files[]数组
          for(File f : files){
              //递归
              listfile(f,map);
          }
      }else{
          /**
           * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
              file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
              那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
           */
          String realName = file.getName().substring(0, file.getName().indexOf("_"));
          //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
          map.put( realName, file.getName());
      }
  }
}