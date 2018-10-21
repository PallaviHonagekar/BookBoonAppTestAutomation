package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import basePackage.PageBase;

public class DownLoadPage extends PageBase{

	@FindBy(id = "download")
	private WebElement downloadInformation;
	
	@FindBy(xpath = "//input[@id='undefined_flexselect'][@placeholder='Studying or working?']")
	private WebElement workingStatusTextBox;
	
	@FindBy(xpath = "//select[@data-placeholder='Studying or working?']")
	private WebElement selectWorkingStatus;
	
	@FindBy(xpath = "//input[@id='undefined_flexselect'][@placeholder='Profession?']")
	private WebElement professionTextBox;
	
	@FindBy(xpath = "//select[@data-placeholder='Profession?']")
	private WebElement selectProfession; 
	
	@FindBy(id = "//input[@id='undefined_flexselect'][@placeholder='Profession area?']")
	private WebElement professionAreaTextBox;
	
	@FindBy(xpath = "//select[@data-placeholder='Profession area?']")
	private WebElement selectProfessionArea;
	
	@FindBy(xpath = "//input[@type='checkbox'][@value='false']")
	private WebElement noUpdatesCheckBox;
	
	@FindBy(xpath = "//button[contains(text(),'Download!')]")
	private WebElement downloadButton;
	
	By searchResults = By.xpath("//div[@class='searchresults']/ol/li");
	By bookNameLocator = By.tagName("//a");
	
	public DownLoadPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseWorkingstatus() {
		waitAndClick(workingStatusTextBox);
		//waitAndClick(selectWorkingStatus);
		waitAndClick(selectWorkingStatus);
		Select workingStatusSelect = new Select(selectWorkingStatus);
		workingStatusSelect.selectByValue("6230e12c-68d8-45d5-8f02-1d3997713150");
		//waitForElementToBeVisible(selectWorkingStatus);
		//String js = "document.getElementByName('answers')[0].style.display='none';";
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true).style.display='block';", selectWorkingStatus);
//		waitAndClick(selectWorkingStatus);
		//((JavascriptExecutor) driver).executeScript("document.getElementByName('answers').data-placeholder='Studying or working?'.style.display='block';");
	
//		List<WebElement> workingStatusOptions = workingStatusSelect.getOptions();
//		System.out.println(workingStatusOptions.size());
//		for(WebElement workingStatus : workingStatusOptions){
//			
//			Actions action = new Actions(driver);
//			action.moveToElement(workingStatus).sendKeys(Keys.TAB);
//			String visibleText = workingStatus.getText();
//			System.out.println(visibleText);
////			if(visibleText.equals(""))
////			{
////				workingStatus.sendKeys("Working");
////			}
////			else {
////				workingStatusSelect.selectByVisibleText("Working");
////				workingStatusTextBox.sendKeys(visibleText);
////			}
////			break;
//		}
//		workingStatusSelect.selectByIndex(1); 
//		workingStatusSelect.selectByVisibleText("Working");
//		workingStatusTextBox.sendKeys("Working");
		
	}
	
	public void chooseProfession() {
		waitAndClick(professionTextBox);
		Select professionSelect = new Select(selectProfession);
		List<WebElement> professionOptions = professionSelect.getOptions();
		for(WebElement profession : professionOptions){
			String visibleText = profession.getText();
			professionSelect.selectByVisibleText(visibleText);
			break;
		}
	}
	
	public void chooseProfessionArea() {
		waitAndClick(professionAreaTextBox);
		Select professionAreaSelect = new Select(selectProfessionArea);
		List<WebElement> professionAreaOptions = professionAreaSelect.getOptions();
		for(WebElement professionArea : professionAreaOptions){
			String visibleText = professionArea.getText();
			professionAreaSelect.selectByVisibleText(visibleText);
			break;
		}
	}
	
	public void downloadBook() {
	//	chooseWorkingstatus();
//		chooseProfession();
//		chooseProfession();
//		waitAndClick(noUpdatesCheckBox);
//		waitAndClick(downloadButton);
	}
}