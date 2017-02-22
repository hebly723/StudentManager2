package service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import service.InfoService;
import utils.PropertiesInfo;
import utils.PropertyInterface;

public class Academy implements InfoService {

	public String covert(String classnumber){
		String Academy = classnumber.substring(4, 6);
		System.out.println(Academy);
		PropertyInterface propertyInterface;
		try {
			propertyInterface = new PropertiesInfo();
			Map map = propertyInterface.readAllProperties();
			return (String) map.get(Academy); 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public static void main(String args[])
	{
		String classnumber = "15S024001";
//		System.out.println(URLEncoder.encode("www.ly723.site:2048/StudentManager2/DownLoadExcel.action?savepath=/home/StudentManager2/Excel/YearEnd/&amp;filename=(刘导员)116年研究生思政工作数据统计.xls"));
		InfoService infoService = new Academy();
		System.out.println(infoService.covert(classnumber));
	}
}
