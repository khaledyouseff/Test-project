package TestProject.Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenshotsUtilities {
    public static final String SCREENSHOTS_PATH = "test-outputs" + File.separator + "screenshots";

    private ScreenshotsUtilities() {}

    public static void takeScreenshot(WebDriver driver ,String screenshotName) throws IOException {
        if (driver == null) {
            System.out.println("Driver is null. Screenshot skipped.");
            return;
        }

        // Ensure directory exists
        File screenshotDir = new File(SCREENSHOTS_PATH);

        // Check if a file with the same name("screenshots")exists, and it is not a folder and delete it
        if (screenshotDir.exists() && !screenshotDir.isDirectory()) {
            boolean deleted = screenshotDir.delete();
            if (!deleted) {
                throw new IOException("Failed to delete existing file: " + SCREENSHOTS_PATH);
            }
        }

        // Create the directory if it doesn't exist
        if (!screenshotDir.exists()) {
            boolean isCreated = screenshotDir.mkdirs();
            if (!isCreated) {
                throw new IOException("Failed to create screenshot directory: " + SCREENSHOTS_PATH);
            }
        }

        // Capture screenshot

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(SCREENSHOTS_PATH, screenshotName + "_" +".png");

        // Copy screenshot file
        FileUtils.copyFile(screenshot, screenshotFile);


    }
}
