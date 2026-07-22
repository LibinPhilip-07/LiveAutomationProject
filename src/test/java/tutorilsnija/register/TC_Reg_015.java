package tutorilsnija.register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilForTesing.commonUtils;

public class TC_Reg_015 {
	@Test
	public void varifyRegAccDetailsStoredInDB() throws InterruptedException, SQLException
	{
		//Verify the details that are provided while Registering an Account are stored in the Database
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost/opencart/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String firstNameInputData = "Arun";
		driver.findElement(By.id("input-firstname")).sendKeys(firstNameInputData);
		
		String lastNameInputData = "Motoori";
		driver.findElement(By.id("input-lastname")).sendKeys(lastNameInputData);
		
		String emailInputData = commonUtils.emailGenerator();
		driver.findElement(By.id("input-email")).sendKeys(emailInputData);
		
		String passwordInputData = "Jo12345";
		driver.findElement(By.id("input-password")).sendKeys(passwordInputData);
		
		WebElement element = driver.findElement(By.id("input-newsletter"));

		((JavascriptExecutor) driver).executeScript(
		    "arguments[0].scrollIntoView({block:'center'});", element);

		Thread.sleep(500); // Prefer an explicit wait in real tests

		element.click();
		
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		String dbURL = "jdbc:mysql://localhost:3306/opencart_db";
		String username = "root";
		String password = "";
		
		Connection con=DriverManager.getConnection(dbURL, username , password);
		String query="SELECT * FROM oc_customer WHERE email=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, emailInputData);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Customer found in DB");
			System.out.println("First Name : " + rs.getString("firstname"));
		    System.out.println("Last Name  : " + rs.getString("lastname"));
		    System.out.println("Email      : " + rs.getString("email"));
		}
		else {
			System.out.println("Customer NOT found in database");
		}
		rs.close();
		rs.close();
		con.close();
		
	}
	

}
