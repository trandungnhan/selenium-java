package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenFirefoxBrowserTest {

    @Test
    void defaultMode(){

        WebDriver driver =  new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

}
