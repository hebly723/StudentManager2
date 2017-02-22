package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.Activity;
import po.ActivityCustom1;
import po.ActivityExample;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Integer acId);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Integer acId);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    
int updateActivityNum(int acId);
    
    int cleanActivityFiles(int acId);
    
    int updateAcStatus();
    
    List<Activity> selectActivityNotOverDue(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    long selectActivityNotOverDueCount();
    
    List<Activity> selectActivityOverDue(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    long selectActivityOverDueCount();
    
    List<ActivityCustom1> selectActivityNotOverDueByAcCreId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="acCreId") String acCreId);
    long selectActivityNotOverDueByAcCreIdCount(@Param(value="acCreId") String acCreId);
    
    List<ActivityCustom1> selectActivityOverDueByAcCreId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="acCreId") String acCreId);
    long selectActivityOverDueByAcCreIdCount(@Param(value="acCreId") String acCreId);
    
    public List<ActivityCustom1> selectActivityCus1NotOverDue(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="sigPerId")String sigPerId);
    
    public List<ActivityCustom1> selectActivityCus1OverDue(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="sigPerId")String sigPerId);
}