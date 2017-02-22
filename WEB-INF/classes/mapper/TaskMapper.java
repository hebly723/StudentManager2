package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Task;
import po.TaskExample;

public interface TaskMapper {
    int countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer tasId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer tasId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    int updateTaskStatus();
    
    List<Task> selectTaskUnhandled();
    
    List<Task> selectTaskNotOverDueByTasCreId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="tasCreId") String tasCreId);
    long selectTaskNotOverDueByTasCreIdCount(@Param(value="tasCreId") String tasCreId);
    
    List<Task> selectTaskOverDueByTasCreId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="tasCreId") String tasCreId);
    long selectTaskOverDueByTasCreIdCount(@Param(value="tasCreId") String tasCreId);
    
    
}