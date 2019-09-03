package UiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Prouserobj 
{
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	Actions a = new Actions(driver);
    public static final Logger log=Logger.getLogger(Prouserobj.class.getName());
    
    public void FreeUserOpr(WebDriver driver)
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
    
    @FindBy(how = How.XPATH, using = "//div/ul/li[5]/a/span[1]")
    WebElement campaigns; //Web Element  For Hover campaign 
    
    @FindBy(how = How.XPATH, using = "//div/ul/li[5]/ul/li[1]/a/span")
    WebElement createcampaign; //Web Element  For Hover campaign 
    
    
    
     
    
    public void prouseroperations(String username, String password) throws Exception
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
      Thread.sleep(5000);
      
      a.moveToElement(profile).click(profile1).build().perform();
      System.out.println(currentplan.getText());
      softassert.assertEquals(currentplan.getText(),"Small Business Edition");
      log.info("<==========Current plan is - small Business Edition============> ");
    }
}
