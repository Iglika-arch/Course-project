package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
    private WebDriver driver;
    //Constructor
    public FirstPage (WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header-signin-link\"]")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"consent-page\"]//div[2]//button")
    private WebElement agreeAll;

    @FindBy(xpath = "//*[@id=\"yfin-usr-qry\"]")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"header-desktop-search-button\"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"quote-header-info\"]//h1")
    private WebElement searchedCompany;

    @FindBy(xpath = "//*[@id=\"quote-nav\"]//li[4]//span")
    private WebElement statistics;

    @FindBy(xpath = "//*[@id=\"Col1-0-KeyStatistics-Proxy\"]/section/div[2]/div[1]//tr[7]/td[2]")
    private WebElement priceBook;

    @FindBy(xpath = "//*[@id=\"quote-summary\"]/div[2]/table/tbody/tr[6]/td[2]")
    private WebElement dividendsRate;


    public void search(){
        search.sendKeys("Apple");
    }
    public void clickSearch(){
        searchBtn.click();
    }

    public void clickSignUp(){
        signIn.click();
    }

    public void clickAgreeAll(){
        agreeAll.click();
    }

    public void clickStatistics(){
        statistics.click();
    }

    public String getSearchedCompany(){
        return searchedCompany.getText();
    }


    public String getPriceBook(){
        return priceBook.getText();
    }

    public String getDividendsRate(){
        return dividendsRate.getText();
    }
}
