package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import basePackage.PageBase;

public class DownLoadPage extends PageBase{

	@FindBy(id = "download")
	private WebElement downloadInformation;
	
	@FindBy(css = "input[placeholder='Studying or working?']")
	private WebElement workingStatusTextBox;
	
	@FindBy(xpath = "//select[@data-placeholder='Studying or working?']")
	private WebElement selectWorkingStatus;
	
	@FindBy(css = "input[placeholder='Profession?']")
	private WebElement professionTextBox;
	
	@FindBy(xpath = "//select[@data-placeholder='Profession?']")
	private WebElement selectProfession; 
	
	@FindBy(css = "input[placeholder='Profession area?']")
	private WebElement professionAreaTextBox;
	
	@FindBy(xpath = "//select[@data-placeholder='Profession area?']")
	private WebElement selectProfessionArea;
	
	@FindBy(xpath = "//input[@type='checkbox'][@value='false']")
	private WebElement noUpdatesCheckBox;
	
	@FindBy(xpath = "//button[contains(text(),'Download!')]")
	private WebElement downloadButton;
	
	public DownLoadPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseWorkingstatus() {
		waitAndType(workingStatusTextBox, "Working");
		workingStatusTextBox.sendKeys(Keys.ENTER);
	}
	
	public void chooseProfession() {
		waitAndType(professionTextBox, "IT");
		professionTextBox.sendKeys(Keys.ENTER);
	}
	
	public void chooseProfessionArea() {
		waitAndType(professionAreaTextBox, "Software");
		professionAreaTextBox.sendKeys(Keys.ENTER);
	}
	
	public void downloadBook(){
			chooseWorkingstatus();
			chooseProfession();
			chooseProfessionArea();
//			Point checkboxLocation = noUpdatesCheckBox.getLocation();
			WebElement elem = driver.findElement(By.xpath("//input[@type='checkbox'][@value='false']"));
			    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
			    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elem);
			
			waitAndClick(downloadButton);
			try {
				Robot robot = new Robot(); 
				
				downloadButton.sendKeys("");
				downloadButton.sendKeys(Keys.ENTER);
				
				System.out.println(driver.getWindowHandles().size());
//				for(int i=0;i<3;i++)
//				{
//					Thread.sleep(2000);	
//					robot.keyPress(KeyEvent.VK_TAB);
//				}
//				Thread.sleep(2000);	
//		        robot.keyPress(KeyEvent.VK_ENTER);
//		        
//		        Thread.sleep(2000);
//		        robot.keyRelease(KeyEvent.VK_ENTER);
//				 ((JavascriptExecutor)driver).executeScript("window.focus();");
//				 robot.setAutoDelay(250);
//				 
//				 robot.keyPress(KeyEvent.VK_ALT);
//			     Thread.sleep(1000);
//			     robot.keyPress(KeyEvent.VK_S);
//			     Thread.sleep(2000);
//			     robot.keyRelease(KeyEvent.VK_ALT);
//			     robot.keyRelease(KeyEvent.VK_S);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		
	}
	
	public void checkDowloadedBook() {
		File pathToDirectory = new File("E://downloads//");
		String[] files = pathToDirectory.list();
		for(String file : files) {
			System.out.println(file);
		}
	}
}