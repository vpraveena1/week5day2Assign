package week5day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/*Assignment 4:Fill mandatory fields (https://dev111725.service-now.com/)
"1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Knowledge  in filter navigator and press enter
4. Create new Article 
5.Select knowledge base as IT and category as IT- java and Click Ok
6.Update the other mandatory fields
7.Select the submit option*/
public class FillMandatory {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.get("https://dev107173.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("iGl9apX7W!G^");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.findElementByXPath("//mark[text()='Knowledge']").click();
	    WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//span[text()='Knowledge base']/following::input[4]")).sendKeys("IT",Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		//driver.findElement(By.xpath("//span[text()='Category']/following::input[4]")).sendKeys("Java",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Short description']/following::input[2]")).sendKeys("Java Knowledge");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		driver.close();
	}

}
