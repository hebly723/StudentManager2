package service;

import java.util.List;
import java.util.Map;

import po.Dueactivity;
import po.User;


public interface DueActivityService {
	
	public boolean insertDueActivity(List<Dueactivity> dueactivity);
	public List<String > selectUserByAcId(int acId);
	public boolean updateDueAvtivity(int acId, List<String> academys);
	public int deleteDueActivity(int acId);
	public Map<String, List<User>> selectUserOrderByAcademy(int acId);
}
