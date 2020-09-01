import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_Commerce_Site {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.flipkart.com/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	     driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphones");
	     driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
	     
	     List<String> li = new ArrayList<String>();
	     List<WebElement> iphones = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
	     for (WebElement webElement : iphones) {
			String value = webElement.getText();
			li.add(value);
		}
         Set<String> se = new TreeSet<String>();
	     for (String x : li) {
			se.add(x);
		}
	     System.out.println("The Iphones Names in Ascending Order");
	     for (String y : se) {
			System.out.println(y);
		}
	     
	     List<String> li1 = new ArrayList<String>();
	     List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	     for (WebElement webElement1 : prices) {
			String value1 = webElement1.getText();
			li1.add(value1);
		}
	     Set<String> se1 = new TreeSet<String>();
	     for (String x1: li1) {
	    	 se1.add(x1);
		}
	     System.out.println("The Iphones Prices in Ascending Order");
	     for (String y1 : se1) {
			System.out.println(y1);
		}
	     
	     
	     
	     
	     
//	     for (WebElement webElement : iphones) {
//	    	 String value = webElement.getText();
//	    	 System.out.println(webElement.getText());
//			
//		}
	     
	     

	}

}
