package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Dueactivity;
import po.DueactivityExample;

public interface DueactivityMapper {
    int countByExample(DueactivityExample example);

    int deleteByExample(DueactivityExample example);

    int insert(Dueactivity record);

    int insertSelective(Dueactivity record);

    List<Dueactivity> selectByExample(DueactivityExample example);

    int updateByExampleSelective(@Param("record") Dueactivity record, @Param("example") DueactivityExample example);

    int updateByExample(@Param("record") Dueactivity record, @Param("example") DueactivityExample example);
}