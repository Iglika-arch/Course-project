package webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header-signin-link\"]")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"consent-page\"]/div/div/div/form/div[2]/div[2]/button")
    private WebElement agreeAll;

    @FindBy(xpath = "//*[@id=\"reg-submit-button\"]")
    private WebElement acknowledge;

    @FindBy(xpath = "//*[@id=\"reg-error-lastName\"]")
    private WebElement errorLastName;

    @FindBy(xpath = "//*[@id=\"reg-error-yid\"]")
    private WebElement errorEmail;

    @FindBy(xpath = "//*[@id=\"reg-error-phone\"]")
    private WebElement errorMobile;

    @FindBy(xpath = "//*[@id=\"reg-error-birthDate\"]")
    private WebElement errorBirthdate;


    @FindBy(xpath = "//*[@id='atomic']//input[@id='yfin-usr-qry']")
    private WebElement search;



    //Constructor
    public CreateAccount(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    public void clickSignUp(){
        signIn.click();
    }

    public void clickAgreeAll(){
        agreeAll.click();
    }

    public void clickAcknowledge(){
        acknowledge.click();
    }
    public String getErrorLastName(){
        return errorLastName.getText();
    }

    public String getErrorEmail(){
        return errorEmail.getText();
    }

    public String getErrorMobile(){
        return errorMobile.getText();
    }
    public String getErrorBirthdate(){
        return errorBirthdate.getText();
    }

    public void search(){
        search.sendKeys("Apple");
    }
}
