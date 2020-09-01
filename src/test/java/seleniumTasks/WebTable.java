package seleniumTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[text()='Table']")).click();
		driver.findElement(By.xpath("(//a[@href='./table-search-filter-demo.html'])[2]")).click();

		List<WebElement> allRow = driver.findElements(By.tagName("tr"));
		int m = allRow.size() / 2;
		int l = allRow.size();

		WebElement middleRow = allRow.get(m);
		List<WebElement> middleValues = middleRow.findElements(By.tagName("td"));
		for (WebElement middle : middleValues) {
			System.out.println(middle.getText());
		}

		WebElement lastRow = allRow.get(l-1);
		List<WebElement> last = lastRow.findElements(By.tagName("td"));
		for (WebElement lastValues : last) {
			System.out.println(lastValues.getText());

		}
	}
}
