package tutorilsnija.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_Reg_003 {

	@Test
	public void verifyRegAccWithAllField() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//span[text()='My Account']")).click(); 
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("23456789");
		driver.findElement(By.id("input-password")).sendKeys("Jomon");
		driver.findElement(By.id("input-confirm")).sendKeys("Jomon");
		driver.findElement(By.xpath("//input[@name='newsletter']['@value=1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value=1]")).click();
		driver.findElement(By.xpath("//input[@type='submit'][@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"common-success\"]/ul/li[3]/a")).isDisplayed());
		
		String expectedProp1="Your Account Has Been Created!";
		String expectedProp2="Congratulations! Your new account has been successfully created!";
		String expectedProp3="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProp4="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProp5="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expectedProp6="contact us.";
		String actualPropDetails=driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(actualPropDetails.contains(expectedProp1));
		Assert.assertTrue(actualPropDetails.contains(expectedProp2));
		Assert.assertTrue(actualPropDetails.contains(expectedProp3));
		Assert.assertTrue(actualPropDetails.contains(expectedProp4));
		Assert.assertTrue(actualPropDetails.contains(expectedProp5));
		Assert.assertTrue(actualPropDetails.contains(expectedProp6));
		
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	public String generateEmail()
	{
		Date date=new Date();
		String stringDate= date.toString();
		String noSpaceString=stringDate.replaceAll("\\s", "");
		String replacedString=noSpaceString.replaceAll("\\:","");
		String emailWithTime=replacedString+"@gmail.com";
		return emailWithTime;
	}

}
 