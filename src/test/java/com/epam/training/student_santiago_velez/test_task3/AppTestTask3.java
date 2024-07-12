package com.epam.training.student_santiago_velez.test_task3;

import com.epam.training.student_santiago_velez.task3.base.BaseClass;
import com.epam.training.student_santiago_velez.task3.pageobjectsclasses.ComputeEnginePage;
import com.epam.training.student_santiago_velez.task3.pageobjectsclasses.CostEstimateSummaryPage;
import com.epam.training.student_santiago_velez.task3.pageobjectsclasses.GoogleCloudCalculatorPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppTestTask3 extends BaseClass{
    @Before
    public void setUp() throws Exception {
        setUpDriver("chrome");
        setUpWait(driver, 10);
    }

    @Test
    public void testValidateEstimatedCostTaskThree() {
        driver.get(getGoogleCloudCalculatorUrl());

        GoogleCloudCalculatorPage googleCloudCalculatorObject = new GoogleCloudCalculatorPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleCloudCalculatorObject.getPageTitleLocator()));
        googleCloudCalculatorObject.clickOnAddToEstimateButton();
        googleCloudCalculatorObject.clickOnComputeEngineCard();

        ComputeEnginePage computeEngineObject = new ComputeEnginePage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(computeEngineObject.getPageTitleLocator()));
        computeEngineObject.fillOutInstancesInput("4");
        computeEngineObject.selectOperativeSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
        computeEngineObject.clickRegularProvisioningModelButton();
        computeEngineObject.selectMachineFamily("General Purpose\n" +
                "Best price-performance for general workloads.");
        computeEngineObject.selectSeries("N1\n" +
                "Balanced price/performance");
        computeEngineObject.selectMachineTypes("n1-standard-8\n" +
                "vCPUs: 8, RAM: 30GB");
        computeEngineObject.clickAddGPUsToggle();
        computeEngineObject.selectGPUtype("NVIDIA V100");
        computeEngineObject.selectNumberOfGPUs("1");
        computeEngineObject.selectLocalSSD("2x375 GB");
        computeEngineObject.selectRegion("Netherlands (europe-west4)");

        //Wait until the changes are saved and price is calculated:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Service cost updated')]")));
        computeEngineObject.clickShareButton();
        computeEngineObject.clickOpenEstimateSummaryButton();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        switchTabs(1);

        CostEstimateSummaryPage costEstimateSummaryObject = new CostEstimateSummaryPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(costEstimateSummaryObject.getPageTitleLocator()));
        Assert.assertEquals("Failed", "4", costEstimateSummaryObject.getNumberOfInstancesValue());
        Assert.assertEquals("Failed", "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)", costEstimateSummaryObject.getOperatingSystemValue());
        Assert.assertEquals("Failed", "Regular", costEstimateSummaryObject.getProvisioningModelValue());
        Assert.assertEquals("Failed", "n1-standard-8, vCPUs: 8, RAM: 30 GB", costEstimateSummaryObject.getMachineType());
        Assert.assertEquals("Failed", "true", costEstimateSummaryObject.getaddGPUsValue());
        Assert.assertEquals("Failed", "NVIDIA V100", costEstimateSummaryObject.getGPUModelValue());
        Assert.assertEquals("Failed", "1", costEstimateSummaryObject.getNumberOfGPUsValue());
        Assert.assertEquals("Failed", "2x375 GB", costEstimateSummaryObject.getLocalSSDModel());
        Assert.assertEquals("Failed", "Netherlands (europe-west4)", costEstimateSummaryObject.getRegion());
    }

    @After
    public void cleanUp(){
        if(com.epam.training.student_santiago_velez.task2.base.BaseClass.driver != null){
//            driver.quit(); // Uncomment to close the WebDriver instance after the Test method is completed
        }
    }
}
