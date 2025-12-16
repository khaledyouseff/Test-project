package TestProject.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private WebDriver driver;
    private BrowserActions browserActions;

    public Validations(WebDriver driver) {
        this.driver = driver;
        browserActions = new BrowserActions(driver);
    }

    private Validations() {
    }

    public void AssertEquals(String Actual, String Expected, String Message) {
        Assert.assertEquals(Actual, Expected, Message);
    }
}
