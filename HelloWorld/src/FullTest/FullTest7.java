package FullTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullTest7 {
	public static void main(String[] args) {
	    // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
        
        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the login page
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        
        // Click on the blinking text link to open a new window
        driver.findElement(By.cssSelector(".blinkingText")).click();
        
        // Get all open window handles (parent and child windows)
        Set<String> windows = driver.getWindowHandles(); // Returns a Set of window handles  //Name the Java collection framework used to store window ids.
        
        // Create an Iterator to traverse through the window handles
        Iterator<String> it = windows.iterator();
        
        // Get the parent window handle
        String parentId = it.next();
        
        // Get the child window handle
        String childId = it.next();
        
        // Switch the WebDriver's focus to the child window
        driver.switchTo().window(childId);
        
        // Print the red text (email instructions) from the child window
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        
        // Retrieve the text from the red paragraph
        driver.findElement(By.cssSelector(".im-para.red")).getText();
        
        // Extract the email address from the red text
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText()
                           .split("at")[1] // Split the string at "at" and take the second part
                           .trim()         // Trim leading and trailing whitespace
                           .split(" ")[0]; // Split the string at the first space and take the first part
        
        // Switch the WebDriver's focus back to the parent window
        driver.switchTo().window(parentId);
        
        // Enter the extracted email address into the username input field
        driver.findElement(By.id("username")).sendKeys(emailId);
	}
}
