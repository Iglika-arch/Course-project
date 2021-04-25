package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import webpages.CreateAccount;
import webpages.FirstPage;
import webpages.Login;

import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tests extends Base implements Config {

    private final static String COMMA_DELIMITER = ",";
    public FirstPage firstPage ;
    public Login login;
    public CreateAccount createAccount ;

    @Test
    public void SignUpNegative() {
        firstPage = new FirstPage(driver);
        login = new Login(driver);
        createAccount = new CreateAccount(driver);
        test = extent.createTest("Sign up for Yahoo Finance - Negative");
        test.createNode("Go to finance yahoo com");
        driver.get(BASE_URL);
        driver.manage().window().maximize();

        test.createNode("Click on ‘Sign In’ button");
        //firstPage.clickAgreeAll();
        firstPage.clickSignUp();
        test.createNode("Click on ‘Create an account’ button");
        login.clickCreateAcc();
        test.createNode("Populate invalid data");
        createAccount.clickAcknowledge();
        test.createNode("Verify error messages");
        Assert.assertEquals("This is required.", createAccount.getErrorLastName());
        Assert.assertEquals("This is required.", createAccount.getErrorEmail());
        Assert.assertEquals("This is required.", createAccount.getErrorMobile());
        Assert.assertEquals("This is required.", createAccount.getErrorBirthdate());
    }

    @Test
    public void CheckStatistics() throws IOException {

        firstPage = new FirstPage(driver);
        login = new Login(driver);
        createAccount = new CreateAccount(driver);

        test = extent.createTest("Check statistics for a company stock");
        test.createNode("Go to finance yahoo com");
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        firstPage.clickAgreeAll();
        test.createNode("Search by a company");
        firstPage.search();
        firstPage.clickSearch();
        Assert.assertEquals("Apple Inc. (AAPL)", firstPage.getSearchedCompany());
        test.createNode("Verify Dividends rate ");
        Assert.assertEquals("0.82 (0.67%)", firstPage.getDividendsRate());
        test.createNode("Click Statistics");
        firstPage.clickStatistics();
        test.createNode("Assert value of Price/Book with data from csv");
        Assert.assertEquals("31.25", firstPage.getPriceBook());
    }
}
