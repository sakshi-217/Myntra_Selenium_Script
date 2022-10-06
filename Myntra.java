package Myntra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Myntra {
	
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	}
//  @Parameters({"mobile","password"})
    //String mobile,String password
    
    @Test(priority=1)
    public void login() throws InterruptedException
    {
    	driver.get(url);
    	// login
    	driver.findElement(By.cssSelector("#desktop-header-cnt > div.desktop-bound > div.desktop-actions > div > div.desktop-userIconsContainer > span.myntraweb-sprite.desktop-iconUser.sprites-headerUser")).click();

        //click on login button
        driver.findElement(By.className("desktop-linkButton")).click();
        
        //send mobile no
        driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("8983838316");
        
        //click on continue
        driver.findElement(By.className("submitBottomOption")).click();
        
        Thread.sleep(30000);
        
        //click on continue
        driver.findElement(By.className("submitBottomOption")).click();
        
        Thread.sleep(5000);
        
        //click on password
        driver.findElement(By.xpath("//span[contains(text(),'Password')]")).click();
        
        //send password
        driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys("@Admin123");
        driver.findElement(By.xpath("//div//button[text()='LOGIN']")).click();
    }
   @Test(priority=2) 
   public void search() throws InterruptedException
   {
	   Thread.sleep(4000);
   
       //display the correct text(hint) in the search box
       isHintText = driver.findElement(By.xpath("//input[contains(@placeholder,'Search for products, brands and more')]")).isDisplayed();
       
       System.out.println("is hint present?: "+isHintText);
     
       //positive testcase.
       driver.findElement(By.className("desktop-searchBar")).sendKeys("tops");
       //click on search icon
       driver.findElement(By.className("desktop-submit")).click();
      
       Actions a = new Actions(driver);
       WebElement recommend = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
       //hover on sort by: Recommended
       a.moveToElement(recommend).perform();
       //click on Better Discount
       driver.findElement(By.xpath("//label[contains(text(),'Better Discount')]")).click();
       
       
       //scroll
       Thread.sleep(1000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)", "");
       Thread.sleep(2000);
       js.executeScript("window.scrollBy(0,500)", "");
       Thread.sleep(2000);
       js.executeScript("window.scrollBy(0,500)", "");
       
       optionsDisplayed = driver.findElement(By.tagName("h1")).isDisplayed();
       
       System.out.println("is the options dispalyed?"+optionsDisplayed);
       
     //negative testcase
       driver.findElement(By.className("desktop-searchBar")).clear();
       driver.findElement(By.className("desktop-searchBar")).sendKeys("12tbdhf");
     //click on search icon
      driver.findElement(By.className("desktop-submit")).click();
   
       errText = driver.findElement(By.className("title-corrections")).getText();
       System.out.println(errText);
       
     //enter the keyword by brand name.
      //positive testcase
       driver.findElement(By.className("desktop-searchBar")).clear();
       driver.findElement(By.className("desktop-searchBar")).sendKeys("puma");
     //click on search icon
       driver.findElement(By.className("desktop-submit")).click();
       
     //enter the keyword by brand name.
       //negative testcase
       driver.findElement(By.className("desktop-searchBar")).clear();
       driver.findElement(By.className("desktop-searchBar")).sendKeys("xyz");
     //click on search icon
       driver.findElement(By.className("desktop-submit")).click();
       
       incorrectBrandName = driver.findElement(By.className("index-infoBig")).getText();
       System.out.println("text displayed for incorrect brand name: "+ incorrectBrandName);
       isTextInCorrectBrandName = incorrectBrandName.equals("We couldn't find any matches!");
       System.out.println("is text for incorrect brand name present?:"+isTextInCorrectBrandName);       
      
   }
   
   @Test(priority=3)
   public void filter() throws InterruptedException
   {
	   
	   //driver.get(url);
   	// Search for tops
   	driver.findElement(By.className("desktop-searchBar")).sendKeys("tops");
   	driver.findElement(By.className("desktop-submit")).click();
   	// get total number of items for a search
   	
   	String title=driver.findElement(By.className("title-title")).getText();
   	String total=driver.findElement(By.className("title-count")).getText();
   	System.out.println(title+"  "+total);
   	
   	// applying filter for men
   	driver.findElement(By.cssSelector("#mountRoot > div > div > main > div:nth-child(3) > div.search-leftContainer.column-base > section > div > div:nth-child(2) > ul > li:nth-child(1) > label")).click();
   	Thread.sleep(2000);
   	
   	 title=driver.findElement(By.className("title-title")).getText();
   	 total=driver.findElement(By.className("title-count")).getText();
   	 
   	System.out.println("After applying single filter(men)");
   	System.out.println(title+"  "+total);
   	
   	//applying filter for girls with multiple filter H&M
   	driver.findElement(By.cssSelector("#mountRoot > div > div > main > div:nth-child(3) > div.search-leftContainer.column-base > section > div > div:nth-child(2) > ul > li:nth-child(4) > label")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.xpath("//label[contains(text(),'H&M')]")).click();
   	Thread.sleep(2000);
   	// applying one more filter of price
   	driver.findElement(By.xpath("//label[contains(text(),'Rs. 974 to Rs. 1649')]")).click();
   	Thread.sleep(2000);
   	title=driver.findElement(By.className("title-title")).getText();
  	 total=driver.findElement(By.className("title-count")).getText();
  	 
  	System.out.println("After applying multiple filter(girls and H&M and price)");
  	System.out.println(title+"  "+total);
  	
  	driver.findElement(By.cssSelector("span.header-clearAllBtn")).click();
  	Thread.sleep(2000);

	title=driver.findElement(By.className("title-title")).getText();
	total=driver.findElement(By.className("title-count")).getText();
	 
	System.out.println("After applying clear all");
	System.out.println(title+"  "+total);
   }
   
  @Test(priority=4)
  public void myProfile() throws InterruptedException
  {
	  Actions a =new Actions(driver);
      WebElement profile =driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
      a.moveToElement(profile).perform();
      
      WebElement myprofile=driver.findElement(By.className("desktop-infoTitle"));
      a.moveToElement(myprofile).click().perform();
      Thread.sleep(2000);
      
     //getting user details
      System.out.print(driver.findElement(By.xpath("//td[contains(text(),'Full Name')]")).getText()+" ");
      System.out.println(driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
      
      System.out.print(driver.findElement(By.xpath("//td[contains(text(),'Mobile Number')]")).getText()+" ");
      System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
      
      System.out.print(driver.findElement(By.xpath("//td[contains(text(),'Email ID')]")).getText()+" ");
      System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText());
      
      System.out.print(driver.findElement(By.xpath("//td[contains(text(),'Gender')]")).getText()+" ");
      System.out.println(driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText());
      
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,250)", "");
      Thread.sleep(2000);
      driver.findElement(By.className("profile-editButton")).click();
      js.executeScript("window.scrollBy(0,350)", "");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]/div[6]/div[1]/input[1]")).sendKeys("9146134449");
      driver.findElement(By.xpath("//div//button[contains(text(),'Save Details')]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[3]/div[2]/div/div[1]/img")).click();
    
  }
  
  @Test(priority=5)
  public void wishlist() throws InterruptedException
  {
	  // click on wishlist
	  driver.findElement(By.xpath("//a//span[2][contains(text(),'Wishlist')]")).click();
	  Thread.sleep(2000);
	  // total no of items in wishlist
	  HeadLine=driver.findElement(By.cssSelector("span.index-count.index-heading")).getText();
	  System.out.println("Total Count in wishlist:");
	  System.out.println("My wishlist " +HeadLine);
	  Thread.sleep(2000);
	  
	  //removing item from wishlist
	  driver.findElement(By.xpath("//*[@id=\"item0\"]/div[1]/div")).click();
	  Thread.sleep(2000);
	  System.out.println("Count after removing item:");
	  HeadLine=driver.findElement(By.cssSelector("span.index-count.index-heading")).getText();
	  System.out.println("My wishlist " +HeadLine);
	  Thread.sleep(2000);
	  
  }
  @Test(priority=6)
  public void addtoCart() throws InterruptedException
  {
	  Thread.sleep(2000);	
	    
	    //
	  JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,100)", "");
    
    //move single item to bag
    driver.findElement(By.xpath("//*[@id=\"item0\"]/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//*[@id=\"item0\"]/div[2]/div/div/div[3]/button[2]")).click();
    driver.findElement(By.cssSelector("div.sizeselect-done")).click();
    System.out.println("Item added successfully");
    //click on mybag
    driver.findElement(By.cssSelector("span.myntraweb-sprite.desktop-iconBag.sprites-headerBag")).click();
    Thread.sleep(2000);
    js.executeScript("window.scrollBy(0,200)", "");
    
   // driver.navigate().back();
    //move one more item to bag
