package basePackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
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
		System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER);
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.download.dir", "E:\\JAVA\\BookBoonDownloadTest");
//		
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
//		    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
//
//		profile.setPreference( "browser.download.manager.showWhenStarting", false );
//		profile.setPreference( "pdfjs.disabled", true );
		
		driver = new InternetExplorerDriver();
		
		driver.get(Constant.URL_SIGN_IN);
		driver.manage().window().maximize();	
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchedBookPage = PageFactory.initElements(driver, SearchedBooksPage.class);
		downloadPage = PageFactory.initElements(driver, DownLoadPage.class);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
