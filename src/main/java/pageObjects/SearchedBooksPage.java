package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePackage.PageBase;

public class SearchedBooksPage extends PageBase{
	By searchResults = By.xpath("//div[@class='searchresults']/ol/li");
	By bookNameLocator = By.xpath("//b/a");
	
	public SearchedBooksPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectABook(String bookName) {
		waitForAllElementsToPresent(searchResults);
		List<WebElement> searchResultsList = driver.findElements(searchResults);
		searchingBookDetail:
		for(WebElement bookDetails : searchResultsList) {
			List<WebElement> searchedBookNameList = bookDetails.findElements(bookNameLocator);
			for(WebElement searchedBookName : searchedBookNameList) {
				String searchResult = waitAndGetText(searchedBookName).toLowerCase();
				if(searchResult.contains(bookName)) {
					waitAndClick(searchedBookName);
					break searchingBookDetail;
				}
			}
		}
	}
}
