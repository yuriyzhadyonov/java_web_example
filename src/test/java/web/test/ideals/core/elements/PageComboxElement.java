package web.test.ideals.core.elements;

import org.openqa.selenium.By;
import web.test.ideals.core.pages.AbstractPage;

public class PageComboxElement extends PageElements {

    public PageComboxElement(AbstractPage clsInstance, By by) {
        this.by = by;
        this.clsInstance = clsInstance;
        this.driver = clsInstance.getDriver();
    }

    public PageComboxElement sendString(String text){
        if (element == null) {
            this.find();
        }
        element.sendKeys(text);
        return this;
    }

    public PageComboxElement clean(){
        if (element == null) {
            this.find();
        }
        element.clear();
        return this;
    }

    public AbstractPage build() {
        return clsInstance;
    }

    @Override
    public String toString() {
        return "PageComboxElement{" +
                "driver=" + driver +
                ", by=" + by +
                ", element=" + element +
                ", clsInstance=" + clsInstance +
                '}';
    }
}
