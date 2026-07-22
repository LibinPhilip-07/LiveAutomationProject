package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_016 {
	@Test
	public void varifyMandatoryFieldsNotAcceptingSpaces()
	{
		//Verify whether the Mandatory fields in the Register Account page are not accepting only spaces
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("");
		driver.findElement(By.id("input-lastname")).sendKeys("");
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-telephone")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).isDisplayed());
		String expectedFnameWrng="First Name must be between 1 and 32 characters!";
		String expectedLnameWrng="Last Name must be between 1 and 32 characters!";
		String expectedEmailWrng="E-Mail Address does not appear to be valid!";
		String expectedTelWrng="Telephone must be between 3 and 32 characters!";
		String expectedPswdWrng="Password must be between 4 and 20 characters!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText(), expectedFnameWrng);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText(), expectedLnameWrng);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText(), expectedEmailWrng);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText(), expectedTelWrng);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText(), expectedPswdWrng);
		
		driver.quit();
		
	}

}
