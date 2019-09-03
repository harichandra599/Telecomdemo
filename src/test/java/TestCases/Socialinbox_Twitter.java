package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import BusinessFunctions.TestBase;
import UiActions.Socialinbox_Twitterobj;
import jxl.read.biff.BiffException;

public class Socialinbox_Twitter extends TestBase
{
   Socialinbox_Twitterobj sitwitter;
   public static final Logger log=Logger.getLogger(Socialinbox_Twitter.class.getName());
   
   @BeforeMethod
   public void openBrowser(Method result) throws Exception
   {
	   test = extent.startTest(result.getName());
	   test.log(LogStatus.INFO, result.getName() + "Social Inbox Twitter Test Started");
	   init();
	   
   }
   @DataProvider(name="loginData")
	public String[][] getTestData() throws IOException, BiffException
	{
		String[][] testRecords = getData("TestData.xls", "Sheet3");
		return testRecords;
	}
 @Test (dataProvider="loginData")
 public void socialinboxtwitter(String username, String password) throws Exception 
 { 
	 sitwitter=new Socialinbox_Twitterobj(driver);
	  Thread.sleep(3000);
	  log.info("<===========Starting Social Inbox Twitter operations===========> ");
	  sitwitter.Socialinboxtwitteroperations(username, password);
	  Thread.sleep(3000);
	  sitwitter.SocialinboxtwitterMentions();
	  log.info("<===========Ended Social Inbox Twitter operations operations===========> ");
	  /*Sendmail sndmail=new Sendmail();
	  sndmail.SendAttachment();*/
	  
 }

@AfterMethod
public void browserclose() throws Exception
{
	closeBrowser();
}
	
}
