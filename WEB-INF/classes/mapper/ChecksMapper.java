package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Checks;
import po.ChecksExample;

public interface ChecksMapper {
    int countByExample(ChecksExample example);

    int deleteByExample(ChecksExample example);

    int deleteByPrimaryKey(String cheId);

    int insert(Checks record);

    int insertSelective(Checks record);

    List<Checks> selectByExample(ChecksExample example);

    Checks selectByPrimaryKey(String cheId);

    int updateByExampleSelective(@Param("record") Checks record, @Param("example") ChecksExample example);

    int updateByExample(@Param("record") Checks record, @Param("example") ChecksExample example);

    int updateByPrimaryKeySelective(Checks record);

    int updateByPrimaryKey(Checks record);
}