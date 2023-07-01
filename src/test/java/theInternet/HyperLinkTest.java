package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HyperLinkPage;

public class HyperLinkTest {

    @Test
    void canClickOnHyperLinksSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        HyperLinkPage hyperLinkPage = new HyperLinkPage(driver);

        hyperLinkPage.clickLinkText("200");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes/200");

        hyperLinkPage.clickLinkText("here");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes");

        hyperLinkPage.clickLinkText("301");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes/301");

        hyperLinkPage.clickLinkText("here");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes");

        hyperLinkPage.clickLinkText("404");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes/404");

        hyperLinkPage.clickLinkText("here");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes");

        hyperLinkPage.clickLinkText("500");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes/500");

        hyperLinkPage.clickLinkText("here");
        hyperLinkPage.verifyHyperLink("https://the-internet.herokuapp.com/status_codes");

        driver.quit();

    }

}
