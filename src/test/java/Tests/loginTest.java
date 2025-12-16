package Tests;

import TestProject.Drivers.MyDriver;
import TestProject.Listeners.ListenersTestNG;
import TestProject.Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(ListenersTestNG.class) //Without this line the driver will be null as the properties will not be loaded
public class loginTest {

        //variables

        String browserName;
        MyDriver driver;
        String FalseEmail = "khaled@gmail.com";
        String FalsePassword = "123456";

        //configurations


        @BeforeClass // I changed it from before method to before class as i will write more than one method for tests
        public void Setup() {

            browserName = "chrome";

            driver = new MyDriver(browserName);


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
    }

