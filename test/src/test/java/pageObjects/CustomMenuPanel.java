package pageObjects;

import configuration.AbstractPageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomMenuPanel extends AbstractPageObjectClass {

    public CustomMenuPanel (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CustomMenuPanel clickMenuOption(String option){
        driver.findElement(By.xpath("//a[contains(text(), '"+option+"')]/ancestor::li[contains(@class, 'menu-item')]")).click();
        return new CustomMenuPanel(driver);
    }

    public BuySellAllPlansPage clickSubMenuOptionBuySellPlan(String subOption) {
        driver.findElement(By.xpath("//a[contains(text(), '" + subOption + "')]")).click();
        return new BuySellAllPlansPage(driver);
    }

    public ToolBoxAllToolsPage clickSubMenuOptionToolBox(String subOption) {
        driver.findElement(By.xpath("//a[contains(text(), '" + subOption + "')]")).click();
        return new ToolBoxAllToolsPage(driver);
    }

    public ConsoleApplicationPage clickSubMenuOptionConsoleApplication(String subOption) {
        driver.findElement(By.xpath("//a[contains(text(), '" + subOption + "')]")).click();
        return new ConsoleApplicationPage(driver);
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'menu-item')]")));
    }
}
