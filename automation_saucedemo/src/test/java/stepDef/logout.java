package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User login to saucedemo website")
    public void user_login_to_saucedemo_website() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @And("User should navigate to left sidebar")
    public void user_should_navigate_to_left_sidebar() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
    }

    @When("User click logout button")
    public void user_click_logout_button() throws InterruptedException {
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);
    }

    @Then("User back to saucedemo website login page")
    public void user_back_to_saucedemo_website_login_page() {
        Assert.assertEquals("Swag Labs",driver.findElement(By.className("login_logo")).getText());
        System.out.println("Scenario : Logout from saucedemo website");
        System.out.println("You successfully log out from saucedemo website");
        driver.quit();
    }
}
