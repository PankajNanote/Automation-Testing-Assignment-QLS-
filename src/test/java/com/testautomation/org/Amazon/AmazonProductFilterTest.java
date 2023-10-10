package com.testautomation.org.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonProductFilterTest {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\panka\\eclipse-workspace\\Automation\\Driver\\chromedriver.exe");
		
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void applyFiltersOnAmazon() {
			
		driver.get("https://www.amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	
	@Test(priority = 2)
	public void applyPriceRangeFilter() {
		
		WebElement minPriceInput = driver.findElement(By.id("low-price"));
		
        WebElement maxPriceInput = driver.findElement(By.id("high-price"));
        
        WebElement goButton = driver.findElement(By.className("a-button-input"));
        
        minPriceInput.clear();
        minPriceInput.sendKeys("30000");
        maxPriceInput.clear();
        maxPriceInput.sendKeys("60000");
        
        goButton.click();


	}
     
	@Test(priority = 3)
    public void searchLaptopsByBrands() {
         
        	//WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
           // searchBox.clear();
            
            //WebElement searchBox1 = driver.findElement(By.id("twotabsearchtextbox"));
            //searchBox1.sendKeys("laptop");
            //searchBox1.submit();
            
            try {
                Thread.sleep(3000);
                } catch (InterruptedException e) {
                e.printStackTrace();
                }
        
            WebElement brandFilter = driver.findElement(By.xpath("//span[text()='Brand']"));
            brandFilter.click();
            
            selectBrandCheckbox("HP");
            selectBrandCheckbox("Dell");
            
            WebElement applyButton = driver.findElement(By.xpath("//span[text()='Apply']"));
            applyButton.click();
	      

	try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
      }
	}
	          
	 
	

	
        private void selectBrandCheckbox(String brandname) {
		// TODO Auto-generated method stub
        	
        	 String checkboxXPath = "//span[contains(text(), '" + brandname + "')]/preceding-sibling::div/input";
        	 WebElement brandCheckbox = driver.findElement(By.xpath(checkboxXPath));
              if (!brandCheckbox.isSelected()) {
                  brandCheckbox.click();
              }
          }
	


		@AfterTest
        public void tearDown() {
        	driver.quit();
        }
			
	}
		 
	 
		

