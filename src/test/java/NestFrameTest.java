import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestFrameTest {

    @Test
    void verifyFrameContent(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("content")).getText());

    }
}
