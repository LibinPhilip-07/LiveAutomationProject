package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC_Reg_022 {
	@Test
	public void verifyRegAccPswdFieldisToggledVisibility() {
		//Check the visibility of password and password confirm field is toggled visibility
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("type"), "password");
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("type"), "password");
		
		driver.quit();
	}

}
