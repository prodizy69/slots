package com.rss.listener;


import com.rss.config.Configuration;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext ctx = servletContextEvent.getServletContext();
            File webapp = new File(ctx.getRealPath("/"));

            String configFolder = "WEB-INF/config";
            if (!new File(configFolder).isAbsolute()) {
                configFolder = new File(webapp, configFolder).getAbsolutePath();
            }
            String logConfigurationFile = configFolder+ File.separator + "log.properties";
            String systemConfigurationFile = configFolder+ File.separator + "system.properties";
            File file = new File(systemConfigurationFile);
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            properties.put("JSON_FOLDER_PATH",configFolder);
            Configuration.getInstance().setProperties(properties);
            PropertyConfigurator.configure(logConfigurationFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
