package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_Reg_020 {
	@Test
	public void verifyPrivacyFieldCheckedornotRegAcc() {
		//verify privacy policy field is not selected state in Register account page
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).isSelected());
		driver.quit();
	}

}
