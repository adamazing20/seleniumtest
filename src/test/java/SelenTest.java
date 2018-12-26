import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This Test is a Selenium Demo that loads google hangouts, clicks the sign in button, and checks that the
 * "Forgot email?" button is enabled/clickable
 */

public class SelenTest {

    //Declaring Webdriver Variable to be used to call Driver to control browser
    private static WebDriver browser;
    private static WebDriverWait wait;
    private static final By EMAIL_EXISTS_BUTTON = By.cssSelector("button[jsname='Cuz2Ue']");

    // @BeforeEach is a Junit Annotation that tells the test runner to run this method before each test (anything annotated with @Test)
    @BeforeEach
    public void setup() {

        // Tells the test runner where to find our webdriver executable
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");

        //Instantiates our webdriver as a new instance of ChromeDriver
        browser = new ChromeDriver();
        // defining a max wait time for elements to exist when envoking ExpectedConditions
        wait = new WebDriverWait(browser, 10);

    }

    // @AfterEach is a Junit Annotation that tells the test runner to run this method After each test (anything annotated with @Test)
    @AfterEach
    public void tearDown() {
        //Closes our open browser
        browser.close();
    }

    //This is the actual test, you can have multiple per fil, usually has a descriptive name
    @Test
    public void testMethodOne() {
        //Calling get() on a url will tell the driver to open that page
        browser.get("https://hangouts.google.com/");

        //finding elements is a way of telling the driver how to interact with elements on the webpage
        browser.findElement(By.linkText("Sign in")).click();

        // assert or check that the button is clickable on the page (this would be the thing you're checking for in the test)
        assertTrue(checkForgotEmailBtnIsClickcable());

    }

    //return true if the button is enabled/clickable
    private boolean checkForgotEmailBtnIsClickcable() {
        return getEmailBtn().isEnabled();
    }

    //separate method for getting the button off the page we want to test
    private WebElement getEmailBtn() {
        //some selenium magic to wait for the page to load -> selenium is often faster than a browser so if you don't wait it will look
        //for the element before the page loads
        return wait.until(ExpectedConditions.visibilityOf(browser.findElement(EMAIL_EXISTS_BUTTON)));
    }
}
