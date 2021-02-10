package src.test.java.posfdclogin;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.main.java.utilities.TestBase;

import static org.testng.Assert.assertEquals;

public class posfdclogin extends TestBase {

    Logger log = Logger.getLogger(getClass().getSimpleName());

    public posfdclogin(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement ph_username;
    @FindBy(id = "password")
    WebElement ph_password;
    @FindBy(xpath = "//*[@id=\"Login\"]")
    WebElement login;
    @FindBy(xpath = ("//*[@id=\"userNavLabel\"]"))
    WebElement usertech;
    @FindBy(xpath = ("//*[@id=\"userNav-menuItems\"]/a[5]"))
    WebElement logout;


    public boolean sfdclogin() throws Exception {
        boolean bRes_Flag = false;
        oBroUti.waitForElementVisible(driver, ph_username, 5);
        oBroUti.ufSendKeys(ph_username, System.getProperty("td_emailId"));
        oBroUti.ufSendKeys(ph_password, System.getProperty("td_password"));
        oBroUti.ufClick(login);
        oBroUti.waitForElementVisible(driver, usertech, 5);
        if (oBroUti.isDisplayed(usertech))
            bRes_Flag = true;
        return bRes_Flag;
    }


    public boolean logoutOfsfdc() throws Exception {
        boolean bRes_Flag = false;
        if (oBroUti.isDisplayed(logout))
            logout.click();
        bRes_Flag = true;
        return bRes_Flag;
    }

    public boolean checkLoggedIntoTekAppOrNotElseLogin() throws Exception {
        boolean bRes_Flag = false;
        try {
            oBroUti.waitForElementVisible(driver, usertech, 3);
        } catch (Exception ea) {
            log.error("By passing error when we run on suite case");
        }
        if (!oBroUti.isDisplayed(usertech))
            bRes_Flag = sfdclogin();

        return bRes_Flag;
    }

    public boolean checkLoggedIntosfdcOrNotElseLogout() throws Exception {
        boolean bRes_Flag = false;
        if (oBroUti.isDisplayed(usertech))
            bRes_Flag = logoutOfsfdc();

        return bRes_Flag;

    }

    public boolean invalidsfdclogin() throws Exception {
        boolean bRes_Flag = false;
        oBroUti.waitForElementVisible(driver, ph_username, 5);
        oBroUti.ufSendKeys(ph_username, System.getProperty("td_invalid_emailId"));
        oBroUti.ufSendKeys(ph_password, System.getProperty("td_invalid_password"));
        oBroUti.ufClick(login);
        log.info("****************************");
        Thread.sleep(3000);
        bRes_Flag = true;
        return bRes_Flag;
    }

    @FindBy(xpath = "//*[@id=\"rememberUn\"]")
    WebElement Rememberme;

    public boolean Rememberusernamecheck() throws Exception {
        boolean bRes_Flag = false;
        oBroUti.waitForElementVisible(driver, ph_username, 5);
        oBroUti.ufSendKeys(ph_username, System.getProperty("td_emailId"));
        oBroUti.ufSendKeys(ph_password, System.getProperty("td_password"));
        oBroUti.ufclick(Rememberme);
        oBroUti.ufClick(login);
        oBroUti.waitForElementVisible(driver, usertech, 5);
        if (oBroUti.isDisplayed(ph_username))
            bRes_Flag = true;
        return bRes_Flag;
    }

    public boolean forgotpassword() throws Exception {
        boolean bRes_Flag = false;
        oBroUti.waitForElementVisible(driver, ph_username, 5);
        oBroUti.ufSendKeys(ph_username, System.getProperty("td_emailId"));
        oBroUti.ufSendKeys(ph_password, System.getProperty("td_invalid_password"));
        oBroUti.ufClick(login);
//        if (oBroUti.isDisplayed(errormessage))
//        log.info("****************************");

        Thread.sleep(3000);
        bRes_Flag = true;
        return bRes_Flag;
    }

}
