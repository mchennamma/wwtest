package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	@FindBy(xpath = "(//span[@class='menu-link__inner-wrapper'][contains(.,'Find a Studio')])[1]")
	public WebElement findStudio;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  String getTitle(){
		return driver.getTitle();
	}
	
	public void clickFindAStudio(){
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(findStudio));
		findStudio.click();
	}
}
