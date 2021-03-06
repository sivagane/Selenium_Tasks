package day4;

import org.testng.annotations.Test;

import day3.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class NewTest extends Util {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BaseUrl);
	}

	@Test(dataProviderClass = Util.class, dataProvider = "guru")
	public void login(String s1, String s2) throws InterruptedException {

		driver.findElement(By.name("uid")).sendKeys(s1);
		driver.findElement(By.name("password")).sendKeys(s2);
		driver.findElement(By.name("btnLogin")).click();
		try {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			System.out.println("Test Case is Failed");
		} catch (NoAlertPresentException e) {
			String Actual = driver.getTitle();
			String Expected = "Guru99 Bank Manager HomePage";
			if (Actual.equalsIgnoreCase(Expected)) {
				WebElement mgrId = driver.findElement(By.xpath("//td[text()='Manger Id : mngr278841']"));
				String Id = mgrId.getText();
				Assert.assertEquals(Id, "Manger Id : mngr278841");
				System.out.println("Test Case is Passed");
			}

		}
		driver.navigate().to("http://www.demo.guru99.com/V4/index.php");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
