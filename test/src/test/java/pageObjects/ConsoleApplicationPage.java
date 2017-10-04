package pageObjects;


import configuration.AbstractPageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ConsoleApplicationPage extends AbstractPageObjectClass {
    private final String ALL_ENTRIES_COUNT_XPATH= ".//span[@class='ambassadordashboard-button-text' and text() ='All Entries']/preceding-sibling::span[@class='ambassadordashboard-row-count']";
    private final String LIST_OF_DASHBOARD_ENTRIES_CSS = ".ambassadordashboard-result-field.ambassadordashboard-result-name";
    private final String DROP_DOWN_LIST_CSS = ".chosen-single>span";
    private final String CURRENT_USER_CLASS = "current_user";
    private final String LOGOUT_USER_CSS = ".logout>a";

    @FindBy(xpath = ALL_ENTRIES_COUNT_XPATH)
    protected WebElement allEntriesCounter;

    @FindBy(css = LIST_OF_DASHBOARD_ENTRIES_CSS)
    protected List<WebElement> listOfDashboardNames;

    @FindBy(css = DROP_DOWN_LIST_CSS)
    protected WebElement dropDownList;

    @FindBy(className = CURRENT_USER_CLASS)
    protected WebElement currentUser;

    @FindBy(css = LOGOUT_USER_CSS)
    protected WebElement logoutUser;

    public ConsoleApplicationPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAllEntriesCounterValue(){
        return allEntriesCounter.getText();
    }

    public boolean isNameInDashboardSelected(String name){
        for (WebElement we:listOfDashboardNames) {
            if (name.equalsIgnoreCase(we.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean isHideButtonDisplayed(){
        WebElement hideButton = optionalWaitUntil(2, ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ambassadordashboard-hide-row>button")));
        return hideButton!=null;
    }

    public ConsoleApplicationPage clickDropDownList(){
        dropDownList.click();
        return new ConsoleApplicationPage(driver);
    }

    public ConsoleApplicationPage clickCurrentUser(){
        currentUser.click();
        return new ConsoleApplicationPage(driver);
    }

    public AmbassadorSystemHomePage clickLogoutUser(){
        logoutUser.click();
        return new AmbassadorSystemHomePage(driver);
    }


    public boolean isValuePresentInDropDown(String value) {
        return isElementPresent(By.xpath(".//li[contains(@class, 'active-result') and text() = '" + value + "']"));
    }

    public CustomMenuPanel getCustomMenuPanel(){
        return new CustomMenuPanel(driver);
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALL_ENTRIES_COUNT_XPATH)));
    }
}
