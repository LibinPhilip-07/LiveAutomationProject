package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_004 {

	@Test
	public void verifyRegWithoutData() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		String actualWarningFname="First Name must be between 1 and 32 characters!";
		String actualWarningLname="Last Name must be between 1 and 32 characters!";
		String actualWarningEmail="E-Mail Address does not appear to be valid!";
		String actualWarningTel="Telephone must be between 3 and 32 characters!";
		String actualWarningPswd="Password must be between 4 and 20 characters!";
		String actualWarningPrivacy="Warning: You must agree to the Privacy Policy!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText(), actualWarningFname);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText(), actualWarningLname);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText(), actualWarningEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText(), actualWarningTel);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText(), actualWarningPswd);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText(), actualWarningPrivacy);
		
		driver.quit();
		
		

	}

}
