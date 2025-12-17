package TestProject.Listeners;



import TestProject.Drivers.MyDriver;
import TestProject.Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import java.io.File;
import java.io.IOException;

public class ListenersTestNG implements IExecutionListener, ITestListener, IInvokedMethodListener {
    File AllureFile = new File("allure-results");
    File LogseFile = new File("test-outputs/logs");
    File screenshotsFile = new File("test-outputs/screenshots");


    @Override
    public void onExecutionStart() {
        PropertiesUtilities.LoadProperties();
        FileUtilities.deleteFiles(AllureFile);
        FileUtilities.cleanDirectory(screenshotsFile);
    }

    @Override
    public void onExecutionFinish() {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResultt) {
        WebDriver driver = MyDriver.getInstance();
        // to attach only after the test method not the other methods in test class
        if (method.isTestMethod()) {
            switch (testResultt.getStatus()) {
                case ITestResult.SUCCESS -> {
                    try {
                        ScreenshotsUtilities.takeScreenshot(driver, "Passed-" + testResultt.getName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                case ITestResult.FAILURE -> {
                    try {
                        ScreenshotsUtilities.takeScreenshot(driver, "Failed-" + testResultt.getName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
                case ITestResult.SKIP -> {
                    try {
                        ScreenshotsUtilities.takeScreenshot(driver, "Skipped-" + testResultt.getName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        }

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {


    }

    @Override
    public void onTestSkipped(ITestResult result) {


    }
}

