package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;
    //Constructor
    public Login (WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"createacc\"]")
    private WebElement createAcc;

    public void clickCreateAcc(){
        createAcc.click();
    }
}
