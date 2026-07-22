package tutorilsnija.register;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilForTesing.commonUtils;

public class TC_Reg_017 {
	

	WebDriver driver;
	@AfterMethod
	public void closeBrwsr() {
		driver.quit();
	}
	@Test(dataProvider = "pswdSupplier")
	public void verifyPswdComplexityStd(String pswdTxt) {
		//Verify whether the Password fields in the Register Account page are following Password Complexity Standards
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Jokkuttan");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.emailGenerator());
		driver.findElement(By.id("input-telephone")).sendKeys("0225732210");
		driver.findElement(By.id("input-password")).sendKeys(pswdTxt);
		driver.findElement(By.id("input-confirm")).sendKeys(pswdTxt);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		String expectedPswdWrngMsg="Password entered is not meeting the Passwor complexity standard !";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText(), expectedPswdWrngMsg);
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"common-success\"]/ul/li[3]/a")).isDisplayed());

	}
	@DataProvider(name="pswdSupplier")
	public Object[][] supplyPaswd() {
		Object[][] data= {{"12345"},{"abcdefghi"},{"abcd1234"},{"abcd123@"},{"ABCD123$"}};
		return data;
	}

}
