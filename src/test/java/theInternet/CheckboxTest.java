package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxTest {

    WebDriver driver;

    @Test
    void validateCheckSuccessfully() {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        CheckboxPage checkboxPage = new CheckboxPage(driver);

        checkboxPage.selectCheckbox1();

        checkboxPage.verifyCheckbox1Selected();

        checkboxPage.selectCheckbox2();

        checkboxPage.verifyCheckbox2Selected();

        driver.quit();

    }

    @Test
    void validateUncheckSuccessfully() {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        CheckboxPage checkboxPage = new CheckboxPage(driver);

        checkboxPage.unselectCheckbox1();

        checkboxPage.verifyCheckbox1Unselected();

        checkboxPage.unselectCheckbox2();

        checkboxPage.verifyCheckbox2Unselected();
        driver.quit();

    }

}
