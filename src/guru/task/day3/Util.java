package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Util {
	public static String value= null;
	public static String exeLocation = "C:\\Users\\Hp\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
	public static String BaseUrl = "http://www.demo.guru99.com/V4/";
	 public static String userName = "mngr278841";
	 public static String passWord = "abujarA";

	public static Object[][] readvalueFromExcel() throws IOException {
		File f = new File("C:\\Users\\Hp\\eclipse WorkSpace\\Task_Eigth_Aug\\src\\guru\\task\\testdata\\JavaExcelSheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Sheet1");
		Row hRow = s.getRow(0);
        int allRows = s.getPhysicalNumberOfRows();
		int allCells = hRow.getPhysicalNumberOfCells();
		Object[][] ob = new Object[allRows][allCells];
		int j;
		for (int i = 0; i < allRows; i++) {
			Row eachRow = s.getRow(i);
			for ( j= 0; j < allCells; j++) {
				Cell eachCell = eachRow.getCell(j);
				 value = eachCell.getStringCellValue();
				 ob[i][j]= value;
			}
       
		}
		return ob;
	}
	
	@DataProvider(name="guru")
	public Object[][] data() throws IOException {
		return readvalueFromExcel();
	}
}
