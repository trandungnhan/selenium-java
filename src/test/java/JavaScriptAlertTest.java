import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest {

    @Test
    void jsAlert(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage(driver);

        javaScriptAlertPage.selectJsAlertButton();
        Assert.assertEquals(javaScriptAlertPage.getPopupMessage(),"I am a JS Alert");
        javaScriptAlertPage.selectOkButton();
        Assert.assertEquals(javaScriptAlertPage.getResultMessage(),"You successfully clicked an alert");

        driver.quit();
    }

    @Test
    void jsConfirm(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage(driver);

        javaScriptAlertPage.selectJsConfirmButton();
        Assert.assertEquals(javaScriptAlertPage.getPopupMessage(),"I am a JS Confirm");
        javaScriptAlertPage.selectCancelButton();
        Assert.assertEquals(javaScriptAlertPage.getResultMessage(),"You clicked: Cancel");

        driver.quit();
    }

    @Test
    void jsPrompt(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage(driver);

        javaScriptAlertPage.selectJsPromptButton();
        javaScriptAlertPage.sendMessage("Hello");
        javaScriptAlertPage.selectOkButton();
        Assert.assertEquals(javaScriptAlertPage.getResultMessage(),"You entered: Hello");

        driver.quit();
    }
}
