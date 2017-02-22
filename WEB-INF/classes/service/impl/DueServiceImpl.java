package service.impl;

import java.util.List;

import mapper.DueMapper;
import mapper.TaskMapper;
import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Due;
import po.DueExample;
import po.Task;
import po.TaskExample;
import service.DueService;

public class DueServiceImpl implements DueService {
	@Autowired
	private DueMapper dueMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TaskMapper taskMapper;
	public List<Due> selectTasDueIdByTasId( int tasId ) {
		DueExample example = new DueExample();
		DueExample.Criteria criteria = example.createCriteria();
		criteria.andTasidEqualTo(tasId);
		return dueMapper.selectByExample(example);
	}
	public void updateStatusOverDue() {
		TaskExample taskExample = new TaskExample();
		TaskExample.Criteria criteria = taskExample.createCriteria();
		criteria.andTasStatusEqualTo("3");
		List<Task> task = taskMapper.selectByExample(taskExample);
		for (Task task2 : task) {
			DueExample example = new DueExample();
			DueExample.Criteria dueCriteria = example.createCriteria();
			dueCriteria.andTasidEqualTo(task2.getTasId());
//			List<Due> due = dueMapper.selectByExample(example);
			Due due2 = new Due();
			due2.setTasStatus("3");
			dueMapper.updateByExampleSelective(due2, example);
		}
	}
	@Override
	public int insertDue(Due due) {
		return dueMapper.insert(due);
	}
	@Override
	public int deleteDue(Due due) {
		DueExample example = new DueExample();
		DueExample.Criteria dueCriteria = example.createCriteria();
		dueCriteria.andTasidEqualTo(due.getTasid());
		return dueMapper.deleteByExample(example);
	}
	@Override
	public int deleteDueByTasId(int tasId) {
		DueExample example = new DueExample();
		DueExample.Criteria dueCriteria = example.createCriteria();
		dueCriteria.andTasidEqualTo(tasId);
		return dueMapper.deleteByExample(example);
	}
	@Override
	public int activeTask(Due due) {
		due.setTasStatus("1");
		DueExample example = new DueExample();
		DueExample.Criteria criteria = example.createCriteria();
		criteria.andTasidEqualTo(due.getTasid());
		criteria.andUserIdEqualTo(due.getUserId());
		return dueMapper.updateByExample(due, example);
	}
	@Override
	public List<Due> selectTasDueIdByDue(Due due) {
		DueExample example = new DueExample();
		DueExample.Criteria criteria = example.createCriteria();
		criteria.andTasidEqualTo(due.getTasid());
		criteria.andUserIdEqualTo(due.getUserId());
		return dueMapper.selectByExample(example);
	}
	@Override
	public void updateDue(Due due) {
		DueExample example = new DueExample();
		DueExample.Criteria criteria = example.createCriteria();
		criteria.andTasidEqualTo(due.getTasid());
		criteria.andUserIdEqualTo(due.getUserId());
		dueMapper.updateByExample(due, example);
	}

}
