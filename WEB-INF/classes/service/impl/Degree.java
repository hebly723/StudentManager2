package service.impl;

import java.io.IOException;
import java.util.Map;

import service.InfoService;
import utils.PropertiesInfo;
import utils.PropertyInterface;

public class Degree implements InfoService {

	@Override
	public String covert(String classnumber) {
		String degree = classnumber.substring(2, 3);
		System.out.println(degree);
		PropertyInterface propertyInterface;
		try {
			propertyInterface = new PropertiesInfo();
			Map map = propertyInterface.readAllProperties();
			return (String) map.get(degree); 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String args[])
	{
		String classnumber = "15B024001";
		InfoService infoService = new Degree();
		System.out.println(infoService.covert(classnumber));
	}

}
