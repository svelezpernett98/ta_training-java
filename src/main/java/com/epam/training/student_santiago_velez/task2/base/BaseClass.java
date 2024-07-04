package com.epam.training.student_santiago_velez.task2.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait tenSecondsWait;
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
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Chrome was selected as default WebDriver, if you want edge, pass 'edge' as an argument to the getDriver() method");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        tenSecondsWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }

    public String getUrl(){
        return prop.getProperty("pastebinurl");
    }
}
