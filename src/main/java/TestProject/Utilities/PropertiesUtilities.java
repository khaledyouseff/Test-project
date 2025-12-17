package TestProject.Utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class PropertiesUtilities {
    private PropertiesUtilities() {
    }

    public static final String PROPERTIES_PATH = "src/main/resources";


    public static Properties LoadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> propertiesFileList;

            propertiesFileList = FileUtils.listFiles(new File(PROPERTIES_PATH), new String[]{"properties"}
                    , true);
            propertiesFileList.forEach(propertyFile -> {
                try {
                    properties.load(new FileInputStream(propertyFile));
                    System.out.println("Loaded properties from: " + propertyFile.getAbsolutePath());

                } catch (IOException ioe) {
                    System.out.println("Error reading file " + propertyFile.getName() + ": " + ioe.getMessage());
                }

            });
            System.getProperties().putAll(properties);
            System.out.println(("All properties successfully loaded and added to system properties."));
            return properties;
        } catch (Exception e) {
            System.out.println("Failed to load properties file data because:" + e.getMessage());
            return null;
        }
    }

    public static String getPropertyValue(String key) {

        String value = System.getProperty(key);

        if (value == null) {
            System.out.println(" Property not found for key: " + key);
        } else {
            System.out.println("Retrieved property: " + key + " = " + value);
        }
        return value;
    }



}