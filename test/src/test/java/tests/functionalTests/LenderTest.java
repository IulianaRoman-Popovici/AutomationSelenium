package tests.functionalTests;

import configuration.AbstractTestClass;
import org.junit.*;
import pageObjects.*;


public class LenderTest extends AbstractTestClass {
    protected static AmbassadorSystemHomePage ambassadorSystemHomePage;
    protected static ConsoleApplicationPage consoleApplicationPage;
    protected BuySellAllPlansPage buySellAllPlansPage;
    protected ToolBoxAllToolsPage toolBoxAllToolsPage;

    @BeforeClass
    public static void setUp() {
        // preconditions
        setUpDrivers("chrome");
        navigateToAmbassadorSystems();
        ambassadorSystemHomePage = getAmbassadorSystemHomePage();
        consoleApplicationPage = ambassadorSystemHomePage.clickLoginButtonOnHomePage()
                                                         .fillInEmail("qaLenderAmbassadorSystems@gmail.com")
                                                         .fillInPassword("Qa123456")
                                                         .clickLoginButton();
    }

    @After
    public void afterEachMethod(){
        consoleApplicationPage = consoleApplicationPage.getCustomMenuPanel()
                .clickMenuOption("Console")
                .clickSubMenuOptionConsoleApplication("Collaboration Console");
    }

    @AfterClass
    public static void tearDown(){
        closeDriver();
        // Abort pageObjects in case of an unexpected error.
        quitDriver();
    }

    @Test
    public void testConsoleApplicationInformation(){
        consoleApplicationPage = consoleApplicationPage.clickDropDownList();
        /* Verify that Agent network is showing the correct information */
        Assert.assertTrue("Error: Agent is not displayed in list and should be", consoleApplicationPage.isValuePresentInDropDown("qaAgentAmbassadorSystems@gmail.com"));
        /* Verify that the dashboard is displaying the correct HomeToHome */
        Assert.assertEquals("Error: The All Entries value is not correct", "1", consoleApplicationPage.getAllEntriesCounterValue());

        Assert.assertTrue("Error: Agent name is not displayed in dashboard and should be", consoleApplicationPage.isNameInDashboardSelected("Platinum Agent"));
        Assert.assertTrue("Error: Client name is not displayed in dashboard and should be", consoleApplicationPage.isNameInDashboardSelected("AutomationClinet Client"));
        /* Verify that the Hide button is not displayed for the selected HomeToHome */
        Assert.assertFalse("Error: Hide button is displayed and it shouldn't be", consoleApplicationPage.isHideButtonDisplayed());
    }

    @Test
    public void testBuySellPlansInformation(){
        buySellAllPlansPage = consoleApplicationPage.getCustomMenuPanel()
                .clickMenuOption("Buy/Sell Plans")
                .clickSubMenuOptionBuySellPlan("ALL PLANS");

        /* Verify that the correct Client name is displayed in header*/
        Assert.assertTrue("Error: The name displayed in the hader is not correct", buySellAllPlansPage.isHeaderNameCorrect("Client QA"));

        /* Verify that for this lender platinum user all the Plans are displayed*/
        Assert.assertTrue("Error: Not all Buy/Sell Plans are displayed", buySellAllPlansPage.areAllPlansDisplayedForPlatinum());
    }

    @Test
    public void testAllToolsInformation(){
        toolBoxAllToolsPage = consoleApplicationPage.getCustomMenuPanel()
                .clickMenuOption("Tool Box")
                .clickSubMenuOptionToolBox("ALL TOOLS");

        /* Verify that the correct Client name is displayed in header*/
        Assert.assertTrue("Error: The name displayed in the header is not correct", toolBoxAllToolsPage.isHeaderNameCorrect("Client QA"));

        /* Verify that for this lender platinum user all the Tools are displayed*/
        Assert.assertTrue("Error: Not all Tools are displayed", toolBoxAllToolsPage.areAllToolsDisplayedForPlatinum());

         /* Verify that for this lender platinum user all the Fast Links are displayed*/
        Assert.assertTrue("Error: Not all Fast Links are displayed", toolBoxAllToolsPage.areAllFastLinksDisplayedForPlatinum());
    }
}
