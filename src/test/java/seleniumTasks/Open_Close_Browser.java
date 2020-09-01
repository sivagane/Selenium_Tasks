package seleniumTasks;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_Close_Browser {

	static WebDriver driver;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String value = s.nextLine();
		if(value.equalsIgnoreCase("OpenBrowser")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		}
		else if(value.equalsIgnoreCase("CloseBrowser")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.close();
		}

	}

}
