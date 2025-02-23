package definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @When("I log in with the created account")
    public void userLoginWithCreatedAccount() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);

        loginPage.enterEmail("testuser@example.com");  // Use actual email
        loginPage.enterPassword("Test@1234");
        loginPage.clickLogin();
    }

    @Then("I should see my account dashboard")
    public void userShouldSeeAccountDashboard() {
        Assert.assertTrue(loginPage.isLoginSuccessful());
        driver.quit();
    }
}
