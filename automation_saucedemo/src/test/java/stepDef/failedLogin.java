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

public class failedLogin {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User go to saucedemo login page")
    public void user_go_to_saucedemo_login_page() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @When("User input the invalid username")
    public void user_input_the_invalid_username() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("user_friska");
        Thread.sleep(1000);
    }

    @And("User input the invalid Password")
    public void user_input_the_invalid_password() throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys("friska_baik");
        Thread.sleep(1000);
    }

    @And("Click the login button")
    public void click_the_login_button() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @Then("User should not navigate to saucedemo home page")
    public void user_should_not_navigate_to_saucedemo_home_page() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        System.out.println("Scenario : Login with invalid  usernames and passwords");
        System.out.println("You can see error " + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        driver.quit();
    }
}
