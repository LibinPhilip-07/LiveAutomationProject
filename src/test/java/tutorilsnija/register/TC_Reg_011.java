package tutorilsnija.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_Reg_011 {
	
	WebDriver driver;
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	@Test
	public void verifyRegAccWithInvalidPhn() {
		//Verify Registering an Account by providing an invalid phone number 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Jokkuttan");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys(emailGen());
		driver.findElement(By.id("input-telephone")).sendKeys("abcde");
		driver.findElement(By.id("input-password")).sendKeys("abc123");
		driver.findElement(By.id("input-confirm")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		String expectedWrngMsg="Telephone number does not appeared to be valid";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWrngMsg);

	}
	public String emailGen() {
		Date date=new Date();
		String dateString=date.toString();
		String dateMail=dateString.replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		return dateMail;
	}

}
