package tutorilsnija.register;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Reg_023 {
	@Test
	public void verifyWorkingofEveryLinkInRegAcc() {
		//verify working of each and every link of register account page 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/a/i")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"information-contact\"]/ul/li[2]/a")).isDisplayed());
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/ul/li[3]/a")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"error-not-found\"]/ul/li[2]/a")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"error-not-found\"]/ul/li[2]/a")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"logo\"]/h1/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-search\"]/ul/li[2]/a")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[2]/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/ul/li[3]/a")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//ul[@class='breadcrumb']//i[@class='fa fa-home']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/p/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/ul/li[3]/a")).isDisplayed());
		driver.navigate().back();
		
		
		
	}


}
