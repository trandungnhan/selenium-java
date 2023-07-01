package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HyperLinkPage {

    WebDriver driver;

    public HyperLinkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkText(String code){
        driver.findElement(By.linkText(code)).click();
    }

    public void verifyHyperLink(String link){
        Assert.assertEquals(driver.getCurrentUrl(),link);
    }


}
