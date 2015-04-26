import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Step {

    private WebDriver driver;

    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.quit();
    }

    public void checkClear() {

        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearTable();
        publicationReferencePage.generateText();
    }

    public void checkShowExample() {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearAndShowExamples();
    }

    public void goHome() {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.openPage();
    }

    public void writeAndClean(String name, String lastName, int number){
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearTable();
        publicationReferencePage.writeFirstName(name, number);
        publicationReferencePage.writeLastName(lastName, number);
        publicationReferencePage.clearFirstName(number);
        publicationReferencePage.clearLastName(number);
    }

    public void checkEnteredAndResult(String firstName, String lastName, String titleBook, String publicationTitle, String pageTo, String pageFrom, String numberEdition, int number) {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearTable();
        publicationReferencePage.writeFirstName(firstName, number);
        publicationReferencePage.writeLastName(lastName, number);
        publicationReferencePage.enterPublication(publicationTitle, titleBook, pageFrom, pageTo, numberEdition);
        publicationReferencePage.checkCurrentYear();
        publicationReferencePage.generateText();
        publicationReferencePage.checkResult(firstName, lastName, titleBook, publicationTitle, pageTo, pageFrom, numberEdition);
    }

    public void checkDisabledTable() {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.checkDisabled();
    }

    public void selectConferenceEnteredAndCheckResult(String firstName, String lastName, String titleBook, String conferenceTitle, String pageTo, String pageFrom, String city, String placeID, String publicationHouse, int number) {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearTable();
        publicationReferencePage.selectConference();
        publicationReferencePage.writeFirstName(firstName, number);
        publicationReferencePage.writeLastName(lastName, number);
        publicationReferencePage.enterPublicationConference(titleBook, conferenceTitle, pageTo, pageFrom, city, placeID, publicationHouse);
        publicationReferencePage.generateText();
        publicationReferencePage.checkResultConference(firstName, lastName, titleBook, conferenceTitle, pageTo, pageFrom, city, placeID, publicationHouse);

    }

    public void selectBookEnteredAndCheckResult(String firstName, String lastName, String titleBook, String numberEdition, String country, String publicationHouse, String redactor, int number)  {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearTable();
        publicationReferencePage.selectBook();
        publicationReferencePage.writeFirstName(firstName, number);
        publicationReferencePage.writeLastName(lastName, number);
        publicationReferencePage.enterPublicationBook(titleBook, numberEdition, country, publicationHouse, redactor);
        publicationReferencePage.generateText();
        publicationReferencePage.checkResultBook(firstName, lastName, titleBook, numberEdition, country, publicationHouse, redactor);

    }

    public void selectWebResourceEnteredAndCheckResult(String firstName, String lastName, String publicationTitle, String titleWebResource, String webResourceUrl, int number) {
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.clearTable();
        publicationReferencePage.selectElectronicResource();
        publicationReferencePage.writeLastName(lastName, number);
        publicationReferencePage.writeFirstName(firstName, number);
        publicationReferencePage.enterPublicationElectronicResource(publicationTitle, titleWebResource, webResourceUrl);
        publicationReferencePage.generateText();
        publicationReferencePage.checkResultElectronicResource(firstName, lastName, publicationTitle, titleWebResource, webResourceUrl);
    }

   public  void checkSelectFormat(int sum){
       PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
       publicationReferencePage.checkSelectFormat(sum);
   }

    public  void checkSelectLanguage(int sum){
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.checkSelectLanguage(sum);
    }
    public  void checkSelectConferenceType(int sum){
        PublicationReferencePage publicationReferencePage = new PublicationReferencePage(driver);
        publicationReferencePage.checkSelectConferenceType(sum);
    }
}

