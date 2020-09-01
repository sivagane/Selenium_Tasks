package seleniumTasks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail_userName_Verification {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\Downloads\\GeckoDriver v 27.0\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/login/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.findElement(By.name("identifier")).sendKeys("sivag918@gmail.com");
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		
		driver.findElement(By.name("password")).sendKeys("siva08091990");
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb' and @xpath='1']")).click();
		
		List<WebElement> Emails = driver.findElements(By.xpath("//div[@role='checkbox']"));
		int noOfEmails = Emails.size();
		
		List<WebElement> names = driver.findElements(By.xpath("//span[@class='bA4']//child::span[@email]"));
		for (WebElement name : names) {
			System.out.println(name.getText());
		}
	}

}
