package TestProject.Pages;
import org.openqa.selenium.By;

public class LoginPage {

    //Locators
    private final By UserName = By.id("edit-account");
    private final By PassWord = By.id("edit-password");
    private final By LogInButton = By.id("edit-submit");
    private final By LoginErrorMessage = By.id("edit-account-error");
}
