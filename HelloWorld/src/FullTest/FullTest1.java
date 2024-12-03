package FullTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullTest1 {
	public static void main(String[] args) throws InterruptedException {
	
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe"); 	// Set the path to the ChromeDriver executable (replace with your path)        
        WebDriver driver = new ChromeDriver(); // Create an instance of ChromeDriver (opens a new Chrome browser)        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Set an implicit wait of 5 seconds (waits for elements to appear before throwing an error)\
        driver.get("https://rahulshettyacademy.com/locatorspractice/"); // Navigate to the target webpage
        
        
        // **Step 1: Login Attempt**
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000L);  // Pause execution for 2 second to simulate delay (not ideal for production)
        
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());  // Find and print the error message (if login fails) using CSS Selector
        
        driver.findElement(By.linkText("Forgot your password?")).click();    // Click on the "Forgot your password?" link to navigate to the forgot password page
        Thread.sleep(2000L);  // Pause execution for 2 second to simulate delay (not ideal for production)

        
        // **Step 2: Pathway** Root element -> element body
        //Method 1:
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@rsa.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9864353253");
        Thread.sleep(2000L); 
        
        driver.findElement(By.xpath("//input[@type='text'][1]")).clear();  // Clear the value from the second text input field on the page
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();  // Clear the value from the second text input field on the page
        driver.findElement(By.xpath("//input[@type='text'][3]")).clear();  // Clear the value from the second text input field on the page
        Thread.sleep(2000L);  // Pause execution for 2 second to simulate delay (not ideal for production)
        
        
        //Method 2:
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");  // Find the Email input field using CSS Selector and enter "john@rsa.com"
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9864353253");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();  // Click on the "Reset Password" button using CSS Selector
        Thread.sleep(2000L);  // Pause execution for 2 second to simulate delay (not ideal for production)
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());   // Print the reset password confirmation message to the console

        
        driver.findElement(By.xpath("//input[@type='text'][1]")).clear();  // Clear the value from the second text input field on the page
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();  // Clear the value from the second text input field on the page
        driver.findElement(By.xpath("//input[@type='text'][3]")).clear();  // Clear the value from the second text input field on the page
        Thread.sleep(2000L);  // Pause execution for 2 second to simulate delay (not ideal for production)
        
        
        //Method 3:
        driver.findElement(By.xpath("//form/input[1]")).sendKeys("John");
        driver.findElement(By.xpath("//form/input[2]")).sendKeys("john@rsa.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");    // Find the phone number field using XPath and enter "9864353253"
        Thread.sleep(2000L);
        
        driver.findElement(By.xpath("//input[@type='text'][1]")).clear();  // Clear the value from the second text input field on the page
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();  // Clear the value from the second text input field on the page
        driver.findElement(By.xpath("//input[@type='text'][3]")).clear();  // Clear the value from the second text input field on the page
        Thread.sleep(2000L);  // Pause execution for 2 second to simulate delay (not ideal for production)
        
        
        //Method 4: 
        //driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com"); // Enter "john@gmail.com" in the third text input field using CSS Selector
        
        
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); // Navigate back to the login page
        Thread.sleep(1000); // Pause execution for 2 second to simulate delay

        
        // **Step 3: Login Again**
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");  // Enter username in the login input field using CSS Selector
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");  // Enter password using CSS Selector with partial matching
        driver.findElement(By.id("chkboxOne")).click(); // Select the "Remember Me" checkbox using its ID
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();  // Find and click the login button using XPath with partial class matching
        Thread.sleep(2000L); // Pause execution for 2 second to simulate delay
        
                
        // **Step 4: Logout**
        driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // Find and click the "Log Out" button to log out
        Thread.sleep(2000L); // Pause execution for 2 second to simulate delay
	}
}


//ID -> tagname#id -> input#inputUsername

//Xpath
//Tagname[@attribute='value']
//input[@placeholder="Username"]

//input<type="text" placeholder="Name">
//input[@placeholder='Name']

//Tagname[@attribute='value'][index] -> selecting the input box
//<input type="text placeholder="Username" value="">
//input[placeholder='Username']


//Tagname[@attribute='value']:nth-child(index). - child items
//parnetTagname/childTagname
//button[contains[@class,'submit')]. - Regular expression
//input[type*='pass'] - css


//CSS Selector 
//name
//class name -> tagname.classname -> Button.signInBtn -> .error

//tag name -> tagname[attribute='value] -> <input type="text" placeholder="Username" value="">
//input[placeholder='username']

//link text
//partial link text





//When to use Xpath, cssSelector and ID
//
//
//
//Use ID (Perferred when available)
//
//When to use:
//The element has unique ID attribute
//The ID is static and does not change dynamically on the page
//
//Advantage:
//Fastest and most reliable because ID is unique on the page
//East to understand and write
//
//Limitation:
//Not all elements have ID attributes
//Some ID values may be dynamically generated and can change
//
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//Use css Selector (Fast and versatile)
//
//When to use:
//The element does not have a unique ID, but can use attribute classes or hierarchy to locate it
//Prefer concise syntax over XPath
//
//Advantage:
//Faster than XPath
//Supports advanced matching patterns like partial matches (^, $, *)
//Easier to read for simple selector
//
//Limitations:
//Does not traverse back up the DOM (e.g., no support for finding parents like XPath).
//Can become complex for deeply nested elements.
//
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//
//
//Use XPath (Powerful but slower)
//
//When to use:
//The element does not have ID and cssSelector is insufficient (e.g., need to traverse parent/ancestor nodes).
//
//The DOM structure is complex, and you need advanced navigation:
//Finding an element relative to another.
//Traversing the DOM hierarchy (parent, child, sibling).
//
//
//Advantages:
//Can traverse both up and down the DOM hierarchy.
//Supports complex queries with conditions (contains, starts-with, and, or, etc.).
//
//Limitations:
//Slightly slower than CSS Selector.
//Syntax can become lengthy and hard to read.