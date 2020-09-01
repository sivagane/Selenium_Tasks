package seleniumTasks;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TwitterRegisteration {

	WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://twitter.com/i/flow/signup");
	}
	
	@Test
	public void registeration() throws InterruptedException {
		driver.findElement(By.name("name")).sendKeys("SivaGanesh");
		driver.findElement(By.name("phone_number")).sendKeys("8248879248");
	    Select s1 = new Select(driver.findElement(By.xpath("//select[@aria-label='Month']")));
	    s1.selectByIndex(8);
	    Select s2 = new Select(driver.findElement(By.xpath("//select[@aria-label='Day']")));
	    s2.selectByValue("8");
	    Select s3 = new Select(driver.findElement(By.xpath("//select[@aria-label='Year']")));
	    s3.selectByVisibleText("1990");
	    driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
	    driver.findElement(By.xpath("//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj "
	    		+ "r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs "
	    		+ "r-bcqeeo r-q4m81j r-qvutc0']")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}