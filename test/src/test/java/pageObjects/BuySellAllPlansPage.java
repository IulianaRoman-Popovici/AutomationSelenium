package pageObjects;


import configuration.AbstractPageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BuySellAllPlansPage extends AbstractPageObjectClass {

    private final String CLIENT_NAME_CLASS = "client_name";

    public BuySellAllPlansPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CustomMenuPanel getCustomMenuPanel(){
        return new CustomMenuPanel(driver);
    }

    public boolean areAllPlansDisplayedForPlatinum(){
        return isElementPresent(By.cssSelector("a[href ='http://hometohome.staging.wpengine.com/buy-your-home/']"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/sell-your-home/']"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/refinance-your-home/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/rent-or-buy/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/sell-buy/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/buy-1st-home/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/investor-buy-hold/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/investor-flip/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/buy-vacation-home/"));
    }

    public boolean isHeaderNameCorrect(String name) {
        return isElementPresent(By.xpath(".//span[@class='client_name' and contains(text(), '" + name + "')]"));
    }

    @Override
    public void waitForPageToLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".buy-sell-page .wrapper-inner>h2")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLIENT_NAME_CLASS)));
    }
}
