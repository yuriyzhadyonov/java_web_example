package web.test.ideals.core.elements;

import org.openqa.selenium.By;
import web.test.ideals.core.pages.AbstractPage;

public class PageButtonElement extends PageElements{

    public PageButtonElement(AbstractPage clsInstance, By by) {
        this.clsInstance = clsInstance;
        this.by = by;
        this.driver = clsInstance.getDriver();
    }

    public PageButtonElement click(){
        if (element == null) {
            this.find();
        }
        element.click();
        return this;
    }

}
