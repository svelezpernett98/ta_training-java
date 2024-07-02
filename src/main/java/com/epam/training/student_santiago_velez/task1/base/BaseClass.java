package com.epam.training.student_santiago_velez.task1.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    private WebDriver driver;
    private Properties prop;

    public BaseClass(){
        try{
            prop  = new Properties();
            FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\epam\\training\\student_santiago_velez\\task1\\resources\\config.properties.txt");
            prop.load(data);
        } catch (IOException e){
            System.err.println("Failed getting the data, " + e.getMessage());
        }
    }

    public WebDriver getDriver(String browser){
        switch(browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                return driver;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                return driver;

            default:
                System.out.println("Chrome was selected as default WebDriver, if you want edge, pass 'edge' as a parameter to the getDriver() method");
                driver = new ChromeDriver();
                return driver;
        }
    }

    public String getUrl(){
        return prop.getProperty("pastebinurl");
    }
}
