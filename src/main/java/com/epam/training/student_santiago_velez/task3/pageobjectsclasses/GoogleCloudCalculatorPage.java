package com.epam.training.student_santiago_velez.task3.pageobjectsclasses;

import com.epam.training.student_santiago_velez.task3.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudCalculatorPage extends BaseClass{
    private By pageTitle = By.xpath("//h1[contains(text(), 'Welcome to Google')]");
    private By addToEstimateButton = By.cssSelector("div[jsaction='JIbuQc:x7hz7c;']>div.VfPpkd-dgl2Hf-ppHlrf-sM5MNb>button[jscontroller='O626Fe']");
    private By computeEngineCard = By.cssSelector("div.DzHYNd>:nth-child(1)");

    public void clickOnAddToEstimateButton(){
        driver.findElement(addToEstimateButton).click();
    }
    public void clickOnComputeEngineCard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.DzHYNd>:nth-child(1)")));
        driver.findElement(computeEngineCard).click();
    }

    public By getPageTitleLocator(){
        return pageTitle;
    }

}
