package seleniumTasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebSite {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.website.com/");
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.id("memberFunction")).click();
		driver.findElement(By.id("username")).sendKeys("sivag918@gmail.com");
		driver.findElement(By.id("password")).sendKeys("websitesiva");
		Thread.sleep(5000);
		WebElement captchaFrame = driver.findElement(By.name("a-5tr1qclnvfcy"));
		driver.switchTo().frame(captchaFrame);
		driver.findElement(By.xpath("//span[@class='recaptcha-checkbox goog-inline-block recaptcha-"
				+ "checkbox-unchecked rc-anchor-checkbox']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("signin-submit2")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
