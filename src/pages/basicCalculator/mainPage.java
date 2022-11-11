import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainPage {
    WebDriver driver;
    WebDriverWait wait;
    public mainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Header Main Page Controls
    By pageHeaderLbl = By.cssSelector("div.container a.navbar-brand.js-scroll-trigger");
    By menuBtn = By.cssSelector("button[data-target='#navbarResponsive']");

    // Navigation panel
    By numberGameNavigationLbl = By.cssSelector("div#navbarResponsive li.nav-item:nth-child(1)");
    By automationKataNavigationLbl = By.cssSelector("div#navbarResponsive li.nav-item:nth-child(2)");
    By workshopsNavigationLbl = By.cssSelector("div#navbarResponsive li.nav-item:nth-child(3)");
    By mediaNavigationLbl = By.cssSelector("div#navbarResponsive li.nav-item:nth-child(4)");
    By mikeTalksNavigationLbl = By.cssSelector("div#navbarResponsive li.nav-item:nth-child(5)");

    // Instructions Container Controls
    By instructionsTitleLbl = By.cssSelector("section#main-body h1");
    By instructionsFirstRowLbl = By.cssSelector("section#main-body p:nth-child(3)");
    By instructionsSecondRowLbl = By.cssSelector("section#main-body p:nth-child(4)");
    By instructionsThirdRowLbl = By.cssSelector("section#main-body p:nth-child(5)");
    By instructionsFourthRowLbl = By.cssSelector("section#main-body p:nth-child(6)");
    By instructionsFifthRowLbl = By.cssSelector("section#main-body p:nth-child(8)");

    // Calculate Controls
    By calculateLbl = By.cssSelector("form#calcForm h2");
    By firstNumberTxtbox = By.cssSelector("input#number1Field");
    By secondNumberTxtbox = By.cssSelector("input#number2Field");
    By operationCmbbox = By.cssSelector("select#selectOperationDropdown");
    By calculateBtn = By.cssSelector("input#calculateButton");
    By answerTxtbox = By.cssSelector("form#answerForm input");
    By integersOnlyChkbox = By.cssSelector("input#integerSelect");
    By clearBtn = By.cssSelector("input#clearButton");

    // Footer Controls
    By copyrightLbl = By.cssSelector("footer.footer div.col-md-4 span");
    By twitterBtn = By.cssSelector("footer.footer div.col-md-4 ul.list-inline.social-buttons li:nth-child(1) a");
    By linkedInBtn = By.cssSelector("footer.footer div.col-md-4 ul.list-inline.social-buttons li:nth-child(3) a");
    By aboutLink = By.cssSelector("footer.footer div.col-md-4 ul.list-inline.quicklinks li:nth-child(1)");
    By termsofUseLink = By.cssSelector("footer.footer div.col-md-4 ul.list-inline.quicklinks li:nth-child(2)");

    // List of all methods
    // Method for verifying navigation bar
    public void verifyAllLabels(){
        // Waiting for navigation labels
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberGameNavigationLbl));
        wait.until(ExpectedConditions.visibilityOfElementLocated(automationKataNavigationLbl));
        wait.until(ExpectedConditions.visibilityOfElementLocated(workshopsNavigationLbl));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mediaNavigationLbl));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mikeTalksNavigationLbl));

        // Asserting navigation labels
        assertEquals("NUMBER GAME", driver.findElement(numberGameNavigationLbl).getText());
        assertEquals("AUTOMATION KATA", driver.findElement(automationKataNavigationLbl).getText());
        assertEquals("WORKSHOPS", driver.findElement(workshopsNavigationLbl).getText());
        assertEquals("MEDIA", driver.findElement(mediaNavigationLbl).getText());
        assertEquals("MIKE TALKS", driver.findElement(mikeTalksNavigationLbl).getText());

        // Asserting Instruction panel labels
        assertEquals("Instructions", driver.findElement(instructionsTitleLbl).getText());
        assertEquals("The following page is a very basic calculator - I know you have one on your phone, so why do you need another one?",
                driver.findElement(instructionsFirstRowLbl).getText());
        assertEquals("The purpose of this page is to provide an object with basic functionality for you to try your first attempt to use a test tool on.",
                driver.findElement(instructionsSecondRowLbl).getText());
        assertEquals("You can add/subtract/divide/multiply - all mathematical functions. When chosen, the page checks that you've entered numerical values. You can also toggle whether you want your answer as an integer value.",
                driver.findElement(instructionsThirdRowLbl).getText());
        assertEquals("If you choose to concatonate, the system treats the inputs as strings, and won't check numerical values. You'll also not be able to select to get an integer value answer.",
                driver.findElement(instructionsFourthRowLbl).getText());
        assertEquals("There are multiple builds available. Prototype works perfectly, whereas builds 1-8 have problems. A good set of tests should help identify what the problems are.",
                driver.findElement(instructionsFifthRowLbl).getText());

        // Asserting Footer labels
        assertEquals("Copyright © Mike Talks 2020", driver.findElement(copyrightLbl).getText());
        assertEquals("https://twitter.com/TestSheepNZ", driver.findElement(twitterBtn).getAttribute("href"));
        assertEquals("https://www.linkedin.com/in/mike-talks-3423348/", driver.findElement(linkedInBtn).getAttribute("href"));
        assertEquals("About", driver.findElement(aboutLink).getText());
        assertEquals("Terms of Use", driver.findElement(termsofUseLink).getText());
    }

    // Method for adding first and second number
    public void calculateSum(int firstNumber, int secondNumber){
        driver.findElement(firstNumberTxtbox).clear();
        driver.findElement(secondNumberTxtbox).clear();
        driver.findElement(firstNumberTxtbox).sendKeys(Integer.toString(firstNumber));
        driver.findElement(secondNumberTxtbox).sendKeys(Integer.toString(secondNumber));
        driver.findElement(operationCmbbox).sendKeys("Add");
        driver.findElement(calculateBtn).click();
        int sum = firstNumber + secondNumber;
        // Asserting sum if correct
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerTxtbox));
        assertEquals(Integer.toString(sum), driver.findElement(answerTxtbox).getAttribute("value"));
    }
    // Method for subtracting first and second number
    public void calculateDifference(int firstNumber, int secondNumber){
        driver.findElement(firstNumberTxtbox).clear();
        driver.findElement(secondNumberTxtbox).clear();
        driver.findElement(firstNumberTxtbox).sendKeys(Integer.toString(firstNumber));
        driver.findElement(secondNumberTxtbox).sendKeys(Integer.toString(secondNumber));
        driver.findElement(operationCmbbox).sendKeys("Subtract");
        driver.findElement(calculateBtn).click();
        int difference = firstNumber - secondNumber;
        // Asserting difference if correct
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerTxtbox));
        assertEquals(Integer.toString(difference), driver.findElement(answerTxtbox).getAttribute("value"));
    }
    // Method for multiplying first and second number
    public void calculateProduct(int firstNumber, int secondNumber){
        driver.findElement(firstNumberTxtbox).clear();
        driver.findElement(secondNumberTxtbox).clear();
        driver.findElement(firstNumberTxtbox).sendKeys(Integer.toString(firstNumber));
        driver.findElement(secondNumberTxtbox).sendKeys(Integer.toString(secondNumber));
        driver.findElement(operationCmbbox).sendKeys("Multiply");
        driver.findElement(calculateBtn).click();
        int product = firstNumber * secondNumber;
        // Asserting product if correct
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerTxtbox));
        assertEquals(Integer.toString(product), driver.findElement(answerTxtbox).getAttribute("value"));
    }
    // Method for dividing first and second number
    public void calculateQuotient(int firstNumber, int secondNumber){
        driver.findElement(firstNumberTxtbox).clear();
        driver.findElement(secondNumberTxtbox).clear();
        driver.findElement(firstNumberTxtbox).sendKeys(Integer.toString(firstNumber));
        driver.findElement(secondNumberTxtbox).sendKeys(Integer.toString(secondNumber));
        driver.findElement(operationCmbbox).sendKeys("Divide");
        driver.findElement(calculateBtn).click();
        int quotient = firstNumber / secondNumber;
        // Asserting quotient if correct
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerTxtbox));
        assertEquals(Integer.toString(quotient), driver.findElement(answerTxtbox).getAttribute("value"));
    }
    // Method for concatenating first and second number
    public void concatenateTwoNumbers(int firstNumber, int secondNumber){
        driver.findElement(firstNumberTxtbox).clear();
        driver.findElement(secondNumberTxtbox).clear();
        driver.findElement(firstNumberTxtbox).sendKeys(Integer.toString(firstNumber));
        driver.findElement(secondNumberTxtbox).sendKeys(Integer.toString(secondNumber));
        driver.findElement(operationCmbbox).sendKeys("Concatenate");
        driver.findElement(calculateBtn).click();
        String concatenatedAnswer = Integer.toString(firstNumber) + Integer.toString(secondNumber);
        // Asserting two concatenated numbers are correct
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerTxtbox));
        assertEquals(concatenatedAnswer, driver.findElement(answerTxtbox).getAttribute("value"));
    }
}
