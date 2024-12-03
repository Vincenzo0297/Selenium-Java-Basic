package FullTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FullTest4 {
	public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/vincent.ong/Downloads/chromedriver131/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        
        // Use WebDriverWait to wait for the dropdown to be visible
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
     
        
        // **Step 1: Drop Down Selection**
        //Drop down selection Test
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(1); //Selection value 
        Thread.sleep(5000L); // Pause execution for 2 second to simulate delay
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
              
        dropdown.selectByVisibleText("AED");
        Thread.sleep(2000L); // Pause execution for  second to simulate delay
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        dropdown.selectByValue("USD");
        Thread.sleep(2000L); // Pause execution for  second to simulate delay
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        dropdown.selectByValue("INR");
        Thread.sleep(2000L); // Pause execution for  second to simulate delay
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        
        
        
        // **Step 2: Counter**
        driver.findElement(By.className("paxinfo")).click(); //Dropdown button

        Thread.sleep(2000L);
        
        
        /*int i=1;

	     while(i<5){

		     driver.findElement(By.id("hrefIncAdt")).click();
	
		     i++;

    	}*/
        
        System.out.println(driver.findElement(By.id("hrefIncAdt")).getText()); 

	     for(int i=1;i<5;i++){

	    	 driver.findElement(By.id("hrefIncAdt")).click(); //Click button

	     }


    	driver.findElement(By.id("btnclosepaxoption")).click();  // close (Done) button

    	Assert.assertEquals(driver.findElement(By.className("paxinfo")).getText(), "5 Adult"); ////Dropdown button
    	System.out.println(driver.findElement(By.className("paxinfo")).getText());
        
        
        
        // **Step 3: Auto suggestion input**
    	driver.findElement(By.id("autosuggest")).sendKeys("ind");
    	Thread.sleep(3000);
    	List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
    			
    			
    	 // **Step 4: Check Box input**
    	Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

    	//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

    	driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

    	System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

    	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
    			
    			
    	
    	// **Step 5: Calendar and the button (Round Trip)**
    	// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

    	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
    	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

    	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
    			
    	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
    		System.out.println("its enabled");
    		
    		Assert.assertTrue(true);

    	}else{

    		Assert.assertTrue(false);

    	}
    			
    			
    	for(WebElement option :options){
    			
    		if(option.getText().equalsIgnoreCase("India")){
    				
    			option.click();
    				
    				break;
    			}

    	}
    	
    	 // **Step 6: handling dynamic Drop Down Selection**
    	//  //a[@value='MAA']  - Xpath for chennai
		
		
    	//  //a[@value='BLR']
    		
    		
    	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
    		
    	driver.findElement(By.xpath("//a[@value='AMD']")).click();
    		
    	Thread.sleep(2000);
    		
    		
    	//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    		
    	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
    		
    	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
    }
}
