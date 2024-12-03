package FullTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FullTest8 {
	public static void main(String[] args) {
		 // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
        
        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the page with the drag-and-drop functionality
        driver.get("https://jqueryui.com/droppable/");
        
        // Correctly find all iframe elements and get their count
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        
        // Switch to the first iframe
        driver.switchTo().frame(0);

        // Alternative way to switch to iframe using WebElement (uncomment if needed)
        // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        
        // Create an instance of the Actions class
        Actions a = new Actions(driver);

        // Locate the draggable and droppable elements inside the iframe
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        // Perform the drag-and-drop action
        a.dragAndDrop(source, target).build().perform();

        // Switch back to the main content of the page
        driver.switchTo().defaultContent();
	}
}
