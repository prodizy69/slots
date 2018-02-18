package com.rss.config;


import java.util.Properties;

public class Configuration {
    private static final Configuration instance = new Configuration();
    private Properties properties = new Properties();
    public static Configuration getInstance(){
        return instance;
    }
    private Configuration(){

    }
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String get(String key){
        return this.get(key,null);
    }

    public String get(String key,String defaultValue){
        return this.properties.getProperty(key,defaultValue);
    }

    public void set(String key,String value){
        this.properties.setProperty(key,value);
    }

}
