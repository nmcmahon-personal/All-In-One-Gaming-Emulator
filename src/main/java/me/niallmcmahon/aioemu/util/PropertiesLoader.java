package me.niallmcmahon.aioemu.util;

import me.niallmcmahon.aioemu.exception.PropertyNotFoundException;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class PropertiesLoader {

    public static String getStringProperty(String property) {
        if(System.getenv(property) != null) {
            return System.getenv(property);
        }
        if(System.getProperty(property) != null) {
            return System.getProperty(property);
        }

        throw new PropertyNotFoundException(String.format("Property %s cannot be found", property));
    }

    public static int getIntProperty(String property) {
        return Integer.parseInt(getStringProperty(property));
    }

    public static void loadAppProperties() {
        ResourceBundle appProperties = ResourceBundle.getBundle("application");
        Enumeration<String> keys = appProperties.getKeys();
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.setProperty(key, appProperties.getString(key));
        }
    }
}
