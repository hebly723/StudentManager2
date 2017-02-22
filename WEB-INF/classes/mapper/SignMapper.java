package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.Activity;
import po.Sign;
import po.SignCustom1;
import po.SignExample;

public interface SignMapper {
    int countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int deleteByPrimaryKey(Integer sigId);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignExample example);

    Sign selectByPrimaryKey(Integer sigId);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
    
    String selectSignByacIdAndsigPerId(@Param("acId")int acId,@Param("sigPerId") String sigPerId);
    
    List<Sign> selectSignUnhandledByAcId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="acId") Integer acId);
    long selectSignUnhandledByAcIdCount(@Param(value="acId") Integer acId);
    
    List<Sign> selectSignHandledByAcId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="acId") Integer acId);
    long selectSignHandledByAcIdCount(@Param(value="acId") Integer acId);
    
    List<SignCustom1> selectSignBySigPerId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="sigPerId") String sigPerId);
    long selectSignBySigPerIdCount(@Param(value="sigPerId") String sigPerId);
    
    List<Sign> selectStudentByAcId(@Param(value="acId") Integer acId);
    
    long selectActivitySignCount(@Param(value="acId") Integer acId);

	List<Sign> selectSignUnhandledByAcIdAndTeacherId(@Param(value="startPos") Integer startPos,
			@Param(value="pageSize") Integer pageSize, @Param(value="acId")Integer acId, @Param(value="userId")String userId);
	
	long selectSignUnhandledByAcIdAndTeacherIdCount(@Param(value="acId") Integer acId, @Param(value="userId") String userId);
	
	List<Sign> selectSignHandledByAcIdAndTeacherId(@Param(value="startPos") Integer startPos,
			@Param(value="pageSize") Integer pageSize, @Param(value="acId")Integer acId, @Param(value="userId")String userId);
	
	long selectSignHandledByAcIdAndTeacherIdCount(@Param(value="acId") Integer acId, @Param(value="userId") String userId);
	
	List<Sign> selectSignByAcIdAndTeacherId(@Param(value="acId") Integer acId, @Param(value="userId") String userId);
	
}

	