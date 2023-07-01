package MarsAir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MarsAirTest {

    @Test
    void loginMarsAirSuccessfully() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://marsair.recruiting.thoughtworks.net/NhanTran");

        Select departingSel = new Select(driver.findElement(By.id("departing")));
        departingSel.selectByVisibleText("July");

        Select returningSel = new Select(driver.findElement(By.id("returning")));
        returningSel.selectByVisibleText("December (two years from now)");

        driver.findElement(By.id("promotional_code")).sendKeys("AF3-FJK-418");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        String promoMegs = driver.findElement(By.className("promo_code")).getText();
        Assert.assertEquals(promoMegs, "Promotional code AF3-FJK-418 used: 30% discount!");

        String successfulMegs1 = driver.findElement(By.xpath("//div[@id='content']/p[1]")).getText();
        Assert.assertEquals(successfulMegs1,"Seats available!");

        String successfulMegs2 = driver.findElement(By.xpath("//div[@id='content']/p[3]")).getText();
        Assert.assertEquals(successfulMegs2,"Call now on 0800 MARSAIR to book!");


    }
}
