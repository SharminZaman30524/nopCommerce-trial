package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public static String currentDir = System.getProperty("user.dir");

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(currentDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
