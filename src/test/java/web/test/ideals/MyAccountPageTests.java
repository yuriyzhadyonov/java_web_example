package web.test.ideals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import web.test.ideals.core.BasePageTests;
import web.test.ideals.core.DriverManager;
import web.test.ideals.core.pages.LoginPage;
import web.test.ideals.core.pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MyAccountPageTests extends BasePageTests {

    MyAccountPage myAccountPage;

    String loginData = "gxqqobjrzqoahsjbee@twzhhq.online";
    String passwordData = "12345";

    @Before
    public void getTestClassInstance(){

        getDriverFromProperty();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().checkThatPageOpened();

        myAccountPage = loginPage.doLogIn(loginData, passwordData);
        myAccountPage.checkThatPageOpened();
    }

    @After
    public void tidyUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testAccountPageDo1(){
//        myAccountPage.search.sendString("bllllla bla a");
        System.out.println("empty");
        assertTrue( true );
    }

}
