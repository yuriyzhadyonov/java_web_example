package web.test.ideals.core;

import org.openqa.selenium.WebDriver;

public class BasePageTests {

    private DriverManager driverManager = new DriverManager();
    public WebDriver driver;

    public void getDriverFromProperty() {
        driver = driverManager.getDriverFromProperty();
    }

    public void getDriver(DriverManager.DriverEnum driverToGet) {
        driver = driverManager.getDriver(driverToGet);
    }
}
