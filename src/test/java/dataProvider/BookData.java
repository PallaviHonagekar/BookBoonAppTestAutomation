package dataProvider;

import org.testng.annotations.DataProvider;

import constants.Constant;

public class BookData {
	@DataProvider(name = Constant.BOOK_NAME_DATA_PROVIDER)
	public static Object[][] bookName() {
		 return new Object[][] { {"C++"} };
	}
}
