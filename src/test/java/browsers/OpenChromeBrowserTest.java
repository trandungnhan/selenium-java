package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.performance.Performance;
import org.openqa.selenium.devtools.v111.performance.model.Metric;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OpenChromeBrowserTest {

    @Test
    void defaultMode(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void headlessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.quit();

    }

    @Test
    void mobileMode(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 412);
        deviceMetrics.put("height", 915);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev");
    }

    @Test
    void fakeGeoLocation(){
//        https://oldnavy.gap.com/stores
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(37.774929),
                Optional.of(-122.419416),
                Optional.of(1)));

        driver.get("https://oldnavy.gap.com/stores");
    }

    @Test
    void interceptionNetwork(){
        WebDriver driver = new ChromeDriver();
        DevTools devTool = ((HasDevTools) driver).getDevTools();

        devTool.createSession();
        devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTool.addListener(Network.requestWillBeSent(), requestSent -> {
            System.out.println("Request URL => " + requestSent.getRequest().getUrl());
            System.out.println("Request Method => " + requestSent.getRequest().getMethod());
            System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());
            System.out.println("------------------------------------------------------");
        });

        devTool.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Response Url => " + responseReceived.getResponse().getUrl());
            System.out.println("Response Status => " + responseReceived.getResponse().getStatus());
            System.out.println("Response Headers => " + responseReceived.getResponse().getHeaders().toString());
            System.out.println("Response MIME Type => " + responseReceived.getResponse().getMimeType().toString());
            System.out.println("------------------------------------------------------");
        });

        driver.get("https://selenium.dev");
    }
    @Test
    void openSeleniumHomePageAndCapturePerformanceMetrics(){
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
        driver.get("https://selenium.dev");

        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();

        for(Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }

}
