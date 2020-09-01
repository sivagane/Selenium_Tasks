package seleniumTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPopup {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("http://www.popuptest.com/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     WebElement clickElement = driver.findElement(By.xpath("//a [contains(text(),'Click here to test..')]"));
	     
	     String parentWHandle = driver.getWindowHandle();
	     JavascriptExecutor js =(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView(true)", clickElement);
	     
	     clickElement.click();
	     
	     driver.findElement(By.xpath("//a [@href=\"javascript:winopen('http://www.popuptest.com/popup3.html','blank','width=450,height=235,status=yes')\"]")).click();
	     driver.switchTo().window(parentWHandle);
	     driver.findElement(By.xpath("//a[@href='http://www.popuptest.com/popup2.html']")).click();
	     driver.switchTo().window(parentWHandle);
	     driver.findElement(By.xpath("//a[@href='http://www.popuptest.com/popup3.html']")).click();
	     driver.switchTo().window(parentWHandle);
	     driver.findElement(By.xpath("//a[@href=\"javascript:PopWindow('http://www.popuptest.com/popup4.html', 450, 320)\"]")).click();
	     driver.switchTo().window(parentWHandle);
	     
	     Set<String> windowHandles = driver.getWindowHandles();
	     List<String> li = new ArrayList<String>();
	     li.addAll(windowHandles);
	     String fifthWindow = li.get(4);
	     String thirdWindow = li.get(2);
	     driver.switchTo().window(fifthWindow);
	     Thread.sleep(3000);
	     driver.switchTo().window(thirdWindow);
	     
	     
	     
	     
	}
}
