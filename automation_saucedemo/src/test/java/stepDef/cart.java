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

public class cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    
    @Given("User success login in saucedemo web")
    public void user_success_login_in_saucedemo_web() throws InterruptedException {
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

    @When("Click the Add to Cart button on the selected product")
    public void click_the_add_to_cart_button_on_the_selected_product() throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(1000);
    }

    @And("User click icon cart in top right of page")
    public void user_click_icon_cart_in_top_right_of_page() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);
    }

    @Then("On the cart page, the selected products will be displayed")
    public void on_the_cart_page_the_selected_products_will_be_displayed() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Add product to cart");
        System.out.println("You can see product name " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in the cart page");
        driver.quit();
    }
}
