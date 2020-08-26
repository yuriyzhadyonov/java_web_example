package web.test.ideals.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.test.ideals.core.elements.PageButtonElement;
import web.test.ideals.core.elements.PageComboxElement;
import web.test.ideals.core.locators.PageLocators;

public abstract class AbstractPage{

    protected WebDriver driver;
    protected static String BASE_HOST; // http://automationpractice.com
    protected String pageUrl;

    static {
        BASE_HOST = System.getProperty("test.host", "http://automationpractice.com");
    }

    public final PageComboxElement search;
    public final PageButtonElement searchBtn;
    public final PageButtonElement cart;

    public AbstractPage(String page_url, WebDriver driver) {
        pageUrl = BASE_HOST + page_url;
        this.driver = driver;

        search = new PageComboxElement(this, PageLocators.COMMON_SEARCH);
        searchBtn = new PageButtonElement(this, PageLocators.COMMON_SEARCH_BTN);
        cart = new PageButtonElement(this, PageLocators.COMMON_CART);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public abstract AbstractPage openPage();

    public abstract AbstractPage closePage();

    public abstract AbstractPage checkThatPageOpened();

    public void waitUntilLoadPage(By marker, int waitSec){
        WebDriverWait wait = new WebDriverWait(driver, waitSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(marker));
    }

    public String getTitleForPage(){
        return driver.getTitle();
    }

}
