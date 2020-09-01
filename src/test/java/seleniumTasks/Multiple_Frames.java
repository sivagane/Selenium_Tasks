package seleniumTasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Frames {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.ecanarys.com/Blogs/ArticleID/326/What-is-Synchronization-Handling-Synchronization-in-Selenium-WebDriver-using-C");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     WebElement frmDev = driver.findElement(By.xpath("//iframe[@name='f16907ef21b1728']"));
	     WebElement adFrame = driver.findElement(By.xpath("//iframe[@id='addFrame1']"));
	     WebElement queryFrame= driver.findElement(By.xpath("//iframe[@id='oc_iframe']"));
	     
	     WebElement share = driver.findElement(By.xpath("//h4[text()='Share']"));
	     
	     JavascriptExecutor js = (JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView(true)", share);
	     driver.switchTo().frame(frmDev);
	     
	     Thread.sleep(3000);
	     
	     WebElement home = driver.findElement(By.xpath("(//a[@title='Canarys - IT Services | Azure & Azure DevOps Consulting | Mobility Solutions | Microsoft Dynamics | Genesys | ADM'])[2]"));
	     js.executeScript("arguments[0].scrollIntoView(false)", home);
	     driver.switchTo().frame(adFrame);
	     Thread.sleep(3000);
	     driver.switchTo().frame(queryFrame);
	     Thread.sleep(3000);
	     
	     

	}

}
