package com.jupitertoys.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static InputStream filInputStream;
    public static Properties properties;

    public static String getBrowser(){
        System.out.println("This is the browser is update");
        return System.getenv("BROWSER");
    }

    public static String getWebsiteUrl(){
        return System.getenv("URL");
    }

    public static String getBaseUriForTokenGeneration(){
        return "https://"+System.getenv("OKTA_DOMAIN");
    }

    public static String getApiBaseUri(){
        return System.getenv("BASE_URI");
    }

    public static int getImplicitWait(){
        return Integer.parseInt(System.getenv("IMPLICIT_WAIT"));
    }

    public static void cleanUp(){
        if(filInputStream != null){
            try {
                filInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
