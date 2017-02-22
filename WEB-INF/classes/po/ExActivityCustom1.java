package po;

import java.util.ArrayList;
import java.util.List;

public class ExActivityCustom1 extends ActivityCustom1 {

	public ExActivityCustom1(){
		
	}
	
List<String> academys = new ArrayList<String>();
	
	public List<String> getAcademys() {
		return academys;
	}

	public void setAcademys(List<String> academys) {
		this.academys = academys;
	}
	
	public void setAcademysByUser(List<User> user) {
		List<String> strings= new ArrayList<String>();
		for (User user2 : user) {
			strings.add(user2.getUserAcademy());
		}
		this.academys = academys;
	}
	
	public void extendsAcademy(String academy)
	{
		this.academys.add(academy);
	}
	
	public ExActivityCustom1(ActivityCustom1 activityCustom1){
		this.setAcCreDate(activityCustom1.getAcCreDate());
		this.setAcCreId(activityCustom1.getAcCreId());
		this.setAcDesc(activityCustom1.getAcDesc());
		this.setAcDoc1Name(activityCustom1.getAcDoc1Name());
		this.setAcDoc2Name(activityCustom1.getAcDoc2Name());
		this.setAcDoc3Name(activityCustom1.getAcDoc3Name());
		this.setAcDocId(activityCustom1.getAcDocId());
		this.setAcDueDate(activityCustom1.getAcDueDate());
		this.setAcId(activityCustom1.getAcId());
		this.setAcSigDueDate(activityCustom1.getAcSigDueDate());
		this.setAcSigNum(activityCustom1.getAcSigNum());
		this.setAcStatus(activityCustom1.getAcStatus());
		this.setAcTitle(activityCustom1.getAcTitle());
		this.setAcType(activityCustom1.getAcType());
		this.setSigStatus(activityCustom1.getSigStatus());
	}
	
}
