import com.google.common.base.Verify;
import com.smarttested.qa.smartassert.SmartAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicationReferencePage extends Page {

    private final String URL = "http://corpus.by/publicationReference/";

    Date date = new Date();
    SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat format2 = new SimpleDateFormat(" yyyy ");

    @FindBy(css = "input.red-button[name='btn_type_clear_and_show_examples']")
    private WebElement showExamplesButton;

    @FindBy(css = "input.red-button[name='clearTable']")
    private WebElement clearTableButton;

    public PublicationReferencePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "textarea[name='title']")
    private WebElement publicationName;

    @FindBy(css = "input[id='czasopis_title']")
    private WebElement publicationTypeButton;

    @FindBy(id = "pages_from")
    private WebElement pagesFrom;

    @FindBy(id = "pages_to")
    private WebElement pagesTo;

    @FindBy(id = "number_edition")
    private WebElement journalNumber;


    @Override
    public void openPage() {
        driver.navigate().to(URL);
    }

    public void enterPublication(String publicationTitle, String titleBook, String pageFr, String pageT, String numberEdition) {
        publicationName.sendKeys(titleBook);
        Assert.assertEquals(publicationName.getText(), titleBook, "publicationName is not  equals");
        publicationTypeButton.sendKeys(publicationTitle);
        Assert.assertEquals(publicationTypeButton.getText(), publicationTitle, "publicationType is not  equals");
        pagesFrom.sendKeys(pageFr);
        Assert.assertEquals(pagesFrom.getText(), pageFr, "pagesFrom is not  equals");
        pagesTo.sendKeys(pageT);
        Assert.assertEquals(pagesTo.getText(), pageT, "pagesTo is not  equals");
        journalNumber.sendKeys(numberEdition);
        Assert.assertEquals(journalNumber.getText(), numberEdition, "journalNumber is not  equals");

    }

    public void clearAndShowExamples() {
        showExamplesButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> firstNameList = getFirstNameList();
        List<WebElement> lastNameList = getLastNameList();
      //  clearTableButton.click();
        Assert.assertTrue(firstNameList.get(0).getAttribute("value").length() > 0, "element with id 'firstname1' is  empty");
        Assert.assertTrue(lastNameList.get(0).getAttribute("value").length() > 0, "element with id 'lastname1' is  empty");
        Assert.assertTrue(publicationName.getAttribute("value").length() > 0, "Name of publication is  clear ");
        Assert.assertTrue(publicationType.getAttribute("value").length() > 0, "Type of publication is  clear ");
        Assert.assertTrue(pagesFrom.getAttribute("value").length() > 0, "Pages numbering from is  clear ");
        Assert.assertTrue(pagesTo.getAttribute("value").length() > 0, "Pages numbering to is  clear ");
        Assert.assertTrue(journalNumber.getAttribute("value").length() > 0, "journal number is  clear");
    }

    public void clearTable()  {
        waitForVisibility(clearTableButton, 5000);
        List<WebElement> firstNameList = getFirstNameList();
        List<WebElement> lastNameList = getLastNameList();
        clearTableButton.click();
        for (WebElement firstName : firstNameList) {
            Assert.assertTrue(firstName.getText().length() == 0, String.format("element with id 'firstname%s' is not empty", firstNameList.indexOf(firstName) + 1));
        }
        for (WebElement lastName : lastNameList) {
            Assert.assertTrue(lastName.getText().length() == 0, String.format("element with id 'lastname%s' is not empty", lastNameList.indexOf(lastName) + 1));
        }
        System.out.println(publicationName.getAttribute("value"));
        Assert.assertTrue(publicationName.getAttribute("value").length() == 0, "Name of publication is not clear ");
        Assert.assertTrue(publicationTypeButton.getAttribute("value").length() == 0, "Type of publication is not clear ");
        Assert.assertTrue(pagesFrom.getAttribute("value").length() == 0, "Pages numbering from is not clear ");
        Assert.assertTrue(pagesTo.getAttribute("value").length() == 0, "Pages numbering to is not clear ");
        Assert.assertTrue(journalNumber.getAttribute("value").length() == 0, "journal number is not clear");
    }

    @FindBy(css = "input[id='no_author']")
    private WebElement noAuthor;

    public void checkDisabled() {
        WebElement firstName = getFirstNameList().get(0);
        WebElement lastName = getLastNameList().get(0);
        noAuthor.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(firstName.getCssValue("background-color").equals("rgba(190, 190, 190, 1)") && lastName.getCssValue("background-color").equals("rgba(190, 190, 190, 1)"));
    }

    public void writeFirstName(String name, int number) {
        WebElement firstName = getFirstNameList().get(number);
        firstName.sendKeys(name);
    }

    public void clearFirstName(int number) {
        WebElement eraseButtonFirstName = getEraseButtonFirstName().get(number);
        eraseButtonFirstName.click();
    }

    public void writeLastName(String lname, int number) {
        WebElement lastName = getLastNameList().get(number);
        lastName.sendKeys(lname);
    }

    public void clearLastName(int number) {
        WebElement eraseButtonFirstName = getEraseButtonLastName().get(number);
        eraseButtonFirstName.click();
    }

    public List<WebElement> getFirstNameList() {
        List<WebElement> list = new ArrayList<WebElement>();
        for (int i = 1; i <= 10; i++) {
            list.add(driver.findElement(By.name("firstname" + i)));
        }
        return list;
    }


    public List<WebElement> getLastNameList() {
        List<WebElement> list = new ArrayList<WebElement>();
        for (int i = 1; i <= 10; i++) {
            list.add(driver.findElement(By.name("lastname" + i)));
        }
        return list;
    }

    public List<WebElement> getEraseButtonFirstName() {
        List<WebElement> list = new ArrayList<WebElement>();
        for (int i = 1; i <= 10; i++) {
            list.add(driver.findElement(By.cssSelector("input[onclick=\"eraseFirstNameField('" + i + "_author_id')\"]")));
        }
        return list;
    }


    public List<WebElement> getEraseButtonLastName() {
        List<WebElement> list = new ArrayList<WebElement>();
        for (int i = 1; i <= 10; i++) {
            list.add(driver.findElement(By.cssSelector("input[onclick=\"eraseLastNameField('" + i + "_author_id1')\"]")));
        }
        return list;
    }

    @FindBy(css = "a[href='../']")
    private WebElement urlHomePage;

    @FindBy(css = "a[href='http://ssrlab.by']")
    private WebElement urlSsrlab;

    public void checkUrlHomePage() {
        urlHomePage.click();
    }

    public void checkUrlSsrlab() {
        urlSsrlab.click();
        // softAssert.assertEquals();
    }

    @FindBy(css = "input.blue-button-generator")
    private WebElement generetorButton;


    @FindBy(css = "textarea.main-textaera")
    private WebElement textaeraWithReference;

    public void generateText() {
        generetorButton.click();
        Assert.assertTrue(textaeraWithReference.isDisplayed(), "Textarea is not displayed");
    }

    public void checkResult(String firstName, String lastName, String titleBook, String publicationTitle, String pageTo, String pageFrom, String numberEdition) {


        textaeraWithReference.getText().contains(firstName);
        textaeraWithReference.getText().contains(lastName);
        textaeraWithReference.getText().contains(titleBook);
        textaeraWithReference.getText().contains(publicationTitle);
        textaeraWithReference.getText().contains(pageTo);
        textaeraWithReference.getText().contains(pageFrom);
        textaeraWithReference.getText().contains(numberEdition);
        textaeraWithReference.getText().contains(format2.format(date));
    }

    @FindBy(css = "input[name='current_year']")
    private WebElement checkBoxCurrentYear;

    @FindBy(css = "input[name='year']")
    private WebElement inputYear;

    public void checkCurrentYear() {
        if (!checkBoxCurrentYear.isSelected()) {
            checkBoxCurrentYear.click();
        }
        Assert.assertEquals(inputYear.getText(), format2.format(date), "Wrong year ");
    }
    
    @FindBy(css = "select[name='publication_type']")
    private WebElement publicationType;


    @FindBy(css = " input[id='book_title']")
    private WebElement bookTitle;

    @FindBy(css = " input[id='volume_of_book']")
    private WebElement volumeOfBook;

    @FindBy(css = "input[id='redactor']")
    private WebElement redactorBook;


    public void selectBook() {
        Select select = new Select(publicationType);
        select.selectByValue("book");
        Assert.assertTrue(bookTitle.isDisplayed(), "BookTitle is not displayed");
        Assert.assertTrue(volumeOfBook.isDisplayed(), "volumeOfBook is not displayed");
        Assert.assertTrue(city.isDisplayed(), "city is not displayed");
        Assert.assertTrue(publishHouse.isDisplayed(), "publishHouse is not displayed");
        Assert.assertTrue(redactorBook.isDisplayed(), "redactorBook is not displayed");
    }

    public void enterPublicationBook(String titleBook, String numberEdition, String country, String publicationHouse, String redactor) {
        bookTitle.sendKeys(titleBook);
        Assert.assertEquals(bookTitle.getText(), titleBook, "publicationName is not  equals");
        volumeOfBook.sendKeys(numberEdition);
        Assert.assertEquals(volumeOfBook.getText(), numberEdition, "volumeOfBook is not  equals");
        city.sendKeys(country);
        Assert.assertEquals(city.getText(), country, "city is not  equals");
        publishHouse.sendKeys(publicationHouse);
        Assert.assertEquals(publishHouse.getText(), publicationHouse, "publishHouse is not  equals");
        redactorBook.sendKeys(redactor);
        Assert.assertEquals(redactorBook.getText(), redactor, "journalNumber is not  equals");

    }

    public void checkResultBook(String firstName, String lastName, String titleBook, String numberEdition, String country, String publicationHouse, String redactor) {

        textaeraWithReference.getText().contains(firstName);
        textaeraWithReference.getText().contains(lastName);
        textaeraWithReference.getText().contains(titleBook);
        textaeraWithReference.getText().contains(country);
        textaeraWithReference.getText().contains(publicationHouse);
        textaeraWithReference.getText().contains(redactor);
        textaeraWithReference.getText().contains(numberEdition);
        textaeraWithReference.getText().contains(format2.format(date));
    }

    @FindBy(css = "textarea[id='conference_title']")
    private WebElement conferenceTitle;

    @FindBy(css = "input[id='city']")
    private WebElement city;

    @FindBy(css = "input[id='place_id']")
    private WebElement placeId;

    @FindBy(css = "input[id='publish_house']")
    private WebElement publishHouse;

    public void selectConference() {
        Select select = new Select(publicationType);
        select.selectByValue("conference");
        Assert.assertTrue(conferenceTitle.isDisplayed(), "Textarea is not displayed");
        Assert.assertTrue(city.isDisplayed(), "city is not displayed");
        Assert.assertTrue(placeId.isDisplayed(), "placeId is not displayed");
        Assert.assertTrue(publishHouse.isDisplayed(), "publishHouse is not displayed");
    }

    public void enterPublicationConference(String titleBook, String conferenceTItle, String pageT, String pageFr, String country, String placeID, String publicationHOUSE) {
        publicationName.sendKeys(titleBook);
        Assert.assertEquals(publicationName.getText(), titleBook, "publicationName is not  equals");
        conferenceTitle.sendKeys(conferenceTItle);
        Assert.assertEquals(conferenceTitle.getText(), conferenceTItle, "conferenceType is not  equals");
        pagesFrom.sendKeys(pageFr);
        Assert.assertEquals(pagesFrom.getText(), pageFr, "pagesFrom is not  equals");
        pagesTo.sendKeys(pageT);
        Assert.assertEquals(pagesTo.getText(), pageT, "pagesTo is not  equals");
        pagesTo.sendKeys(pageT);
        Assert.assertEquals(city.getText(), country, "city is not  equals");
        placeId.sendKeys(placeID);
        Assert.assertEquals(placeId.getText(), placeId, "pagesTo is not  equals");
        publishHouse.sendKeys(publicationHOUSE);
        Assert.assertEquals(publishHouse.getText(), publicationHOUSE, "publicationHouse is not  equals");
        checkBoxCurrentYear.click();
        Assert.assertEquals(inputYear.getText(), format2.format(date), " inputYear is not current");

    }

    public void checkResultConference(String firstName, String lastName, String titleBook, String conferenceTitle, String pageTo, String pageFrom, String city, String placeID, String publicationHouse) {


        textaeraWithReference.getText().contains(firstName);
        textaeraWithReference.getText().contains(lastName);
        textaeraWithReference.getText().contains(titleBook);
        textaeraWithReference.getText().contains(conferenceTitle);
        textaeraWithReference.getText().contains(pageTo);
        textaeraWithReference.getText().contains(pageFrom);
        textaeraWithReference.getText().contains(city);
        textaeraWithReference.getText().contains(placeID);
        textaeraWithReference.getText().contains(publicationHouse);
        textaeraWithReference.getText().contains(format2.format(date));
    }

    @FindBy(css = "input[id='website_title']")
    private WebElement websiteTitle;

    @FindBy(css = "input[id='date_of_access']")
    private WebElement dateOfAccess;
    @FindBy(css = " input[id='date_today']")
    private WebElement checkBoxCurrentDay;

    @FindBy(css = " input[id='url']")
    private WebElement url;


    public void selectElectronicResource() {
        Select select = new Select(publicationType);
        select.selectByValue("electronic_resource");
        Assert.assertTrue(websiteTitle.isDisplayed(), "websiteTitle is not displayed");
        Assert.assertTrue(dateOfAccess.isDisplayed(), "dateOfAccess is not displayed");
        if (!checkBoxCurrentDay.isSelected()) {
            checkBoxCurrentDay.click();
        }
        Assert.assertEquals(dateOfAccess.getText(), format1.format(date), "dateOfAccess is not current");
        Assert.assertTrue(url.isDisplayed(), "url is not displayed");

    }

    public void enterPublicationElectronicResource(String publicationTitle, String webResourceTitle, String webResourceUrl) {
        publicationName.sendKeys(publicationTitle);
        Assert.assertEquals(publicationName.getText(), publicationTitle, "publicationName is not  equals");
        websiteTitle.sendKeys(webResourceTitle);
        Assert.assertEquals(websiteTitle.getText(), webResourceTitle, "publicationType is not  equals");
        url.sendKeys(webResourceUrl);
        Assert.assertEquals(url.getText(), webResourceUrl, "webResourceUrl is not  equals");
        checkBoxCurrentYear.click();
        Assert.assertEquals(inputYear.getText(), format2.format(date), " inputYear is not current");
    }

    public void checkResultElectronicResource(String firstName, String lastName, String publicationTitle, String webResourceTitle, String webResourceUrl) {

        textaeraWithReference.getText().contains(firstName);
        textaeraWithReference.getText().contains(lastName);
        textaeraWithReference.getText().contains(webResourceTitle);
        textaeraWithReference.getText().contains(publicationTitle);
        textaeraWithReference.getText().contains(webResourceTitle);
        textaeraWithReference.getText().contains(format1.format(date));
        textaeraWithReference.getText().contains(format2.format(date));
    }
    @FindBy(id = "publication_format")
    private WebElement publicationFormat;

    public void checkSelectFormat(int sum){
        Select select = new Select(publicationFormat);
        publicationFormat.click();
        Assert.assertEquals(select.getOptions().size(), sum, "The number of elements is not correct");

    }
    @FindBy(id = "publication_language_id")
    private WebElement publicationLanguage;

    public void checkSelectLanguage(int sum){
        Select select = new Select(publicationLanguage);
        publicationLanguage.click();
        Assert.assertEquals(select.getOptions().size(),sum, "The number of elements is not correct");
    }

    @FindBy(css = "select[name='type_redactor']")
    private WebElement typeRedactor;

    public void checkSelectConferenceType(int sum){
        Select select = new Select(publicationType);
        select.selectByValue("conference");
        Select selectType = new Select(typeRedactor);
        Assert.assertEquals(selectType.getOptions().size(), sum, "The number of elements is not correct");

    }

}
