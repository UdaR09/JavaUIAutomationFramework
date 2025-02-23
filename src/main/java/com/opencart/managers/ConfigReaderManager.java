package com.opencart.managers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {
    private static final Logger logger = LogManager.getLogger(ConfigReaderManager.class);
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties properties;

    public static void initProperties(){
        try
            {
                FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
                logger.log(Level.DEBUG, "Reading properties from file " + CONFIG_FILE_PATH);

                properties = new Properties();
                properties.load(fileInputStream);
                logger.log(Level.DEBUG, "Loading properties from file " + CONFIG_FILE_PATH);
                fileInputStream.close();
            }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        if(properties == null){
            initProperties();
        }
        String value = "The value for key:" + key + " is: " + properties.getProperty(key);
        logger.log(Level.DEBUG, value);
        return properties.getProperty(key);
    }
}
