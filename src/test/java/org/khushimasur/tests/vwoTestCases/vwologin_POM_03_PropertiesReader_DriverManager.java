package org.khushimasur.tests.vwoTestCases;

import io.qameta.allure.Description;
import org.khushimasur.base.CommonToAllTests;
import org.khushimasur.driver.DriverManager;
import org.khushimasur.pages.PageObjectModel.vwoProject.normal.loginpage;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class vwologin_POM_03_PropertiesReader_DriverManager extends CommonToAllTests {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Khushi\\Downloads\\edgedriver_win64\\msedgedriver.exe");


//POM
        loginpage loginPage_VWO = new loginpage(DriverManager.getDriver());
        String error_message = loginPage_VWO.loginToVWOLoginInvalidCreds("admin@gmail.com","123");

//Assertion
        assertThat(error_message).isNotBlank().isNotNull().isNotEmpty();


        Assert.assertEquals(error_message, "Your email, password, IP address or location did not match");




    }

}
