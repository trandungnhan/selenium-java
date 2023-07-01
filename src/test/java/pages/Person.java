package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Person {

    By lastNameLocator = By.cssSelector("table#table1 tbody tr:nth-child(%d) td:nth-child(1)");
    By firstNameLocator = By.cssSelector("table#table1 tbody tr:nth-child(%d) td:nth-child(1)");
    By emailLocator = By.cssSelector("table#table1 tbody tr:nth-child(%d) td:nth-child(1)");
    By dueLocator = By.cssSelector("table#table1 tbody tr:nth-child(%d) td:nth-child(1)");
    By websiteLocator = By.cssSelector("table#table1 tbody tr:nth-child(%d) td:nth-child(1)");

    String lastName;
    String firstName;
    String email;
    String due;
    String website;

    WebDriver driver;

    public Person(WebDriver driver) {
        this.driver = driver;
    }

    public Person(String lastName, String firstName, String email, String due, String website) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getDue() {
        return due;
    }

    public String getWebsite() {
        return website;
    }

    public Person addPerson(){
        String lastName = driver.findElement(lastNameLocator).getText();
        String firstName = driver.findElement(firstNameLocator).getText();
        String email = driver.findElement(emailLocator).getText();
        String due = driver.findElement(dueLocator).getText();
        String website = driver.findElement(websiteLocator).getText();

        return new Person(lastName,firstName,email,due,website);

    }
}
