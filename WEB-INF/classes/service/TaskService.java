package service;

import java.util.List;

import po.Task;

public interface TaskService {
	public List<Task> selectTaskByTasDueId(String tasDueId); 
	public List<Task> selectTaskByTasCreId(String tasCreId); 
	public Task selectTaskByTasId(int tasId);
	public int insertTask(Task task);
	public int updateTask(Task task);
	public int deleteTask(int tasId);
	public int updateTaskStatus();
	
	public List<Task> selectTaskUnhandled();
    
    public List<Task> selectTaskNotOverDueByTasCreId(Integer startPos,Integer pageSize,String tasCreId);
    int selectTaskNotOverDueByTasCreIdCount(String tasCreId);
    
    public List<Task> selectTaskOverDueByTasCreId(Integer startPos,Integer pageSize,String tasCreId);
    int selectTaskOverDueByTasCreIdCount(String tasCreId);
    
    public List<Task> selectTaskNotOverDueByTasDueId(Integer startPos,Integer pageSize,String tasDueId);
    int selectTaskNotOverDueByTasDueIdCount(String tasDueId);
    
    public List<Task> selectTaskOverDueByTasDueId(Integer startPos,Integer pageSize,String tasDueId);
    int selectTaskOverDueByTasDueIdCount(String tasDueId);
    
    public List<Task> selectTaskByTasAcId(int tasAcId);
    
}
