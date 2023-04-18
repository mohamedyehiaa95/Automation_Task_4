import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class RegistrationPageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\a815201\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegistrationPage() {
        driver.get("https://accounts.lambdatest.com/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.register("Yehia Mohamed", "Yehia98@gmail.com", "P@ssw0rd123", "22123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://accounts.lambdatest.com/email/verify"));

        String expectedUrl = "https://accounts.lambdatest.com/email/verify";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "ERROR : The page did not redirect to the expected URL");

        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);
    }

}
