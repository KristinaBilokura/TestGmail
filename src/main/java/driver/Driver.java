package driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AppiumDriver driver;
    private static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Custom Phone");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                setUp();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
    protected void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
