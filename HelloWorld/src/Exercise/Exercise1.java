package Exercise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class Exercise1 {

    @BeforeMethod
    public void setUp() {
        // Code to initialize resources before each test, if necessary
    }

    @AfterMethod
    public void tearDown() {
        // Code to clean up resources after each test, if necessary
    }

    @Test
    public void testIfCondition() {
        int number = 10;
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }

    @Test
    public void testWhileLoop() {
        int i = 1;
        while (i <= 5) {
            System.out.println("Number: " + i);
            i++;
        }
    }

    @Test
    public void testForLoop() {
        int n = 10;
        int t1 = 0, t2 = 1;

        System.out.print("First " + n + " terms of Fibonacci series: ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(t1 + " + ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        System.out.println();
    }

    @Test
    public void testIfConditionOddEven() {
        int number = 10;
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    @Test
    public void testOddEvenNumbers() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even.");
            } else {
                System.out.println(i + " is odd.");
            }
        }
    }

    @Test
    public void testEmailPattern() {
        Pattern emailPattern = Pattern.compile("[\\S\\d]+@[\\S\\d]+\\.[\\S\\d]+");
        assertTrue(emailPattern.matcher("example@example.com").matches());
        assertTrue(emailPattern.matcher("user@domain.co").matches());
        assertFalse(emailPattern.matcher("user@domain").matches());
        assertFalse(emailPattern.matcher("user@domain.").matches());
        assertFalse(emailPattern.matcher("userdomain.com").matches());
    }

    @Test
    public void testPhoneNumberPattern() {
        Pattern phoneNumberPattern = Pattern.compile("\\+\\d{2}-\\d{4}-\\d{4}");
        assertTrue(phoneNumberPattern.matcher("+12-3456-7890").matches());
        assertTrue(phoneNumberPattern.matcher("+34-5678-9012").matches());
        assertFalse(phoneNumberPattern.matcher("12-3456-7890").matches());
        assertFalse(phoneNumberPattern.matcher("+123-456-7890").matches());
        assertFalse(phoneNumberPattern.matcher("+12-34567-890").matches());
    }

    @Test
    public void testPricePattern() {
        Pattern pricePattern = Pattern.compile("\\$\\d+\\.\\d+");
        assertTrue(pricePattern.matcher("$10.99").matches());
        assertTrue(pricePattern.matcher("$5.00").matches());
        assertTrue(pricePattern.matcher("$100.00").matches());
        assertFalse(pricePattern.matcher("10.9999").matches());
        assertFalse(pricePattern.matcher("$10").matches());
    }

    @Test
    public void testDatePattern() {
        Pattern datePattern = Pattern.compile("\\d{4}-[A-Za-z]{3}-\\d+");
        assertTrue(datePattern.matcher("2024-Jan-01").matches());
        assertTrue(datePattern.matcher("2024-Dec-31").matches());
        assertTrue(datePattern.matcher("2023-Mar-15").matches());
        assertFalse(datePattern.matcher("2024-01-01").matches());
        assertFalse(datePattern.matcher("24-Jan-01").matches());
        assertFalse(datePattern.matcher("2024-January-01").matches());
    }
}
