package UiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import BusinessFunctions.TestBase;

public class Freeuserobj extends TestBase
{
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	
    public static final Logger log=Logger.getLogger(Freeuserobj.class.getName());
    
    public Freeuserobj(WebDriver driver)
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
    
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle file-upload-bg user-default-padding']")
    WebElement profile; //Web Element  For profile mouse over 
    
    @FindBy(how = How.XPATH, using = "//*[@id='header_notification_bar']/li[1]/a")
    WebElement profile1; //Web Element  For profile click 
    
    @FindBy(how = How.XPATH, using = "//div[2]/div[3]/ul/li[1]/span")
    WebElement currentplan; //Web Element  For profile click 
    
    @FindBy(how = How.LINK_TEXT, using = "Dashboard")
    WebElement Dashboard; //Web Element  For Dashboard click
    
    @FindBy(how = How.LINK_TEXT, using = "Post Manager")
    WebElement postmgr; //Web Element  For Post manager click
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaigns\"]")  
    WebElement campaigns; //Web Element  For Hover campaign 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Create Campaign\"]")
    WebElement createcampaign; //Web Element  For Hover create campaign 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaign Planner\"]")
    WebElement campaignplanner; //Web Element  For Hover  campaign planner 
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Campaign Calendar\"]")
    WebElement campaigncalendar; //Web Element  For Hover  campaign planner 
    
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
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Digital Library\"]")
    WebElement DigitalLibrary; //Web Element  For select  Digital Library
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Images\"]")
    WebElement Images; //Web Element  For select  Images
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Videos\"]")
    WebElement Videos; //Web Element  For select  Videos
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Audios\"]")
    WebElement Audios; //Web Element  For select  Audios
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Uploader\"]")
    WebElement Uploader; //Web Element  For select  Uploader
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Social Assets\"]")
    WebElement SocialAssets; //Web Element  For select  Social Assets
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Storage\"]")
    WebElement Storage; //Web Element  For select  Storage
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Stock Images\"]")
    WebElement StockImages; //Web Element  For select  Stock Images
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"RSS Content Manager\"]")
    WebElement Rsscontentmgr; //Web Element  For select  RSS Content Manager
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Subscriptions\"]")
    WebElement Subscriptions; //Web Element  For select  Subscriptions
    
    @FindBy(how = How.XPATH, using = "//span[text()=\"Extra Storage\"]")
    WebElement ExtraStorage; //Web Element  For select  Extra Storage
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    
    public void freeuseroperatopns(String username, String password) throws Exception
    {
  	  //enter user name 
  	  Thread.sleep(5000);
  	  musername.sendKeys(username);
  	  log.info("Entered user name " +username+ " and object is "+musername.toString());
  	  log.info("<===========User name entered successfully!===========> ");
  	  mpassword.sendKeys("social@123");
  	  log.info("Entered user name " +password+ " and object is "+mpassword.toString());
	  log.info("<===========password entered successfully!===========> ");
      loginbutton.click();
      log.info("<===========Login button clicked successfully!===========> ");
      //Thread.sleep(5000);
      Actions a = new Actions(driver);
      a.moveToElement(profile).click(profile1).build().perform();
      System.out.println(currentplan.getText());
      //softassert.assertEquals(currentplan.getText(),"Small Business Edition");
      log.info("<==========Current plan is - small Business Edition============> ");
      
      //Click on Dash board 
      Dashboard.click();
      log.info("<==========DashBoard clicked successfully on LeftMenu============> ");
      //Click on Post manager
      postmgr.click();
      log.info("<==========Post Manager clicked successfully on LeftMenu============> ");
      //Move the mouse to campaigns
      a.moveToElement(campaigns).click(createcampaign).build().perform();
      wait_for_page_load(2000);
      log.info("<==========Mouse moved to campaigns on LeftMenu and create campaign clicked successfully============> ");
      //click on campaign planner
      a.moveToElement(campaigns).click(campaignplanner).build().perform();
      log.info("<==========Mouse moved to campaigns on LeftMenu and campaign planner clicked successfully============> ");
      //Click on campaign calendar
      a.moveToElement(campaigns).click(campaigncalendar).build().perform();
      log.info("<==========Mouse moved to campaigns on LeftMenu and campaign calendar clicked successfully============> ");
      //Mouse hover on Reporting and select Digital library 
      a.moveToElement(reporting).click(DigitalLibraryreport).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Digital library clicked successfully============> ");
      //Mouse hover on Reporting and select Campaigns
      a.moveToElement(reporting).click(Campaignsreport).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Campaigns clicked successfully============> ");
      //Mouse hover on Reporting and select facebook
      a.moveToElement(reporting).click(Facebook).build().perform();
      log.info("<==========Mouse moved to Reporting on LeftMenu and Facebook clicked successfully============> ");
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
      SocialInbox.click();
      log.info("<==========Social inbox clicked successfully============> ");
      //Mouse hover on Digital library and select Images
      a.moveToElement(DigitalLibrary).click(Images).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Images clicked successfully============> ");
      //Mouse hover on Digital library and select Videos
      a.moveToElement(DigitalLibrary).click(Videos).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Videos clicked successfully============> ");
      //Mouse hover on Digital library and select Audio
      a.moveToElement(DigitalLibrary).click(Audios).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Audios clicked successfully============> ");
      //Mouse hover on Digital library and select Social assets
      a.moveToElement(DigitalLibrary).click(SocialAssets).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Social assets clicked successfully============> ");
      //Mouse hover on Digital library and select uploader
      a.moveToElement(DigitalLibrary).click(Uploader).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and uploader clicked successfully============> ");
     //Mouse hover on Digital library and select Storage
      a.moveToElement(DigitalLibrary).click(Storage).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Storage clicked successfully============> ");
     //Mouse hover on Digital library and select Stock images
      a.moveToElement(DigitalLibrary).click(StockImages).build().perform();
      log.info("<==========Mouse moved to Digital library on LeftMenu and Stock Images clicked successfully============> ");
      //Click on RSS content manager
      Rsscontentmgr.click();
      log.info("<==========RSS content manager clicked successfully============> ");
      //Mouse hover on Subscriptions and select Extra storage
      a.moveToElement(Subscriptions).click(ExtraStorage).build().perform();
      log.info("<==========Mouse moved to Subscriptions on LeftMenu and Extra storage clicked successfully============> ");
      
      
      
      
      
      
      
      
      
      
    }
}
