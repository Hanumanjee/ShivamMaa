package com.cre.studentloans;

import com.cre.pages.studentloans.GetMyLoansRatePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetMyLoansRateTest {
    private WebDriver driver;

    @BeforeTest
    public void createNewChromedriver(){
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @Test
    public void getStudentLoanRateTest(){
        GetMyLoansRatePage _getMyLoansRatePage = new GetMyLoansRatePage(this.driver);
        _getMyLoansRatePage.launchURL().navigateToStudentLoanOptionsPage().fillEducationForm().fillFinancialForm().fillProfileForm();

    }

    @AfterTest
    public void tearDown(){
        if(this.driver !=null){
           this.driver.quit();
        }
    }
}

