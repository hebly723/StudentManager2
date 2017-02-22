package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	@SuppressWarnings("rawtypes")
	public List fileUpload(HttpServletRequest request, HttpServletResponse response,String folder) throws Exception;
	public List<FileItem> fileOnTemp(HttpServletRequest request, HttpServletResponse response) throws IOException;
	public List TransferTemp(HttpServletRequest request, HttpServletResponse response,String folder, 
   			List<FileItem> list);
	public void fileDownload(String fileName, String path, HttpServletRequest request,HttpServletResponse response) throws Exception;
	public String SaveFile(MultipartFile file,String uuid,String folder);
	public boolean delAllFile(String path);
	public void delFolder(String folderPath);
	public boolean deleteFiles(List<String> filenamelist, String parentpath);
	public boolean deleteFile(String filename, String parentpath);
}
