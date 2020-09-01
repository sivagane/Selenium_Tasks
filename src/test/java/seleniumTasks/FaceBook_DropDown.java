package seleniumTasks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook_DropDown {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

		Select s1 = new Select(driver.findElement(By.id("day")));
		boolean s1Mul = s1.isMultiple();
		System.out.println(s1Mul);
		List<WebElement> s1Options = s1.getOptions();
		for (WebElement s1Op : s1Options) {
			System.out.println(s1Op.getText());
		}
		s1.selectByIndex(8);
		WebElement s1Value = s1.getFirstSelectedOption();
		System.out.println(s1Value.getText());
		//s1.deselectAll();-For Only MultiSelect Dropdown only we can use deselectAll method.

		Select s2 = new Select(driver.findElement(By.id("month")));
		boolean s2Mul = s2.isMultiple();
		System.out.println(s2Mul);
		List<WebElement> s2Options = s2.getOptions();
		for (WebElement s2Op : s2Options) {
			System.out.println(s2Op.getText());
        }
		s2.selectByValue("9");
		WebElement s2Value = s2.getFirstSelectedOption();
		System.out.println(s2Value.getText());
		//s2.deselectAll();

		Select s3 = new Select(driver.findElement(By.id("year")));
		boolean s3Mul = s3.isMultiple();
		System.out.println(s3Mul);
		List<WebElement> s3Options = s3.getOptions();
		for (WebElement s3Op : s3Options) {
			System.out.println(s3Op.getText());
        }
		s3.selectByVisibleText("1990");
		WebElement s3Value = s3.getFirstSelectedOption();
		System.out.println(s3Value.getText());
		//s3.deselectAll();
	}
}
