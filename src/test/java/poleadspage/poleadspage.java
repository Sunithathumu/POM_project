package src.test.java.poleadspage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.main.java.utilities.TestBase;


    public class poleadspage extends TestBase {

        Logger log = Logger.getLogger(getClass().getSimpleName());

        public poleadspage(WebDriver driver) {
            TestBase.driver = driver;
            PageFactory.initElements(driver, this);
        }
        @FindBy(name = "username")
        WebElement ph_username;
        @FindBy(id = "password")
        WebElement ph_password;
        @FindBy(xpath = "//*[@id=\"Login\"]")
        WebElement login;
        @FindBy(xpath =("//*[@id=\"Lead_Tab\"]/a"))
        WebElement leads;
        @FindBy(xpath = ("//*[@id=\"userNavLabel\"]"))
        WebElement usertech;
        @FindBy(xpath = ("//*[@id=\"userNav-menuItems\"]/a[5]"))
        WebElement logout;


        public boolean leadstab() throws Exception {
            boolean bRes_Flag = false;
            oBroUti.waitForElementVisible(driver, leads, 5);
            oBroUti.ufSendKeys(ph_username, System.getProperty("td_emailId"));
            oBroUti.ufSendKeys(ph_password, System.getProperty("td_password"));
            oBroUti.ufClick(login);
            oBroUti.ufClick(leads);
            if (oBroUti.isDisplayed(leads))
                bRes_Flag = true;
            return bRes_Flag;
        }
    }
