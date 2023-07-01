package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    @Test
    void withValidCredentialsShouldLoginSuccess(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("tomsmith");
        loginPage.inputPassword("SuperSecretPassword!");
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.getWelcomeMessage(),"Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertEquals(loginPage.getCurrentURL(),"https://the-internet.herokuapp.com/secure");
        driver.quit();
    }

}
