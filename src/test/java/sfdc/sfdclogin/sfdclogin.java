package src.test.java.sfdc.sfdclogin;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import src.test.java.posfdclogin.posfdclogin;
import src.main.java.utilities.TestBase;


public class sfdclogin extends TestBase {

    posfdclogin login;

    Logger log = Logger.getLogger(getClass().getSimpleName());

    @BeforeTest
    public void settingUpEnvironment() throws Exception {
        sErrorMessage = "";
        sClassNameForScreenShot = getClass().getSimpleName();
        driver.get(oCons.getsfdcURL());
        login = new posfdclogin(driver);
        login.checkLoggedIntosfdcOrNotElseLogout();

    }

    @AfterMethod
    public void settingReqURL() throws Exception {
        driver.get(oCons.getsfdcURL());
    }

    @Test(priority = 2)
    public void to_Check_Whether_Login_Happening_Or_Not() throws Exception {

        login.sfdclogin();
    }

    @Test(priority = 1)
    public void To_check_Error_For_Invalid_Login() throws Exception {
        login.TC_02_invalidsfdclogin();
        SoftAssert sa = new SoftAssert();

        sa.assertAll();
    }
    @Test(priority = 4)
    public void Remember_username_check() throws Exception {

        login.TC_03_Rememberusernamecheck();
    }
    @Test(priority = 3)
    public void forgot_password() throws Exception {

        login.TC_04_forgotpassword();
    }

}
