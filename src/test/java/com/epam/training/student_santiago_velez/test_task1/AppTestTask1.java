package com.epam.training.student_santiago_velez.test_task1;
//import junit.framework.Test;
//import junit.framework.TestCase;
import com.epam.training.student_santiago_velez.task1.base.BaseClass;
import com.epam.training.student_santiago_velez.task1.pageobjectsclasses.PasteBinHomePage;
//import junit.framework.TestSuite;
//import org.junit.After;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AppTestTask1 {
    WebDriver driver;
    BaseClass base;

    @Before
    public void setUp(){
        base = new BaseClass();
        driver = base.getDriver("chrome");
    }

    @Test
    public void testCreateNewPasteTaskOne(){
        driver.get(base.getUrl());
        PasteBinHomePage pasteBinHomePageObject = new PasteBinHomePage();
        pasteBinHomePageObject.insertTextIntoTextArea(driver, "Hello from WebDriver");
        pasteBinHomePageObject.selectElementFromExpirationDropDownList(driver,"10 Minutes");
        pasteBinHomePageObject.typePasteName(driver, "helloweb");

    }

    @After
    public void cleanUp(){
        if(driver != null){
//            driver.quit(); // Uncomment to close the WebDriver instance after the Test method is completed
        }
    }
}
