package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.lang.String;

import basePackage.PageBase;

public class HomePage extends PageBase{
	@FindBy(id = "search_input")
	private WebElement searchInputBox;
	
	@FindBy(xpath = "//button[text()='Go!']")
	private WebElement searchButton;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void searchForBook(String bookName) {
		waitAndType(searchInputBox, bookName);
		waitAndClick(searchButton);
		System.out.println(bookName);
	}
}
