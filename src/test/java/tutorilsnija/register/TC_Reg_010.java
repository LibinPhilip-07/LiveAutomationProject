package tutorilsnija.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_Reg_010 {
	@Test
	public void verifyregAccwithInvalidEmail() throws IOException, InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Jokkuttan");
		driver.findElement(By.id("input-lastname")).sendKeys("Jose");
		driver.findElement(By.id("input-email")).sendKeys("amootori");
		driver.findElement(By.id("input-telephone")).sendKeys("12456789");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		Thread.sleep(3000);
		
		File srcScreenShot1=driver.findElement(By.xpath("//*[@id=\"content\"]")).getScreenshotAs(OutputType.FILE);
		File dest=new File("ScreenShots/actualWrng.png");
		FileUtils.copyFile(srcScreenShot1, dest);
		
		BufferedImage atualBufferedImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\ScreenShots\\actualWrng.png"));
		BufferedImage expectedBufferImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\ScreenShots\\expectedImg.png"));
		
		ImageDiffer imgDiffer=new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBufferImg, atualBufferedImg);
		boolean diffVal = imgDifference.hasDiff();
		Assert.assertFalse(diffVal);
		
		driver.quit();
	}
	

}
