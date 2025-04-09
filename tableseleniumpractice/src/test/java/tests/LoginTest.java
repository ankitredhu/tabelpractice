package tests;

import base.BaseTest;
import dataproviders.ExcelDataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
    public void testLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        System.out.println("Login attempted with: " + username + " / " + password);
    }
}
