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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User should navigate to saucedemo login page")
    public void user_should_navigate_to_saucedemo_login_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("User input the username")
    public void user_input_the_username() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
    }

    @And("User input the  Password")
    public void user_input_the_password() throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
    }

    @And("User click the login button")
    public void user_click_the_login_button() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @Then("User should navigate to saucedemo home page")
    public void user_should_navigate_to_saucedemo_home_page() {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login with valid usernames and passwords");
        System.out.println("You successfully log in, if you can see the title page name " + driver.findElement(By.className("title")).getText());
        driver.quit();
    }
}
