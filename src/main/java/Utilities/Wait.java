package Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriver driver;

    public Wait(WebDriver webDriver)
    {
        driver = webDriver;
    }
    WebDriverWait wait = new WebDriverWait(driver,30);

    public WebElement WaitForElementToBeVisible(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(locator))));
    }

  }
