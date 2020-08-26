package web.test.ideals.core.locators;

import org.openqa.selenium.By;

public class PageLocators {

//    COMMON
    public static final By COMMON_SEARCH = By.xpath("//input[@class = 'search_query form-control ac_input']");
    public static final By COMMON_SEARCH_BTN = By.xpath("//button[@name= 'submit_search']");
    public static final By COMMON_CART = By.xpath("//div[@class = 'shopping_cart']/a");
    public static final By COMMON_SIGN_IN = By.xpath("//a[@class = 'login']");
    public static final By COMMON_SIGN_OUT = By.xpath("//a[@class = 'logout']");

//    LOGIN
    public static final By LOGIN_PAGE_EMAIL = By.cssSelector("#email");
    public static final By LOGIN_PAGE_PASSWORD = By.cssSelector("#passwd");
    public static final By LOGIN_PAGE_SIGN_IN = By.cssSelector("#SubmitLogin");

//    ACC
    public static final By ACC_LINK1 = By.cssSelector("#SubmitLogin");

}
