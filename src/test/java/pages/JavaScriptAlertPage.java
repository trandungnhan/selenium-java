package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage {
    
    WebDriver driver;

    By jsAlertButton = By.xpath("//button[.='Click for JS Alert']");
    By jsConfirmButton = By.xpath("//button[.='Click for JS Confirm']");
    By jsPromptButton = By.xpath("//button[.='Click for JS Prompt']");
    By resultMessage = By.id("result");

    public JavaScriptAlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectJsAlertButton(){
        driver.findElement(jsAlertButton).click();
    }

    public void selectJsConfirmButton(){
        driver.findElement(jsConfirmButton).click();
    }

    public void selectJsPromptButton(){
        driver.findElement(jsPromptButton).click();
    }

    public void selectOkButton(){
        driver.switchTo().alert().accept();
    }

    public void selectCancelButton(){
        driver.switchTo().alert().dismiss();
    }

    public String getResultMessage(){
        return driver.findElement(resultMessage).getText();
    }

    public String getPopupMessage(){
        return driver.switchTo().alert().getText();
    }

    public void sendMessage(String message){
        driver.switchTo().alert().sendKeys(message);
    }

}
