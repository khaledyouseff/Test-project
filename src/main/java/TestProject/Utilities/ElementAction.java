package TestProject.Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ElementAction {


        private WebDriver driver;
        // added these two bots waits and scroll
        private Waits waits;


public ElementAction(WebDriver driver) {
            this.driver = driver;
            waits = new Waits(driver);

        }
    public void SendData(By locator, String data) {
        waits.WaitForElementVisibility(locator);
        ScrollToElement(locator);
        FindElement(locator).sendKeys(data);
    }
    public void ClickElement(By locator) {
        waits.WaitForElementToBeClickable(locator);
        ScrollToElement(locator);
        FindElement(locator).click();
    }

    public WebElement FindElement(By locator) {

        return driver.findElement(locator);
    }

    public String GetText(By locator) {

        waits.WaitForElementVisibility(locator);
        ScrollToElement(locator);
        return FindElement(locator).getText();
    }
    public void ScrollToElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"
                , FindElement(locator));
    }
}
