//Ranjana   7204012347    R@njana72040
//Abhi      7385919107    Pass@123
//Rutuja    7768098324    Rutuja@123
//sakshi    8983838316    @Admin123



package Myntra;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Myntra_Test {
	WebDriver driver;
    String url="https://www.myntra.com/";
    String orders_url="https://www.myntra.com/my/orders";
    String login_url="https://www.myntra.com/login?referer=https://www.myntra.com/";
    public static String wishlistUrl = "https://www.myntra.com/12196028";
    public static String wishlistUrl1 = "https://www.myntra.com/17270154";
    public static String contact_us_url="https://www.myntra.com/contactus";
        public static String heading, items;
        boolean optionsDisplayed = false;
        boolean isHintText;
        boolean isTextInCorrectBrandName = false;
        boolean headPresent;
        public static String HeadLine;
        
        public static String query,query1,query2,query3,query4,result1,result2;
        public static boolean chat=false;
        public static boolean callNow=false;
        public static boolean writeToUs=false;
        public static boolean chat1=false;
        
        String errText;
        String incorrectBrandName;
        String profileHead;
        
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarika_bote\\eclipse-workspace\\New\\library\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	
	}
	
	//Login
	@Parameters({"id","password"})
	@Test(priority=1)
	public void login(String id,String password) throws InterruptedException, IOException {
		driver.get(url);
        driver.findElement(By.cssSelector("#desktop-header-cnt > div.desktop-bound > div.desktop-actions > div > div.desktop-userIconsContainer > span.myntraweb-sprite.desktop-iconUser.sprites-headerUser")).click();
        driver.get(login_url);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div[1]/input")).sendKeys(id);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div[3]")).click();
        
        Thread.sleep(30000);
        
        
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div[3]/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div/form/div/div[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div/form/div/div[3]/button")).click();
        
        
        

	}
	
	//Search Bar
	@Test(priority=2)
	  public void searchBarTestMeth() throws InterruptedException
	  {

	
	    	Thread.sleep(4000);
		 
	      //display the correct hint in the search box
	      isHintText = driver.findElement(By.xpath("//input[contains(@placeholder,'Search for products, brands and more')]")).isDisplayed();
	      System.out.println("is hint present?: "+isHintText);
	      
	    
	      
	      //positive testcase.
	      driver.findElement(By.className("desktop-searchBar")).sendKeys("Kurtas");
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[3]/a")).click();
	     
	      
	      //optionsDisplayed = driver.findElement(By.className("title-title")).isDisplayed();
	      optionsDisplayed = driver.findElement(By.tagName("h1")).isDisplayed();
	      
	      //Assert.assertEquals(optionsDisplayed, true);
	      System.out.println("is the options dispalyed?"+optionsDisplayed);
	      
	      //negative testcase
	      driver.findElement(By.className("desktop-searchBar")).clear();
	      driver.findElement(By.className("desktop-searchBar")).sendKeys("12tbdhf\n");
	      driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[3]/a")).click();
	       errText = driver.findElement(By.className("title-corrections")).getText();
	      System.out.println(errText);
	      
	      
	      //enter the keyword by brand name.
	      //positive testcase
	      driver.findElement(By.className("desktop-searchBar")).clear();
	      driver.findElement(By.className("desktop-searchBar")).sendKeys("puma\n");
	      driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[3]/a")).click();
	      
	      //enter the keyword by brand name.
	      //negative testcase
	      driver.findElement(By.className("desktop-searchBar")).clear();
	      driver.findElement(By.className("desktop-searchBar")).sendKeys("xyz\n");
	      driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[3]/a")).click();
	      incorrectBrandName = driver.findElement(By.className("index-infoBig")).getText();
	      System.out.println("text displayed for incorrect brand name: "+ incorrectBrandName);
	      isTextInCorrectBrandName = incorrectBrandName.equals("We couldn't find any matches!");
	      System.out.println("is text for incorrect brand name present?:"+isTextInCorrectBrandName);
	      
	      Thread.sleep(4000);
	  }
	
	//Filter
	@Test(priority=3)
    public void filter() throws InterruptedException {
        //driver.get(url);
          driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys("tops");
          driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/a/span")).click();
          Thread.sleep(1000);
          //single filter
          driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[3]/div[1]/section/div/div[2]/ul/li[1]/label")).click();
          Thread.sleep(1000);
          //clear
          driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[3]/div[1]/section/div/div[1]/span[2]")).click();
          Thread.sleep(1000);
          //multiple filters
          driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[3]/div[1]/section/div/div[2]/ul/li[1]/label")).click();
          Thread.sleep(1000);
          
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,250)", "");
          
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[3]/div[1]/section/div/div[3]/ul/li[6]/label")).click();
          driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[3]/div[1]/section/div/div[3]/ul/li[8]/label")).click();
          Thread.sleep(1000);
          
                 
          //display count of filters
          heading = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div/h1")).getText();
          items = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div/span")).getText();
          System.out.println(heading+" "+items);
          Thread.sleep(2000);

  
  }
	
	
	//My Profile 
	@Test(priority=4)
    public void myProfile() throws InterruptedException
 {
		Thread.sleep(2000);
		
     Actions a =new Actions(driver);
     WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/div[1]/span[2]"));
     a.moveToElement(profile).perform();
     
     WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/div[2]/div[2]/div[1]/a/div[1]"));
     a.moveToElement(user).click().perform();
     
    
      //profile options (displayed only when a user is logged in
     profileHead = driver.findElement(By.className("profile-infoLabel")).getText();
     //is the heading 'profile details' present
     headPresent = profileHead.equals("Profile Details");
     System.out.println("is the heading present? "+headPresent);
     
     //get the attribute and value of profile details
     System.out.print(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText()+" ");
     System.out.println(driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
     
     System.out.print(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]")).getText()+" ");
     System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
     
     System.out.print(driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]")).getText()+" ");
     System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText());
     
     System.out.print(driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]")).getText()+" ");
     System.out.println(driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText());       
 }
	//WishList
	@Test(priority=5)
    public void wishList() throws InterruptedException
   {

		Thread.sleep(2000);
		
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/a[1]/span[1]")).click();
	   Thread.sleep(2000);
	  HeadLine=driver.findElement(By.className("index-headingDiv")).getText();
	  System.out.println(HeadLine);
	   Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/ul/div[1]/div[1]/div")).click();
	  Thread.sleep(2000);
	      

  
   }
	//Add To Cart
	@Test(priority=6)
	public void addToCart() throws InterruptedException, IOException {
		String text1=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[1]/span[2]")).getText();
		  System.out.println("My wishlist "+ text1);
		  
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/ul/div[1]/div[2]/div[2]/span/a")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/ul/div[1]/div[2]/div/div/div[3]/button[3]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/ul/div[1]/div[2]/div/div/div[5]")).click();
		  
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/a[2]/span[1]")).click();
		  
		    //Take Screenshot
	      	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      		
	      	//copy the screenshot to the screenshot folder
	      	FileUtils.copyFile(src, new File("ScreenShot\\defect_addToCart.png"));
	      	
		    Thread.sleep(3000);
		  
			String text=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[1]/div[6]/div[2]")).getText();
			System.out.println(text);
	}

	//Place an Order
	@Test(priority=7)
    public void placeOrder() throws InterruptedException
    {
       
           Thread.sleep(5000);
           
           //click on place order button
            WebElement ele=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[3]/button"));
        
            Actions action=new Actions(driver);
            action.moveToElement(ele).click().perform();    
            Thread.sleep(2000);
            
            // to display estimated date
            System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[3]/div[2]/div[2]/div/div/div/div/span[1]")).getText());
            System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[3]/div[2]/div[2]/div/div/div/div/span[2]")).getText());
           
            // to display total amount
            System.out.println("Total Amount :" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[3]/div[4]/div[2]/div/div[4]/span[2]/span[2]")).getText());
            
                
    }
	
	//My Orders
	@Test(priority=8)
	  public void myOrders() throws InterruptedException
	  {
	      
		driver.navigate().back();
	     Thread.sleep(2000);
		
	     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]")).click();
	     Thread.sleep(2000);
	     driver.navigate().back();
	     
	  // mouse hover over profile
	     Actions a =new Actions(driver);
	     WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/div[1]/span[2]"));
	     a.moveToElement(profile).perform();
		
	  
		
	     // click on orders
	     WebElement order = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/a[1]/div"));
	     a.moveToElement(order).click().perform();
	     
	     
	     String detail=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/span")).getText();
	     Thread.sleep(2000);
	     System.out.println(detail);
	     
	  // click on track
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]")).click();
	     
	     Thread.sleep(2000);
	     // get text of track
	     String expected_date=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[4]/div[2]/div/div[2]/div/div[5]/div[2]/div[2]")).getText();
	     Thread.sleep(2000);
	     System.out.println(expected_date);
	     
	     
	     driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[1]/div/div[4]/div[2]/div/div[1]/div/div[2]/span")).click();
	     Thread.sleep(2000);
	     
	     
	
	      
	  }
	
	//Contact Us
	@Test(priority=9)
	public void contactUs() throws InterruptedException, IOException {
		
		 // mouse hover over profile
	     Actions a =new Actions(driver);
	     WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/div[1]/span[2]"));
	     a.moveToElement(profile).perform();
	     
	     
	  // click on contact us
	     WebElement contact = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/a[4]/div"));
	     a.moveToElement(contact).click().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Non-order Related Issues')]")).click();
		Thread.sleep(2000);
		
		//printing all available options
		query=driver.findElement(By.xpath("(//div[@class='oneLinerDesktop-infoAll'])[1]")).getText();
		System.out.println(query);
		
		query1=driver.findElement(By.xpath("(//div[contains(text(),'Payment/Refund')])[1]")).getText();
		System.out.println(query1);
		
		query2=driver.findElement(By.xpath("//div[contains(text(),'Offers, Discounts, Coupons')]")).getText();
		System.out.println(query2);
		
		query3=driver.findElement(By.xpath("//div[contains(text(),'Manage Your Account')]")).getText();
		System.out.println(query3);
		
		query4=driver.findElement(By.xpath("//div[contains(text(),'Other')]")).getText();
		System.out.println(query4);
		
		//click on the Payment/Refund option
		driver.findElement(By.xpath("(//div[contains(text(),'Payment/Refund')])[1]")).click();
		Thread.sleep(1000);
		
		//click on the 'unable to use gift card option'
		driver.findElement(By.xpath("//div[contains(@class,'query-genericQueryText')][contains(text(),'I am unable to use gift card')]")).click();
		Thread.sleep(1000);
		
		//Printing available options
		
		chat=driver.findElement(By.xpath("//div[@class='option-text option-isDisabled']")).isEnabled();
		System.out.println(chat);

		Thread.sleep(1000);
		
		callNow=driver.findElement(By.xpath("//div[contains(text(),'Call Now')]")).isEnabled();
		System.out.println(callNow);
		
		writeToUs=driver.findElement(By.xpath("//div[contains(text(),'Write To Us')]")).isEnabled();
		System.out.println(writeToUs);
		
		
		//Take Screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//copy the screenshot to the screenshot folder
		FileUtils.copyFile(src, new File("ScreenShot\\defect_contactUs.png"));
		
		
		
		//Testing Recent Issues
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Recent Issues')]")).click();
		Thread.sleep(2000);
		
		
		//Testing Frequently asked questions
		Thread.sleep(2000);
        driver.findElement(By.xpath("//div[6]//div[1]")).click();
        Thread.sleep(2000);
        
        String termstext=driver.findElement(By.xpath("//div[@id='TnCQueries']")).getText();
        System.out.println(termstext);
				
	}
	

	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
}
