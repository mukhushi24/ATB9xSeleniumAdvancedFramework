//package org.khushimasur.pages.PageObjectModel.vwoProject;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class loginpage {
//    private WebDriver driver;
//
//
//    // Constructor to initialize WebDriver
//    public loginpage(WebDriver driver) {
//        this.driver = driver;
//    }
//    //pageClass-locator
//    //it is just a pagelocator stategy to find which locator we are gonna use
//    //divide our locators
//    //locators are used to find and interact with elements on a web page.
//    //locator uses id,classname,name...etc
//    //here in this part we are not finding we are just declaring the elements
//    //why have we used private here?
//    //it's encapsulation i dont want to share the information with anyone else
//    private By username = By.id("login-username");
//    private By password = By.id("login-password");
//    private By signin = By.id("js-login-btn");
//    private By errormessage = By.id("js-notification-box-msg");
//    // Step 2 - Page Actions
//
//    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
//        driver.get(PropertiesReader.readKey("url"));
//        driver.findElement(username).sendKeys(user);
//        driver.findElement(password).sendKeys(pwd);
//        driver.findElement(signButton).click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        String error_message_text = driver.findElement(error_message).getText();
//        return error_message_text;
//
//    }
//
//
//}
package org.khushimasur.pages.PageObjectModel.vwoProject.improvedPOM;

import org.khushimasur.base.CommonToAllPage;
import org.khushimasur.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImprovedLoginPage extends CommonToAllPage {
    private WebDriver driver;

    // Constructor to initialize WebDriver
    public ImprovedLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signin = By.id("js-login-btn");
    private By errormessage = By.id("js-notification-box-msg");

    // Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {

            openVWOUrl();
            enterInput(username,user);
            enterInput(password,pwd);
            clickElement(signin);
        custom_wait();
        presenceOfElement(errormessage);
            return getText(errormessage);


        }

    }

