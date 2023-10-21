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


public class productDetail {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User successfully login in to saucedemo web")
    public void user_successfully_login_in_to_saucedemo_web() throws InterruptedException {
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

    @When("Click name product on the product page")
    public void click_name_product_on_the_product_page() throws InterruptedException {
//        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
        driver.findElement(By.id("item_4_title_link")).click();
        Thread.sleep(1000);
    }

    @Then("Display page product detail that user chooses")
    public void display_page_product_detail_that_user_chooses() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Show Product Detail");
        System.out.println("You can see product detail" + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        driver.quit();
    }
}
