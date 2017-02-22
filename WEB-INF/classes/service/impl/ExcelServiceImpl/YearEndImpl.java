package service.impl.ExcelServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
public class YearEndImpl implements ExcelService{
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
	
	public YearEndImpl() throws IOException{
		PropertyInterface pro = new PropertiesExcelLocation();
		Map map = pro.readAllProperties();
		InputStream	= (String) map.get("YearEndImplModelPath");
		savepath			= (String) map.get("YearEndImplSavepath");
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
				savepath + list.get(0));
		WritableWorkbook wwb = Workbook.createWorkbook(file, readWb);
		//读取第一张工作表
		WritableSheet ws = wwb.getSheet(0);
		//获得第一个单元格对象
		WritableCell wc = ws.getWritableCell(2, 2);
		//判断单元格的类型，做出相应的转换
//		if (wc.getType() == CellType.LABEL)
//		{
//			PropertyInterface proInterface = new PropertiesExcel();
//			Map map = proInterface.readAllProperties();
//			List Label = (List) map.get("Label");
//			Label label;
			for (int i = 1; i < list.toArray().length; i++) {
				try {
				ws.addCell(new Label(i, 3, (String) list.get(i) ,
				ws.getWritableCell(i, 3).getCellFormat()));
				}catch (Exception e)
				{
					e.printStackTrace();
					ws.addCell(new Label(i, 3, "空" ,
							ws.getWritableCell(i, 3).getCellFormat()));
				}
				System.out.println((String) list.get(i));
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
		ExcelService excelService = new YearEndImpl();
		excelService.write(null);
	}
}
