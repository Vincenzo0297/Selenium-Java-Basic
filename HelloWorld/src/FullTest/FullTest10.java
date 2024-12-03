package FullTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FullTest10 {
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		String monthNumber = "6";
		
		String date = "15";
		
		String year = "2027";
		
		String[] expectedList = {monthNumber,date,year};
		
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(1000L);
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		Thread.sleep(1000L);
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		Thread.sleep(1000L);
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		Thread.sleep(1000L);
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		Thread.sleep(1000L);
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		Thread.sleep(1000L);
		
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		Thread.sleep(1000L);
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		Thread.sleep(1000L);

		for(int i =0; i<actualList.size();i++){
		
			System.out.println(actualList.get(i).getAttribute("value"));
			
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
			Thread.sleep(1000L);
			
		}
	}
}
