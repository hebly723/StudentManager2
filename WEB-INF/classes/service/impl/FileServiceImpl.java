package service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import service.FileService;
import utils.doFile;
/**
 * 文件上传的服务
 * @author 王志强
 *
 */
public class FileServiceImpl implements FileService {
	@Autowired
	private doFile dofile;
	@SuppressWarnings("rawtypes")
	public List fileUpload(HttpServletRequest request,
			HttpServletResponse response,String folder) throws Exception {
			return dofile.upload(request, response,folder);
	}

	public void fileDownload(String fileName, String path,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			dofile.download(fileName, path, request, response);

	}

	@Override
	public List<FileItem> fileOnTemp(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String message = null;
		try {
			return dofile.temp(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message= "文件上传失败！";
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List TransferTemp(HttpServletRequest request,
			HttpServletResponse response, String folder, List<FileItem> list) {
		// TODO Auto-generated method stub
		String message = null;
		try {
			return dofile.transfer(request, response, folder, list, message);
		} catch (FileSizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 public String SaveFile(MultipartFile file,String uuid,String folder){
		 return dofile.SaveFile(file, uuid,folder);
	 }

	@Override
	public boolean delAllFile(String path) {
		return dofile.delAllFile(path);
	}

	@Override
	public void delFolder(String folderPath) {
		dofile.delFolder(folderPath);
	}

	@Override
	public boolean deleteFiles(List<String> filenamelist, String parentpath) {
		return dofile.deleteFiles(filenamelist, parentpath);
	}

	@Override
	public boolean deleteFile(String filename, String parentpath) {
		return dofile.deleteFile(filename, parentpath);
	}

}
