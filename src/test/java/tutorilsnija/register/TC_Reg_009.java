package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_009 {
	
	@Test
	public void verifyRegAccUsingExixstingAcc() {
		//Verify Registering an Account by providing the existing account details (i.e. existing email address)
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Jokkuttan");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys("Jo@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("0225732210");
		driver.findElement(By.id("input-password")).sendKeys("abc123");
		driver.findElement(By.id("input-confirm")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		String expectedMsg="Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText(), expectedMsg);
		driver.quit();

	}

}
