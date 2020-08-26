package web.test.ideals.core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverManager {

    private WebDriver remoteWebDriver;
    private static final String hubUrl;
    private static final String driverToUse;
    private DesiredCapabilities desiredCapabilities;

    static {
        hubUrl = System.getProperty("test.hub", "http://localhost:4444/wd/hub");
        driverToUse = System.getProperty("test.driver.touse", "CHROME");
    }

    public enum DriverEnum {
        CHROME,
        FIREFOX,
        REMOTE_CHROME,
        REMOTE_FIREFOX
    }

    public DriverManager() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resouces\\chromedriver.84.exe");
        System.setProperty("webdriver.gecko.driver", "src\\test\\resouces\\geckodriver.exe");
    }

    public WebDriver getDriverFromProperty() {
        return getDriver(DriverEnum.valueOf(driverToUse.toUpperCase()));
    }

    public WebDriver getDriver(DriverEnum driverEnum) {
        switch (driverEnum) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--test-type").addArguments("--disable-extensions");
                return new ChromeDriver(options);
            case FIREFOX:
                return new FirefoxDriver();
            case REMOTE_CHROME:
                desiredCapabilities = DesiredCapabilities.chrome();
//                desiredCapabilities.setBrowserName("chrome");
//                desiredCapabilities.setPlatform(Platform.ANY);
//                desiredCapabilities.setVersion("84");

                return createNewDriver(desiredCapabilities);
            case REMOTE_FIREFOX:
                desiredCapabilities = DesiredCapabilities.firefox();
//                desiredCapabilities.setPlatform(Platform.ANY);
//                desiredCapabilities.setBrowserName("firefox");
//                desiredCapabilities.setCapability("marionatte", false);
//                desiredCapabilities.setVersion("78");

                return createNewDriver(desiredCapabilities);
            default:
                return new ChromeDriver();
        }
    }

    private WebDriver createNewDriver(DesiredCapabilities dc) {
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(hubUrl), dc);
        } catch (java.net.MalformedURLException MalformedURLException) {
//            TODO: best way :)
            System.out.println("Something was wrong!");
        }
        return remoteWebDriver;
    }

}
