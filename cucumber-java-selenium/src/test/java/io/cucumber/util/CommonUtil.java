package io.cucumber.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class CommonUtil {

    public static int getResponseCode(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("Error checking image: " + urlString);
            return 500; // Assuming error
        }
    }
    public static String getConfigProperty(String str) throws IOException {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("src/test/resources/config.properties");
        prop.load(in);
        return prop.getProperty(str);
    }
}
