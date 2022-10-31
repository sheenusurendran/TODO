package com.singtel.selenium.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyFileReader {

    private static final String CONFIG_FILEPATH = "./config.properties";
    public static HashMap<Object,Object> appConfig = new HashMap<>();
    Properties properties = new Properties();
    public PropertyFileReader(){
        try{
            File file = new File(CONFIG_FILEPATH);
            FileInputStream fis= new FileInputStream(file);
            properties.load(fis);
            appConfig.putAll(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static HashMap<Object,Object> getConfiguration(){
        return appConfig;
    }
    public String getPropValueUsingKey(String keyName){
        String propValue=null;
        try{
            if(keyName.isEmpty()){
                System.err.println("Empty key received for Property loading");
                throw new RuntimeException("Property key is empty");
            }   else
                propValue=properties.getProperty(keyName);
            if (!propValue.isEmpty()){
                return propValue;
            } else
                System.err.println("Empty value received for Property key" +keyName);
        }catch (Exception e){
            e.printStackTrace();
        }return propValue;
    }
}
