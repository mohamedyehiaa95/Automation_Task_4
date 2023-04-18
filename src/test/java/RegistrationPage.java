import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(id = "name")
    WebElement fullNameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"userpassword\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/form/div[3]/div/div")
    WebElement showPasswordButton;

    @FindBy(css = "select[name=\"country_code\"] option[value='+357']")
    WebElement phoneCodeOption;

    @FindBy(name = "phone")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/form/div[6]/button")
    WebElement signUpButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void register(String fullName, String email, String password, String phoneNumber) {
        enterFullName(fullName);
        enterEmail(email);
        enterPassword(password);
        toggleShowPassword();
        selectPhoneCodeOption();
        enterPhoneNumber(phoneNumber);
        clickSignUp();
    }

    private void enterFullName(String fullName) {
        fullNameInput.sendKeys(fullName);
    }

    private void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void toggleShowPassword() {
        showPasswordButton.click();
    }

    private void selectPhoneCodeOption() {
        phoneCodeOption.click();
    }

    private void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    private void clickSignUp() {
        signUpButton.click();
    }
}
