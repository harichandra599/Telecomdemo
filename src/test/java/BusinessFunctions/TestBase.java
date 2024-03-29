package BusinessFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelReader.ExcelReader;
import Listeners.Listner;
import jxl.read.biff.BiffException;

public class TestBase 
{
	
public static final Logger log=Logger.getLogger(TestBase.class.getName());
public static WebDriver driver;
Listner lis;
ExcelReader excelreader;
public static ExtentReports extent;
public static ExtentTest test;
public Properties OR=new Properties();

public WebDriver getDriver() 
{
	return driver;
}


/*...................> Static Block to generate Reports <..........................*/

static
{
	Calendar calendar=Calendar.getInstance();
  	SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
  	extent=new ExtentReports(System.getProperty("user.dir")+"//src//test//java//ExecutionReports//Test_Execution_Report-"+formater.format(calendar.getTime())+".html",false);
	
}
/*...................> Method to load data from config.properfies file <..........................*/

public void load_data() throws IOException
{
	File config = new File(System.getProperty("user.dir") + "//src//test//java//Configurations//config.properties");
	//File homepage= new File(System.getProperty("user.dir") + "//src//test//java//com//mavSocial//config//homepage.properties");
	FileInputStream f1 = new FileInputStream(config);
	//FileInputStream f2 = new FileInputStream(homepage);
	OR.load(f1);
	//OR.load(f2);

}

/*...................> Method to initialize browser and to get URL of the page <..........................*/

public void init() throws IOException
{
	load_data();
	String log4jConfPath="log4j.properties";
	PropertyConfigurator.configure(log4jConfPath);
	select_browser(OR.getProperty("browser"));
	get_url(OR.getProperty("url"));

}

/*...................> Method to select a browser <..........................*/

public void select_browser(String browser)
{
  if(browser.equalsIgnoreCase("firefox"))
  {
	  log.info("creating object of "+browser);
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
	  driver= new FirefoxDriver();
      driver.manage().window().maximize();
  }
  if(browser.equalsIgnoreCase("chrome"))
  {
	  
	  log.info("creating object of "+browser);
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
	  driver= new ChromeDriver();
      driver.manage().window().maximize();
  }
  if(browser.equalsIgnoreCase("ie"))
  {
	  log.info("creating object of "+browser);
	  System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
	  driver=new InternetExplorerDriver();
      driver.manage().window().maximize();
  }
  if(browser.equalsIgnoreCase("chromeheadless"))
  {
	  log.info("creating object of "+browser);
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("headless");	  
	  options.addArguments("window-size=1400,800");
	  options.setPageLoadStrategy(PageLoadStrategy.NONE);
	  driver= new ChromeDriver(options);
      driver.manage().window().maximize();
  }
  if(browser.equalsIgnoreCase("firefoxheadless"))
  {
	  log.info("creating object of "+browser);
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
	  FirefoxOptions options = new FirefoxOptions();
	  options.setHeadless(true);
	  driver= new FirefoxDriver(options);
      driver.manage().window().maximize();
  }
  if(browser.equalsIgnoreCase("htmlunitdriver"))
  {
	  log.info("creating object of "+browser);
	  driver= new HtmlUnitDriver(true);
      driver.manage().window().maximize();
  }
  if(browser.equalsIgnoreCase("phantomjs"))
  {
	  System.setProperty("phantomjs.binary.path", System.getProperty("user.dir")+"/drivers/phantomjs.exe");		

	  driver = new PhantomJSDriver();
	 
  }
	
}

/*...................> Method to get URL of the page <..........................*/

public void get_url(String url)
{
	log.info(" =====>Navigating to url<======= "+url);
	driver.get(url);
	driver.manage().window().maximize();
}

/*...................> Method to CaptureScreenshot <..........................*/

public String capture_screen(String fileName) 
{
	if (fileName == "") 
	{
		fileName = "blank";
	}
	File destFile = null;
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	try
	{
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "//src//test//java//Screenshots//Screen_Shot_Of-";
		destFile = new File(reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(scrFile, destFile);
		// This will help us to link the screen shot in testNG report
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

	}
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	return destFile.toString();
}
public void Dbcapture_screen() throws Exception
{
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	 Date dt = new Date();
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(scrFile, new File("\\src\\test\\java\\Screenshots\\"+dateFormat.format(dt)+".png"));
}
/*...................> Method to close a Browser <..........................*/

public void closeBrowser() throws Exception 
{
	wait_for_page_load(15);
	driver.close();
	log.info("Window closed");
	//driver.quit();
	log.info("Browser closed");
	extent.endTest(test);
	extent.flush();
}

/*...................> Method for generating extent reports <..........................*/

public void get_result(ITestResult result)
{
	if (result.getStatus() == ITestResult.SUCCESS)
	{
		test.log(LogStatus.PASS, result.getName() + " test is pass");
		String screen = capture_screen(result.getName());
		test.log(LogStatus.PASS, test.addScreenCapture(screen));
	}
	else if (result.getStatus() == ITestResult.SKIP) 
	{
		test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		String screen = capture_screen(result.getName());
		test.log(LogStatus.PASS, test.addScreenCapture(screen));
	}
	else if (result.getStatus() == ITestResult.FAILURE) 
	{
		test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
		String screen = capture_screen(result.getName());
		test.log(LogStatus.FAIL, test.addScreenCapture(screen));
	}
	else if (result.getStatus() == ITestResult.STARTED)
	{
		test.log(LogStatus.INFO, result.getName() + " test is started");
	}
}

/*...................> Method to read data from Excel Sheet <..........................*/

public String[][] getData(String excelName, String sheetName) throws BiffException, IOException
{
	//System.out.println(System.getProperty("user.dir"));
	String excellocation = System.getProperty("user.dir")+"//src//test//java//TestData//"+excelName;
	System.out.println(excellocation);
	excelreader = new ExcelReader();
	return excelreader.readExcel(excellocation, sheetName);
}

/*...................> JavaScriptExecutor code to highlight an Element <..........................*/

public static void highlight_me(WebDriver driver, WebElement element) throws InterruptedException 
{
	// Creating JavaScriptExecuter Interface
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// Execute javascript
	js.executeScript("arguments[0].style.border='4px solid yellow'", element);
	Thread.sleep(3000);
	js.executeScript("arguments[0].style.border=''", element);
}

/*...................> JavaScriptExecutor code to Scroll down the page <..........................*/

public static void scroll_down()
{
	JavascriptExecutor js = ((JavascriptExecutor) driver);

	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
}

/*...................> JavaScriptExecutor code to Scroll down to particular web element <..........................*/

public static void scroll_down_to_element(WebElement ele)
{
	JavascriptExecutor js = ((JavascriptExecutor) driver);

	js.executeScript("arguments[0].scrollIntoView();", ele);
}

/*...................> Scrolling down using Robot Class <..........................*/

public static void scroll_down_with_robot() throws AWTException
{
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	
}
public static void Enter_with_robot() throws AWTException
{
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_ENTER);
	
}
/*...................> Implicitly wait Method to wait for loading a page <..........................*/

public void wait_for_page_load(int time) throws Exception
{
	driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	Thread.sleep(5000);
}

/*...................> Explicitly wait Method for waiting an element in a page <..........................*/

public void wait_for_element_present(WebElement wb)
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(wb));
}

