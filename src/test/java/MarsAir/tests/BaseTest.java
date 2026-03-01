package MarsAir.tests;

import MarsAir.pages.SearchPage;
import MarsAir.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected SearchPage searchPage;

    @BeforeMethod
    void setUp() {
        String browserType = ConfigReader.getProperty("browser");
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Unsupported browser type: '" + browserType + "'. Please check your config.properties file.");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchPage = new SearchPage(driver);

    }

    @AfterMethod
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
