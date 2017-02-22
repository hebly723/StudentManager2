package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.Due;
import po.Sign;
import po.SignCustom1;
import po.Task;

public interface SignService {
	public List<Sign> selectSignByAcIdAndTeacherId(Integer acId,String userId);
	public List<Sign> selectSignByAcId(int acId); 
	public int insertSign(Sign sign);
	public int updateSign(Sign sign);
	public int updateSignAll(Sign sign);
	public String selectDocIdById(int sigId);
	public Sign selectSignById(int sigId);
	public Sign selectSignBysigPerId(String sigPerId);
	public List<Sign> selectUnhandleSigns();
	public String selectSignByacIdAndsigPerId(int acId,String sigPerId);
	public List<Sign> selectSignByAcIdOk(int acId);
	List<Sign> selectSignUnhandledByAcId(Integer startPos,Integer pageSize,Integer acId);
    int selectSignUnhandledByAcIdCount(Integer acId);
    
    List<Sign> selectSignHandledByAcId( Integer startPos,Integer pageSize,Integer acId);
    int selectSignHandledByAcIdCount(Integer acId);
    
    List<Sign> selectSignUnhandledByAcIdAndTeacherId(Integer startPos,Integer pageSize,Integer acId,String userId);
    int selectSignUnhandledByAcIdAndTeacherIdCount(Integer acId,String userId);
    
    List<Sign> selectSignHandledByAcIdAndTeacherId( Integer startPos,Integer pageSize,Integer acId,String userId);
    int selectSignHandledByAcIdAndTeacherIdCount(Integer acId,String userId);
    
    List<SignCustom1> selectSignBySigPerId(Integer startPos,Integer pageSize,String sigPerId);
    int selectSignBySigPerIdCount(String sigPerId);
    
    List<Sign> selectStudentByAcId(Integer acId);
    
    int countSignSuccess(int acId);
    
    int countSign( int acId);
    int countExecute(int acId);  
    int deleteSignById( Integer id);
    public void deleteSignByTasId(Task task);
}
