package seleniumTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections4.bag.TreeBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteValueToExcel {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\Hp\\Desktop\\JavaExcelSheet.xlsx");
		Workbook w = new XSSFWorkbook();

		Sheet s = w.createSheet("new");

		Map<String, Object[]> empInfo = new TreeMap<String, Object[]>();
		empInfo.put("1", new Object[] { "Emp id", "Emp Name", "Emp Designation" });

		empInfo.put("2", new Object[] { "TC01", "Manish", "Technical Manager" });
		empInfo.put("3", new Object[] { "TC02", "Gopal", "TechnicalWriter" });

		Set<String> keyid = empInfo.keySet();
		System.out.println(keyid);
		int rowid = 0;

		for (String key : keyid) {
			Row row = s.createRow(rowid++);
			Object[] objArr = empInfo.get(key);
			
			int cellid = 0;

			for (Object obj : objArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
				System.out.println((String)obj);
			}
		}

		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}
}
