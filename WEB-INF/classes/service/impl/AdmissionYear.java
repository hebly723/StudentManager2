package service.impl;

import java.io.IOException;
import java.util.Map;

import service.InfoService;
import utils.PropertiesInfo;
import utils.PropertyInterface;

public class AdmissionYear implements InfoService {

	@Override
	public String covert(String classnumber) {
		String year = classnumber.substring(0, 2);
		System.out.println(year);
		PropertyInterface propertyInterface;
		return year;
		
	}
	
	public static void main(String args[])
	{
		String classnumber = "15B024001";
		InfoService infoService = new AdmissionYear();
		System.out.println(infoService.covert(classnumber));
	}

}
