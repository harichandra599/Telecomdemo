package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;
import BusinessFunctions.TestBase;
import UiActions.Socialinbox_Facebookobj;
import jxl.read.biff.BiffException;

public class Socialinbox_Facebook extends TestBase
{
	Socialinbox_Facebookobj sifacebook;
	public static final Logger log=Logger.getLogger(Socialinbox_Facebook.class.getName());
	@BeforeMethod
	   public void openBrowser(Method result) throws Exception
	   {
		   test = extent.startTest(result.getName());
		   test.log(LogStatus.INFO, result.getName() + "Social Inbox Facebook Test Started");
		   init();
		   
	   }
	@DataProvider(name="loginData")
	  public String[][] getTestData() throws IOException, BiffException
		{
			String[][] testRecords = getData("TestData.xls", "Sheet3");
			return testRecords;
		}
	 @Test (dataProvider="loginData")
	 public void socialinboxfacebook(String username, String password) throws Exception 
	 { 
		 sifacebook=new Socialinbox_Facebookobj(driver);
		  Thread.sleep(3000);
		  log.info("<===========Starting Social Inbox Facebook operations===========> ");
		  sifacebook.Socialinboxfacebookoperations(username, password);
		  log.info("<===========Ended Social Inbox Facebook operations===========> ");
		  /*Sendmail sndmail=new Sendmail();
		  sndmail.SendAttachment();*/
		  
	 }

	@AfterMethod
	public void browserclose() throws Exception
	{
		closeBrowser();
	}

}
