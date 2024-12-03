package Exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

public class Exercise2 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Create WebDriver instance
        driver = new ChromeDriver();
    }

    @Test
    public void testMazeGame() {
        // Navigate to the maze game page
        driver.get("https://gt-automation-exercise-games.tiiny.site/game-01.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the page to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hint")));

            while (true) {
                // Get the hint direction
                WebElement hintElement = driver.findElement(By.id("hint"));
                String hint = hintElement.getText();

                // Click the corresponding button based on the hint
                if (hint.equalsIgnoreCase("up")) {
                    driver.findElement(By.id("up")).click();
                } else if (hint.equalsIgnoreCase("down")) {
                    driver.findElement(By.id("down")).click();
                } else if (hint.equalsIgnoreCase("left")) {
                    driver.findElement(By.id("left")).click();
                } else if (hint.equalsIgnoreCase("right")) {
                    driver.findElement(By.id("right")).click();
                }

                // Wait a bit for the game to process
                Thread.sleep(500);

                // Check for the win message
                String message = driver.findElement(By.id("message")).getText();
                if ("You win!".equals(message)) {
                    System.out.println("Maze completed!");
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJumpGame() {
        // Navigate to the jump game page
        driver.get("https://gt-automation-exercise-games.tiiny.site/game-02.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the page to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("distanceValue")));

            while (true) {
                // Get the distance to the next obstacle
                WebElement distanceElement = driver.findElement(By.id("distanceValue"));
                int distance = Integer.parseInt(distanceElement.getText());

                // Press the jump button if the distance is less than a threshold
                if (distance < 100) {
                    driver.findElement(By.id("jump")).click();
                }

                // Check for win or game over messages
                String message = driver.findElement(By.id("message")).getText();
                if ("You win!".equals(message)) {
                    System.out.println("Jump game completed!");
                    break;
                } else if ("Game Over!".equals(message)) {
                    System.out.println("Game over in jump game!");
                    break;
                }

                // Short wait for the next check
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDataClassificationGame() {
        // Navigate to the data classification game page
        driver.get("https://gt-automation-exercise-games.tiiny.site/game-03.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the page to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("data")));

            // Define regular expressions for each type
            Pattern emailPattern = Pattern.compile("[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}");
            Pattern phonePattern = Pattern.compile("\\+\\d{2}-\\d{4}-\\d{4}");
            Pattern pricePattern = Pattern.compile("\\$\\d+\\.\\d{2}");

            for (int i = 0; i < 20; i++) {
                // Get the displayed text
                WebElement dataElement = driver.findElement(By.id("data"));
                String data = dataElement.getText();

                // Determine the correct button to click based on the text
                if (emailPattern.matcher(data).matches()) {
                    driver.findElement(By.id("email")).click();
                } else if (phonePattern.matcher(data).matches()) {
                    driver.findElement(By.id("phone")).click();
                } else if (pricePattern.matcher(data).matches()) {
                    driver.findElement(By.id("price")).click();
                } else {
                    driver.findElement(By.id("other")).click();
                }

                // Short wait before the next classification
                Thread.sleep(500);

                // Check if the Submit button has changed to "Restart"
                WebElement submitButton = driver.findElement(By.id("submit"));
                if ("Restart".equals(submitButton.getText())) {
                    System.out.println("Data classification game completed!");
                    break;
                }
            }

            // Submit the classification
            driver.findElement(By.id("submit")).click();

            // Check the final message
            String message = driver.findElement(By.id("message")).getText();
            assertEquals(message, "Well done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
