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

    public  String GetCurrentBrowserURL() {
        return driver.getCurrentUrl();
    }

    public  String GetPageTitle() {
        return driver.getTitle();
    }

    public  void RefreshPage() {
        driver.navigate().refresh();

    }

    public  void quitBrowser() {

        driver.quit();

    }
}

