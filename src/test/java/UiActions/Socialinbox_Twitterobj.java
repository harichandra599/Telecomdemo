package UiActions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import BusinessFunctions.TestBase;
import net.sourceforge.htmlunit.corejs.javascript.NativeGenerator.GeneratorClosedException;

public class Socialinbox_Twitterobj extends TestBase
{
   WebDriver driver;
   SoftAssert softassert=new SoftAssert();
	
   public static final Logger log=Logger.getLogger(Socialinbox_Twitterobj.class.getName());
   
   public  Socialinbox_Twitterobj(WebDriver driver)
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
   
   @FindBy(how = How.XPATH, using = "//a[@id='Twitter']/img")
   WebElement Sitwitter; //Web Element  For select  Twitter
   
   @FindBy(how = How.XPATH, using = "//a[starts-with(@data-original-title,'Navigate to Profile')]")
   WebElement twitterusrname; //Web Element  For getting twitter user name 
   
  // @FindBy(how = How.XPATH, using = " //div[@class='feeds-content']//p[contains(text(),'getting inbox tweets')]")
  // WebElement tweetdesc; //Web Element  For getting tweet description 
   
   @FindBy(how = How.XPATH, using = "//i[@class='icon-calendar icons']//span")
   WebElement tweetdate; //Web element for Tweet 
   
   @FindBy(how = How.XPATH, using = "//div[@class='feeds-date']//span")
   WebElement tweetdtae; //Web element for Tweet Date 
   
   @FindBy(how = How.XPATH, using = "//div[@class='feeds-action-icons']")
   WebElement like; //Web element for like tweet
   
   @FindBy(how = How.XPATH, using = "//span[starts-with(@class,'tags_count')]")
   WebElement tags; //Web element for tags 
   
   @FindBy(how = How.XPATH, using = "//a[@class='deleteFeedTag tooltipClass']")
   WebElement exittag; //Web element for exist tag
   
   @FindBy(how = How.XPATH, using = "//input[@placeholder='Add tag']")
   WebElement taginput; //Web element for Tag input
   
   @FindBy(how = How.XPATH, using = "//input[@placeholder='Add tag']")
   WebElement tagname; //Web element for tag name 
   
   @FindBy(how = How.XPATH, using = "//i[@data_following='1']")
   WebElement twitterdm; //Web element for twitter Dm
   
   @FindBy(how = How.XPATH, using = "//div[@id = 'dm_msg']")
   WebElement twitterdmmsg; //Web element for twitter Dm message description
   
   @FindBy(how = How.XPATH, using = "//button[@id ='sendDM']")
   WebElement twitterdmbtn; //Web element for twitter dm send button 
   
   @FindBy(how = How.XPATH, using = "//i[@data_following='0']")
   WebElement twitterdm2; //Web element for twitter dm send button 
   
   @FindBy(how = How.XPATH, using = "//div[@id='twitterReplyInput']")
   WebElement twitterreplyinput; //Web element for twitter reply
   
   @FindBy(how = How.XPATH, using = "//div[@class='image_library']//i")
   WebElement twitterreplydl; //Web element for Digital library icon in twitter reply
   
   @FindBy(how = How.XPATH, using = "//*[@id=\"img-872380\"]")
   WebElement twitterreplydlimg; //Web element for Digital library image selection
  
   @FindBy(how = How.XPATH, using = "//button[@class='reply-tweet pull-right']")
   WebElement twitterreplybtn; //Web element for reply button 
  
   @FindBy(how = How.CLASS_NAME, using = "selectPosts changeFilter")
   WebElement postscheckbox; //Web element for posts check box 
   
   @FindBy(how = How.CLASS_NAME, using = "selectMentionsPosts changeFilter")
   WebElement mentionscheckbox; //Web element for Mentions check box
   
   
   
   
   
   
   
   public void Socialinboxtwitteroperations(String username, String password) throws Exception
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
	      //Click on Twitter Tab
	      Sitwitter.click();
	      log.info("<==========In Social inbox Twitter Tab clicked successfully============> ");
	      //Getting Tweet owner name 
	      System.out.println(twitterusrname.getText());
	      log.info("<==========Tweet owner name is============>:" +twitterusrname.getText());
	      //Getting Tweet Date 
	    // System.out.println(tweetdate.getText());
	     // log.info("<==========Tweet Date  is============>:" +tweetdate.getText());
	      //Click on Like 
	      like.click();
	      log.info("<==========Like Button clicked successfully============>");
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
        		  Thread.sleep(4000);
        		 // Enter_with_robot();
        		  robot.keyPress(KeyEvent.VK_ENTER);
        	  	  robot.keyRelease(KeyEvent.VK_ENTER);
        		  
        		  
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
          
	      
	      wait_for_page_load(5000);
          //Click on Twitter dm icon 
	      if(twitterdm.isDisplayed())
	      {
	    	  twitterdm.click();
    		  log.info("<==========Twitter direct message icon clicked  successfully============>");
	    	  wait_for_page_load(3000);
	    	  //Enter message description
	    	  twitterdmmsg.sendKeys("Twitter Direct message given by automation");
    		  log.info("<==========Twitter direct message description given by automation successfully============>");
	    	  //Click on Send button 
	    	  twitterdmbtn.click();
	    	  log.info("<==========Twitter direct message send buttton clicked successfully============>");
	      }
	      else
	      {
	    	  //click on twiter dm icon 
	    	  twitterdm2.click();
	    	  log.info("<==========Twitter direct message icon clicked  successfully============>");
	    	  wait_for_page_load(4000);
	    	  twitterdmmsg.sendKeys("Twitter direct message given by automation");
	    	  log.info("<==========Twitter direct message description given by automation successfully============>");
	    	  twitterdmbtn.click();
	    	  twitterdmbtn.click();
	       	  log.info("<==========Twitter direct message send buttton clicked successfully============>");
	      }
	      //reply to the Tweet 
	      wait_for_page_load(5000);
	      twitterreplyinput.sendKeys("Tweet reply given by automation ");
	      log.info("<==========Twitter reply given by automation successfully============>");
	      //click on digital library
	      wait_for_page_load(3000);
	      twitterreplydl.click();
	      log.info("<==========Twitter reply Digital library icon clicked  successfully============>");
	      //select image from Digital library 
	      wait_for_page_load(5000);
	      twitterreplydlimg.click();
	      log.info("<==========Twitter reply image selected from Digital library successfully============>");
	      //Click on reply button 
	      Thread.sleep(4000);;
	      //scroll down window
	      scroll_down();
	      twitterreplybtn.click();
	      log.info("<==========Twitter reply button clicked  successfully============>");
	      wait_for_page_load(4000);
	     }
   public void SocialinboxtwitterMentions() throws Exception
   {
	   //Click on Mentions
	   mentionscheckbox.click();
	   log.info("<==========Mentions checkbox clicked  successfully============>");
	   Thread.sleep(3000);
	 //un check the posts check box
	   postscheckbox.click();
	   log.info("<==========Posts checkbox clicked  successfully============>");
	   Thread.sleep(3000);
   }
}
