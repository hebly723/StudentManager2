package po;

import java.util.ArrayList;
import java.util.List;

public class ExActivity extends Activity {

	List<String> academys = new ArrayList<String>();
	
	public ExActivity(){
		
	}
	
	public List<String> getAcademys() {
		return academys;
	}

	public void setAcademys(List<String> academys) {
		this.academys = academys;
	}
	
	public void extendsAcademy(String academy)
	{
		this.academys.add(academy);
	}
	public ExActivity(Activity activity){
		this.setAcCreDate(activity.getAcCreDate());
		this.setAcCreId(activity.getAcCreId());
		this.setAcDesc(activity.getAcDesc());
		this.setAcDoc1Name(activity.getAcDoc1Name());
		this.setAcDoc2Name(activity.getAcDoc2Name());
		this.setAcDoc3Name(activity.getAcDoc3Name());
		this.setAcDocId(activity.getAcDocId());
		this.setAcDueDate(activity.getAcDueDate());
		this.setAcId(activity.getAcId());
		this.setAcSigDueDate(activity.getAcSigDueDate());
		this.setAcSigNum(activity.getAcSigNum());
		this.setAcStatus(activity.getAcStatus());
		this.setAcTitle(activity.getAcTitle());
		this.setAcType(activity.getAcType());
	}
}
