package MarsAir.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    By selDepartingMonth = By.id("departing");
    By selReturningMonth = By.id("returning");
    By msgSeatStatus = By.xpath("//p[contains(text(),'available') or contains(text(),'Unfortunately')]");
    By msgCallToBook = By.xpath("//p[contains(text(),'Call now')]");
    By msgDiscountResult = By.cssSelector(".promo_code");
    By txtPromotionalCode = By.id("promotional_code");
    By btnSearch = By.xpath("//input[@type='submit']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFlight(String departMonth, String returnMonth, String promotionalCode) {
        new Select(driver.findElement(selDepartingMonth)).selectByVisibleText(departMonth);
        new Select(driver.findElement(selReturningMonth)).selectByVisibleText(returnMonth);
        driver.findElement(txtPromotionalCode).sendKeys(promotionalCode);
        driver.findElement(btnSearch).click();
    }

    public String getConfirmSeatMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msgSeatStatus)).getText();
    }

    public String getBookingPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msgCallToBook)).getText();
    }

    public String getDiscountResult(int second) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(second));
            return customWait.until(ExpectedConditions.visibilityOfElementLocated(msgDiscountResult)).getText();
        }catch (Exception e){
            return "";
        }

    }

}
