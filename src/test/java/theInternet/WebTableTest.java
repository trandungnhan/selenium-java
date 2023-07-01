package theInternet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Person;
import pages.WebTablePage;

import java.util.List;

public class WebTableTest {

    @Test
    void validateBiggestDuePerson() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        WebTablePage webTablePage = new WebTablePage(driver);

        String actualResult = webTablePage.findBiggestDuePerson();

        Assert.assertEquals(actualResult, "Jason Doe");
        driver.quit();
    }

   @Test
   void validateAddPersonSuccessfully(){

       WebDriver driver = new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/tables");

       Person person = new Person(driver);

       List<Person> table = null;

       table.add(person.addPerson());

       System.out.println(table);

       Person person2 = new Person(person.getFirstName(),
                                   person.getLastName(),
                                   person.getEmail(),
                                   person.getDue(),
                                   person.getWebsite());
       table.add(person2);

       System.out.println(table);
       driver.quit();
   }
}
