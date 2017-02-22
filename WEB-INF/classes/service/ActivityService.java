package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.Activity;
import po.ActivityCustom1;
import po.Actype;
import po.Due;
import po.Sign;

public interface ActivityService {
	public int insertActivity(Activity activity);
	public int updateActivity(Activity activity);
	public int updateActivityNum(int acId);
	public int deleteActivity(int acId);
	public String selectAcDocIdById(int id);
	public Activity	selectActivityById(int id);
	public int cleanActivityFiles(int acId);
	public int updateAcStatus();
	 
    public List<Activity> selectActivityNotOverDue(Integer startPos,Integer pageSize);
    int selectActivityNotOverDueCount();
    
    public List<Activity> selectActivityOverDue(Integer startPos,Integer pageSize);
    int selectActivityOverDueCount();
    
    public List<ActivityCustom1> selectActivityNotOverDueByAcCreId(Integer startPos,Integer pageSize,String acCreId);
    int selectActivityNotOverDueByAcCreIdCount(String acCreId);
    
    public List<ActivityCustom1> selectActivityOverDueByAcCreId(Integer startPos,Integer pageSize,String acCreId);
    int selectActivityOverDueByAcCreIdCount(String acCreId);
    
    public List<ActivityCustom1> selectActivityCus1NotOverDue(Integer startPos,Integer pageSize,String sigPerId);
    
    public List<ActivityCustom1> selectActivityCus1OverDue(Integer startPos,Integer pageSize,String sigPerId);
    
    List updateSigStatus1(List acList);
    public Integer countByAcType( String AcType);
    public List<Activity> selectActivityByCreId(String creId);
    
    List<Actype> selectAcType();
    
    public boolean ifDueExist( Sign sign );
    
}
