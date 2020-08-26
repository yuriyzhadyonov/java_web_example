package web.test.ideals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import web.test.ideals.core.BasePageTests;
import web.test.ideals.core.pages.LoginPage;
import web.test.ideals.core.pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class LoginPageTests extends BasePageTests {

    LoginPage loginPage;
    MyAccountPage myAccountPage;

    String loginData = "gxqqobjrzqoahsjbee@twzhhq.online";
    String passwordData = "12345";

    @Before
    public void getTestClassInstance(){
        getDriverFromProperty();
//        getDriver(DriverManager.DriverEnum.CHROME);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.openPage().checkThatPageOpened();
    }

    @After
    public void tidyUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testLoginPage1(){
        loginPage.openPage();

        myAccountPage = loginPage.doLogIn(loginData, passwordData);
        myAccountPage.checkThatPageOpened();

        myAccountPage = new MyAccountPage(loginPage.getDriver());
        myAccountPage.signOut.click();
        myAccountPage.search.sendString("BLA BLA aaaaa").build();
        myAccountPage.searchBtn.click();
        myAccountPage.doSignOut();

        System.out.println("Printt");
        Assert.assertTrue(true);
    }

    @Test
    public void testLoginPageSignIn(){
        myAccountPage = loginPage.doLogIn(loginData, passwordData);
        myAccountPage.checkThatPageOpened();
        //        any additional checks
    }

    @Test
    public void testLoginPageSignOut(){
        myAccountPage = loginPage.doLogIn(loginData, passwordData);
        myAccountPage.checkThatPageOpened();

        loginPage = myAccountPage.doSignOutByBtn();
        loginPage.checkThatPageOpened();
        //        any additional checks
    }

    @Test
    public void testLoginPageSignOutByGet(){
        myAccountPage = loginPage.doLogIn(loginData, passwordData);
        myAccountPage.checkThatPageOpened();

        loginPage = myAccountPage.doSignOutByGet();
        loginPage.checkThatPageOpened();
        //        any additional checks
    }

    @Test
    public void testFake(){
        System.out.println("FAKE TEST");
    }
}
