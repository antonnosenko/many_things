package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleCalcPage {

    private WebDriver driver;

    @FindBy(css = "#cwbt33")
    private WebElement number1;

    @FindBy(css = "#cwbt34")
    private WebElement number2;

    @FindBy(css = "#cwbt35")
    private WebElement number3;

    @FindBy(css = "#cwbt23")
    private WebElement number4;

    @FindBy(css = "#cwbt24")
    private WebElement number5;

    @FindBy(css = "#cwbt25")
    private WebElement number6;

    @FindBy(css = "#cwbt13")
    private WebElement number7;

    @FindBy(css = "#cwbt14")
    private WebElement number8;

    @FindBy(css = "#cwbt15")
    private WebElement number9;

    @FindBy(css = "#cwbt43")
    private WebElement number0;

    @FindBy(css = "#cwbt45")
    private WebElement equal;

    @FindBy(css = "#cwbt46")
    private WebElement addition;

    @FindBy(css = "#cwbt36")
    private WebElement substraction;

    @FindBy(css = "#cwbt26")
    private WebElement multiplication;

    @FindBy(css = "#cwbt16")
    private WebElement division;

    @FindBy(css = "#cwtltblr > div.cwtlotc")
    private WebElement result;

    @FindBy(css = "#cwclrbtnAC")
    private WebElement reset;

    public GoogleCalcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click1(){
        number1.click();
    }
    public void click2(){
        number2.click();
    }
    public void click3(){
        number3.click();
    }
    public void click4(){
        number4.click();
    }
    public void click5(){
        number5.click();
    }
    public void click6(){
        number6.click();
    }
    public void click7(){
        number7.click();
    }
    public void click8(){
        number8.click();
    }
    public void click9(){
        number9.click();
    }
    public void click0(){
        number0.click();
    }

    public void equal(){
        equal.click();
    }
    public void addition(){
        addition.click();
    }
    public void substraction(){
        substraction.click();
    }
    public void multiplication(){
        multiplication.click();
    }
    public void division(){
        division.click();
    }
    public void reset(){reset.click();}

    public void clickbutton(String symbol) throws IllegalArgumentException {
        char[] symbolchar = symbol.toCharArray();
        for (char i : symbolchar){
            switch (i){
                case '1': click1();
                    break;
                case '2': click2();
                    break;
                case '3': click3();
                    break;
                case '4': click4();
                    break;
                case '5': click5();
                    break;
                case '6': click6();
                    break;
                case '7': click7();
                    break;
                case '8': click8();
                    break;
                case '9': click9();
                    break;
                case '0': click0();
                    break;
                case '-': substraction();
                    break;
                case '+': addition();
                    break;
                case '*': multiplication();
                    break;
                case '/': division();
                    break;
                default: throw new IllegalArgumentException("Wrong argument!");
            }
        }
    }

    public void calculate(String num1, String operator, String num2){
        clickbutton(num1);
        clickbutton(operator);
        clickbutton(num2);
        equal();
    }

    public void calculate(String num1, String operator, String num2, String equalSymb){
        Actions input = new Actions(driver);
        input.moveToElement(result);
        input.click();
        input.sendKeys(num1, operator, num2, equalSymb);
        input.build().perform();
    }

    public String getAnswer(){
        return result.getText();
    }

}
