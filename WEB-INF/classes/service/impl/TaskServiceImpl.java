package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.DueMapper;
import mapper.TaskMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Due;
import po.DueExample;
import po.TaskExample;
import po.Task;
import service.TaskService;

public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskMapper mapper;
	@Autowired
	private DueMapper mapper2;
	public List<Task> selectTaskByTasDueId(String tasDueId) {
		DueExample example = new DueExample();
		example.setOrderByClause("tasId DESC");
		DueExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(tasDueId);
		List<Due> due =  mapper2.selectByExample(example);
		List<Task> taskList = new ArrayList<Task>();
		for(Due due1 : due)
		{
			taskList.add(mapper.selectByPrimaryKey(due1.getTasid()));
		}
		return taskList;
	}
	public List<Task> selectTaskByTasCreId(String tasCreId) {
		TaskExample example = new TaskExample();
		example.setOrderByClause("TAS_CRE_DATE DESC");
		TaskExample.Criteria criteria = example.createCriteria();
		criteria.andTasCreIdEqualTo(tasCreId);
		return mapper.selectByExample(example);
	}
	public int insertTask(Task task) {
		return mapper.insertSelective(task);
	}
	public int updateTask(Task task) {
		return mapper.updateByPrimaryKeySelective(task);
	}
	@Override
	public Task selectTaskByTasId(int tasId) {
		return mapper.selectByPrimaryKey(tasId);
	}
	@Override
	public int deleteTask(int tasId) {
		return mapper.deleteByPrimaryKey(tasId);
	}
	@Override
	public int updateTaskStatus() {
		return mapper.updateTaskStatus();
	}
	@Override
	public List<Task> selectTaskNotOverDueByTasCreId(Integer startPos,
			Integer pageSize, String tasCreId) {
		return mapper.selectTaskNotOverDueByTasCreId(startPos, pageSize, tasCreId);
	}
	@Override
	public int selectTaskNotOverDueByTasCreIdCount(String tasCreId) {
		return (int)mapper.selectTaskNotOverDueByTasCreIdCount(tasCreId);
	}
	@Override
	public List<Task> selectTaskOverDueByTasCreId(Integer startPos,
			Integer pageSize, String tasCreId) {
		return mapper.selectTaskOverDueByTasCreId(startPos, pageSize, tasCreId);
	}
	@Override
	public int selectTaskOverDueByTasCreIdCount(String tasCreId) {
		return (int)mapper.selectTaskOverDueByTasCreIdCount(tasCreId);
	}
	@Override
	public List<Task> selectTaskNotOverDueByTasDueId(Integer startPos,
			Integer pageSize, String tasDueId) {
		List<Due> due = mapper2.selectTaskNotOverDueByTasDueId(startPos, pageSize, tasDueId);
		ArrayList<Task> task = new ArrayList<Task>();
		for (Due due2 : due) {
			task.add(mapper.selectByPrimaryKey(due2.getTasid()));
		}
		return task;
	}
	@Override
	public int selectTaskNotOverDueByTasDueIdCount(String tasDueId) {
		return (int)mapper2.selectTaskNotOverDueByTasDueIdCount(tasDueId);
	}
	@Override
	public List<Task> selectTaskOverDueByTasDueId(Integer startPos,
			Integer pageSize, String tasDueId) {
		List<Due> due = mapper2.selectTaskOverDueByTasDueId(startPos, pageSize, tasDueId);
		ArrayList<Task> task = new ArrayList<Task>();
		for (Due due2 : due) {
			task.add(mapper.selectByPrimaryKey(due2.getTasid()));
		}
		return task;
	}
	@Override
	public int selectTaskOverDueByTasDueIdCount(String tasDueId) {
		return (int)mapper2.selectTaskOverDueByTasDueIdCount(tasDueId);
	}
	@Override
	public List<Task> selectTaskUnhandled() {
		return mapper.selectTaskUnhandled();
	}
	@Override
	public List<Task> selectTaskByTasAcId(int tasAcId) {
		TaskExample example = new TaskExample();
		TaskExample.Criteria criteria = example.createCriteria();
		criteria.andTasAcIdEqualTo(tasAcId);
		return mapper.selectByExample(example);
	}
	
	

}
