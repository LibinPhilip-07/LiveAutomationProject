package tutorilsnija.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_001 {

	@Test
	public void registerWithMandatoryFields() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Jomon");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys(emailGeneratorMethod());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("Password");
		driver.findElement(By.id("input-confirm")).sendKeys("Password");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading="Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(), expectedHeading);
		
		String expectedContent1="Congratulations! Your new account has been successfully created!";
		String expectedContent2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedContent3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText(), expectedContent1);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText(), expectedContent2);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]")).getText(), expectedContent3);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		

	}
	public String emailGeneratorMethod()
	{
		Date date=new Date();
		String stringDate= date.toString();
		String noSpaceString=stringDate.replaceAll("\\s", "");
		String replacedString=noSpaceString.replaceAll("\\:","");
		String emailWithTime=replacedString+"@gmail.com";
		return emailWithTime;
	}

}
