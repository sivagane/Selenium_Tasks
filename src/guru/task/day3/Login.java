package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class Login extends Util {

	static WebDriver driver;

	public static void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void login(String userName, String passWord) throws InterruptedException {
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.name("btnLogin")).click();

		try {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			System.out.println("Test Case is Failed");
		} catch (NoAlertPresentException e) {
			String Actual = driver.getTitle();
			String Expected = "Guru99 Bank Manager HomePage";
			if (Actual.equalsIgnoreCase(Expected)) {
				System.out.println("Test Case is Passed");
			}
		}

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		launchBrowser();
		driver.get(BaseUrl);
		readValueFromExcel();

		driver.quit();
	}

	public static void readValueFromExcel() throws IOException, InterruptedException {
		File f = new File("C:\\Users\\Hp\\Desktop\\JavaExcelSheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Sheet1");
		int allRows = s.getPhysicalNumberOfRows();

		for (int i = 1; i < allRows; i++) {
			String UserName = s.getRow(i).getCell(0).getStringCellValue();
			String PassWord = s.getRow(i).getCell(1).getStringCellValue();
			login(UserName, PassWord);
			
			driver.navigate().to("http://www.demo.guru99.com/V4/index.php");
		}

	}

}
