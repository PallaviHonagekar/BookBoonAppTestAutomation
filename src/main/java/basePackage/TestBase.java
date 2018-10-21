package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import constants.Constant;
import pageObjects.HomePage;
import pageObjects.SearchedBooksPage;
import pageObjects.DownLoadPage;

public class TestBase {
	protected WebDriver driver;
	protected HomePage homePage;
	protected SearchedBooksPage searchedBookPage;
	protected DownLoadPage downloadPage;
	
	@BeforeMethod
	public void setUp(ITestContext context) {
		System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER);
		driver = new FirefoxDriver();
		driver.get(Constant.URL_SIGN_IN);
		driver.manage().window().maximize();	
		context.setAttribute(Constant.DRIVER, driver);
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchedBookPage = PageFactory.initElements(driver, SearchedBooksPage.class);
		downloadPage = PageFactory.initElements(driver, DownLoadPage.class);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
