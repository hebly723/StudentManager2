package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Due;
import po.DueExample;

public interface DueMapper {
    int countByExample(DueExample example);

    int deleteByExample(DueExample example);

    int insert(Due record);

    int insertSelective(Due record);

    List<Due> selectByExample(DueExample example);

    int updateByExampleSelective(@Param("record") Due record, @Param("example") DueExample example);

    int updateByExample(@Param("record") Due record, @Param("example") DueExample example);
    List<Due> selectTaskNotOverDueByTasDueId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="tasDueId") String tasDueId);
    long selectTaskNotOverDueByTasDueIdCount(@Param(value="tasDueId") String tasDueId);
    
    List<Due> selectTaskOverDueByTasDueId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="tasDueId") String tasDueId);
    long selectTaskOverDueByTasDueIdCount(@Param(value="tasDueId") String tasDueId);
}