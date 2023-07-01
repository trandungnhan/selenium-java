package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.DropDownPage;

public class DropDownTest {

    @Test
    void selectOption1Successfully(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        DropDownPage dropDownPage = new DropDownPage(driver);

        dropDownPage.selectOption("Option 1");

        dropDownPage.verifyOption1Selected();

        dropDownPage.selectOption("Option 2");

        dropDownPage.verifyOption2Selected();

        driver.quit();
    }
    @Test
    void selectMultipleOptionsSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        DropDownPage dropDownPage = new DropDownPage(driver);

        dropDownPage.checkMulSelection();

        dropDownPage.selectFruits("Banana");
        dropDownPage.selectFruits("Apple");
        dropDownPage.deselectFruits("Apple");

        driver.quit();
    }
}
