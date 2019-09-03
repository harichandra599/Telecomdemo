package UiActions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import BusinessFunctions.TestBase;

public class Socialinbox_Facebookobj extends TestBase
{
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	
	   public static final Logger log=Logger.getLogger(Socialinbox_Facebookobj.class.getName());
	   
	   public  Socialinbox_Facebookobj(WebDriver driver)
	   {
	   	 this.driver=driver;
	   	 PageFactory.initElements(driver, this);
	   }
	   @FindBy(how = How.NAME, using = "email")
	   WebElement musername; //Web Element and id For user name 
	   
	   @FindBy(how = How.NAME, using = "pwd")
	   WebElement mpassword; //Web Element and id For user name 
	   
	   @FindBy(how = How.XPATH, using = "//button[@type='submit']")
	   WebElement loginbutton; //Web Element  For login button click 
	   
	   @FindBy(how = How.XPATH, using = "//label[starts-with(@class,'socialStatusCount')]")
	   WebElement pagepostscnt; //Web Element  For login button click
	   
	   
	   @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle file-upload-bg user-default-padding']")
	   WebElement profile; //Web Element  For profile mouse over 
	   
	   @FindBy(how = How.XPATH, using = "//*[@id='header_notification_bar']/li[1]/a")
	   WebElement profile1; //Web Element  For profile click 
	   
	   @FindBy(how = How.XPATH, using = "//div[2]/div[3]/ul/li[1]/span")
	   WebElement currentplan; //Web Element  For current plan 
	   
	   //span[contains(text(),'Enterprise')]
	   @FindBy(how = How.LINK_TEXT, using = "Dashboard")
	   WebElement Dashboard; //Web Element  For Dashboard click
	   
	   @FindBy(how = How.XPATH, using = "//span[text()=\"Social Inbox\"]")
	   WebElement SocialInbox; //Web Element  For select  Social Inbox
	   
	   @FindBy(how = How.XPATH, using = "//a[@id='Facebook']/img")
	   WebElement Sifacebook; //Web Element  For select  Facebook
	   	   
	   @FindBy(how = How.XPATH, using = "//a[@data-original-title=\"Navigate to profile\"]")
	   WebElement fbpostownername; //Web Element  For getting Facebook post owner 
	   
	   @FindBy(how = How.XPATH, using = "//a[starts-with(@class,'socailAnchorLink')]/i")
	   WebElement fblike; //Web Element  For click the like button
	   
	   @FindBy(how = How.XPATH, using = "//i[starts-with(@class,'icon-tag')]")
	   WebElement tags; //Web element for tags 
	   
	   @FindBy(how = How.XPATH, using = "//a[@class='deleteFeedTag tooltipClass']")
	   WebElement exittag; //Web element for exist tag
	   
	   @FindBy(how = How.XPATH, using = "//input[@placeholder='Add tag']")
	   WebElement taginput; //Web element for Tag input 
	   
	   @FindBy(how = How.XPATH, using = "//input[@placeholder='Add tag']")
	   WebElement tagname; //Web element for tag name 
	
	   @FindBy(how = How.XPATH, using = "//div[@class='feeds-content']")
	   WebElement feedscontent; //Web element for clicking feed
	   
	   @FindBy(how = How.ID, using = "fb-comment-box")
	   WebElement fbcommentbox; //Web element for Facebook comment box
	   
	   @FindBy(how = How.XPATH, using = "//div[@class='image_library fb_comment_digital']//i")
	   WebElement fbcmntdl; //Web element for Digital library icon in Facebook comment
	   
