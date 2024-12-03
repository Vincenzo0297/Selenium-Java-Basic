package Hello6;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;  // Correct import for FileUtils
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test2 {

    private static final String FileUtils = null;

	public static void main(String[] args) throws IOException {
        // Set the system property to specify the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
        
        // Create a new instance of ChromeDriver to launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        // Navigate to the webpage
        driver.get("https://google.com");
        
        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Save the screenshot to the specified location
        FileUtils.copyFile(src, new File("C:/screenshot.png")); // Ensure the path is correct
        

    }
}
