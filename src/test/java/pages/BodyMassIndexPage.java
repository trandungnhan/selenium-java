package pages;
import org.openqa.selenium.By;
import static common.Browser.*;

public class BodyMassIndexPage {

    By metricUnitTab = By.cssSelector("#menuon");
    By clearButton = By.className("clearbtn");
    By ageTextBox = By.id("cage");
    By maleRadioButton = By.cssSelector("label[for=csex1");
    By femaleRadioButton = By.cssSelector("label[for=csex2");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By calculateButton = By.xpath("//input[@value='Calculate']");
    By resultLabel = By.xpath("//div[@class='bigtext']/b");

    public BodyMassIndexPage(){
        getDriver();
    }

    public void selectMetricTab(){
        click(metricUnitTab);
    }

    public void clearForm(){
        click(clearButton);
    }

    public void fillCalculatorForm(String age, String gender, String height, String weight) {
        sendKeys(ageTextBox,age);

        if(gender.equalsIgnoreCase("male")){
            check(maleRadioButton);
        }else {
            check(femaleRadioButton);
        }

        sendKeys(heightTextBox,height);
        sendKeys(weightTextBox,weight);
        click(calculateButton);
    }

    public String getResult(){
        return getText(resultLabel)
                .replace("BMI = ","")
                .replace("kg/m2","")
                .trim();
    }

    public void open(){
        visit("https://www.calculator.net/bmi-calculator.html");
    }
}
