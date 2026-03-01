package MarsAir.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String filePath = "src/main/resources/config.properties";
            FileInputStream input = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("There is no file config.properties!");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
