import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenTest {

    //Declaring Webdriver Variable to be used to call Driver to control browser
    private static WebDriver browser;

    // @BeforeEach is a Junit Annotation that tells the test runner to run this method before each test (anything annotated with @Test)
    @BeforeEach
    public void setup() {

        // Tells the test runner where to find our webdriver executable
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");

        //Instantiates our webdriver as a new instance of ChromeDriver
        browser = new ChromeDriver();

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

        // assert or check that an element exists on the page (this would be the thing you're checking for in the test)
        assertTrue(checkForgotEmailLinkExists());

    }

    private boolean checkForgotEmailLinkExists() {

        //this is a gross way of waiting for a browser....this isn't the important bit right now. We can talk about a decent way of doing this when you get
        // an initial test working
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // returns true if the element is found
        //this is not a good test as it won't return anything if it fails to find an element.
        return browser.findElement(By.cssSelector("button[jsname='Cuz2Ue']")).isDisplayed();
    }

}
