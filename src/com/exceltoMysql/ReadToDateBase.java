package com.exceltoMysql;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;
public class ReadToDateBase {
	static JDBCUtil util = new JDBCUtil();
	public static void main(String[] args) {
		String fileToBeRead = "L:\\temp.xls";
		try {           
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
			HSSFSheet sheet = workbook.getSheet("Sheet1");  
			int rows = sheet.getPhysicalNumberOfRows();    
			System.out.println(rows);
			for (int r = 1; r < rows; r++) {      
				String value ="";                      
				HSSFRow row = sheet.getRow(r);
				if (row != null) {
					int  cells = row.getPhysicalNumberOfCells(); 
					System.out.println(cells);
					for (short c = 1; c < cells; c++) {                      
						HSSFCell cell = row.getCell((short) c);                 
						if (cell != null) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {                     
								value += cell.getStringCellValue()+",";
								System.out.println(value);
							} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {                             
								value += cell.getNumericCellValue()+",";
								System.out.println(value);
							} else if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){                      
								value += cell.getStringCellValue()+",";
								System.out.println(value);
							}
						}                       
					}                  
				}
				String [] str = value.split(",");      
				util.insertEmp(str);                   
			}   
		} catch (Exception e) {
			e.printStackTrace();            
		}
	}
}
