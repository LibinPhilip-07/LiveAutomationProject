package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_007 {
	
	@Test
	public void verifyDiffWaystoRegAcc() throws InterruptedException {
		
		//Verify different ways of navigating to 'Register Account' page
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).isDisplayed());
		
		driver.quit();
	}

}
