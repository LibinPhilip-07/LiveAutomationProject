package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_Reg_014 {
	
	WebDriver driver;
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test
	public void verifyRegAccMandatoryFields() {
		//Verify all the mandatory fields in the Register Account page are marked with red color * symbol
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		JavascriptExecutor jsE=(JavascriptExecutor) driver;
		WebElement labelFname = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		String lblContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelFname);
		String lblColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelFname);
		Assert.assertEquals(lblContent, "\"* \"");
		Assert.assertEquals(lblColor, "rgb(255, 0, 0)");
		
		WebElement labelLname = driver.findElement(By.cssSelector("label[for=\"input-lastname\"]"));
		String LnamelblContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelLname);
		String LnamelblColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelLname);
		Assert.assertEquals(LnamelblContent, "\"* \"");
		Assert.assertEquals(LnamelblColor, "rgb(255, 0, 0)");
		
		WebElement labelEmail = driver.findElement(By.cssSelector("label[for=\"input-email\"]"));
		String EmaillblContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelEmail);
		String EmaillblColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelEmail);
		Assert.assertEquals(EmaillblContent, "\"* \"");
		Assert.assertEquals(EmaillblColor, "rgb(255, 0, 0)");
		
		WebElement labelTel = driver.findElement(By.cssSelector("label[for=\"input-telephone\"]"));
		String TellblContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelTel);
		String TellblColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelTel);
		Assert.assertEquals(TellblContent, "\"* \"");
		Assert.assertEquals(TellblColor, "rgb(255, 0, 0)");
		
		WebElement labelPswd = driver.findElement(By.cssSelector("label[for=\"input-password\"]"));
		String PswdlblContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelPswd);
		String PswdblColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelPswd);
		Assert.assertEquals(PswdlblContent, "\"* \"");
		Assert.assertEquals(PswdblColor, "rgb(255, 0, 0)");	
		
		WebElement labelCnfmPswd = driver.findElement(By.cssSelector("label[for=\"input-confirm\"]"));
		String CnfmPswdlblContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelCnfmPswd);
		String CnfmPswdblColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelCnfmPswd);
		Assert.assertEquals(CnfmPswdlblContent, "\"* \"");
		Assert.assertEquals(CnfmPswdblColor, "rgb(255, 0, 0)");	
		
		WebElement labelPrivacyPolicy = driver.findElement(By.cssSelector("[class='pull-right']"));
		String privacyPolicyContent= (String) jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelPrivacyPolicy);
		String privacyPolicyColor=(String)jsE.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelPrivacyPolicy);
		Assert.assertEquals(privacyPolicyContent, "\"* \"");
		Assert.assertEquals(privacyPolicyColor, "rgb(255, 0, 0)");	
		
		driver.quit();		
	}

}
