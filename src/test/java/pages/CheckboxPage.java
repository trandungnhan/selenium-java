package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckboxPage {

    WebDriver driver;

    By checkbox1 = By.cssSelector("#checkboxes input:first-child");
    By checkbox2 = By.cssSelector("#checkboxes input:last-child");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCheckbox1(){
        if (!driver.findElement(checkbox1).isSelected()){
            driver.findElement(checkbox1).click();
        }
    }

    public void selectCheckbox2(){
        if (!driver.findElement(checkbox2).isSelected()){
            driver.findElement(checkbox2).click();
        }
    }

    public void unselectCheckbox1(){
        if (driver.findElement(checkbox1).isSelected()){
            driver.findElement(checkbox1).click();
        }
    }

    public void unselectCheckbox2(){
        if (driver.findElement(checkbox2).isSelected()){
            driver.findElement(checkbox2).click();
        }
    }

    public void verifyCheckbox1Selected()
    {
        Assert.assertTrue(driver.findElement(checkbox1).isSelected());
    }

    public void verifyCheckbox1Unselected()
    {
        Assert.assertFalse(driver.findElement(checkbox1).isSelected());
    }

    public void verifyCheckbox2Selected()
    {
        Assert.assertTrue(driver.findElement(checkbox2).isSelected());
    }

    public void verifyCheckbox2Unselected()
    {
        Assert.assertFalse(driver.findElement(checkbox2).isSelected());
    }

}
