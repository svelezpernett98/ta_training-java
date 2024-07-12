package com.epam.training.student_santiago_velez.task3.pageobjectsclasses;

import com.epam.training.student_santiago_velez.task3.base.BaseClass;
import org.openqa.selenium.By;

public class CostEstimateSummaryPage extends BaseClass {
    private By pageTitle = By.xpath("//h4[(text()='Cost Estimate Summary')]");
    private By numberOfInstancesValue = By.xpath("//span[contains(text(), 'Number of Instances')]/following-sibling::span");
    private By operatingSystemValue = By.xpath("//span[contains(text(), 'Operating System / Software')]/following-sibling::span");
    private By provisioningModelValue = By.xpath("//span[contains(text(), 'Provisioning Model')]/following-sibling::span");
    private By machineType = By.xpath("//span[contains(text(), 'Machine type')]/following-sibling::span");
    private By addGPUsValue = By.xpath("//span[contains(text(), 'Add GPUs')]/following-sibling::span");
    private By GPUModelValue = By.xpath("//span[contains(text(), 'GPU Model')]/following-sibling::span");
    private By numberOfGPUsValue = By.xpath("//span[contains(text(), 'Number of GPUs')]/following-sibling::span");
    private By localSSDModel = By.xpath("//span[contains(text(), 'Local SSD')]/following-sibling::span");
    private By region = By.xpath("//span[contains(text(), 'Region')]/following-sibling::span");

    public String getNumberOfInstancesValue(){
        return driver.findElement(numberOfInstancesValue).getText();
    }

    public String getOperatingSystemValue(){
        return driver.findElement(operatingSystemValue).getText();
    }

    public String getProvisioningModelValue(){
        return driver.findElement(provisioningModelValue).getText();
    }

    public String getMachineType(){
        return driver.findElement(machineType).getText();
    }

    public String getaddGPUsValue(){
        return driver.findElement(addGPUsValue).getText();
    }

    public String getGPUModelValue(){
        return driver.findElement(GPUModelValue).getText();
    }

    public String getNumberOfGPUsValue(){
        return driver.findElement(numberOfGPUsValue).getText();
    }

    public String getLocalSSDModel(){
        return driver.findElement(localSSDModel).getText();
    }

    public String getRegion(){
        return driver.findElement(region).getText();
    }

    public By getPageTitleLocator(){
        return pageTitle;
    }
}
