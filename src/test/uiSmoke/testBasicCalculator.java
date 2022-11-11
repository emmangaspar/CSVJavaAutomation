import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class testBasicCalculator {
    @Test
    public void testCalculatorPageControls(){
        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(5));
        mainPage basicCalculator = new mainPage(chrome, wait);

        // Opening browser
        chrome.get("https://testsheepnz.github.io/BasicCalculator.html");

        // Verify all labels
        basicCalculator.verifyAllLabels();

        // Closing app
        chrome.close();
    }
    @Test
    public void testCalculatorFunctionality(){
        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(5));
        mainPage basicCalculator = new mainPage(chrome, wait);

        // Opening browser
        chrome.get("https://testsheepnz.github.io/BasicCalculator.html");

        // Adding two numbers
        basicCalculator.calculateSum(10, 20);

        // Subtracting two numbers
        basicCalculator.calculateDifference(23, 8);

        // Multiplying two numbers
        basicCalculator.calculateProduct(20, 3);

        // Dividing two numbers
        basicCalculator.calculateQuotient(10, 5);

        // Concatenating two numbers
        basicCalculator.concatenateTwoNumbers(1, 23);

        // Closing app
        chrome.close();
    }
}
