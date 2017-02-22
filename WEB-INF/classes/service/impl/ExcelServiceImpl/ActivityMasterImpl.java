package service.impl.ExcelServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import po.ExTask;
import po.User;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.ExcelService;
import utils.PropertiesExcel;
import utils.PropertiesExcelLocation;
import utils.PropertyInterface;

/**
 * @author Ly723
 * @description 给年终审核表(Year-end audit schedule)使用的表格方法，
 * 方法调用的结果是下载对应的表格
 * @param year 要生成的表格的年份
 * @param id 表格对应的协理员ID
 * @param request
 * @param response
 */
public class ActivityMasterImpl implements ExcelService{
	/**
	 * @author Ly723
	 * @description 模板表格所在绝对路径
	 */
	private String InputStream;
	/**
	 * @author Ly723
	 * @description 生成表格的目录（带斜杠）
	 */
	private String savepath;
	
	public ActivityMasterImpl() throws IOException{
		PropertyInterface pro = new PropertiesExcelLocation();
		Map map = pro.readAllProperties();
		InputStream	= (String) map.get("AcMasterModelPath");
		savepath			= (String) map.get("AcMasterSavepath");
//		InputStream
	}
	public String write(List list){
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
//		int rsRows = readSheet.getRows();
		int rsRows = 4;
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
		File file = new File(
				savepath + "活动总表.xls");
		WritableWorkbook wwb = Workbook.createWorkbook(file, readWb);
		//读取第一张工作表
		WritableSheet ws = wwb.getSheet(0);
		//获得第一个单元格对象
		WritableCell wc = ws.getWritableCell(2, 2);
		//判断单元格的类型，做出相应的转换
//		for (int i = 0; i < model.length; i++) {
////	model[i];
////	ws.a
//			sheet2.setColumnView(i, ws.getColumnView(i));
//			sheet2.addCell(new Label(i, 0, model[i].getContents(), model[i].getCellFormat()));
//		}
//		if (wc.getType() == CellType.LABEL)
//		{
//			PropertyInterface proInterface = new PropertiesExcel();
//			Map map = proInterface.readAllProperties();
//			List Label = (List) map.get("Label");
			Label label;
			for (int i = 0; i < list.toArray().length; i++) {
//				ws.addCell(new Label(0, i+1,  ,
//				ws.getWritableCell(0, i+1).getCellFormat()));
				ws.setRowView(i+1, ws.getRowView(1));
				ExTask exTask = (ExTask)list.get(i);

				ws.addCell(new Label(0, 1, exTask.getTasCreId(), ws.getWritableCell(0, 1).getCellFormat()));
				ws.addCell(new Label(1, 1, exTask.getTasCreName(), ws.getWritableCell(1, 1).getCellFormat()));
				
				
				ws.addCell(new Label(0, i + 3, exTask.getTasAcId().toString(), ws.getWritableCell(i, 1).getCellFormat() ));
				ws.addCell(new Label(1, i + 3, exTask.getTasTitle(), ws.getWritableCell(i, 1).getCellFormat() ));
				
				ws.addCell(new Label(2, i + 3, exTask.getSignNumber().toString() , ws.getWritableCell(i, 1).getCellFormat()));
				ws.addCell(new Label(3, i + 3, exTask.getExcuNumber().toString(), ws.getWritableCell(i, 1).getCellFormat() ));
				if (Integer.parseInt(exTask.getTasStatus().trim())>=3)
					ws.addCell(new Label(4, i + 3, "是", ws.getWritableCell(i, 1).getCellFormat()));
				else
					ws.addCell(new Label(4, i + 3, "否", ws.getWritableCell(i, 1).getCellFormat()));
				try{
					ws.addCell(new Label(5, i + 3, exTask.getTasCreDate().toString(), ws.getWritableCell(i, 1).getCellFormat()));
				}catch(Exception e)
				{
					ws.addCell(new Label(5, i + 3, "空", ws.getWritableCell(i, 1).getCellFormat()));
				}
				try{
				ws.addCell(new Label(6, i + 3, exTask.getTasDueDate().toString(), ws.getWritableCell(i, 1).getCellFormat()));
				}catch (Exception e){
					ws.addCell(new Label(6, i + 3, "空", ws.getWritableCell(i, 1).getCellFormat()));
				}
				try{
					ws.addCell(new Label(7, i + 3, exTask.getBeginDate().toString(), ws.getWritableCell(i, 1).getCellFormat()));
					}catch (Exception e){
						ws.addCell(new Label(7, i + 3, "空", ws.getWritableCell(i, 1).getCellFormat()));
					}
				try{
					ws.addCell(new Label(8, i + 3, exTask.getFiniDate().toString(), ws.getWritableCell(i, 1).getCellFormat()));
					}catch (Exception e){
						ws.addCell(new Label(8, i + 3, "空", ws.getWritableCell(i, 1).getCellFormat()));
					}
				
				//				System.out.println( (Label.toArray())[i-1]);
			}
//			Label lableCF00 = new Label(42, 3, "18" ,ws.getWritableCell(0, 4).getCellFormat());
//			ws.addCell(lableCF00);
			
//		}
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
	public static void main (String args[]) throws IOException
	{
		ExcelService excelService = new ActivityMasterImpl();
		excelService.write(null);
	}
}
