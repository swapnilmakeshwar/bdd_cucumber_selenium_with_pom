package definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupSteps {
    WebDriver driver;
    SignupPage signupPage;

    @Given("I navigate to the Magento signup page")
    public void userNavigateToTheSignupPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        signupPage = new SignupPage(driver);
        signupPage.clickCreateAccountLink();
    }

    @When("I enter valid details and submit the form")
    public void userEnterValidDetails() {
        signupPage.enterFirstName("Test");
        signupPage.enterLastName("User");
        signupPage.enterEmail("testuser" + System.currentTimeMillis() + "@test.com");
        signupPage.enterPassword("Test@1234");
        signupPage.clickSignup();
    }

    @Then("I should see a success message")
    public void userShouldSeeSuccessMessage() {
        Assert.assertTrue(signupPage.isSignupSuccessful());
        driver.quit();
    }
}
