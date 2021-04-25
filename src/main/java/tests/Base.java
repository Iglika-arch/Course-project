package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Base implements Config{
    WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("chrome.switches","--disable-extensions");
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @BeforeSuite
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/HTMLreport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setReportName("Functional report");
        htmlReporter.config().setDocumentTitle("Automation report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname", "Windows");
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            test.fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            test.skip(result.getThrowable());
        else
            test.pass("Test passed");

        extent.flush();
    }
    @AfterSuite
    public void flush() {
        extent.flush();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
