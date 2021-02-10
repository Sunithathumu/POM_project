package src.test.java.leadspage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import src.main.java.utilities.TestBase;
import src.test.java.poleadspage.poleadspage;
import src.test.java.posfdclogin.posfdclogin;

public class leadspage extends TestBase {
    posfdclogin login;
    poleadspage leads;
    Logger log = Logger.getLogger(getClass().getSimpleName());

    @BeforeTest
    public void settingUpEnvironment() throws Exception {
        sErrorMessage = "";
        sClassNameForScreenShot = getClass().getSimpleName();
        driver.get(oCons.getsfdcURL());
        login = new posfdclogin(driver);
        leads = new poleadspage(driver);
//        login.checkLoggedIntosfdcOrNotElseLogout();


    }
    @AfterMethod
    public void settingReqURL() throws Exception {
        driver.get(oCons.getsfdcURL());
    }

    @Test(priority = 1)
    public void leads_page() throws Exception {

//        leadspage.leads();
    }
}
