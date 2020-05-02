package com.cre.pages.studentloans;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class GetMyLoansRatePage {
    private WebDriver driver;

    private static final String URL = "https://www.credible.com/?vt_disabled=true";

    private By button_GetMyLoanRates = By.xpath("//a[@href='/student-loans']/preceding-sibling::button[text()='Get My Loan Rates']");
    private By button_IAmTheStudent = By.xpath("//button[text()='I am the student']");
    private By button_Continue_Education = By.xpath("//button[contains(text(),'Continue') and @data-ga-action='Continue' and not(@disabled)]");
    private By button_Continue_Financial = By.xpath("//div[@class='back']/preceding-sibling::*[@class='next-step']/button");

    private By radioButton_HaveYouCheckedRatesBefore = By.xpath(
            "//h2[contains(text(),'Have you checked rates')]/following-sibling::*//span[@class='radio-label' and contains(text(),'No') and not(contains(text(),'Not sure'))]/preceding-sibling::span");
    private By radioButton_CheckRatesWithAParent = By.xpath(
            "//*[contains(text(),'Check rates with a parent')]/following-sibling::*//span[@class='radio-label' and contains(text(),'No') and not(contains(text(),'Not sure'))]/preceding-sibling::span");

    private By textBox_SchoolName = By.name("education_name");
    private By textBox_EducationCompletionDate = By.name("education_completion_date");
    private By textBox_RequestedLoanAmount = By.name("education_requested_loan_amount");
    private By textBox_EmploymentIncome = By.name("borrower_income_yearly");
    private By textBox_OtherIncome = By.name("borrower_additional_income");
    private By textBox_OtherHouseholdMemberIncome = By.name("borrower_other_household_members_income");
    private By textBox_MonthlyHousingPayment = By.name("borrower_housing_payment");
    private By textBox_FirstName = By.name("borrower_first_name");
    private By textBox_LastName = By.name("borrower_last_name");
    private By textBox_DateOfBirth = By.name("borrower_dob");
    private By textBox_PhoneNo = By.name("borrower_phone");
    private By textBox_StreetAddress = By.name("current_address_street");
    private By textBox_Unit = By.name("current_address_unit");
    private By textBox_City = By.name("current_address_city");
    private By textBox_State = By.xpath("//label[contains(text(),'State')]/following-sibling::span//a");
    private By textBox_Zip = By.name("current_address_zipcode");
    private By textBox_Email = By.xpath("//div[@id='signup-form-wrapper']//input[@name='email']");
    private By textBox_Password = By.xpath("//div[@id='signup-form-wrapper']//input[@name='password']");

    private By dropDown_DegreeType = By.xpath("//label[contains(text(),'Degree type')]/parent::div//a");
    private By dropDown_CurrentYearOfStudy = By.xpath("//label[contains(text(),'Current year of study')]/parent::div//a");
    private By dropDown_PeriodOfLoan = By.xpath("//label[contains(text(),'Academic period of loan')]/parent::div//a");

    private By label_Welcome = By.xpath("//h3[contains(text(),\"Welcome, let’s get started\")]");

    private By linkText_EnterItManually = By.linkText("Enter it manually");


    public GetMyLoansRatePage(WebDriver driver) {
        this.driver = driver;
    }

    public GetMyLoansRatePage launchURL() {
        if (this.driver != null)
            this.driver.manage().window().maximize();
        this.driver.get(URL);
        return new GetMyLoansRatePage(this.driver);
    }

    public GetMyLoansRatePage navigateToStudentLoanOptionsPage() {
        try {
            element(button_GetMyLoanRates).click();
            element(button_IAmTheStudent).click();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.waitUntilElementIsVisible(label_Welcome);
        }

        return new GetMyLoansRatePage(this.driver);

    }

    public GetMyLoansRatePage fillEducationForm() {
        String schoolName = "Gnomon School of Visual Effects";
        String degreeType = "Bachelors";
        String eduCompleteDate = "06/2020";
        String currentYearOfStudy = "Freshman";
        String periodOfLoan = "Winter only 2020";
        String loanAmount = "50000";

        try {
            Thread.sleep(15000);
            element(radioButton_HaveYouCheckedRatesBefore).click();
            element(radioButton_CheckRatesWithAParent).click();
            element(textBox_SchoolName).sendKeys(schoolName);

            By schoolNameLocator = By.xpath("//div[@role='option']/strong[text()='" + schoolName + "']");
            this.waitUntilElementIsVisible(schoolNameLocator);
            element(schoolNameLocator).click();
            Thread.sleep(2001);
            element(dropDown_DegreeType).click();
            element(By.xpath("//div[text()='" + degreeType + "']")).click();

            element(dropDown_CurrentYearOfStudy).click();
            element(By.xpath("//div[text()='" + currentYearOfStudy + "']")).click();

            element(textBox_EducationCompletionDate).sendKeys(eduCompleteDate);

            element(dropDown_PeriodOfLoan).click();
            element(By.xpath("//div[text()='" + periodOfLoan + "']")).click();

            element(textBox_RequestedLoanAmount).sendKeys(loanAmount);
            element(button_Continue_Education).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new GetMyLoansRatePage(this.driver);
    }

    public GetMyLoansRatePage fillFinancialForm() {
        String employmentIncome = "60000";
        String otherIncome = "2000";
        String otherHouseholdMembersIncome = "1000";
        String monthlyHousingPayment = "3500";
        try {
            this.waitUntilElementIsVisible(textBox_EmploymentIncome);
            element(textBox_EmploymentIncome).sendKeys(employmentIncome);
            element(textBox_OtherIncome).sendKeys(otherIncome);
            element(textBox_OtherHouseholdMemberIncome).sendKeys(otherHouseholdMembersIncome);
            element(textBox_MonthlyHousingPayment).sendKeys(monthlyHousingPayment);
            element(button_Continue_Financial).click();



        } catch (Exception e) {
            e.printStackTrace();
        }


        return new GetMyLoansRatePage(this.driver);
    }

    public GetMyLoansRatePage fillProfileForm() {
        String firstName = "Great";
        String lastName = "CredibleProd";
        String dateOfBirth = "01/01/1980";
        String phoneNo = "866-540-6005";
        String streetAddress = "4th Street";
        String unit = "22";
        String city = "San Francisco";
        String state = "California";
        String zip = "94103";
        String password = "Passw0rd";

        try {

            /**
             *  Set email ID in (<FirstName>+<MonthDay>+<Timestamp>)
             *
             */

            SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMdd_HH.mm.ss");
            String email = firstName + "_" + dateFormatter.format(new Date()) + "@credible.com";
            this.waitUntilElementIsVisible(textBox_FirstName);
            element(textBox_FirstName).sendKeys(firstName);
            element(textBox_LastName).sendKeys(lastName);
            element(textBox_DateOfBirth).sendKeys(dateOfBirth);
            element(textBox_PhoneNo).sendKeys(phoneNo);
            /*
             * Enter address.
             */

            element(linkText_EnterItManually).click();
            element(textBox_StreetAddress).sendKeys(streetAddress);
            element(textBox_Unit).sendKeys(unit);
            element(textBox_City).sendKeys(city);
            element(textBox_Zip).sendKeys(zip);
            element(textBox_State).click();
            Thread.sleep(1000);
            By stateComboBox = By.xpath("//label[contains(text(),'State')]/following-sibling::input[@role='combobox']");
            element(stateComboBox).sendKeys(state);
            By searchedState = By.xpath("//*[contains(text(),'" + state + "')]/ancestor::ul[@class='select2-result-sub']/li");
            element(searchedState).click();

            element(textBox_Email).sendKeys(email);
            Thread.sleep(1000);
            element(textBox_Password).sendKeys(password);
            System.out.println("\n************************* TEST COMPLETED *************************\n");





        } catch (Exception e) {
            e.printStackTrace();
        }

        return new GetMyLoansRatePage(this.driver);

    }

    /**
     * Get WebElement
     *
     * @param locator
     * @return webElement
     */

    private WebElement element(By locator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(this.driver);
        fluentWait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100));
        fluentWait.ignoring(WebDriverException.class, ElementClickInterceptedException.class).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);

        WebElement webElement = fluentWait.until(new Function<WebDriver, WebElement>() {
                                                     public WebElement apply(WebDriver driver) {
                                                         WebElement element = driver.findElement(locator);
                                                         if (element.isDisplayed()) {
                                                             return element;
                                                         } else {
                                                             return null;
                                                         }
                                                     }
                                                 }

        );
        return webElement;
    }

    private void waitUntilElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element(locator)));

    }

}
