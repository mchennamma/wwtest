package wwtests;

import org.testng.annotations.Test;

import pageobjects.FindStudioPage;
import pageobjects.HomePage;
import pageobjects.StudioPage;

import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class WWTests {
	
	WebDriver driver;
	HomePage hp;
	FindStudioPage fsp;
	StudioPage sp;

  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.weightwatchers.com/us/");
  }
  
  @Test(priority=0)
  public void verifyHomePageTitle() {
	  hp = new HomePage(driver);
	  Assert.assertEquals(hp.getTitle(), "WW (Weight Watchers): Weight Loss & Wellness Help");;
  }
  
  @Test(priority=1, dependsOnMethods="verifyHomePageTitle")
  public void verifySearchTitle(){
	  hp.clickFindAStudio();
	  fsp = new FindStudioPage(driver);
	  Assert.assertTrue(fsp.getTitle().contains("Find WW Studios & Meetings Near You | WW USA"));
  }
  
  @Test(priority=2)
  public void verifySearch(){
	  fsp.handleModelWindow();
	  fsp.searchStudio("10011");
	  fsp.printDetails();
	  fsp.clickOnFirstLocation();
	  sp = new StudioPage(driver);
	  Assert.assertEquals(fsp.getFirstStudioName(), sp.getStudioName());
  }
  @Test(priority=3, dependsOnMethods="verifySearch")
  public void verifySearchDetails(){
	  sp.printTodaysTimings();
	  sp.printMeetings("THU");
	 
  }
  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
