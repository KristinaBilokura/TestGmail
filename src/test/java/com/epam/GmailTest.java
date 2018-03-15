package com.epam;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GmailTest {
    AppiumDriver driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Custom Phone");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);
    }

    @Test
    public void test() {
        driver.get("https://translate.google.com.ua/");
        //https://accounts.google.com/ServiceLogin?hl=uk&passive=true&continue=https://www.google.com/%3Fgws_rd%3Dssl
        ////*[@id="identifierId"] input type="email"
        ////*[@id="identifierNext"]/content/span
        //type="password" input
        ////*[@id="passwordNext"]/content/span
        ////*[@id="gbwa"]/div[1]/a
        ////*[@id="gb23"]


    }

    @AfterTest
    public void clearUp(){
        driver.quit();
    }


}
