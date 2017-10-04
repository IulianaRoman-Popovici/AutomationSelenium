package pageObjects;

import configuration.AbstractPageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToolBoxAllToolsPage extends AbstractPageObjectClass{
    private final String CLIENT_NAME_CLASS = "client_name";

    public ToolBoxAllToolsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean areAllToolsDisplayedForPlatinum(){
        return isElementPresent(By.cssSelector("a[href ='http://hometohome.staging.wpengine.com/my-service-plan/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/meet-your-agent/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/questionnaire/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/my-finance-plan/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/meet-your-lender/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/loan-sense/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/arm-sense/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/my-home/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/next-dream/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/rate-this-home/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/map-homes/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/market-price/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/cash-to-close/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/cash-flows/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/home-scene/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/money-scene/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/escrow/"))
                &isElementPresent(By.cssSelector("a[href = 'http://hometohome.staging.wpengine.com/gift-a-friend/"));
    }

    public boolean areAllFastLinksDisplayedForPlatinum(){
        return isElementPresent(By.cssSelector("a[href = '#follow_agent']"))
                &isElementPresent(By.cssSelector("a[href = '#follow_lender']"))
                &isElementPresent(By.cssSelector("a[href = '#choose_your_loan']"))
                &isElementPresent(By.cssSelector("a[href = '#market_your_home']"))
                &isElementPresent(By.cssSelector("a[href = '#review_your_offer']"))
                &isElementPresent(By.cssSelector("a[href = '#grow_your_wealth']"))
                &isElementPresent(By.cssSelector("a[href = '#close_your_deal']"))
                &isElementPresent(By.cssSelector("a[href = '#share_your_success']"));
    }

    public boolean isHeaderNameCorrect(String name) {
        return isElementPresent(By.xpath(".//span[@class='client_name' and contains(text(), '" + name + "')]"));
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLIENT_NAME_CLASS)));

    }
}
