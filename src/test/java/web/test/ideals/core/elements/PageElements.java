package web.test.ideals.core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.test.ideals.core.pages.AbstractPage;

public abstract class PageElements {

    protected WebDriver driver;
    protected WebElement element = null;
    protected By by;
    protected AbstractPage clsInstance;

    public PageElements setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    public PageElements find(){
        element = driver.findElement(by);
        return this;
    }
}