//    driver.findElement(By.xpath("//*[@id=\"item0\"]/div[2]/div[2]")).click();
//    driver.findElement(By.xpath("//*[@id=\"item0\"]/div[2]/div/div/div[3]/button[1]")).click();
//    driver.findElement(By.cssSelector("div.sizeselect-done")).click();
//    System.out.println("Item added successfully");
//    
    //click on mybag and check added items 
//    driver.findElement(By.cssSelector("span.myntraweb-sprite.desktop-iconBag.sprites-headerBag")).click();
//    Thread.sleep(2000);
//    js.executeScript("window.scrollBy(0,300)", "");
//    driver.navigate().back();
//   
  }
  
  @Test(priority=7)
  public void placeOrder() throws InterruptedException
  {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
//		Thread.sleep(3000);
//		
		//get total amount
		String text=driver.findElement(By.xpath("//div[@class='priceDetail-base-total']")).getText();
		System.out.print(text);
		
		// click on place order
		driver.findElement(By.cssSelector("button.css-etguer")).click();
		Thread.sleep(2000);
		
		//get excepted date of delivery
		String date_text=driver.findElement(By.xpath("//div//span[contains(text(),'Estimated delivery by')]")).getText();
		String date=driver.findElement(By.cssSelector("span.serviceability-base-estimatedDate")).getText();
		System.out.println(date_text+" "+ date);
		
		//go back to home page
		driver.navigate().back();
		driver.findElement(By.cssSelector("div.button-base-button.savingsFomo-base-button.savingsFomo-base-goBackButton")).click();
		driver.navigate().back();
		
  }
  
  @Test(priority=8)
  public void myOrders() throws InterruptedException
  {
	  //hover over profile
      Actions a =new Actions(driver);
      WebElement profile =driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
      a.moveToElement(profile).perform();
      
      WebElement myprofile=driver.findElement(By.xpath("//div[contains(text(),'Orders')]"));
      a.moveToElement(myprofile).click().perform();
      Thread.sleep(2000);
      
      //click on agent details
      Thread.sleep(2000);
      //driver.findElement(By.cssSelector("p.text-common text-body1.orderStatusInfo-callAgentBtn")).click();
    //  driver.findElement(By.xpath("//p[contains(text(),'Call Agent')]")).click();
      JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.scrollBy(0,50)", "");
//      //take screenshot
//      
//      //close
//      driver.findElement(By.cssSelector("span.svgImages-svg.svgImages-crossBox")).click();
//
//      js.executeScript("window.scrollBy(0,200)", "");
//      
    System.out.println(driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[3]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div[1]")));
    //click on exchange
    driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]")).click();
   //click on cancel
    driver.findElement(By.cssSelector("div.NewHalfCard-crossHolder")).click();
   //click on return
    driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]")).click();
    js.executeScript("window.scrollBy(0,150)", "");
    
    //check if exchange buttons are enabled
   Boolean bool= driver.findElement(By.xpath("//footer//button[contains(text(),'TRY EXCHANGE')]")).isEnabled();
    System.out.println("Is Try exchange button enabled ? "+bool);
    
    Boolean bool1=driver.findElement(By.xpath("//button[contains(text(),'CONTINUE WITH RETURN')]")).isEnabled();
    System.out.println("Is Continue with return button enabled ? "+bool1);
    
    driver.findElement(By.cssSelector("svg.returnOEEModal-closeIcon")).click();
    
  }
  
  @Test(priority=9)
  public void helpCenter() throws InterruptedException
  {
	  Actions a =new Actions(driver);
      WebElement profile = driver.findElement(By.xpath("//div[@class='desktop-user']"));
      a.moveToElement(profile).perform();

   // click on contact us
      WebElement contact = driver.findElement(By.xpath("//div[contains(text(),'Contact Us')]"));
      a.moveToElement(contact).click().perform();

    driver.findElement(By.xpath("//div[contains(text(),'Non-order Related Issues')]")).click();
  
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
     
     ////div[@class='option-text option-isDisabled]
     chat=driver.findElement(By.xpath("//div[@class='contactUsOption-dOptionInsideWrapper']")).isEnabled();
     System.out.println(chat);

    Thread.sleep(1000);
     
     callNow=driver.findElement(By.xpath("//div[contains(text(),'Call Now')]")).isEnabled();
     System.out.println(callNow);
     
     writeToUs=driver.findElement(By.xpath("//div[contains(text(),'Write To Us')]")).isEnabled();
     System.out.println(writeToUs);
     
     
//     //Take Screenshot
//     File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//     
//     //copy the screenshot to the screenshot folder
//     FileUtils.copyFile(src, new File("ScreenShot\\defect_contactUs.png"));
  
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
  public void tearDown()
  {
	  driver.quit();
  }

}
