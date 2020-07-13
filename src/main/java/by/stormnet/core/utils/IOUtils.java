package by.stormnet.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class IOUtils {

    public  static  String loadGenericProperty(String key, String filename){
        Properties properties = new Properties();
        FileInputStream filePath = null;

        try {
            String filePathString = "src/main/resources/" + filename + ".properties";
            filePath = new FileInputStream(filePathString);
            properties.load(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}
