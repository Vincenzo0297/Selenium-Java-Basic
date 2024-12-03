package FullTest;

import java.time.Duration; // Import for managing time-based operations
import org.openqa.selenium.By; // Import for locating elements in the DOM
import org.openqa.selenium.WebDriver; // Interface for controlling browser behavior
import org.openqa.selenium.chrome.ChromeDriver; // Class to handle Chrome browser
import org.openqa.selenium.edge.EdgeDriver; // Class to handle Edge browser (commented out in this case)
import org.openqa.selenium.firefox.FirefoxDriver; // Class to handle Firefox browser (not used here)
import org.testng.Assert; // Import for assertions in testing

public class FullTest2 {

    public static void main(String[] args) throws InterruptedException {

       
        String name = "rahul";  // Declare a variable to store the username
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");  // Set the path to the ChromeDriver executable
        WebDriver driver = new ChromeDriver();  // Create a new instance of ChromeDriver to control Chrome browser

        // Uncomment the following lines to use EdgeDriver instead of ChromeDriver
        // System.setProperty("webdriver.edge.driver", "/path/to/edgedriver");
        // WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Set an implicit wait of 5 seconds to handle element loading delays
        String password = getPassword(driver);  // Retrieve the temporary password using the `getPassword` method
        driver.get("https://rahulshettyacademy.com/locatorspractice/");  // Navigate to the login page

        
        // **Step 1: Login Attempt**
        driver.findElement(By.id("inputUsername")).sendKeys(name);  // Find the username input field and enter the username
        driver.findElement(By.name("inputPassword")).sendKeys(password); // Find the password input field and enter the retrieved password
        driver.findElement(By.className("signInBtn")).click();  // Find the sign-in button and click it to log in
        Thread.sleep(2000);         // Wait for 2 seconds to allow the login process to complete
        
        // **Step 2: Test the login message**
        
        System.out.println(driver.findElement(By.tagName("p")).getText());  // Get the success message displayed on the page and print it to the console
        
        // Use assertions to validate test results and ensure application behavior matches expectations.
        // Example: Verify that messages, values, or elements are correct.

        // Assert that two values are equal: Assert.assertEquals(actual, expected);
     
        
        
        // Common use cases for assertions:

        // 1. Validate Results: Ensure that outputs or data from the application match the expected values.
        //Example: Check if the success message is correct.
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");   // Assert that the success message is correct
        
        
        // 2. Check Page Elements: Verify if an element is displayed or if its content matches expected values.
        //Example: Confirm that the greeting message includes the username.
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");  // Assert that the greeting message includes the username

        
        //Assert: Use in automated testing to verify certain condition that are true or expected outcomes are met during test execution
        //Assertions are typically employed in test script to ensure application behavior matches the intended design/expected result
        
        
        // 3. Critical Workflow Testing: Ensure important actions, like login or form submission, work as intended.
        //Example: Check if navigating to a page or clicking a button produces the correct result.

        // 4. Halt on Failure: Stop the test immediately if the condition is not met, making it easier to debug.

        // 5. Debugging: Provide meaningful error messages when the test fails, helping to identify the root cause quickly.

	  // Types of assertions:
	  // - Equals: Assert.assertEquals(actual, expected) - Checks if two values are the same.
	  // - True/False: Assert.assertTrue(condition) / Assert.assertFalse(condition) - Validates conditions.
	  // - NotNull/Null: Assert.assertNotNull(object) / Assert.assertNull(object) - Checks for object existence.

	  // Best Practices:
	  // - Use meaningful error messages for clarity when an assertion fails.
	  // - Place assertions after actions to validate outcomes (e.g., clicking a button or loading a page).
	  // - Focus on critical validation points to avoid excessive assertions that may complicate test maintenance.

        // Assertions are crucial for verifying test outcomes, detecting bugs, and ensuring the reliability of automated tests.
        
        // **Step 3: Logout Attempt**
        driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // Find and click the "Log Out" button to log out

        
        driver.close(); // Close the browser window
    }

    // Method to retrieve the temporary password from the "Forgot your password?" workflow
    public static String getPassword(WebDriver driver) throws InterruptedException {

        
        driver.get("https://rahulshettyacademy.com/locatorspractice/"); // Navigate to the login page       
        driver.findElement(By.linkText("Forgot your password?")).click();  // Click on the "Forgot your password?" link
        Thread.sleep(1000);   // Wait for 1 second to allow the "Forgot your password?" page to load

        
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); // Click on the "Reset Password" button
        String passwordText = driver.findElement(By.cssSelector("form p")).getText(); // Retrieve the message that contains the temporary password

        // Split the text to extract the temporary password
        // Example text: "Please use temporary password 'rahulshettyacademy' to Login."
        String[] passwordArray = passwordText.split("'"); // Split by single quotes

      
        String password = passwordArray[1].split("'")[0];   // Extract the password (the first split value inside the quotes)

        
        return password; // Return the extracted password

        // Explanation of splitting:
        // - passwordArray[0]: "Please use temporary password "
        // - passwordArray[1]: "rahulshettyacademy' to Login."
        // Further split ensures we only get "rahulshettyacademy".
    }
}
