package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesExcel implements PropertyInterface {


	//配置文件的路径
    private String configPath=null;
    
    /**
     * 配置文件对象
     */
    private Properties props=null;
    
	/**
     * 默认构造函数，用于sh运行，自动找到classpath下的config.properties。
     */
    public PropertiesExcel() throws IOException{
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("excel.properties");
        props = new Properties();
        props.load(in);
        //关闭资源
        in.close();
    }
    
    /**
     * 根据key值读取配置的值
     * Jun 26, 2010 9:15:43 PM
     * @author 朱志杰
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public String readValue(String key) throws IOException {
        return  props.getProperty(key);
    }
    
    /**
     * 读取properties的全部信息
     * Jun 26, 2010 9:21:01 PM
     * @author 朱志杰
     * @throws FileNotFoundException 配置文件没有找到
     * @throws IOException 关闭资源文件，或者加载配置文件错误
     * 
     */
    public Map readAllProperties() throws FileNotFoundException,IOException  {
        //保存所有的键值
        Map map=new HashMap();
        Enumeration en = props.propertyNames();
        List label = new ArrayList();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String Property = props.getProperty(key);
//            if (key.contains("Label") )
//            {
//            	System.out.println(key+":"+Property);
//            	label.add(Property);
//            }
//            else
            map.put(key, Property);
        }
//        map.put("Label", label);
        return map;
    }

    /**
     * 设置某个key的值,并保存至文件。
     * Jun 26, 2010 9:15:43 PM
     * @author 朱志杰
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public void setValue(String key,String value) throws IOException {
        Properties prop = new Properties();
        InputStream fis = new FileInputStream(this.configPath);
        // 从输入流中读取属性列表（键和元素对）
        prop.load(fis);
        // 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
        // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream fos = new FileOutputStream(this.configPath);
        prop.setProperty(key, value);
        // 以适合使用 load 方法加载到 Properties 表中的格式，
        // 将此 Properties 表中的属性列表（键和元素对）写入输出流
        prop.store(fos,"last update");
        //关闭文件
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) {
        PropertiesExcel p;
        try {
            p = new PropertiesExcel();
            List<String> yearEndList = new ArrayList(95);
            for (int i=0;i<95;i++)
            {
            	yearEndList.add("--");
            }
            yearEndList.add(8, "22");
//    		yearEndList.set(9, (String) userList.get(1));
//    		yearEndList.set(11, (String) userList.get(2));
//    		yearEndList.set(12, (String) userList.get(3));
//    		yearEndList.set(14, (String) userList.get(4));
//    		yearEndList.set(15, (String) userList.get(5));
//    		yearEndList.set(17, (String) userList.get(6));
//    		yearEndList.set(18, (String) userList.get(7));
//    		yearEndList.set(20, (String) userList.get(8));
//    		yearEndList.set(21, (String) userList.get(9));
//    		yearEndList.set(22, (String) userList.get(10));
//    		yearEndList.set(23, (String) userList.get(11));
//    		yearEndList.set(24, (String) userList.get(12));
//    		yearEndList.set(25, (String) userList.get(13));
//    		yearEndList.set(26, (String) userList.get(14));
//    		yearEndList.set(27, (String) userList.get(15));
//    		yearEndList.set(28, (String) userList.get(16));
            System.out.println(yearEndList.size());
            System.out.println(p.readAllProperties());
            Map<String, String> map2 = p.readAllProperties();
            for (String key : map2.keySet()) {
//    			yearEndList.set(Integer.parseInt((String) map.get(key)), (String) userList.get(i));
    			System.out.println("key= "+ key + " and value= " + map2.get(key));
    			
    		}
//            List mapExcel = (List) p.readAllProperties().get("Label");
//            System.out.println(mapExcel);
//            System.out.println(mapExcel.get(0));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
