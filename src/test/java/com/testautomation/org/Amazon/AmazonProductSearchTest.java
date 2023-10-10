package com.testautomation.org.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonProductSearchTest {

		WebDriver driver = new ChromeDriver();
		
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\panka\\eclipse-workspace\\Automation\\Driver\\chromedriver.exe");
		driver.manage().window().maximize();
		}
		
	@Test(priority=1)
	public void searchProductOnAmazon1() {
			
		driver.get("https://www.amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	@Test(priority=2)
		public void searchProductOnAmazon2() {
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("camera");
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	
		
		try {
            Thread.sleep(3000);
            } 
		catch (InterruptedException e) {
            e.printStackTrace();
            }
		
		driver.findElement(By.cssSelector(".s-main-slot"));
		System.out.println("List of Laptops and Prices:");
		System.out.println("List of Cameras and Prices:");
		driver.findElements(By.cssSelector(".s-result-item")); 
	     
		  //List<WebElement> laptopListings = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		  
		  //for (WebElement laptop : laptopListings) {
	            //WebElement titleElement = laptop.findElement(By.xpath(".//span[@class='a-text-normal']"));
	           // WebElement priceElement = laptop.findElement(By.xpath(".//span[@class='a-price-whole']"));
	           // String laptopName = titleElement.getText();
	            //String laptopPrice = priceElement.getText();

	            //System.out.println("Laptop: " + laptopName + ", Price: " + laptopPrice);
		
		//*java.util.List<WebElement> products = driver.findElements(By.className("sresult lvresult clearfix li"));

	    //for(WebElement product:products) {

	        //System.out.println(product.getText()); 
	        }
	
	    
	@AfterTest
    public void tearDown() {
		driver.quit();
		
	}

}
