package TestProject.Utilities;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public  void GoToBrowser( String URL) {
        driver.get(URL);
    }


    public  void quitBrowser() {

        driver.quit();

    }
}

