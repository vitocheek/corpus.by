import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HomePage extends Page {

    private final String BASE_URL = "http://corpus.by/";
    @FindBy(how = How.LINK_TEXT, using = "Get Publication References")
    private WebElement getPublicationReferencesButton;
    private SoftAssert softAssert = new SoftAssert();

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void pageDisplayed() {
        //  softAssert.assertTrue();
    }
}
