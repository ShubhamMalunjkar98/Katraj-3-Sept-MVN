package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellRead {
	public static ArrayList data;

	public static ArrayList dataReader() throws IOException {
		String path = System.getProperty("user.dir") + "\\DataRead\\userdata.xlsx";
		// String path=".\\DataRead\\userdata.xlsx";
		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rownum = sheet.getLastRowNum();
		int colnum = sheet.getRow(0).getLastCellNum();
		
		System.out.println(rownum);// start from 0==>2
		System.out.println(colnum);// start from 1==>2
         data=new ArrayList();
		for (int r = 0; r <= rownum; r++) {
			XSSFRow row = sheet.getRow(r);
			
			for (int c = 0; c < colnum; c++) {//2

				XSSFCell cell = row.getCell(c);
				//data.add(cell.getStringCellValue());
				switch(cell.getCellType()) {
				
				case STRING:data.add(cell.getStringCellValue());
				           break;
				           
				case NUMERIC:data.add(cell.getNumericCellValue());
				           break;
				case FORMULA:data.add(cell.getNumericCellValue());
				           break;
				case BOOLEAN:data.add(cell.getBooleanCellValue());
				           break;
				  default:System.out.println("Data not match");
				}
		
			}

		}
		return data;
	}

	
	public static void writeData() {
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println(dataReader());

	}

}
