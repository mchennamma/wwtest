package pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudioPage {
	WebDriver driver;

	@FindBy(xpath = "//span[@ng-if='!linkName']")
	public WebElement studioName;
	
	@FindBy(xpath = "//div[@class='hours-list-item-wrapper hours-list--currentday']")
	public WebElement todayElement;
	
	@FindBy(className = "schedule-detailed-day")
    public List<WebElement> allScheduleDaysElements;
	
	public WebElement todayScheduleElement;
	
	public StudioPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getStudioName(){
		return studioName.getText().trim();
	}

	public void printTodaysTimings(){
		System.out.println("Hours of Operation --"+todayElement.findElement(By.className("hours-list-item-day")).getText());
		System.out.println(todayElement.findElement(By.className("hours-list-item-hours")).getText());
	}
	
	public void printMeetings(String day){
		HashMap<String, Integer> scheduleMap = new HashMap<String, Integer>();
		int count;
		String leaderName;
		for(WebElement ele : allScheduleDaysElements){
			if(ele.findElement(By.className("schedule-detailed-day-label")).getText().trim().equals(day)){
				todayScheduleElement = ele;
				for(WebElement leader: ele.findElements(By.className("schedule-detailed-day-meetings-item-leader"))){
					leaderName = leader.getText().trim();
					if(!scheduleMap.containsKey(leaderName)){
						scheduleMap.put(leaderName, 1);
					}else{
						count = scheduleMap.get(leaderName)+1;
						scheduleMap.put(leaderName, count);
					}
				}
			}
		}
		
		for(String keys: scheduleMap.keySet()){
			System.out.println(keys+"::"+scheduleMap.get(keys));
		}
		
	}
	
}
