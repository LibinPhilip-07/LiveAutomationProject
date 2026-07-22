package tutorilsnija.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_018 {
	@Test
	public void verifyRegAccFirldHghtWdthEtc() {
		//Verify whether the fields in the Register Account page are according the Client requirements (Examples- Height, Width, Number of characters etc.)
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		String wrng=driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		System.out.println(wrng);
		WebElement fName = driver.findElement(By.id("input-firstname"));
		String fNameWdth=fName.getCssValue("width");
		String fNameHght=fName.getCssValue("height");
		Assert.assertEquals(fNameWdth, "701.253px");
		Assert.assertEquals(fNameHght, "33.9906px");
		String lNameHght=driver.findElement(By.id("input-lastname")).getCssValue("height");
		String lNameWdth=driver.findElement(By.id("input-lastname")).getCssValue("width");
		Assert.assertEquals(lNameWdth, "701.253px");
		Assert.assertEquals(lNameHght, "33.9906px");
		String eMailHght=driver.findElement(By.id("input-email")).getCssValue("height");
		String eMailWdth=driver.findElement(By.id("input-email")).getCssValue("width");
		Assert.assertEquals(eMailWdth, "701.253px");
		Assert.assertEquals(eMailHght, "33.9906px");
		String telHght=driver.findElement(By.id("input-telephone")).getCssValue("height");
		String telWdth=driver.findElement(By.id("input-telephone")).getCssValue("width");
		Assert.assertEquals(telWdth, "701.253px");
		Assert.assertEquals(telHght, "33.9906px");
		String pswdHght=driver.findElement(By.id("input-password")).getCssValue("height");
		String pswdWdth=driver.findElement(By.id("input-password")).getCssValue("width");
		Assert.assertEquals(pswdWdth, "701.253px");
		Assert.assertEquals(pswdHght, "33.9906px");
		String cPswdHght=driver.findElement(By.id("input-confirm")).getCssValue("height");
		String cPswdWdth=driver.findElement(By.id("input-confirm")).getCssValue("width");
		Assert.assertEquals(cPswdWdth, "701.253px");
		Assert.assertEquals(cPswdHght, "33.9906px");
		driver.quit(); 
	}

}
