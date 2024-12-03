package FullTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FullTest6 {
    public static void main(String[] args) {
        // Set the system property to specify the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");

        // Create a new instance of ChromeDriver to launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Amazon homepage
            driver.get("https://www.amazon.com/");
            
            // Create an instance of the Actions class for advanced user interactions
            Actions a = new Actions(driver);

            // Set up an explicit wait to handle dynamic content loading
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the "Account & Lists" element to be visible
            WebElement move = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a[id='nav-link-accountList']")));

            // Perform actions on the search button and enter text with shift key pressed
            WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("twotabsearchtextbox"))); // Assuming "twotabsearchtextbox" is the search bar's ID
            
            a.moveToElement(searchButton)
             .click()
             .keyDown(Keys.SHIFT)
             .sendKeys("hello")
             .doubleClick()
             .build()
             .perform();

            // Perform a context-click on the "Account & Lists" menu
            a.moveToElement(move)
             .contextClick()
             .build()
             .perform();

            System.out.println("Actions performed successfully.");
        } catch (Exception e) {
            // Print the error message if something goes wrong
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
