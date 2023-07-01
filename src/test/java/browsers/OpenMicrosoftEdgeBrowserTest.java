package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenMicrosoftEdgeBrowserTest {

    @Test
    void defaultMode(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();

    }

}
