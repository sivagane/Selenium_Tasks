package tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import day3.DataUtil;


public class ChangePassword extends DataUtil {

	public static WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BaseUrl);
	}
	
	@Test(enabled=false)
	public void changePassWord() {
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.name("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[text()='Change Password']")).click();
		driver.findElement(By.xpath("//input[@name='oldpassword']")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@name='newpassword']")).sendKeys(newPassWord);
		driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(newPassWord);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@Test
	public void verifyWithNewPassWord() throws InterruptedException {
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(newPassWord);
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.xpath("//a[text()='Balance Enquiry']")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(currentAccountNo);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyMiniStatement() throws InterruptedException {
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(newPassWord);
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.xpath("//a[text()='Mini Statement']")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(currentAccountNo);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
