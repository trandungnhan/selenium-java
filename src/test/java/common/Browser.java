package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    // Selenium Owner method -> static method
    public static WebDriver driver;

    public static WebDriverWait wait;

    private static int TIME_OUT_IN_SECONDS = 30;

    public static void launch(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            driver = new ChromeDriver(chromeOptions);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException(browserName + " is not support!!");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit() {
        driver.quit();
    }

    public static void captureScreenShot(String fileName) {
        TakesScreenshot scrShot = ((TakesScreenshot) Browser.getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(String.format("target/%s.png", fileName));
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void check(By element){
        if(driver.findElement(element).isSelected()){
            driver.findElement(element).click();
        }
    }

    public static void uncheck(By element){
        if(driver.findElement(element).isSelected()){
            driver.findElement(element).click();
        }
    }

    public static void click(By element){
        driver.findElement(element).click();
        //wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static String getText(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    public static void sendKeys(By element, String withText){
        //driver.findElement(element).sendKeys(withText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(withText);
    }

    public static void visit(String url){
        driver.get(url);
    }


}