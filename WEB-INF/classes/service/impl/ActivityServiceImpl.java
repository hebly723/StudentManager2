package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.ActivityMapper;
import mapper.ActypeMapper;
import mapper.DueMapper;
import mapper.SignMapper;
import mapper.TaskMapper;
import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Activity;
import po.ActivityCustom1;
import po.ActivityExample;
import po.Actype;
import po.Due;
import po.DueExample;
import po.Sign;
import po.Task;
import po.TaskExample;
import po.User;
import po.UserExample;
import service.ActivityService;
import service.DueService;


public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityMapper acmapper;
	@Autowired
	private SignMapper sigmapper;
	@Autowired
	private ActypeMapper tmapper;
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private DueMapper dueMapper;
	@Autowired
	private UserMapper userMapper;
	public int insertActivity(Activity activity) {
		return acmapper.insertSelective(activity);
	}

	public int updateActivity(Activity activity) {
		return acmapper.updateByPrimaryKeySelective(activity);
	}

	public int updateActivityNum(int acId) {
		return acmapper.updateActivityNum(acId);
	}

	public int deleteActivity(int acId) {
		return acmapper.deleteByPrimaryKey(acId);
	}

	public List<Activity> selectActivityByAcCreId(String acCreId) {
		ActivityExample example = new ActivityExample();
		example.setOrderByClause("AC_CRE_DATE DESC");
		ActivityExample.Criteria criteria = example.createCriteria();
		criteria.andAcCreIdEqualTo(acCreId);
		return acmapper.selectByExample(example);
	}

	@Override
	public String selectAcDocIdById(int id) {
		return acmapper.selectByPrimaryKey(id).getAcDocId();
	}

	@Override
	public Activity selectActivityById(int id) {
		return acmapper.selectByPrimaryKey(id);
	}

	@Override
	public int cleanActivityFiles(int acId) {
		return acmapper.cleanActivityFiles(acId);
	}

	@Override
	public List<Activity> selectActivityNotOverDue(Integer startPos, Integer pageSize) {
		return acmapper.selectActivityNotOverDue(startPos, pageSize);
	}

	@Override
	public int selectActivityNotOverDueCount() {
		return (int)acmapper.selectActivityNotOverDueCount();
	}

	@Override
	public List<Activity> selectActivityOverDue(Integer startPos,
			Integer pageSize) {
		return acmapper.selectActivityOverDue(startPos, pageSize);
	}

	@Override
	public int selectActivityOverDueCount() {
		return (int)acmapper.selectActivityOverDueCount();
	}
	
	@Override
	public List<ActivityCustom1> selectActivityNotOverDueByAcCreId(Integer startPos,
			Integer pageSize, String acCreId) {
		return acmapper.selectActivityNotOverDueByAcCreId(startPos, pageSize, acCreId);
	}
	@Override
	public int selectActivityNotOverDueByAcCreIdCount(String acCreId) {
		return (int)acmapper.selectActivityNotOverDueByAcCreIdCount(acCreId);
	}
	@Override
	public List<ActivityCustom1> selectActivityOverDueByAcCreId(Integer startPos,
			Integer pageSize, String acCreId) {
		return acmapper.selectActivityOverDueByAcCreId(startPos, pageSize, acCreId);
	}

	@Override
	public int selectActivityOverDueByAcCreIdCount(String acCreId) {
		return (int)acmapper.selectActivityOverDueByAcCreIdCount(acCreId);
	}

	@Override
	public int updateAcStatus() {
		return acmapper.updateAcStatus();
	}

	@Override
	public List updateSigStatus1(List acList) {
		if(acList!=null){
			for(int i=0; i<acList.size();i++){
				ActivityCustom1 activity = (ActivityCustom1) acList.get(i);
				int acId = activity.getAcId();
				int count = (int)sigmapper.selectActivitySignCount(acId);
				if(count>=1){
					activity.setSigStatus("1");
				}else{
					activity.setSigStatus("0");
				}
			}
		}
		return acList;
	}

	@Override
	public List<ActivityCustom1> selectActivityCus1NotOverDue(Integer startPos,
			Integer pageSize, String sigPerId) {
		return acmapper.selectActivityCus1NotOverDue(startPos, pageSize, sigPerId);
	}

	@Override
	public List<ActivityCustom1> selectActivityCus1OverDue(Integer startPos,
			Integer pageSize, String sigPerId) {
		return acmapper.selectActivityCus1OverDue(startPos, pageSize, sigPerId);
	}

	@Override
	public List<Activity> selectActivityByCreId(String creId) {
//		acmapper.selectActivityNotOverDueByAcCreId(startPos, pageSize, acCreId)
		ActivityExample activityExample = new ActivityExample();
		ActivityExample.Criteria criteria = activityExample.createCriteria();
		criteria.andAcCreIdEqualTo(creId);
		return acmapper.selectByExample(activityExample);
	}

	@Override
	public Integer countByAcType(String AcType) {
		ActivityExample activityExample = new ActivityExample();
		ActivityExample.Criteria criteria = activityExample.createCriteria();
		criteria.andAcTypeEqualTo(AcType);
//		acmapper.selectByExample(activityExample);
		return acmapper.countByExample(activityExample);
	}
	@Override
	public List<Actype> selectAcType() {
		return tmapper.selectAll();
	}

	@Override
	public boolean ifDueExist(Sign sign) {
		User user = userMapper.selectByPrimaryKey(sign.getSigPerId());
		TaskExample example = new TaskExample();
		TaskExample.Criteria criteria = example.createCriteria();
		criteria.andTasAcIdEqualTo(sign.getSigAcId());
		List<User> userList = new ArrayList<User>();
		List<Task> taskList = taskMapper.selectByExample(example);
		for (Task task : taskList) {
			DueExample example2 = new DueExample();
			DueExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andTasidEqualTo(task.getTasId());
			List<Due> due = dueMapper.selectByExample(example2);
			for (Due due2 : due) {
				User user2 = userMapper.selectByPrimaryKey(due2.getUserId());
				if (user2.getUserGrade().equals(user.getUserGrade())&&
						user2.getUserAcademy().equals(user.getUserAcademy()))
					return true;
			}
		}
		return false;
	}

}
