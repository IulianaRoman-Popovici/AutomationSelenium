package tests.functionalTests;

import configuration.AbstractTestClass;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.*;

public class GeneralTests extends AbstractTestClass {
    protected static AmbassadorSystemHomePage ambassadorSystemHomePage;
    protected LoginPopupPage loginPopupPage;
    protected ConsoleApplicationPage consoleApplicationPage;
    protected CustomMenuPanel customMenuPanel;
    protected BuySellAllPlansPage buySellAllPlansPage;
    protected ToolBoxAllToolsPage toolBoxAllToolsPage;

    @BeforeClass
    public static void setUp() {
        // preconditions
        setUpDrivers("chrome");
        navigateToAmbassadorSystems();
        ambassadorSystemHomePage = getAmbassadorSystemHomePage();
    }

    @AfterClass
    public static void tearDown(){
        closeDriver();
        // Abort pageObjects in case of an unexpected error.
        quitDriver();
    }

    @Test
    public void testLoginErrorOnAmbassadorSystems(){
        loginPopupPage = ambassadorSystemHomePage.clickLoginButtonOnHomePage();
        loginPopupPage = loginPopupPage.fillInEmail("bla bla")
                                       .fillInPassword("bla")
                                       .clickLoginButtonWithErrors();

          /* Verify that Agent network is showing the correct information */
        Assert.assertTrue("Error: Error message is not displayed in list and should be", loginPopupPage.isErrorMessageDisplayed());
        ambassadorSystemHomePage = loginPopupPage.clickCloseLoginPopup();
    }

    @Test
    public void testLoginAndLogoutOnAmbassadorSystems() {
        consoleApplicationPage = ambassadorSystemHomePage.clickLoginButtonOnHomePage()
                                                         .fillInEmail("qaAgentAmbassadorSystems@gmail.com")
                                                         .fillInPassword("Qa123456")
                                                         .clickLoginButton();
        ambassadorSystemHomePage = consoleApplicationPage.clickCurrentUser()
                                                         .clickLogoutUser();
        Assert.assertTrue("Error: User was not logged out and should be", ambassadorSystemHomePage.isLoginButtonDisplayed());
    }
}