/*...................> Explicitly wait Method for URL in a page <..........................*/

public void wait_until_url_contains(String url)
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.urlContains(url));
}

/*...................> Explicitly wait Method for URL in a page <..........................*/

public void wait_until_text_present(WebElement wb,String text)
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.textToBePresentInElement(wb, text));
}

/*...................> Method to use Fluent wait <..........................*/

public void fluent_wait(WebElement ele)
{
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
	wait.withTimeout(30, TimeUnit.SECONDS);
	wait.pollingEvery(5, TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
}

/*...................> Normal wait method using Thread.Sleep method <..........................*/
public void wait_in_seconds(int i) throws InterruptedException
{
	Thread.sleep(1000*i);
}

/*...................> Method to Accept an Alert in a browser <..........................*/

public void accept_alert()
{
	Alert alt=driver.switchTo().alert();
	alt.accept();
}

/*...................> Method to Cancel an Alert in a browser <..........................*/

public void cancel_alert(){
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
}

/*...................> Method to get an alert text <..........................*/

public String get_alert_text(){
	Alert alt=driver.switchTo().alert();
    String text=alt.getText();
    return text;
}

/*...................> Method for switching to a frame using id <..........................*/

public void swith_to_frame_using_id(String id)
{
	driver.switchTo().frame(id);
}

/*...................> Method for switching to a frame using name <..........................*/

public void swith_to_frame_using_name(String name)
{
	driver.switchTo().frame(name);
}

/*...................> Method for switching to a frame using number <..........................*/

public void swith_to_frame_using_number(String number)
{
	driver.switchTo().frame(number);
}

/*...................> Method for switching to default content <..........................*/

public void swith_to_defaulat_content()
{
	driver.switchTo().defaultContent();
}

/*...................> Browser Navigation Methods <..........................*/

public void navigate_back()
{
	driver.navigate().back();
}

public void navigate_forword()
{
	driver.navigate().forward();
}

public void navigate_refresh()
{
	driver.navigate().refresh();
}

/*...................> Method to Navigate to windows <..........................*/

public Iterator<String> getAllWindows() {
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> itr = windows.iterator();
	return itr;
}

public void select_by_visibletext(WebElement ele, String text)
{
	Select dropdown= new Select(ele);
	dropdown.selectByVisibleText(text);
}

public void select_by_value(WebElement ele, String value)
{
	Select dropdown= new Select(ele);
	dropdown.selectByValue(value);
}

public void select_by_index(WebElement ele, int index)
{
	Select dropdown= new Select(ele);
	dropdown.selectByIndex(index);
}

public void bootstrap_dropdown(List <WebElement> ele, String text) throws InterruptedException
{
	        /*for(int i=0;i<ele.size();i++)
		    {
			WebElement choice=ele.get(i);
			String innerhtml=choice.getText();
			if(innerhtml.contains("text"))
			{
				wait_in_seconds(5);
				choice.click();
				break;
			}
            }*/
	
	  for(WebElement choice: ele)
	  {
		  if(choice.getText().contains(text))
		  {
			  choice.click();
			  break;
		  }
	  }
}
public void handlingactions(WebElement ele, WebElement ele2)
{
	Actions a=new Actions(driver);
	a.moveToElement(ele).click(ele2).build().perform();
	
}

public void drag_and_drop(WebElement e1, WebElement e2)
{
	Actions a=new Actions(driver);
    a.dragAndDrop(e1, e2).build().perform();
}

public void set_position(int newpoint1, int newpoint2)
{
	//int x=driver.manage().window().getPosition().getX();
	//int y=driver.manage().window().getPosition().getY();
	Point p=new Point(newpoint1,newpoint2);
	driver.manage().window().setPosition(p);
}

public void set_height_and_width(int height, int width)
{
	//int x=driver.manage().window().getSize().getHeight();
	//int y=driver.manage().window().getSize().getWidth();
	 Dimension d=new Dimension(height,width);
	 driver.manage().window().setSize(d);
	}
  public void context_click(WebElement ele)
  {
	  Actions a=new Actions(driver);
	  a.contextClick(ele).build().perform();
  }
  
  public void double_click(WebElement ele)
  {
	  Actions a=new Actions(driver);
	  a.doubleClick(ele).build().perform();
  }
   
  public void file_upload(String path) throws InterruptedException, AWTException
  {
	    Robot r=new Robot();
		wait_in_seconds(3);
		StringSelection s=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		wait_in_seconds(4);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		wait_in_seconds(3);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		wait_in_seconds(3);
  }

  public String generateRandomString(int length)
  {
 return RandomStringUtils.randomAlphabetic(length);
  }

public String generateRandomNumber(int length)
  {
   return RandomStringUtils.randomNumeric(length);
  }

public String generateRandomAlphaNumeric(int length)
   {
   return RandomStringUtils.randomAlphanumeric(length);
   }

public String generateStringWithAllobedSplChars(int length,String allowdSplChrs)
  {
  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
  "1234567890" +   //numbers
  allowdSplChrs;
  return RandomStringUtils.random(length, allowedChars);
  }

public String generateEmail(int length) 
 {
 String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
 "1234567890" +   //numbers
 "_-.";   //special characters
 String email="";
 String temp=RandomStringUtils.random(length,allowedChars);
 email=temp.substring(0,temp.length()-9)+"@test.org";
 return email;
 }

public String generateUrl(int length) 
{
String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
"1234567890" +   //numbers
"_-.";   //special characters
String url="";
String temp=RandomStringUtils.random(length,allowedChars);
url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
return url;
}















}
