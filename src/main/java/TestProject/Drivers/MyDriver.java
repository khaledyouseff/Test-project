
package TestProject.Drivers;

import TestProject.Utilities.BrowserActions;
import TestProject.Utilities.ElementAction;
import TestProject.Utilities.Validations;
import org.openqa.selenium.WebDriver;


public class MyDriver {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public MyDriver(String BrowserName) {

        WebDriver driver = getDriver(BrowserName).StartDriver();
        setDriver(driver);
    }

    private AbstractDriver getDriver(String browserName) {
        //code
        return switch (browserName.toLowerCase()) {
            case "chrome" -> new ChromeFactory();
            case "firefox" -> new FireFoxFactory();
            case "edge" -> new EdgeFactory();
            default -> throw new IllegalArgumentException();
        };

    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getMyDriver() {
        if (driverThreadLocal.get() == null) {
            return null;
        }
        return driverThreadLocal.get();
    }

    public BrowserActions browser() {
        return new BrowserActions(getMyDriver());
    }

    public ElementAction element() {
        return new ElementAction(getMyDriver());
    }

    public Validations validate() {
        return new Validations(getMyDriver());
    }
    public static WebDriver getInstance(){
        return driverThreadLocal.get();
    }
}
