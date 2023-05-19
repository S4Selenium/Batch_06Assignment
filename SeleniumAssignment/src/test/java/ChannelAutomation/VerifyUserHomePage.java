package ChannelAutomation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyUserHomePage {

	public static WebDriver driver;

	@BeforeMethod
	public void Init() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.channel4.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void VerifyUserNavigationInHome() throws InterruptedException {
        Thread.sleep(3000);
        
	WebElement ele=	driver.findElement(By.xpath("//span[text()='Accept & Continue']"));
	JavascriptExecutor executor  = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", ele);
		driver.findElement(By.xpath("//a[@id='home-link']")).click();
		driver.findElement(By.xpath("//a[@aria-label='Search, click to expand']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Made in Chelsea");
		driver.findElement(By.xpath("//ul/li[@tabindex='-1'][1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in to play')]")).click();
		driver.findElement(By.xpath("(//button)[3]")).click();
		Thread.sleep(5000);
		String color="rgba(170, 255, 137, 1)";
		WebElement Forele=driver.findElement(By.xpath("(//div[@class='text-button__inner'])[1]"));
		String colourvalue =Forele.getCssValue("background-color");
		System.out.println(colourvalue);
		Assert.assertEquals(colourvalue,color);
	
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
