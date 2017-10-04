package configuration;


import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AmbassadorSystemHomePage;

public class AbstractTestClass {
    public static Eyes eyes = new Eyes();
    public static WebDriver driver;

    protected static void setUpDrivers(String browser) {

        if (browser == "chrome") {
            System.setProperty("webdriver.chrome.driver", "/Users/iuliana/Documents/chromedriver");
            driver = new ChromeDriver();
        } else {
            if (browser == "firefox") {
                System.setProperty("webdriver.geckodriver.driver", "/Users/iuliana/Documents/geckodriver/geckodriver");
                driver = new FirefoxDriver();
            }
        }
    }

    protected static AmbassadorSystemHomePage getAmbassadorSystemHomePage(){
        return new AmbassadorSystemHomePage(driver);
    }

    protected static void setUpApplitoolsEyesTest(String testFolderName){
        // This is your api key, make sure you use it in all your tests.
        eyes.setApiKey("hs99771SOQSeT41YArrRBzTYTR2A32zNMcMHtfRHcppc110");
        // Start visual testing with browser viewport set to 1024x768.
        // Make sure to use the returned driver from this point on.
        driver = eyes.open(driver, "Applitools", testFolderName, new RectangleSize(1280, 700));
    }

    protected static void navigateToAmbassadorSystems(){
        driver.get("http://hometohome.staging.wpengine.com/");
    }

    protected static void closeDriver(){
        driver.close();
    }

    protected static void closeEyes(){
        eyes.close();
    }

    protected static void quitDriver(){
        driver.quit();
    }

    protected static void quiteEyes(){
        eyes.abortIfNotClosed();
    }

}
