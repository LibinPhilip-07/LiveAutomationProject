package tutorilsnija.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_006 {
	
	@Test
	public void verifyRegAccWithNewsletterNoSelect()
	{
//		Check 
//		"1. User should be logged in,  taken to 'Account Success' page and proper details should be displayed on the page
//		2. User should be taken to 'Account' page 
//		3. 'No' option should be displayed as selected by default in the Newsletter page"

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Jokkuttan");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys(emailGen());
		driver.findElement(By.id("input-telephone")).sendKeys("234567");
		driver.findElement(By.id("input-password")).sendKeys("abcde");
		driver.findElement(By.id("input-confirm")).sendKeys("abcde");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[4]/li/a")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-newsletter\"]/ul/li[3]/a")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[2]/input")).isSelected());
		
		driver.quit();
		
	}
	public String emailGen()
	{
		Date date=new Date();
		String dateEmail=date.toString();
		String dEmail=dateEmail.replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		return dEmail;
	}

}
