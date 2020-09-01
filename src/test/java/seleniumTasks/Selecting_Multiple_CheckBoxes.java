package seleniumTasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selecting_Multiple_CheckBoxes {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/radio.html");

		WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='checkbox1']"));
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='checkbox2']"));
		WebElement checkBox3 = driver.findElement(By.xpath("//input[@value='checkbox3']"));

		if (checkBox1.isSelected()) {
			System.out.println("The CheckBox1 is already Selected");
		} else {
			checkBox1.click();
			System.out.println("CheckBox1 is Selected");
		}
		
		if (checkBox2.isSelected()) {
			System.out.println("The CheckBox2 is already Selected");
		} else {
			checkBox2.click();
			System.out.println("CheckBox2 is Selected");
		}

		if (checkBox3.isSelected()) {
			System.out.println("The CheckBox3 is already Selected");
		} else {
			checkBox3.click();
			System.out.println("CheckBox3 is Selected");
		}
		
		System.out.println("Done..");
	}
}
