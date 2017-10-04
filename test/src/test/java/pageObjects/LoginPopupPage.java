package pageObjects;


import configuration.AbstractPageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPopupPage extends AbstractPageObjectClass{

    private final String EMAIL_INPUT_FIELD_ID = "user_login1";
    private final String PASSWORD_INPUT_FIELD_ID = "user_pass1";
    private final String LOGIN_BUTTON_ID = "wp-submit1";
    private final String LOGIN_POPUP_ERROR_XPATH = ".//p[@class='error']//strong[text() = 'ERROR']";
    private final String CLOSE_LOGIN_POPUP = "popup-close";

    @FindBy(id = EMAIL_INPUT_FIELD_ID)
    protected WebElement emailInputField;

    @FindBy (id = PASSWORD_INPUT_FIELD_ID)
    protected WebElement passwordInputField;

    @FindBy (id = LOGIN_BUTTON_ID)
    protected WebElement loginButton;

    @FindBy (xpath = LOGIN_POPUP_ERROR_XPATH)
    protected WebElement loginError;

    @FindBy (className = CLOSE_LOGIN_POPUP)
    protected WebElement closeLoginPopup;

    public LoginPopupPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPopupPage fillInEmail(String email){
        emailInputField.clear();
        emailInputField.sendKeys(email);
        return new LoginPopupPage(driver);
    }

    public LoginPopupPage fillInPassword(String pass){
        passwordInputField.clear();
        passwordInputField.sendKeys(pass);
        return new LoginPopupPage(driver);
    }

    public ConsoleApplicationPage clickLoginButton(){
        loginButton.click();
        return new ConsoleApplicationPage(driver);
    }

    public LoginPopupPage clickLoginButtonWithErrors(){
        loginButton.click();
        return new LoginPopupPage(driver);
    }

    public boolean isErrorMessageDisplayed(){
        return isElementPresent(loginError);
    }

    public AmbassadorSystemHomePage clickCloseLoginPopup() {
        closeLoginPopup.click();
        optionalWaitUntil(5, ExpectedConditions.invisibilityOfElementLocated(By.id(LOGIN_BUTTON_ID)));
        return new AmbassadorSystemHomePage(driver);
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(LOGIN_BUTTON_ID)));
    }
}

