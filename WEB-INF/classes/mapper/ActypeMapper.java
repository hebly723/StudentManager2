package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Actype;
import po.ActypeExample;

public interface ActypeMapper {
    int countByExample(ActypeExample example);

    int deleteByExample(ActypeExample example);

    int deleteByPrimaryKey(Integer actypeId);

    int insert(Actype record);

    int insertSelective(Actype record);

    List<Actype> selectByExample(ActypeExample example);
    
    List<Actype> selectAll();

    Actype selectByPrimaryKey(Integer actypeId);

    int updateByExampleSelective(@Param("record") Actype record, @Param("example") ActypeExample example);

    int updateByExample(@Param("record") Actype record, @Param("example") ActypeExample example);

    int updateByPrimaryKeySelective(Actype record);

    int updateByPrimaryKey(Actype record);
}