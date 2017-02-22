package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.ActivityMapper;
import mapper.DueMapper;
import mapper.SignMapper;
import mapper.TaskMapper;
import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Activity;
import po.Due;
import po.DueExample;
import po.SignCustom1;
import po.SignExample;
import po.Sign;
import po.Task;
import po.TaskExample;
import po.User;
import service.SignService;

public class SignServiceImpl implements SignService {
	@Autowired
	private SignMapper mapper;
	@Autowired
	private ActivityMapper acmapper;
	@Autowired
	private TaskMapper taskmapper;
	@Autowired
	private DueMapper dueMapper;
	@Autowired
	private UserMapper userMapper;
	public List<Sign> selectSignByAcId(int acId) {
		SignExample example = new SignExample();
		example.setOrderByClause("SIG_DATE DESC");
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigAcIdEqualTo(acId);
		return mapper.selectByExample(example);
	}
	public List<Sign> selectSignByAcIdOk(int acId) {
		SignExample example = new SignExample();
		example.setOrderByClause("SIG_DATE DESC");
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigAcIdEqualTo(acId);
		criteria.andSigStatusEqualTo("1");
		return mapper.selectByExample(example);
	}
	public int insertSign(Sign Sign) {
		return mapper.insertSelective(Sign);
	}

	public int updateSign(Sign Sign) {
		return mapper.updateByPrimaryKeySelective(Sign);
	}
	@Override
	public String selectDocIdById(int sigId) {
		return mapper.selectByPrimaryKey(sigId).getSigDocId();
	}
	@Override
	public Sign selectSignById(int sigId) {
		return mapper.selectByPrimaryKey(sigId);
	}
	@Override
	public List<Sign> selectUnhandleSigns() {
		SignExample example = new SignExample();
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigStatusEqualTo("0");
		return mapper.selectByExample(example);
	}
	@Override
	public String selectSignByacIdAndsigPerId(int acId, String sigPerId) {
		return mapper.selectSignByacIdAndsigPerId(acId, sigPerId);
	}
	@Override
	public List<Sign> selectSignUnhandledByAcId(Integer startPos,
			Integer pageSize, Integer acId) {
		return mapper.selectSignUnhandledByAcId(startPos, pageSize, acId);
	}
	@Override
	public int selectSignUnhandledByAcIdCount(Integer acId) {
		return (int)mapper.selectSignUnhandledByAcIdCount(acId);
	}
	@Override
	public List<Sign> selectSignHandledByAcId(Integer startPos,
			Integer pageSize, Integer acId) {
		return mapper.selectSignHandledByAcId(startPos, pageSize, acId);
	}
	@Override
	public int selectSignHandledByAcIdCount(Integer acId) {
		return (int)mapper.selectSignHandledByAcIdCount(acId);
	}
	@Override
	public List<SignCustom1> selectSignBySigPerId(Integer startPos, Integer pageSize,
			String sigPerId) {
		return  mapper.selectSignBySigPerId(startPos, pageSize, sigPerId);
		
	}
	@Override
	public int selectSignBySigPerIdCount(String sigPerId) {
		return (int)mapper.selectSignBySigPerIdCount(sigPerId);
	}
	@Override
	public List<Sign> selectStudentByAcId(Integer acId) {
		return mapper.selectStudentByAcId(acId);
	}
	/**
	 *  @author Ly723
	 *  报名成功的人数
	 */
	public int countSignSuccess(int acId) {
		/**
		 * sigstatus大于零则是被处理
		 */
		SignExample example = new SignExample();
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigAcIdEqualTo(acId);
		criteria.andSigStatusEqualTo("1");
		return mapper.countByExample(example);
	}
	/**
	 * @author Ly723
	 * 报名的人数
	 */
	public int countSign( int acId) {
		SignExample example = new SignExample();
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigAcIdEqualTo(acId);
		return mapper.countByExample(example);
	}
	/**
	 * @author Ly723
	 * 报名被审核的人数
	 */
	public int countExecute(int acId){
		SignExample example = new SignExample();
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigAcIdEqualTo(acId);
		criteria.andSigStatusNotEqualTo("0");
		return mapper.countByExample(example);
	}
	@Override
	public Sign selectSignBysigPerId(String sigPerId) {
		SignExample example = new SignExample();
		SignExample.Criteria criteria = example.createCriteria();
		criteria.andSigPerIdEqualTo(sigPerId);
		return (Sign) mapper.selectByExample(example);
	}
	@Override
	public int updateSignAll(Sign sign) {
		return mapper.updateByPrimaryKey(sign);
	}
	public int deleteSignById(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}
	public void deleteSignByTasId(Task task){
		DueExample dueExample = new DueExample();
		DueExample.Criteria tCriteria = dueExample.createCriteria();
		tCriteria.andTasidEqualTo(task.getTasId());
		List<Due> dueList = dueMapper.selectByExample(dueExample);
		Map<String, String> condition = new HashMap<String, String>();
		for (Due due : dueList) {
			User user = userMapper.selectByPrimaryKey(due.getUserId());
			condition.put(user.getUserAcademy(), user.getUserGrade());
		}
		SignExample SignExample = new SignExample();
		SignExample.Criteria sCriteria = SignExample.createCriteria();
		sCriteria.andSigAcIdEqualTo(task.getTasAcId());
		List<Sign> signs = mapper.selectByExample(SignExample);
		for (Sign sign : signs) {
			User user = userMapper.selectByPrimaryKey(sign.getSigPerId());
			if (condition.get(user.getUserAcademy())!= null)
					if (condition.get(user.getUserAcademy()).equals(user.getUserGrade()))
						mapper.deleteByPrimaryKey(sign.getSigId());
		}
	}
	@Override
	public List<Sign> selectSignUnhandledByAcIdAndTeacherId(Integer startPos,
			Integer pageSize, Integer acId, String userId) {
		return mapper.selectSignUnhandledByAcIdAndTeacherId(startPos, pageSize, acId, userId);
	}
	@Override
	public int selectSignUnhandledByAcIdAndTeacherIdCount(Integer acId,
			String userId) {
		return (int)mapper.selectSignUnhandledByAcIdAndTeacherIdCount(acId,userId);
	}
	@Override
	public List<Sign> selectSignHandledByAcIdAndTeacherId(Integer startPos,
			Integer pageSize, Integer acId, String userId) {
		return mapper.selectSignHandledByAcIdAndTeacherId(startPos, pageSize, acId, userId);
	}
	@Override
	public int selectSignHandledByAcIdAndTeacherIdCount(Integer acId,
			String userId) {
		return (int)mapper.selectSignHandledByAcIdAndTeacherIdCount(acId,userId);
	}
	@Override
	public List<Sign> selectSignByAcIdAndTeacherId(Integer acId,
			String userId) {
		return mapper.selectSignByAcIdAndTeacherId(acId, userId);
	}

}
