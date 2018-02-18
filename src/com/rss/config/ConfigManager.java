package com.rss.config;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class ConfigManager {
    private static File configDir;
    private static ConfigManager instance;
    private static Map<String, String> properties = new ConcurrentHashMap<String,String>();
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public static synchronized void initialize(String dir) {
        if (configDir == null) {
            configDir = new File(dir);
        }
    }

    private ConfigManager() {
        try {
            if (configDir == null) {
                String dir = getProperty(PropertyKeys.CONFIG_DIR);
                configDir = new File(dir);
            }
            loadDirectory(configDir);
        } catch (Exception e) {
        } finally {
        }
    }

    private void loadDirectory(File dir) {
        if (!dir.exists()) {
            return;
        }
        File files[] = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return !pathname.isDirectory() &&
                        !pathname.getName().startsWith(".") &&
                        pathname.getName().toLowerCase().endsWith(".xml");
            }
        });
        for (File file : files) {
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(String key : properties.stringPropertyNames()){
                properties.put(key,properties.getProperty(key));
            }
        }
    }

    public static String getProperty(String name) {
        String property;
        try {
            property = properties.get(name);
        } finally {
        }

        if (property == null) {
            property = System.getProperty(name);
        }
        return property;
    }

    public static void setProperty(String name, String value) {
        try {
            properties.put(name, value);
        } finally {
        }
    }

    public static Map<String, String> getProperties() {
        try {
            return new HashMap<String,String>(properties);
        } finally {
        }
    }
}
