package seleniumTasks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Finding_Number_Of_Links {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
        
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement link : links) {
			System.out.println(link.getText());
			}
		int linksCount = links.size();
		
		System.out.println("Total Number of Links in Google Page is "+linksCount);
		
		System.out.println("Done..");
		
		driver.quit();
	}

}
