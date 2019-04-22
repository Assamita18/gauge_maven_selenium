import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver;
import utils.Gutils;
import com.github.javafaker.Faker;
import java.util.Locale;


public class CustomerSignup {

    Faker faker = new Faker(new Locale("en", "US"));


    @Step("Sign in as <email> with password <password>")

    public void signInAs(String email, String password) {
        WebDriver webDriver = Driver.webDriver;
        WebElement userfield =  webDriver.findElement(By.xpath(System.getenv("loginpage_user")));

        String locator;
        userfield.sendKeys(email);


        locator = System.getenv("loginpage_password");

        webDriver.findElement(By.xpath(locator)).sendKeys(password);

        locator = System. getenv("loginpage_loginbutton");

        webDriver.findElement(By.xpath(locator)).click();



    }

    @Step("Verify that page title is <page>")
    public void checkPageTitle(String page) {
        String actualTitle;
        actualTitle = Gutils.getPageTitle();
        Assert.assertEquals(page, actualTitle);

    }

    @Step("Accept Login data")
    public void acceptLogindata(){
        String locator = System.getenv("loginpage_accept_button");
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath(locator)).click();


    }

    @Step("Verify that note module exists")
    public void noteModuleExists(){
        String locator = System.getenv("mynotes_container");
        Gutils.isElementVisible(locator);

    }
}