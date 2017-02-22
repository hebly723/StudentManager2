package service.impl.ExcelServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import po.User;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.ExcelService;
import service.InfoService;
import service.impl.Academy;
import service.impl.Degree;
import utils.PropertiesExcelLocation;
import utils.PropertyInterface;

/**
 * @author Ly723
 * @description 给学生信息表（Student information）schedule 使用的表格方法
 * @param acId 活动ID
 * @param request
 * @param response
 * @return
 */
public class StudentInfoImpl implements ExcelService {
	/**
	 * @description 模板表格所在绝对路径
	 */
	private String InputStream;
	/**
	 * @description 生成表格的目录（带斜杠）
	 */
	private String savepath;
	
	public StudentInfoImpl() throws IOException{
		PropertyInterface pro = new PropertiesExcelLocation();
		Map map = pro.readAllProperties();
		InputStream	= (String) map.get("StudentInfoModelPath");
		savepath			= (String) map.get("StudentInfoTempSavePath");
//		InputStream
	}
	
	public String write(List list){
		System.out.println("All In");
		Workbook readWb = null;
		List ulist = list;
		//构建workbook对象，只读WorkBook对象
		//直接从本地文件创建workbook
	//System.out.println("cell.getContents() + ");
	try{	
		InputStream inputStream = new FileInputStream(
				InputStream);
		
		readWb = Workbook.getWorkbook(inputStream);
//		System.out.println("All In2");
		//sheet的下标是从零开始
		//获取第一张sheet表
		Sheet readSheet = readWb.getSheet(0);
//		System.out.println("All In3");
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
////				if (cell.getContents().equals("——"))
////					System.out.println( "( " + i + ", " + j + ")");
//			}
////			System.out.println();
//		}
		File file ;
		try{
			file = new File(
					savepath + list.get(0) + ".xls");
			}catch (Exception e)
			{
			file = new File(
						savepath + "空表.xls");
			}
		//利用已经创建的Excel工作簿，创建新的可写入的Excel工作簿
		WritableWorkbook wwb = Workbook.createWorkbook(file, readWb);
		//读取第一张工作表
		WritableSheet ws = wwb.getSheet(0);
		//获得第一个单元格对象
		WritableCell wc = ws.getWritableCell(2, 2);
//		WritableSheet sheet2 = (WritableSheet) readWb.getSheet(0);
		
//		wwb.copySheet(0, "sdas", 1);
		WritableSheet sheet2 = wwb.createSheet("try", 1);
		Cell[] model = ws.getRow(0);
//		sheet2.insertRow(10);
//		sheet2.insertColumn(10);
		sheet2.setRowView(0, ws.getRowView(0));
		
//		for (int i = 0; i < model.length; i++) {
////			model[i];
////			ws.a
//			sheet2.setColumnView(i, ws.getColumnView(i));
//			sheet2.addCell(new Label(i, 0, model[i].getContents(), model[i].getCellFormat()));
//		}
		//判断单元格的类型，做出相应的转换
//		if (wc.getType() == CellType.LABEL)
//		{
//			PropertyInterface proInterface = new PropertiesExcel();
//			Map map = proInterface.readAllProperties();
//			List Label = (List) map.get("Label");
//			Label label;
//		InfoService academy = new Academy();
//		InfoService degree = new Degree();
			for (int i = 1; i < ulist.toArray().length; i++) {
				ws.addCell(new Label(0, i, ((User) ulist.get(i)).getUserId(), ws.getWritableCell(i-1, 4).getCellFormat() ));
				System.out.println("In!");
				ws.addCell(new Label(1, i, ((User) ulist.get(i)).getUserName(), ws.getWritableCell(i-1, 2).getCellFormat() ));
				ws.addCell(new Label(2, i, ((User) ulist.get(i)).getUserGrade(), ws.getWritableCell(i-1, 2).getCellFormat()));
				ws.addCell(new Label(3, i, ((User) ulist.get(i)).getUserAcademy(), ws.getWritableCell(i-1, 2).getCellFormat()));
				ws.addCell(new Label(4, i, ((User) ulist.get(i)).getUserMailBox(), ws.getWritableCell(i-1, 2).getCellFormat()));
				ws.addCell(new Label(5, i, ((User) ulist.get(i)).getUserQq(), ws.getWritableCell(i-1, 2).getCellFormat() ));
				ws.addCell(new Label(6, i, ((User) ulist.get(i)).getUserTel(), ws.getWritableCell(i-1, 2).getCellFormat()));
//				System.out.println( (Label.toArray())[i]);
			}
//			Label lableCF00 = new Label(42, 3, "17" ,ws.getWritableCell(0, 4).getCellFormat());
//			ws.addCell(lableCF00);
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
	public static void main(String args[]) throws IOException
	{
		ExcelService excelService = new StudentInfoImpl();
		excelService.write(null);
	}

}
