import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vitalia on 19.04.2015.
 */
public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait waiter;

    public abstract void openPage();

    public Page(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(driver, 30);
    }

    public void waitForVisibility(WebElement element, int timeout) {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
        System.out.println("WebElement " + element + " is visible");
    }
}
