/**
 * 
 */
package service.impl.ExcelServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import po.Activity;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.ExcelService;
import utils.PropertiesExcel;
import utils.PropertiesExcelLocation;
import utils.PropertyInterface;
public class ActivityListImpl implements ExcelService {

	/**
	 * @description 模板表格所在绝对路径
	 */
	private String InputStream;
	/**
	 * @description 生成表格的目录（带斜杠）
	 */
	private String savepath;
	
	public ActivityListImpl() throws IOException{
		PropertyInterface pro = new PropertiesExcelLocation();
		Map map = pro.readAllProperties();
		InputStream	= (String) map.get("ActivityListModelPath");
		savepath			= (String) map.get("ActivityListSavePath");
//		InputStream
	}
	/**
	 * @author Ly723
	 * @param list 要放进表中的数据
	 * 三层：sheet层，行一层，列一层
	 */
	@SuppressWarnings("finally")
	public String write(List list) {
		
		
		Workbook readWb = null;
		//构建workbook对象，只读WorkBook对象
		//直接从本地文件创建workbook
		//System.out.println("cell.getContents() + ");
		try{	
		InputStream inputStream = new FileInputStream(
				InputStream);
		readWb = Workbook.getWorkbook(inputStream);
		//sheet的下标是从零开始
		//获取第一张sheet表
		Sheet readSheet = readWb.getSheet(0);
		//获取sheet表中包含的总列数
		int rsColumn = readSheet.getColumns();
		//获取sheet表中包含的总行数
		int rsRows = readSheet.getRows();
//		int rsRows = 4;
		//获取指定单元格的对象引用
//		for (int i = 0; i < rsRows; i++) {
//			for (int j = 0; j < rsColumn; j++) {
//				Cell cell = readSheet.getCell(j,i);
//				System.out.println(cell.getContents() + "");
//				if (cell.getContents().equals("——"))
//					System.out.println( "( " + i + ", " + j + ")");
//			}
//			System.out.println();
//		}
		//利用已经创建的Excel工作簿，创建新的可写入的Excel工作簿
		/**
		 * 活动明细表目前为空
		 */
		File file;
		try{
		 file= new File(
				savepath + "活动明细表.xls");
		}catch (Exception e)
		{
			file = new File(
					savepath + "空表.xls");
		}
		WritableWorkbook wwb = Workbook.createWorkbook(file, readWb);
		List<List> acList = list;
		WritableSheet sheet2 = null;
		Cell[] model = readSheet.getRow(0);
		try{
			wwb.getSheet(0).setName((String)((Map)acList.get(0).get(0)).get("ActivityName"));
		}catch (Exception e)
		{
			wwb.getSheet(0).setName("空");
		}
		for (int j = 1; j < (acList.toArray()).length; j++) {
//			wwb.copySheet(0, acList.get(j).getAcTitle(), i);
		//复制一定数目的工作表
		try{
			sheet2 = wwb.createSheet((String)((Map)acList.get(j).get(0)).get("ActivityName"), j);
		}catch(Exception e){
			sheet2 = wwb.createSheet("空", j);
		}
		sheet2.setRowView(0, readSheet.getRowView(0));
		
			for (int i = 0; i < model.length; i++) {
				sheet2.addCell(new Label(i, 0, model[i].getContents(), model[i].getCellFormat()));
				sheet2.setColumnView(i, readSheet.getColumnView(i));
			}
		}
		for (int i = 0; i < (acList.toArray()).length; i++){
			//读取第一张工作表
			WritableSheet ws = wwb.getSheet(i);
			//获得第一个单元格对象
//			WritableCell wc = ws.getWritableCell(2, 2);
			//判断单元格的类型，做出相应的转换
//			if (wc.getType() == CellType.LABEL)
//			{
			List<Map> mapList = acList.get(i);
			int j = 1;
//			Map map = new HashMap<String, String>();
//			map.put("signId", sign.getSigPerId());
//			map.put("signName", sign.getSigPerName());
//			map.put("excecuteTime", sign.getSigHanDate());
//			map.put("signTime", sign.getSigDate());
//			map.put("ActivityName", activity.getAcTitle());
//			/**
//			 * status 具体是什么还得问问
//			 */
//			map.put("result", sign.getSigStatus());
			
			for (Map map : mapList) {
				ws.setRowView(1, readSheet.getRowView(0));
				try{
				ws.addCell(new Label(0, j, (String) map.get("signId"),readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}catch (Exception e)
				{
					ws.addCell(new Label(2, j, "无",readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}
				//				Activity activity = (Activity) list.get(i);
				try{
				ws.addCell(new Label(1, j, (String) map.get("signName"),readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}catch (Exception e)
				{
					ws.addCell(new Label(1, j, "无",readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}
				System.out.println((String) map.get("signId"));
				try{
				ws.addCell(new Label(2, j, (String) map.get("signTime"),readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}catch (Exception e)
				{
					ws.addCell(new Label(2, j, "无",readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}
			System.out.println(map.get("signTime").toString());
				try{
				ws.addCell(new Label(3, j, (String) map.get("excecuteTime"),readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}catch (Exception e)
				{
					ws.addCell(new Label(3, j, "无",readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}
				//				System.out.println(activity.getAcCreId());
//				if(activity.getAcCreDate().toString().equals(null)||activity.getAcCreDate().toString().equals(""))
//				ws.addCell(new Label(4, 1, "无",readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				try{
					ws.addCell(new Label(4, j, (String) map.get("result"),readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}catch (Exception e)
				{
					ws.addCell(new Label(4, j, "无",readWb.getSheet(0).getCell(0, 2) .getCellFormat()));
				}
				j++;
			}
				
				
//									System.out.println(activity.getAcCreDate().toString());
				
//				System.out.println(activity.getAcCreDate().toString());
//				ws.addCell(new Label(5, 1, activity.getAcDueDate().toString() ));
//				System.out.println(activity.getAcDueDate());
//			}	
		}		
//		wwb.copySheet(0, "copy", 2);
		//写入Excel对象
		wwb.write();
		wwb.close();
		return savepath;
	}catch (Exception e)
	{
		e.printStackTrace();
		return savepath;
	}
		finally{
			readWb.close();
			return savepath;
		}
	}

	/**
	 * @author Ly723
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
