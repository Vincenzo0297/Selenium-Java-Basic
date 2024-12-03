package FullTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullTest9 {
public static void main(String[] args) throws InterruptedException {
		
        // Set the system property to specify the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
        
        // Create a new instance of ChromeDriver to launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the Amazon homepage
        driver.get("https://qaclickacademy.com/practice.php");
        
        
        //1. Give the count of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size()); //27 tagName
        
        
        
        //2. count of footer section
        WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //Footer 
        System.out.println(footerdriver.findElements(By.tagName("a")).size()); // 20 tagName in footer link
        
        
        //3. count the column of the footer section
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());
        
        
        //4. click on each link in the column
        for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++) {
        	String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
        	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
        	Thread.sleep(1000L);
        	//Open all Tabs
        }
        
        // Retrieve all the window handles opened by the WebDriver session
        Set<String> abc = driver.getWindowHandles();

        // Create an iterator to traverse through the set of window handles
        Iterator<String> it = abc.iterator();

        // Loop through each window handle
        while (it.hasNext()) {
            // Switch to the next window/tab in the sequence
            driver.switchTo().window(it.next());

            // Get and print the title of the currently active window/tab
            System.out.println(driver.getTitle());
        }//The set and iteration is to get each of the website ID just to get the title
	}
}
