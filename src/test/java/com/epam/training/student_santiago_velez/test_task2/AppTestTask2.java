package com.epam.training.student_santiago_velez.test_task2;

import com.epam.training.student_santiago_velez.task2.base.BaseClass;
import com.epam.training.student_santiago_velez.task2.pageobjectsclasses.PasteBinHomePage;
import com.epam.training.student_santiago_velez.task2.pageobjectsclasses.SavedPastePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;


public class AppTestTask2 {
    BaseClass base;

    @Before
    public void setUp(){
        base = new BaseClass();
        BaseClass.driver = base.getDriver("chrome");
    }

    @Test
    public void testValidatePasteContentTaskTwo() {
        String code = String.join("\n",
                "git config --global user.name \"New Sheriff in Town\"",
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")",
                "git push origin master --force"
        );

        BaseClass.driver.get(base.getUrl());

        PasteBinHomePage pasteBinHomePageObject = new PasteBinHomePage();
        pasteBinHomePageObject.insertTextIntoTextArea(code);
        pasteBinHomePageObject.selectElementFromExpirationDropDownList("10 Minutes");
        pasteBinHomePageObject.selectElementFromSyntaxHighligthingDropDownList("Bash");
        pasteBinHomePageObject.typePasteName("how to gain dominance among developers");
        pasteBinHomePageObject.clickOnCreateNewPasteButton();

        SavedPastePage savedPastePageObject = new SavedPastePage();
        BaseClass.tenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(savedPastePageObject.getPasteTitleLocator()));
        assertEquals("Title is not as expected", "how to gain dominance among developers", savedPastePageObject.getBrowserTitle());
        assertEquals("Syntax is not as expected", "Bash", savedPastePageObject.getSyntaxLink());
        assertEquals("Code is not as expected", code, savedPastePageObject.getCodeFromTextArea());
    }

    @After
    public void cleanUp(){
        if(BaseClass.driver != null){
//            driver.quit(); // Uncomment to close the WebDriver instance after the Test method is completed
        }
    }
}
