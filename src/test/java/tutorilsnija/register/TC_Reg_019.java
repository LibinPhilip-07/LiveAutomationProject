package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utilForTesing.commonUtils;

public class TC_Reg_019 {
	WebDriver driver;
	@AfterMethod
	public void closeBrwsr() {
		driver.quit();
	}
	@Test
	public void verifyLeadingAndTrailingSpacesEnteredIntoRegAcc() {
		//Verify whether the leading and trailing spaces entered into the Register Account fields are trimmed
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		String fName="  Jokkuttan ";
		driver.findElement(By.id("input-firstname")).sendKeys(fName);
		String lName="   Jose   ";
		driver.findElement(By.id("input-lastname")).sendKeys(lName);
		String eMail="   "+commonUtils.emailGenerator()+"   ";
		driver.findElement(By.id("input-email")).sendKeys(eMail);
		String telPhone=" 0225732210   ";
		driver.findElement(By.id("input-telephone")).sendKeys(telPhone);
		driver.findElement(By.id("input-password")).sendKeys("1234567");
		driver.findElement(By.id("input-confirm")).sendKeys("1234567");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).click();
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), fName.trim());
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), lName.trim());
		Assert.assertEquals(driver.findElement(By.xpath("input-email")).getAttribute("Value"), eMail.trim());
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), telPhone.trim());
	
	
	}

}
