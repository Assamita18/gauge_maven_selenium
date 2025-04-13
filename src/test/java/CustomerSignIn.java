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
import java.time.Duration;
import java.util.Locale;

public class CustomerSignIn {
    private final WebDriverWait wait;

    public CustomerSignIn() {
        this.wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(10));
    }

    @Step("Sign in as <email> with password <password>")
    public void signInAs(String email, String password) {
        WebElement userfield = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(System.getenv("loginpage_user"))));
        userfield.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(System.getenv("loginpage_password"))));
        passwordField.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(System.getenv("loginpage_loginbutton"))));
        loginButton.click();
    }

    @Step("Verify that page title is <page>")
    public void checkPageTitle(String page) {
        wait.until(ExpectedConditions.titleIs(page));
        String actualTitle = Gutils.getPageTitle();
        Assert.assertEquals(page, actualTitle);
    }

    @Step("Accept Login data")
    public void acceptLogindata() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(System.getenv("loginpage_accept_button"))));
        acceptButton.click();
    }

    @Step("Verify that note module exists")
    public void noteModuleExists() {
        String locator = System.getenv("mynotes_container");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    @Step("Verify that error message is visible")
    public void errorMessageExists() {
        String locator = System.getenv("loginpage_error_message");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    @Step("Verify that error message is <content>")
    public void errorMessageExists(String content) {
        String locator = System.getenv("loginpage_error_message");
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(locator)));
        String actual = errorElement.getText();
        Assert.assertEquals(content, actual);
    }
}