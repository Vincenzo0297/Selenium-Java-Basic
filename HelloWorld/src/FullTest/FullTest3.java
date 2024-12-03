package FullTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FullTest3 {
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// Sibling - Child to parent traverse
		
		//header/div/button[1]/following-sibling::button[1]
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		 // **Step 1: Find the button**
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText());
		
		
		// **Step 2: Alert button**
		String text="Rahul";
		driver.findElement(By.id("name")).sendKeys(text);
		
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000L);
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000L);
		driver.switchTo().alert().dismiss();
		
		
		// **Step 3: Scroll the table and Calculate the sums **
		JavascriptExecutor js = (JavascriptExecutor)driver;
        
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        
        
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        
        
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); //4th column to calculate the sum //List of array 
        int sum = 0;
        for(int i=0; i<values.size(); i++) {
        	sum = sum + Integer.parseInt(values.get(i).getText()); //51
        }
        System.out.println(sum);
        
        driver.findElement(By.cssSelector(".totalAmount")).getText();
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        
        Assert.assertEquals(sum, total);
        Thread.sleep(2000L);
        
        
		
		// **Step 4: Maximize webpage button**
		driver.manage().window().maximize();  // Maximize the browser window to ensure all elements are visible
	    driver.get("http://google.com"); // Open the Google homepage
	    Thread.sleep(2000L);
	    driver.get("http://youtube.com");
	    Thread.sleep(2000L);
	    driver.navigate().to("https://rahulshettyacademy.com/");  // Navigate to another URL (Rahul Shetty Academy)
	    Thread.sleep(2000L);
	        
	    driver.navigate().back(); // Navigate back to the previous page (Google homepage)
	    driver.navigate().forward();  // Navigate forward to the next page (Rahul Shetty Academy)
	}

}
