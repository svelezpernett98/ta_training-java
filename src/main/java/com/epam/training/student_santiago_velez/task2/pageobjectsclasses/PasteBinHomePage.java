package com.epam.training.student_santiago_velez.task2.pageobjectsclasses;

import com.epam.training.student_santiago_velez.task2.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PasteBinHomePage {
    private By codeTextArea = By.cssSelector("textarea#postform-text");
    private By pasteExpirationDropDownList = By.cssSelector("select#postform-expiration");
    private By pasteNameInput = By.cssSelector("input#postform-name");
    private By syntaxHighligthingDropDownList = By.cssSelector("select#postform-format");
    private By createNewPasteButton = By.cssSelector("button.btn.-big[type='submit']");

    public void insertTextIntoTextArea(String code) {
        BaseClass.driver.findElement(codeTextArea).sendKeys(code);
    }

    public void selectElementFromExpirationDropDownList(String dropDownOption) {
        // Using JavaScript to make the select tag visible
        ((JavascriptExecutor) BaseClass.driver).executeScript("arguments[0].style.visibility='visible';", BaseClass.driver.findElement(pasteExpirationDropDownList));

        //explicit wait:
        BaseClass.tenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(pasteExpirationDropDownList));

        Select select = new Select(BaseClass.driver.findElement(pasteExpirationDropDownList));
        select.selectByVisibleText(dropDownOption);
    }

    public void typePasteName(String pasteName) {
        BaseClass.driver.findElement(pasteNameInput).sendKeys(pasteName);
    }

    public void selectElementFromSyntaxHighligthingDropDownList(String dropDownOption){
        ((JavascriptExecutor) BaseClass.driver).executeScript("arguments[0].style.visibility='visible';", BaseClass.driver.findElement(syntaxHighligthingDropDownList));

        //explicit wait:
        BaseClass.tenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(syntaxHighligthingDropDownList));

        Select select = new Select(BaseClass.driver.findElement(syntaxHighligthingDropDownList));
        select.selectByVisibleText(dropDownOption);
    }

    public void clickOnCreateNewPasteButton(){
        BaseClass.driver.findElement(createNewPasteButton).click();
    }

}
