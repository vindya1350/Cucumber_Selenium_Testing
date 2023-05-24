package com.jupitertoys.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jupitertoys.util.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class Driverfactory {

    public WebDriver driver;

    public WebDriver initDriver(String browser) {
        browser = browser.toUpperCase();
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser)).setup();
        switch (browser) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(options);
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(PropertyReader.getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }

    public synchronized WebDriver getDriver() {
        return driver;
    }
}
