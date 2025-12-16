package TestProject.Pages;
import TestProject.Drivers.MyDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private final MyDriver driver;

    //Locators
    private final By UserName = By.id("edit-account");
    private final By PassWord = By.id("edit-password");
    private final By LogInButton = By.id("edit-submit");
    private final By LoginErrorMessage = By.id("edit-account-error");

    //Constructor

    public LoginPage(MyDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void GoToLoginPage() {
        //this browser is inside MyDriver class that returns object from BrowserElement class
        driver.browser().GoToBrowser( "https://ieltsonlinetests.com/account/log" +
                "in?destination=/ielts-online-practice-tests-free");
    }
    public LoginPage SetUserNameField(String UserNameText) {
        driver.element().SendData( UserName, UserNameText);
        return new LoginPage(driver);
        //or return this;
    }
    public LoginPage SetPasswordField(String PasswordText) {
        driver.element().SendData( PassWord, PasswordText);
        return new LoginPage(driver);
        //or return this;
    }
    public LoginPage ClickLoginButton() {
        driver.element().ClickElement(LogInButton);
        return new LoginPage(driver);
    }
    //Validations
    public LoginPage AssertFailedLogin() {
        driver.validate().AssertEquals(driver.element().GetText(LoginErrorMessage),
                "You entered an invalid Email and/or Password combination. Please verify " +
                        "that you entered this information correctly.", "Login Failed");
        return new LoginPage(driver);
    }

}
