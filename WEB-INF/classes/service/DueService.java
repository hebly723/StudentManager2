package service;

import java.util.List;

import po.Due;

public interface DueService {
	/**
	 * @author jenkin
	 * @param tasId
	 * @return Due数组,内含任务id,协理员id,活动状态
	 * 根据任务id查询对应的下发人员
	 */
	public List<Due> selectTasDueIdByTasId( int tasId);
	/**
	 * @author jenkin
	 * @param tasId
	 * @return Due数组,内含任务id,协理员id,活动状态
	 * 根据任务id和人员ID查询对应的下发人员
	 */
	public List<Due> selectTasDueIdByDue( Due due);
	/**
	 * @author jenkin
	 * 更新状态为过期
	 */
	public void updateStatusOverDue();
	/**
	 * 插入数据
	 * @param due
	 * @return
	 */
	public int insertDue(Due due);
	/**
	 * 删除数据
	 * @param due
	 * @return
	 */
	public int deleteDue(Due due);
	/**
	 * 根据任务ID删除数据
	 * @param due
	 * @return
	 */
	public int deleteDueByTasId(int tasId);
	/**
	 * 激活任务
	 */
	public int activeTask(Due due);
	/**
	 * 更新任务
	 */
	public void updateDue(Due due);
}
