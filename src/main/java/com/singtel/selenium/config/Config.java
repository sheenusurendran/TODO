package com.singtel.selenium.config;
import java.io.File;

public class Config {
    public static  String chromeDriver;
    public static String browser;
    public static long shortWait;
    public static long longWait;
    public static final String fs = File.separator;
    public static String currentDirectory = System.getProperty("user.dir");
    public static String chromeDriverPath=null;
   // public static String reportPath=null;
    public static String url=null;
    public static PropertyFileReader fileReader = new PropertyFileReader();
    public static void initProperties() {
        try{
            chromeDriver= PropertyFileReader.appConfig.get("chromeDriver").toString().replaceAll("\"","");
            browser= PropertyFileReader.appConfig.get("browser").toString();
            shortWait= Long.parseLong(PropertyFileReader.appConfig.get("shortWait").toString());
            longWait = Long.parseLong(PropertyFileReader.appConfig.get("longWait").toString());
            //reportPath=PropertyFileReader.appConfig.get("ScreenShotsPath").toString();
            url=PropertyFileReader.appConfig.get("url").toString();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
