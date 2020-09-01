package listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		EventFiringWebDriver eHandler = new EventFiringWebDriver(driver);
		EventCapture eCapture = new EventCapture();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		eHandler.register(eCapture);
		eHandler.navigate().to("https://www.edureka.co/blog/");
		eHandler.findElement(By.id("wzrk-cancel")).click();
		
		
		
	}
}
