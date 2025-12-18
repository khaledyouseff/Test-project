package Tests;

import TestProject.Drivers.MyDriver;
import TestProject.Listeners.ListenersTestNG;
import TestProject.Pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static TestProject.Utilities.PropertiesUtilities.getPropertyValue;

@Listeners(ListenersTestNG.class) //Without this line the driver will be null as the properties will not be loaded
public class loginTest {

        //variables

        String browserName;
        MyDriver driver;
        String FalseEmail ;
        String FalsePassword ;

        //configurations


        @BeforeClass // I changed it from before method to before class as i will write more than one method for tests
        public void Setup() {
            browserName = getPropertyValue("Browser_Name");
            driver = new MyDriver(browserName);
            FalseEmail = getPropertyValue("Invalid_Email");
             FalsePassword = getPropertyValue("Invalid_Password");
            new LoginPage(driver).GoToLoginPage();
        }

        //Tests
        @Test
        public void failedLogin() throws IOException {

            new LoginPage(driver).
                    SetUserNameField(FalseEmail).
                    SetPasswordField(FalsePassword).
                    ClickLoginButton().AssertFailedLogin();

        }


    @AfterClass
    public void TearDown() {
        driver.browser().quitBrowser();

    }
    }

