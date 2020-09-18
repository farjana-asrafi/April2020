package testTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTestNG {

	WebDriver dr;

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Palak\\Selenium\\Session6\\driver\\chromedriver.exe");
		dr = new ChromeDriver();

		dr.manage().window().maximize();

		dr.get("https://www.techfios.com/ibilling/?ng=login/");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void test() {

		WebElement userName = dr.findElement(By.xpath("//input[@id = 'username']"));
		userName.sendKeys("demo@techfios.com");

		WebElement password = dr.findElement(By.xpath("//input[@id = 'password']"));
		password.sendKeys("abc123");

		WebElement signIn = dr.findElement(By.xpath("//button[@name= 'login']"));
		signIn.click();

	}

	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		dr.close();
	}
}
