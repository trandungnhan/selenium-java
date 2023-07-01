package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By submitButton = By.cssSelector("button[type=submit]");
    By welcomeMessage = By.className("subheader");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username){
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public String getWelcomeMessage(){
        return driver.findElement(welcomeMessage).getText();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
