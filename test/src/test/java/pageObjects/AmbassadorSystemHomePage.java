package pageObjects;


import configuration.AbstractPageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmbassadorSystemHomePage extends AbstractPageObjectClass{

    private final String LOGIN_BUTTON_HOMEPAGE_CSS = ".login_btn.btn";

    @FindBy (css = LOGIN_BUTTON_HOMEPAGE_CSS)
    protected WebElement loginButtonHomePage;

    public AmbassadorSystemHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPopupPage clickLoginButtonOnHomePage(){
        loginButtonHomePage.click();
        return new LoginPopupPage(driver);
    }

    public boolean isLoginButtonDisplayed(){
       return isElementPresent(loginButtonHomePage);
    }

    @Override
    public void waitForPageToLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(LOGIN_BUTTON_HOMEPAGE_CSS)));
    }
}
