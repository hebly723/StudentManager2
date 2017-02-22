package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import po.Activity;
import po.Message;
import po.MessageExample;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer notId);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer notId);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    int insertMessages(List<Message> list);
    
    List<Message> selectMessageAlreadByNotRecId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="notRecId") String notRecId);
    long selectMessageAlreadByNotRecIdCount(@Param(value="notRecId") String notRecId);
    
    List<Activity> selectMessageUnreadByNotRecId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="notRecId") String notRecId);
    long selectMessageUnreadByNotRecIdCount(@Param(value="notRecId") String notRecId);
    
    List<Activity> selectMessageByNotSenId(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize,@Param(value="notSenId") String notSenId);
    long selectMessageByNotSenIdCount(@Param(value="notSenId") String notSenId);
}