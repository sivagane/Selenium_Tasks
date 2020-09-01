package seleniumTasks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Print_AllOptions {

	static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void print_All_Options() {
		driver.findElement(By.id("u_0_2")).click();
		WebElement day = driver.findElement(By.id("day"));
		Select s = new Select(day);
		    List<WebElement> days = s.getOptions();
			for (WebElement Days : days) {
				System.out.println(Days.getText());
			}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}