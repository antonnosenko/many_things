package GoogleCalcTests;

import PageObject.GoogleCalcPage;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCalcSteps {

    private static final String url = "https://www.google.com.ua/search?q=calc&oq=calc&aqs=chrome.0.69i59l2j69i61j69i60j0l2.1423j0j9&sourceid=chrome&ie=UTF-8";
    private static final String webdriverPath = "./webdrivers/chromedriver.exe";
    private static final String webdriverProperty = "webdriver.chrome.driver";
    private static final String numRegex = "[-]{0,1}[\\d]*";
    private static final String operatorRegex = "[-+/*]{1}";
    private static final String equalSymb = "=";
    public static WebDriver driver;
    public static PageObject.GoogleCalcPage gcalc;

    @BeforeStories
    public void setup(){
        System.setProperty(webdriverProperty, webdriverPath);
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterStories
    public void shutDown(){
        driver.quit();
    }

    @Given("google calculator page")
    public void googleCalcPage(){
        gcalc = new GoogleCalcPage(driver);
    }

    @When("press the buttons $num1 $operator $num2")
    public void inputOperationWhithButtons(String num1, String operator, String num2) throws IllegalArgumentException {
        if(num1.matches(numRegex)&& operator.matches(operatorRegex)&& num2.matches(numRegex)){
            gcalc.calculate(num1, operator, num2);
        }
        else {
            throw new IllegalArgumentException("Wrong argument!");
        }
    }

    @When("input in field $num1 $operator $num2")
    public void inputOperationWhithField(String num1, String operator, String num2) throws IllegalArgumentException {
        if(num1.matches(numRegex)&& operator.matches(operatorRegex)&& num2.matches(numRegex)){
            gcalc.calculate(num1, operator, num2, equalSymb);
        }
        else {
            throw new IllegalArgumentException("Wrong argument!");
        }
    }

    @Then("the answer is $result")
    public void answerIs(String answer){
        Assert.assertEquals(answer, gcalc.getAnswer());
        gcalc.reset();
    }
}
