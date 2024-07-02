package com.epam.training.student_santiago_velez.task1.pageobjectsclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PasteBinHomePage {
    private By codeTextArea = By.cssSelector("textarea#postform-text");
    private By pasteExpirationDropDownList = By.cssSelector("select#postform-expiration");
    private By pasteNameInput = By.cssSelector("input#postform-name");
    private WebDriverWait tenSecondsWait;

    public void insertTextIntoTextArea(WebDriver driver, String code) {
        driver.findElement(codeTextArea).sendKeys(code);
    }

    public void selectElementFromExpirationDropDownList(WebDriver driver, String dropDownOption) {
        // Using JavaScript to make the select tag visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", driver.findElement(pasteExpirationDropDownList));

        tenSecondsWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        tenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(pasteExpirationDropDownList));

        Select select = new Select(driver.findElement(pasteExpirationDropDownList));
        select.selectByVisibleText(dropDownOption);
    }

    public void typePasteName(WebDriver driver, String pasteName) {
        driver.findElement(pasteNameInput).sendKeys(pasteName);
    }

}
