package test;

import java.awt.AWTException;

import org.testng.annotations.Test;
import basePackage.TestBase;
import constants.Constant;
import dataProvider.BookData;

public class DownloadBookTest extends TestBase{
	@Test(dataProvider = Constant.BOOK_NAME_DATA_PROVIDER, dataProviderClass = BookData.class)
	 public void testDownloadedBook(String bookName) throws AWTException {
		 homePage.searchForBook(bookName.toLowerCase());
		 searchedBookPage.selectABook(bookName.toLowerCase());
		 downloadPage.downloadBook();
	 }
}
