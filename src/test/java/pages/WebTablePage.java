package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTablePage {

    WebDriver driver;

    By dueColumnLocator = By.cssSelector("table#table1 tbody tr td:nth-child(4)");

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public String findBiggestDuePerson(){

        List<WebElement> dueColumn = driver.findElements(dueColumnLocator);

        List<Float> dueValue = dueColumn
                .stream().map(WebElement::getText)
                .collect(Collectors.toList())
                .stream()
                .map(due -> due.replace("$",""))
                .collect(Collectors.toList())
                .stream()
                .map(Float::parseFloat)
                .collect(Collectors.toList());

        Float maxDue = dueValue.stream().max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);

        int indexOfMaxDue = dueValue.indexOf(maxDue);
        for(Float due: dueValue){
            System.out.println(due);
        }
        System.out.println("max due value" + maxDue);
        System.out.println("max due index" + indexOfMaxDue);
        String lastNameOfBiggestPerson = driver.findElement(By.cssSelector(String.format("table#table1 tbody tr:nth-child(%d) td:nth-child(1)", indexOfMaxDue+1))).getText();
        String firstNameOfBiggestPerson = driver.findElement(By.cssSelector(String.format("table#table1 tbody tr:nth-child(%d) td:nth-child(2)", indexOfMaxDue+1))).getText();

        return String.format("%s %s", firstNameOfBiggestPerson, lastNameOfBiggestPerson);
    }

}
