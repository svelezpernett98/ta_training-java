package com.epam.training.student_santiago_velez.task3.pageobjectsclasses;

import com.epam.training.student_santiago_velez.task3.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ComputeEnginePage extends BaseClass {
    private By pageTItle = By.cssSelector("h1[aria-label='Selected product title']");
    private By numberOfInstancesInput = By.xpath("//div[contains(text(), 'Number of instances')]/../following-sibling::div[2]/div[2]/div/label/span[2]/input");
    private By OperatingSystemDropDownList = By.xpath("//span[contains(text(), 'Operating System / Software')]/ancestor::*[3]/div[1]");
    private By regularProvisioningModelButton = By.cssSelector("input#regular+label");
    private By machineFamilyDropDownList = By.xpath("//span[contains(text(), 'Machine Family')]/ancestor::*[3]/div[1]");
    private By seriesDropDownList = By.xpath("//span[contains(text(), 'Series')]/ancestor::*[3]/div[1]");
    private By machineTypeDropDownList = By.xpath("//span[contains(text(), 'Machine type')]/ancestor::*[3]/div[1]");
    private By addGPUsToggle = By.cssSelector("button[role='switch'][aria-label='Add GPUs']");
    private By GPUtypeDropDownList = By.xpath("//span[contains(text(), 'GPU Model')]/ancestor::*[3]/div[1]");
    private By numberOfGPUsDropDownList = By.xpath("//span[contains(text(), 'Number of GPUs')]/ancestor::*[3]/div[1]");
    private By localSSDdropDownList = By.xpath("//span[text()='Local SSD']/ancestor::*[3]/div[1]");
    private By regionDropDownList = By.xpath("//span[contains(text(), 'Region')]/ancestor::*[3]/div[1]");
    private By shareButton = By.xpath("//span[contains(text(), 'Share')]");
    private By openEstimateSummaryButton = By.cssSelector("a[track-name='open estimate summary']");

    public void fillOutInstancesInput(String numberOfInstances){
        driver.findElement(numberOfInstancesInput).clear();
        driver.findElement(numberOfInstancesInput).sendKeys(numberOfInstances);
    }

    public void selectOperativeSystem(String operativeSystemOption){
        driver.findElement(OperatingSystemDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Operating System / Software']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(operativeSystemOption)){
                liElement.click();
                break;
            }
        }
    }

    public void clickRegularProvisioningModelButton(){
        driver.findElement(regularProvisioningModelButton).click();
    }

    public void selectMachineFamily(String machineFamilyOption){
        driver.findElement(machineFamilyDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Machine Family']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(machineFamilyOption)){
                liElement.click();
                break;
            }
        }
    }

    public void selectSeries(String seriesOption){
        driver.findElement(seriesDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Series']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(seriesOption)){
                liElement.click();
                break;
            }
        }
    }

    public void selectMachineTypes(String machineTypeOption){
        driver.findElement(machineTypeDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Machine type']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(machineTypeOption)){
                liElement.click();
                break;
            }
        }
    }

    public void clickAddGPUsToggle(){
        driver.findElement(addGPUsToggle).click();
    }

    public void selectGPUtype(String GPUTypeOption){
        wait.until(ExpectedConditions.visibilityOfElementLocated(GPUtypeDropDownList));
        driver.findElement(GPUtypeDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='GPU Model']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(GPUTypeOption)){
                liElement.click();
                break;
            }
        }
    }

    public void selectNumberOfGPUs(String numberOfGPUsOption) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfGPUsDropDownList));
        driver.findElement(numberOfGPUsDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Number of GPUs']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(numberOfGPUsOption)){
                liElement.click();
                break;
            }
        }
    }

    public void selectLocalSSD(String localSSDOption){
        driver.findElement(localSSDdropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Local SSD']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().equalsIgnoreCase(localSSDOption)){
                liElement.click();
                break;
            }
        }
    }

    public void selectRegion(String regionOption){
        driver.findElement(regionDropDownList).click();
        WebElement ulElement = driver.findElement(By.cssSelector("ul[aria-label='Region']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            if (liElement.getText().toLowerCase().contains(regionOption.toLowerCase())){
                liElement.click();
                break;
            }
        }
    }

    public void clickShareButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(shareButton));
        driver.findElement(shareButton).click();
    }

    public void clickOpenEstimateSummaryButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(openEstimateSummaryButton));
        driver.findElement(openEstimateSummaryButton).click();
    }

    public By getPageTitleLocator(){
        return pageTItle;
    }

}

