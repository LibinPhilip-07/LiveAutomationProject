package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilForTesing.commonUtils;

public class TC_Reg_021 {
	@Test
	public void vefifyRegAccWithoutSelectPrivacyPolicy() {
		//verify Register account without selecting privacy policy 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Jokkuttan");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.emailGenerator());
		driver.findElement(By.id("input-telephone")).sendKeys("0225732210");
		driver.findElement(By.id("input-password")).sendKeys("123456789");
		driver.findElement(By.id("input-confirm")).sendKeys("123456789");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		String expctdWarningMsg="Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText(), expctdWarningMsg);
		
		driver.quit();
	}

}
