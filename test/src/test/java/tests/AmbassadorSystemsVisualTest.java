package tests;

import configuration.AbstractTestClass;
import org.junit.*;
import pageObjects.*;


public class AmbassadorSystemsVisualTest extends AbstractTestClass {
    protected static String testName = "Ambassador Systems Staging: Visual Tests";
    protected static AmbassadorSystemHomePage ambassadorSystemHomePage;
    protected LoginPopupPage loginPopupPage;
    protected ConsoleApplicationPage consoleApplicationPage;
    protected CustomMenuPanel customMenuPanel;
    protected BuySellAllPlansPage buySellAllPlansPage;
    protected ToolBoxAllToolsPage toolBoxAllToolsPage;

    @BeforeClass
    public static void setUp() {
        // create the set expected Conditions for the project
        setUpDrivers("chrome");
        ambassadorSystemHomePage = getAmbassadorSystemHomePage();
        setUpApplitoolsEyesTest(testName);
        navigateToAmbassadorSystems();
    }

    @AfterClass
    public static void tearDown(){
        closeDriver();
        closeEyes();
        // Abort pageObjects in case of an unexpected error.
        quitDriver();
        quiteEyes();
    }

    /**
     * Visual test to validate the major UI of the application
     **/
    @Test
    public void testEyesOnAmbassadorSystems(){
        // Visual validation point #1
        eyes.checkWindow(10,"Ambassador Systems: Home Page");
        loginPopupPage = ambassadorSystemHomePage.clickLoginButtonOnHomePage();

        // Visual validation point #2
        eyes.checkWindow("Ambassador Systems: Login Popup");
        consoleApplicationPage = loginPopupPage.fillInEmail("qaLenderAmbassadorSystems@gmail.com")
                                               .fillInPassword("Qa123456")
                                               .clickLoginButton();

        // Visual validation point #3
        eyes.checkWindow("Ambassador Systems: Console page");
        customMenuPanel = consoleApplicationPage.getCustomMenuPanel();
        buySellAllPlansPage = customMenuPanel.clickMenuOption("Buy/Sell Plans")
                                          .clickSubMenuOptionBuySellPlan("ALL PLANS");

        // Visual validation point #4
        eyes.checkWindow("Ambassador Systems: Buy/Sell Plans page - ALL PLANS");
        customMenuPanel = buySellAllPlansPage.getCustomMenuPanel();
        toolBoxAllToolsPage = customMenuPanel.clickMenuOption("Tool Box")
                                     .clickSubMenuOptionToolBox("ALL TOOLS");

        // Visual validation point #5
        eyes.checkWindow("Ambassador Systems: Tool Box page - ALL TOOLS");
    }
}

