package org.khushimasur.tests.vwoTestCases;

import io.qameta.allure.Description;
import org.khushimasur.pages.PageObjectModel.vwoProject.normal.loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class vwologin_POM_02_PropertiesReader {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Khushi\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver(edgeOptions);
//        driver.navigate().to("https://app.vwo.com");
        driver.get("https://app.vwo.com");

        loginpage loginPage_VWO = new loginpage(driver);
        String error_message = loginPage_VWO.loginToVWOLoginInvalidCreds("admin@gmail.com","123");


        assertThat(error_message).isNotBlank().isNotNull().isNotEmpty();


        Assert.assertEquals(error_message, "Your email, password, IP address or location did not match");


        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null


    }

}
