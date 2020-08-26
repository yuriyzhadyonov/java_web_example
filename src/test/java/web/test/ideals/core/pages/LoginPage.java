package web.test.ideals.core.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.test.ideals.core.elements.PageButtonElement;
import web.test.ideals.core.elements.PageComboxElement;
import web.test.ideals.core.locators.PageLocators;

public class LoginPage extends AbstractPage{

    public static final String PAGE_URL = "/index.php?controller=authentication";
    public static final String TITLE = "My Store";
    private final By pageLoadMarker = PageLocators.COMMON_SEARCH;

    public PageComboxElement email;
    public PageComboxElement password;
    public PageButtonElement singIn;

    public LoginPage(WebDriver driver) {
        super(PAGE_URL, driver);

        email = new PageComboxElement(this, PageLocators.LOGIN_PAGE_EMAIL);
        password = new PageComboxElement(this, PageLocators.LOGIN_PAGE_PASSWORD);
        singIn = new PageButtonElement(this, PageLocators.LOGIN_PAGE_SIGN_IN);
    }

    public LoginPage openPage() {
        driver.get(pageUrl);
        super.waitUntilLoadPage(pageLoadMarker, 4);
        return this;
    }

    @Override
    public LoginPage closePage() {
        driver.close();
        return this;
    }

    @Override
    public LoginPage checkThatPageOpened() {
        Assert.assertTrue(getTitleForPage().contains(TITLE));
//        checks
        return this;
    }

    public MyAccountPage doLogIn(String email, String password){
        this.email.sendString(email).build();
        this.password.sendString(password).build();
        this.singIn.click();

        MyAccountPage myAccountPage = new MyAccountPage(this.getDriver());
        return myAccountPage;
    }

}
