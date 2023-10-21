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


public class sorting {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User should success login in to saucedemo web")
    public void user_should_success_login_in_to_saucedemo_web() throws InterruptedException {
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

    @When("User click dropdown icon in top right of page")
    public void user_click_dropdown_icon_in_top_right_of_page() throws InterruptedException {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(1000);
    }

    @And("User choose price high to low")
    public void user_choose_price_high_to_low() throws InterruptedException {
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        Thread.sleep(1000);
    }

    @Then("List products on the home page will be sorted based on prices high to low")
    public void list_products_on_the_home_page_will_be_sorted_based_on_prices_high_to_low() {
        Assert.assertEquals("$49.99",driver.findElement(By.xpath("//div[@class='inventory_container']/div/div[1]/div[2]/div[2]/div")).getText());
        System.out.println("Scenario : Sort products by price low to high");
        System.out.println("You can see the first product with the price " + driver.findElement(By.xpath("//div[@class='inventory_container']/div/div[1]/div[2]/div[2]/div")).getText());
        driver.quit();
    }
}
