package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_013 {
	@Test
	public void verifyPlaceHoldersRegAcc() {
		//Verify all the fields in the Register Account page have the proper place holders
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		String expectedFnamePlaceholder="First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), expectedFnamePlaceholder);
		
		String expectedLnamePlaceHolder="Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), expectedLnamePlaceHolder);
		
		String expectedEmailPlaceHolder="E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), expectedEmailPlaceHolder);
		
		String expectedTelPlaceHolder="Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expectedTelPlaceHolder);
		
		String expectedPswdPlaceHolder="Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), expectedPswdPlaceHolder);
		
		String expectedCnfrmPswdPlaceHolder="Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expectedCnfrmPswdPlaceHolder);
		
		
		driver.quit();

	}

}
