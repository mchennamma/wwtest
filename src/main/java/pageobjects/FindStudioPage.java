package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindStudioPage {
	WebDriver driver;
	
	@FindBy(id = "meetingSearch")
    public  WebElement searchField;
	
	@FindBy(xpath = "//button[@class='btn spice-translated'][contains(.,'Submit')]")
	public WebElement searchButton;
	
	@FindBy(xpath = "(//button[@class='bx-button'])[2]")
	public WebElement noThanks;
	
	@FindBy(className = "meeting-location")
    public List<WebElement> searchResult;
	
	public String locationName;
	
	public FindStudioPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  String getTitle(){
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains("Find WW Studios "));
		return driver.getTitle();
	}

	public void searchStudio(String zip){
		waitForElement(searchField);
		searchField.sendKeys(zip);
		searchButton.click();
	}
	public void handleModelWindow(){
		waitForElement(noThanks);
		noThanks.click();
	}
	
	public void printDetails(){
		locationName = searchResult.get(0).findElement(By.className("location__name")).getText().trim();
		System.out.println("Location Name -->"+locationName);
		System.out.println("Location Distance -->"+searchResult.get(0).findElement(By.className("location__distance")).getText());
	}
	
	public String getFirstStudioName(){
		return locationName;
	}
	
	public void clickOnFirstLocation(){
		searchResult.get(0).findElement(By.className("location__name")).click();
	}
	
	private void waitForElement(WebElement ele){
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
