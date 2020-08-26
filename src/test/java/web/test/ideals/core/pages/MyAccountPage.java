package web.test.ideals.core.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.test.ideals.core.elements.PageButtonElement;
import web.test.ideals.core.locators.PageLocators;

public class MyAccountPage extends AbstractPage {

    public static final String PAGE_URL = "/index.php?controller=my-account";
    public static final String PAGE_LOG_OUT_URL = "/index.php?mylogout=";
    public static final String TITLE = "My account - My Store";
    private final By pageLoadMarker = PageLocators.COMMON_SEARCH;

    public PageButtonElement signOut;
//    any more

    public MyAccountPage(WebDriver driver) {
        super(PAGE_URL, driver);
        signOut = new PageButtonElement(this, PageLocators.COMMON_SIGN_OUT);
    }

    public MyAccountPage openPage() {
        driver.get(pageUrl);
        super.waitUntilLoadPage(pageLoadMarker, 3);
        return this;
    }

    @Override
    public AbstractPage closePage() {
        return null;
    }

    @Override
    public MyAccountPage checkThatPageOpened() {
        Assert.assertEquals(TITLE, getTitleForPage());
        return this;
    }

    public LoginPage doSignOut(){
        return doSignOutByGet();
    }

    public LoginPage doSignOutByBtn(){
        this.signOut.click();
        LoginPage loginPage = new LoginPage(this.getDriver());

        return loginPage;
    }

    public LoginPage doSignOutByGet(){
        driver.get(BASE_HOST + PAGE_LOG_OUT_URL);
        LoginPage loginPage = new LoginPage(this.getDriver());

        return loginPage;
    }

}
