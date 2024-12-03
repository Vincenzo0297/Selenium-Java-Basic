package FullTest;

import java.util.Arrays; // For converting arrays to lists
import java.util.List; // For working with lists
import java.util.concurrent.TimeUnit; // Not used but typically for managing time-based waits

import org.openqa.selenium.By; // To locate elements in the DOM
import org.openqa.selenium.WebDriver; // Interface to control browser behavior
import org.openqa.selenium.WebElement; // Represents an HTML element
import org.openqa.selenium.chrome.ChromeDriver; // Driver for the Chrome browser
import org.openqa.selenium.support.ui.ExpectedConditions; // For explicit waits (not used in this code)
import org.openqa.selenium.support.ui.WebDriverWait; // To wait for elements to appear (not used here)

public class FullTest5 {

    public static void main(String[] args) throws InterruptedException {

        // Set the system property to specify the location of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
        
        // Create a new instance of ChromeDriver to control the browser
        WebDriver driver = new ChromeDriver();
        
        // Create an explicit wait object with a timeout of 5 seconds
        WebDriverWait w = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));


        // Define the list of items needed (vegetables to add to the cart)
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Cauliflower"};

        // Navigate to the target shopping webpage
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        
        // Pause execution for 3 seconds to allow the page to load
        Thread.sleep(3000);

        // Call the addItems method to add the required items to the cart
        addItems(driver, itemsNeeded);
        
        
     // Click on the cart icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        // Click the "Proceed to Checkout" button
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // Wait until the promo code input field is visible
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        // Enter the promo code into the input field
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        // Click the "Apply" button for the promo code
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Wait until the promo information message is visible
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        // Print the promo information message to the console
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    // Method to add specified items to the cart
    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0; // Counter to track how many items have been added

        // Find all product names on the page (e.g., "Brocolli - 1 Kg")
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        // Loop through the list of products
        for (int i = 0; i < products.size(); i++) {
            
            // Split the product name by "-" to separate the vegetable name and weight
            String[] name = products.get(i).getText().split("-");
            
            // Trim any extra spaces around the vegetable name
            String formattedName = name[0].trim();

            // Convert the array of itemsNeeded into a list for easy searching
            List itemsNeededList = Arrays.asList(itemsNeeded);

            // Check if the current product name is in the list of itemsNeeded
            if (itemsNeededList.contains(formattedName)) {
                j++; // Increment the counter as this item is found

                // Click the "Add to Cart" button for the current product
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // If all required items are added, exit the loop early
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
//Deep dive into functional testing

//Synchronization usage



//implicit wait:
//Hey wait for 5 number of seconds before you throw exception
//
//15 seconds to load
//
//Explicit wait:
//15 seconds .. -Specific to all location hotel search
//
//Thread.Sleep
//Fluent.Wait
//
//
//
//
//Explicit wait can be achieved in 2 ways:
//WebDriverWait = 10 seconds = 3rd
//FluentWait = 10 seconds, Polling 4 sec,
//Your card is accepted(3sec), your order is being (7th sec)-
//processed-confirmation
//
//How different it is from WebDriver Wait?
//timeout = 10 seconds
//
//Fluent wait finds the web element repeatedly at regular
//intervals of time untill the timeout or till the object
//gets found
//
//
//Unlike WebDriver wait, we need to build Customized wait
//methods based on condition
//
//Both WebDriverWait and FluenWait classes implement wait
//interface

