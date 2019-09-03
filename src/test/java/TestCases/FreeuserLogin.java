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
import UiActions.Freeuserobj;
import jxl.read.biff.BiffException;

public class FreeuserLogin  extends TestBase
{
  Freeuserobj free;
  public static final Logger log=Logger.getLogger(FreeuserLogin.class.getName());
  
  @BeforeMethod
  public void openbrowser(Method result) throws IOException
  {
	  test = extent.startTest(result.getName());
	  test.log(LogStatus.INFO, result.getName() + " test Started");
	  init();
  }
  @DataProvider(name="loginData")
	public String[][] getTestData() throws IOException, BiffException
	{
		String[][] testRecords = getData("TestData.xls", "Sheet1");
		return testRecords;
	}
  @Test (dataProvider="loginData")
  public void freeuseroperations(String username, String password) throws Exception 
  { 
	  free=new Freeuserobj(driver);
	  Thread.sleep(3000);
	  log.info("<===========Starting Free user operarions===========> ");
	  
	  free.freeuseroperatopns(username, password);
	  log.info("<===========Ended Free user operations===========> ");
  }

@AfterMethod
public void browserclose() throws Exception
{
	closeBrowser();
}

}
