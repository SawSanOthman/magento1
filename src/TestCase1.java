import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class TestCase1 {

	WebDriver driver = new ChromeDriver();
	String WebSite = "https://magento.softwaretestingboard.com";

	String[] FNames = { "Sawsan", "Sama", "Lamar", "Masa" };
	String[] LNames = { "Anas", "Ahmad", "Ghaith" };

	Random rand = new Random();

	int RandomOfIndexFNames = rand.nextInt(FNames.length);
	int RandomOfIndexLNames = rand.nextInt(LNames.length);

	String UserFirstName = FNames[RandomOfIndexFNames];
	String UserLasttName = LNames[RandomOfIndexLNames];

	int RandomOfNumber = rand.nextInt(78451);

	String DomainName = "@gmail.com";

	String Password1 = "mesk123@";
	String EmailInput = UserFirstName + UserLasttName + RandomOfNumber + DomainName;
//String GlobalEmailInput ="";

	@BeforeTest
	public void SetUp() {

		driver.manage().window().maximize();
		driver.get(WebSite);

	}

	@Test(priority = 1)
	public void SignUp() throws InterruptedException {

		driver.findElement(By.linkText("Create an Account")).click();

		WebElement FNInput = driver.findElement(By.id("firstname"));
		FNInput.sendKeys(UserFirstName);

		WebElement LNInput = driver.findElement(By.id("lastname"));
		LNInput.sendKeys(UserLasttName);
		
		WebElement EInput = driver.findElement(By.id("email_address"));
		EInput.sendKeys(UserFirstName + UserLasttName + RandomOfNumber + DomainName);
		
				
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys(Password1);

		WebElement ConfirmPasswordInput = driver.findElement(By.id("password-confirmation"));
		ConfirmPasswordInput.sendKeys(Password1);
		Thread.sleep(3000);
		WebElement CreateInput = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		CreateInput.click();

	}

	@Test(priority = 2)
	public void LogOut() {

		 String LogOutUrl =
		"https://magento.softwaretestingboard.com/customer/account/logout/";
		driver.get(LogOutUrl);

	}

	@Test(priority=3)
	
	public void LogIn () throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign In")).click();
		
		WebElement EmailInput1 = driver.findElement(By.id("email"));
		EmailInput1.sendKeys(EmailInput);
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(Password1);
		Thread.sleep(2000);
		WebElement SigninButton = driver.findElement(By.id("send2"));
		SigninButton.click();
	}
	
	
	
	
	
	
}
