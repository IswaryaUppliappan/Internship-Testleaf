package testleafinternship.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OppDelete {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement opp=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
        driver.executeScript("arguments[0].click();", opp);
        WebElement k = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
        k.sendKeys("Salesforce Automation by Iswarya");  
        k.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();
        WebElement s = driver.findElement(By.xpath("//div[text()='Delete']"));
        driver.executeScript("arguments[0].click();", s);
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Opportunity \"Salesforce Automation by Iswarya\" was deleted. Undo";
		Assert.assertEquals(actual_Result,expected_Result);
      

	}

}
