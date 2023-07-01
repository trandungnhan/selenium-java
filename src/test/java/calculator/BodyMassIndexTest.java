package calculator;
import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;

public class BodyMassIndexTest extends BaseTest {

    BodyMassIndexPage bodyMassIndexPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
    }

    @BeforeMethod
    void setup(){
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearForm();
    }

    @DataProvider
    Object[][] data(){
        return new Object[][]{
                {"30", "male","180","80", "24.7"},
                {"26", "female","165","55", "20.2"}
        };
    }

    @Test(dataProvider = "data")
    void TC01(String age,String gender, String height, String weight, String expectedResult) {
        bodyMassIndexPage.fillCalculatorForm(age, gender,height,weight);
        Assert.assertEquals(bodyMassIndexPage.getResult(),expectedResult);
    }

}
