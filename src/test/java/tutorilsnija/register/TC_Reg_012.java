package tutorilsnija.register;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilForTesing.commonUtils;

public class TC_Reg_012 {
	@Test
	public void verifyRegAccUsingKeyboardKeys() {
		//Verify Registering an Account by using the Keyboard keys
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		Actions actn=new Actions(driver);
		for(int i=1;i<=23;i++) {
		actn.sendKeys(Keys.TAB).perform();
		}
		actn.sendKeys("Jokkuttan").perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys("Jose").perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys(commonUtils.emailGenerator()).perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys("123456").perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys("abcd").perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys("abcd").perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys(Keys.ARROW_LEFT).perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys(Keys.TAB).perform();
		actn.sendKeys(Keys.SPACE).perform();
		actn.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"common-success\"]/ul/li[3]/a")).isDisplayed());
		
		driver.quit();

	}
	

}
