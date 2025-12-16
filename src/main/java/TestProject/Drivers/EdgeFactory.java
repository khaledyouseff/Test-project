package TestProject.Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver implements WebDriverOptionsAbstract<EdgeOptions> {
    @Override
    public EdgeOptions getOptions() {
        WebDriverManager.chromedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");

        return edgeOptions;
    }
    @Override
    public WebDriver StartDriver(){
        return new EdgeDriver(getOptions());
    }
}

