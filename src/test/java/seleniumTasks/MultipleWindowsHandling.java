package seleniumTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsHandling {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/s?k=iphonwa&ref=nb_sb_noss_2");
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Apple iPhone 11 (64GB) - Black'])[2]")).click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("(//span[text()='Apple iPhone 11 (64GB) - White'])[2]")).click();
		driver.switchTo().window(parentWindow);
		
		Set<String> allWin = driver.getWindowHandles();
	    List<String> li = new ArrayList<String>();
	    li.addAll(allWin);
	    System.out.println(li.size());
		for (int i=0;i<li.size();i++) {
			String win = li.get(i);
			WebDriver window = driver.switchTo().window(win);
			System.out.println(window.getTitle());
			Thread.sleep(3000);
			if(window.getTitle().equalsIgnoreCase("Apple iPhone 11 (64GB) - Black: Amazon.in")) {
				driver.switchTo().window(li.get(i));
			}
		}

	    driver.quit();
	}

}
