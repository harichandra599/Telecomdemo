package UiActions;

import java.time.Duration;
import java.time.Instant;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import BusinessFunctions.TestBase;

public class Enterpriseuserobj extends TestBase
{
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	
    public static final Logger log=Logger.getLogger(Enterpriseuserobj.class.getName());
    
    public  Enterpriseuserobj(WebDriver driver)
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
    
    @FindBy(how = How.XPATH, using = "//span[contains(@id,'fb_comment_coun')]")
    WebElement fbltstcmnt; //Web Element  For Get comments count click
  
            
    @FindBy(how = How.LINK_TEXT, using = "Post Manager")
    WebElement postmgr; //Web Element  For Post manager click
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Post Manager\"]")
    WebElement postmgr1; //Web Element  For Post manager click
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Bulk Upload                                        \"]")
    WebElement BulkUpload; //Web Element  For Bulk Upload click
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Pending Approval\"]")
    WebElement PendingApproval; //Web Element  For Pending Approval click
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaigns\"]")  
    WebElement campaigns; //Web Element  For Hover campaign 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Create Campaign\"]")
    WebElement createcampaign; //Web Element  For Hover create campaign 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaign Planner\"]")
    WebElement campaignplanner; //Web Element  For Hover  campaign planner 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaign Calendar\"]")
    WebElement campaigncalendar; //Web Element  For Hover  campaign Calendar
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Ads\"]")
    WebElement Ads; //Web Element  For Hover  Ads
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Create Ads\"]")
    WebElement CreateAds; //Web Element  For Hover  Create Ads
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Ad Drafts\"]")
    WebElement AdDrafts; //Web Element  For Hover  Ads
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Reporting\"]")
    WebElement reporting; //Web Element  For Hover  reporting 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Digital Library\"]")
    WebElement DigitalLibraryreport; //Web Element  For select  DigitalLibrary 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaigns\"]")
    WebElement Campaignsreport; //Web Element  For select  Campaigns 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Facebook\"]")
    WebElement Facebook; //Web Element  For select  Facebook 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Twitter\"]")
    WebElement Twitter; //Web Element  For select  Twitter 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Tumblr\"]")
    WebElement Tumblr; //Web Element  For select  Tumblr 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"LinkedIn\"]")
    WebElement LinkedIn; //Web Element  For select  LinkedIn 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Instagram\"]")
    WebElement Instagram; //Web Element  For select  Instagram 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"YouTube\"]")
    WebElement YouTube; //Web Element  For select  YouTube
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Short URL\"]")
    WebElement ShortURL; //Web Element  For select  Short URL 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Social Inbox\"]")
    WebElement SocialInbox; //Web Element  For select  Social Inbox
  
    @FindBy(how = How.XPATH, using = "//span[text()=\"Social Listening\"]")
    WebElement SocialListening; //Web Element  For select  Social Listening
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Digital Library\"]")
    WebElement DigitalLibrary; //Web Element  For select  Digital Library
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Media\"]")
    WebElement Media; //Web Element  For select  Media
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Social Assets\"]")
    WebElement SocialAssets; //Web Element  For select  Social Assets
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Google Drive\"]")
    WebElement GoogleDrive; //Web Element  For select  Google Drive
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Storage\"]")
    WebElement Storage; //Web Element  For select  Storage
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"RSS Content Manager\"]")
    WebElement rsscntntmgr; //Web Element  For select  RSS Content Manager
    
  
    @FindBy(how = How.XPATH, using = "//span[text()=\"Teams & Brands\"]")
    WebElement TandB; //Web Element  For select  Teams & Brands
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Manage Teams\"]")
    WebElement manageteams; //Web Element  For select  Manage Teams
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Global Permissions\"]")
    WebElement GlobalPermissions; //Web Element  For select  Global Permissions
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Activity Log\"]")
    WebElement ActivityLog; //Web Element  For select  Activity Log
     
    
    public void enterpriseuseroperations(String username, String password) throws Exception
    {
  	  //enter user name 
  	  Thread.sleep(5000);
  	  musername.sendKeys(username);
  	  log.info("Entered user name " +username+ " and object is "+musername.toString());
  	  log.info("<===========Hi User name entered successfully!===========> ");
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
      //Get Fb Latest comments count
      Thread.sleep(10000);
      if(fbltstcmnt.isDisplayed())
      {
    	  log.info("<==========latest comments displayed with in 10 seconds ============> ");
      }
      else
      {
    	  Dbcapture_screen();
      }
      System.out.println(fbltstcmnt.getText());
      //Mouse hover on post manager in left menu and click on Post manager
      a.moveToElement(postmgr).click(postmgr1).build().perform();
      log.info("<==========mousee hover on post manager in LeftMenu and click on post manager successfully============> ");
      //Mouse hover on post manager in left menu and click on Bulk upload
      a.moveToElement(postmgr).click(BulkUpload).build().perform();
      log.info("<==========mouse hover on post manager in LeftMenu and click on bulk upload successfully============> ");
      //Mouse hover on post manager in left menu and click on Pending approval
      wait_for_page_load(3000);
      a.moveToElement(postmgr).click(PendingApproval).build().perform();
      log.info("<==========mouse hover on post manager in LeftMenu and click on Pending approval successfully============> ");
      //Move the mouse to campaigns
      wait_for_page_load(2000);
      a.moveToElement(campaigns).click(createcampaign).build().perform();
      
      log.info("<==========Mouse moved to campaigns on LeftMenu and create campaign clicked successfully============> ");
      //click on campaign planner
      a.moveToElement(campaigns).click(campaignplanner).build().perform(); 
      log.info("<==========Mouse moved to campaigns on LeftMenu and campaign planner clicked successfully============> ");
      //Click on campaign calendar
      a.moveToElement(campaigns).click(campaigncalendar).build().perform();
      log.info("<==========Mouse moved to campaigns on LeftMenu and campaign calendar clicked successfully============> ");
      //Mouse hover on Ads in Left menu and click on Create ads
      a.moveToElement(Ads).click(CreateAds).build().perform();
      log.info("<==========Mouse moved to Ads on LeftMenu and Create ads clicked successfully============> ");
      //Mouse hover on Ads in Left menu and click on  ads drafts
      a.moveToElement(Ads).click(AdDrafts).build().perform();
      log.info("<==========Mouse moved to Ads on LeftMenu and Ad Drafts clicked successfully============> ");
      //Mouse hover on Reporting and select Digital library 
      //wait_for_page_load(4000);
      a.moveToElement(reporting).click(DigitalLibraryreport).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Digital library clicked successfully============> ");
      //Mouse hover on Reporting and select Campaigns
      a.moveToElement(reporting).click(Campaignsreport).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Campaigns clicked successfully============> ");
      //Mouse hover on Reporting and select facebook
    /*  wait_for_page_load(3000);
      a.moveToElement(reporting).perform();
      a.moveToElement(reporting).click(Facebook).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Facebook clicked successfully============> ");*/
      //Mouse hover on Reporting and select Twitter
      a.moveToElement(reporting).click(Twitter).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Twitter clicked successfully============> ");
      //Mouse hover on Reporting and select Tumblr
      a.moveToElement(reporting).click(Tumblr).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Tumblr clicked successfully============> ");      
      //Mouse hover on Reporting and select Linkedin
      a.moveToElement(reporting).click(LinkedIn).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Linkedin clicked successfully============> ");
      //Mouse hover on Reporting and select Instagram
      a.moveToElement(reporting).click(Instagram).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and instagram clicked successfully============> ");
      //Mouse hover on Reporting and select youtube
      a.moveToElement(reporting).click(YouTube).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and youtube clicked successfully============> ");
      //Mouse hover on Reporting and select short url
      a.moveToElement(reporting).click(ShortURL).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Short url clicked successfully============> ");
      //click on social inbox
      wait_for_page_load(10000);
      SocialInbox.click();
      log.info("<==========Social inbox clicked successfully============> ");
      //Click on social Listening
      SocialListening.click();
      log.info("<==========Social Listening clicked successfully============> ");
      //Mouse hover on digital library and click on Media
      wait_for_page_load(5000);
      a.moveToElement(DigitalLibrary).moveToElement(Media).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Media clicked successfully============> ");
      //Mouse hover on digital library and click on social assets
      a.moveToElement(DigitalLibrary).moveToElement(SocialAssets).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and SocialAssets clicked successfully============> ");
      //Mouse hover on digital library and click on GoogleDrive
      a.moveToElement(DigitalLibrary).moveToElement(GoogleDrive).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and GoogleDrive clicked successfully============> ");
    //Mouse hover on digital library and click on Storage
      a.moveToElement(DigitalLibrary).moveToElement(Storage).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Storage clicked successfully============> ");
      //Click on Rss content manager
      rsscntntmgr.click();
      log.info("<==========RSS content manager clicked successfully============> ");
      //click on 
      a.moveToElement(TandB).moveToElement(manageteams).build().perform();
      log.info("<==========Mouse moved to T and B on LeftMenu and Manage Teams clicked successfully============> ");
      a.moveToElement(TandB).moveToElement(GlobalPermissions).build().perform();
      log.info("<==========Mouse moved toT and B on LeftMenu and Global permissions clicked successfully============> ");
      a.moveToElement(TandB).moveToElement(ActivityLog).build().perform();
      log.info("<==========Mouse moved to T and B on LeftMenu and Activity log clicked successfully============> ");
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
}
