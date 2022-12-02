package week5day2Assignment;
/*Asssignment 2:Create new Proposal (https://dev111725.service-now.com/
"1. Launch ServiceNow application
2. Login with valid credential 
3. Click All and Enter Proposal in filter navigator and press enter 
4. Click- new  and  fill mandatory fields and click 'Submit' 
Button.
5. Verify the successful creation of new Proposal"*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProfile {

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
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("My Proposals",Keys.ENTER);
		shadow.findElementByXPath("//span[@class='item-icon']").click();
		WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//span[@class='label-text']/following::input[40][1]")).sendKeys("Replace color  to pink");
		driver.findElement(By.xpath("(//span[text()='Change Request values'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='select2-chosen'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='s2id_autogen6_search']")).sendKeys("Review Comments");
		driver.findElement(By.xpath("//span[text()='Review comments']")).click();
		driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[1]")).sendKeys("Good product");
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		driver.close();
		
	}

}
