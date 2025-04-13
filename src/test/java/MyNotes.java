import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.Driver;
import utils.Gutils;
import com.github.javafaker.Faker;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import java.time.Duration;
import java.util.Locale;

public class MyNotes {
    private final Faker faker = new Faker(new Locale("en", "US"));
    private final DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
    private final WebDriverWait wait;

    public MyNotes() {
        this.wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(10));
    }

    @Step("Select add a note")
    public void clickOnAddANote() {
        WebElement addANoteElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(System.getenv("homepage_AddNote_button"))));
        addANoteElement.click();
    }

    @Step("Add text to the note title")
    public void addTextTitle() {
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(System.getenv("myNotes_titlefield"))));
        String buzzwordTitle = faker.company().buzzword();
        titleField.sendKeys(buzzwordTitle);
        scenarioStore.put("expected_note_title", buzzwordTitle);
    }

    @Step("Add text to the note body")
    public void addTextBody() {
        WebElement notebodyfield = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(System.getenv("myNotes_notebodyfield"))));
        String catchPhraseBody = faker.company().catchPhrase();
        notebodyfield.sendKeys(catchPhraseBody);
        scenarioStore.put("expected_body_title", catchPhraseBody);
    }

    @Step("Save Note")
    public void clickOnAddANote2() {
        WebElement addANoteElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(System.getenv("myNotes_addNoteButton"))));
        addANoteElement.click();
    }

    @Step("Verify that note Title matches entry")
    public void verifyTitleMatchesStored() {
        String expected_note_title = (String) scenarioStore.get("expected_note_title");
        String actual_note_title = Gutils.elementTextis("myNotes_thirdNote");
        Assert.assertEquals(expected_note_title, actual_note_title);
    }

    @Step("Verify that note Body matches entry")
    public void verifyBodyMatchesStored() {
        String expected_body = (String) scenarioStore.get("expected_body_title");
        String actual_body = Gutils.elementTextis("myNotes_thirdNoteBody");
        Assert.assertEquals(expected_body, actual_body);
    }
}



