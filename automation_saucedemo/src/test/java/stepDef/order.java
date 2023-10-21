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

public class order {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User open the SauceDemo website")
    public void userOpenTheSauceDemoWebsite() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @When("User log in as a standard user")
    public void userLogInAsAStandardUser() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @And("User select a product named Sauce Labs Backpack")
    public void userSelectAProductNamed() throws InterruptedException {
        driver.findElement(By.id("item_4_title_link")).click();
        Thread.sleep(1000);
    }

    @Then("User should see the product details matching Sauce Labs Backpack")
    public void userShouldSeeTheProductDetailsMatching() throws InterruptedException {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Product Matching");
        Thread.sleep(1000);
    }

    @And("User add the product to the cart")
    public void userAddTheProductToTheCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
    }

    @And("User go to the cart")
    public void userGoToTheCart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        Thread.sleep(1000);
    }

    @And("User proceed to checkout")
    public void userProceedToCheckout() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Assert.assertEquals("Checkout: Your Information",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        Thread.sleep(1000);
    }

    @And("User enter the following checkout information:")
    public void userEnterTheFollowingCheckoutInformation() throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys("Ayu");
        driver.findElement(By.id("last-name")).sendKeys("Friska");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(1000);
    }

    @And("User continue with the checkout")
    public void userContinueWithTheCheckout() throws InterruptedException {
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
    }

    @And("User complete the order")
    public void userCompleteTheOrder() throws InterruptedException {
        Assert.assertEquals("Checkout: Overview",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
    }

    @Then("User should see a confirmation message THANK YOU FOR YOUR ORDER")
    public void userShouldSeeAConfirmationMessage() {
        Assert.assertEquals("Thank you for your order!",driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText());
        System.out.println("Scenario : User successfully complete the order");
        System.out.println("You successfully complete your order");
        driver.quit();
    }
}