	   @FindBy(how = How.XPATH, using = "//div[contains(@class,'modal fade in')]//div[4]//img[1]")
	   WebElement dlimg; //Web element for Digital library image selection
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   public void Socialinboxfacebookoperations(String username, String password) throws Exception
	   {
		      
		      Robot robot = new Robot();
		      //enter user name 
		  	  Thread.sleep(5000);
		  	  musername.sendKeys(username);
		  	  log.info("Entered user name " +username+ " and object is "+musername.toString());
		  	  log.info("<===========User name entered successfully!===========> ");
		  	  mpassword.sendKeys(password);
		  	  log.info("Entered password " +password+ " and object is "+mpassword.toString());
			  log.info("<===========password entered successfully!===========> ");
			  Thread.sleep(5000);
		      loginbutton.click();
		      log.info("<===========Login button clicked successfully!===========> ");
		      Instant starttime=Instant.now();
		      wait_for_page_load(5000);
		      if(pagepostscnt.isDisplayed())
		      {
		    	  log.info("<===========Page posts count is ===========> " + pagepostscnt.getText());
		      }
		      Instant endtime=Instant.now();
		      Duration timeinterval=Duration.between(starttime, endtime);
		      log.info("<===========Time(Seconds) taken for Dashboard loading is:===========>" +timeinterval.getSeconds());
		      wait_for_page_load(10000);
		      Actions a = new Actions(driver);
		      a.moveToElement(profile).click(profile1).build().perform();
		      
		      System.out.println(currentplan.getText());
		      softassert.assertEquals(currentplan.getText(),"Enterprise");
		      log.info("<==========Current plan is - Enterprise============> ");
		      //Click on Dash board 
		      Dashboard.click();
		      log.info("<==========DashBoard clicked successfully on LeftMenu============> ");
		      //Click on social inbox 
		      SocialInbox.click();
		      log.info("<==========Social inbox clicked successfully============> ");
		      //Click on facebook Tab
		     // Sifacebook.click();
		      log.info("<==========In Social inbox Facebook Tab clicked successfully============> ");
		      //Getting facebook post owner name 
		      System.out.println(fbpostownername.getText());
		      log.info("<==========Social Inbox facebook post owner name is : ============>"+fbpostownername.getText());
		      //click on like button 
		      //wait_for_element_present(fblike);
		      Thread.sleep(3000);
		      fblike.click();
		      log.info("<==========Social Inbox facebook post liked successfully ============>");
		      //click on up arrow
		      robot.keyPress(KeyEvent.VK_PAGE_UP);
		      robot.keyPress(KeyEvent.VK_PAGE_UP);
		      robot.keyPress(KeyEvent.VK_PAGE_UP);
		      robot.keyPress(KeyEvent.VK_PAGE_UP);
		      robot.keyPress(KeyEvent.VK_PAGE_UP);
		      
		      //Click on Tag button 
		      Thread.sleep(5000);
		      tags.click();
		      log.info("<==========Tag button clicked successfully============>");
		      Thread.sleep(5000);
	        	  if(taginput.isDisplayed())
	        	  {
	        		  
	        		  Thread.sleep(5000);
	        		  taginput.sendKeys(generateRandomString(6));
	        		  log.info("<==========Tag name given by automation successfully============>");
	        		  robot.keyPress(KeyEvent.VK_ENTER);
	        	  	  robot.keyRelease(KeyEvent.VK_ENTER);
	        	  	  Thread.sleep(4000);
	        		  
	        		  
	        	  }
	        	  else
	        	  {
	        		  
	        		  wait_for_page_load(4000);
	        		  exittag.click();
	        		  taginput.sendKeys("generateRandomString(6)");
	        		  //Enter_with_robot();
	        		  robot.keyPress(KeyEvent.VK_ENTER);
	        	  	  robot.keyRelease(KeyEvent.VK_ENTER);
	        		  log.info("<==========Tag name given by automation successfully============>");
	        	  }
	          
		      
		      Thread.sleep(3000);;
		      //click on feeds content 
		      /*feedscontent.click();
		      log.info("<==========Feeds content clicked successfully============>");*/
		      //write the decription in Facebook post comment box 
		      wait_for_page_load(4000);
		      fbcommentbox.sendKeys("Comment given by automation");
		      //click on digital library for selecting an image 
		      fbcmntdl.click();
		      log.info("<==========Digital library icon clicked successfully============>");
	          //click on image in digtakl library 
		      Thread.sleep(3000);
		      dlimg.click();
		      log.info("<==========Digital library image  clicked successfully============>");

}
}
