package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface PropertyInterface {
	
    /**
     * 根据key值读取配置的值
     * Jun 26, 2010 9:15:43 PM
     * @author 朱志杰
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public String readValue(String key) throws IOException ;
    
    /**
     * 读取properties的全部信息
     * Jun 26, 2010 9:21:01 PM
     * @author 朱志杰
     * @throws FileNotFoundException 配置文件没有找到
     * @throws IOException 关闭资源文件，或者加载配置文件错误
     * 
     */
    public Map<String,String> readAllProperties() throws FileNotFoundException,IOException;
    /**
     * 设置某个key的值,并保存至文件。
     * Jun 26, 2010 9:15:43 PM
     * @author 朱志杰
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public void setValue(String key,String value) throws IOException;
}
