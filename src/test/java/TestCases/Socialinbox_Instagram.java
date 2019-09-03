package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;
import BusinessFunctions.TestBase;
import UiActions.Socialinbox_instagramobj;
import jxl.read.biff.BiffException;

public class Socialinbox_Instagram extends TestBase
{
  Socialinbox_instagramobj siinstagram;
  public static final Logger log = Logger.getLogger(Socialinbox_Instagram.class.getName());
  @BeforeMethod
  public void openBrowser(Method result) throws Exception
  {
	  test = extent.startTest(result.getName());
	  test.log(LogStatus.INFO, result.getName() + "Social Inbox Instagram Test Started");
	  init();
  }
  @DataProvider(name="loginData")
  public String[][] getTestData() throws IOException, BiffException
	{
		String[][] testRecords = getData("TestData.xls", "Sheet3");
		return testRecords;
	}
  @Test(dataProvider = "loginData")
  public void Socialinboxinstagram(String username, String password) throws Exception
  {
	  siinstagram = new Socialinbox_instagramobj(driver);
	  Thread.sleep(5000);
	  log.info("<===========Starting Social Inbox instagram operations===========> ");
	  siinstagram.Socialinboxinstagramoperations(username, password);
	  log.info("<===========Ended Social Inbox Instagram operations operations===========> ");
	  /*Sendmail sndmail=new Sendmail();
	  sndmail.SendAttachment();*/
  }
  @AfterMethod
  public void browserclose() throws Exception
	{
		closeBrowser();
	}
}
