package com.epam.training.student_santiago_velez.task2.pageobjectsclasses;

import com.epam.training.student_santiago_velez.task2.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavedPastePage {
    private By pasteTitle = By.cssSelector("div.info-top>h1");
    private By syntaxLink = By.cssSelector("div.left>:first-child");
    private By codeFromTextArea = By.cssSelector("div.top-buttons+div.source>ol");

    public String getBrowserTitle(){
        return BaseClass.driver.findElement(pasteTitle).getText();
    }

    public String getSyntaxLink(){
        return BaseClass.driver.findElement(syntaxLink).getText();
    }

    public String getCodeFromTextArea(){
        System.out.println(BaseClass.driver.findElement(codeFromTextArea).getText());
        return BaseClass.driver.findElement(codeFromTextArea).getText();
    }

}
