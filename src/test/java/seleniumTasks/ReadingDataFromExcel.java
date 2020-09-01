package seleniumTasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	static String value = null;

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Hp\\Desktop\\JavaExcelSheet.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);

		Sheet s = w.getSheet("new");
		Row hrow = s.getRow(0);
		int rowssize = s.getPhysicalNumberOfRows();
		int colssize = hrow.getPhysicalNumberOfCells();
		int j;

		for (int i = 0; i < rowssize; i++) {

			Row eachRow = s.getRow(i);
			for (j = 0; j < colssize; j++) {
				Cell eachcell = eachRow.getCell(j);
				int cellType = eachcell.getCellType();

				if (cellType == 1) {
					value = eachcell.getStringCellValue();
					System.out.println(value);
				} else if (DateUtil.isCellDateFormatted(eachcell)) {
					Date d = eachcell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					value = sdf.format(d);
					System.out.println(value);
				} else {
					double doub = eachcell.getNumericCellValue();
					long l = (long) doub;
					value = String.valueOf(l);
					System.out.println(value);

				}
			}
		}
	}
}
