package seleniumTasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Adactin {

	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://adactin.com/");
		
		String ActualTitle = driver.getTitle();
		
		Assert.assertEquals(ActualTitle, "Australian IT Consulting Company | Microsoft, SAP, "
				+ "Adobe, Guidewire specialist - Sydney, Melbourne, Canberra, Brisbane | Adactin");
		System.out.println("Done..");
		driver.close();

	}

}
