package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPage {

    WebDriver driver;

    By dropdownBox = By.id("dropdown");
    By option1 = By.xpath("//option[contains(text(),'Option 1')]");
    By option2 = By.xpath("//option[contains(text(),'Option 2')]");
    By mulSelection = By.id("fruits");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption(String option){
        Select selectDropboxList = new Select(driver.findElement(dropdownBox));
        selectDropboxList.selectByVisibleText(option);
    }

    public void verifyOption1Selected(){
        Assert.assertTrue(driver.findElement(option1).isSelected());
    }

    public void verifyOption2Selected(){
        Assert.assertTrue(driver.findElement(option2).isSelected());
    }

    public void checkMulSelection(){
        Select selectFruits = new Select(driver.findElement(mulSelection));
        if(selectFruits.isMultiple()){
            System.out.println("Able select multiple options");
        }else {
            System.out.println("Select only 1 option");
        }
    }

    public void selectFruits(String fruit){
        Select selectFruits = new Select(driver.findElement(mulSelection));
        selectFruits.selectByVisibleText(fruit);
    }

    public void deselectFruits(String fruit){
        Select selectFruits = new Select(driver.findElement(mulSelection));
        selectFruits.selectByVisibleText(fruit);
    }
}
