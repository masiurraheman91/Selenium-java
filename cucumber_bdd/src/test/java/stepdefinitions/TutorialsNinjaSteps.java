package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.TutorialsNinjaHook;
import io.cucumber.java.en.*;

public class TutorialsNinjaSteps {

    String email = "test" + System.currentTimeMillis() + "@gmail.com";

    @Given("User opens website")
    public void user_opens_website() {

        System.out.println("Website Opened");
    }

    @When("User registers account")
    public void user_registers_account() {

        WebDriverWait wait = new WebDriverWait(TutorialsNinjaHook.driver, Duration.ofSeconds(10));

        WebElement myAccount = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='My Account']")
                )
        );

        myAccount.click();

        TutorialsNinjaHook.driver.findElement(By.linkText("Register")).click();
        TutorialsNinjaHook.driver.findElement(By.id("input-firstname")).sendKeys("Masiur");
        TutorialsNinjaHook.driver.findElement(By.id("input-lastname")).sendKeys("Raheman");
        TutorialsNinjaHook.driver.findElement(By.id("input-email")).sendKeys(email);
        TutorialsNinjaHook.driver.findElement(By.id("input-telephone")).sendKeys("9999999999");
        TutorialsNinjaHook.driver.findElement(By.id("input-password")).sendKeys("test123");
        TutorialsNinjaHook.driver.findElement(By.id("input-confirm")).sendKeys("test123");
        TutorialsNinjaHook.driver.findElement(By.name("agree")).click();
        TutorialsNinjaHook.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        System.out.println("Registration Passed");
    }

    @And("User logout after registration")
    public void user_logout_after_registration() {

        TutorialsNinjaHook.driver.findElement(By.linkText("Logout")).click();

        System.out.println("Logout After Registration Passed");
    }

    @And("User login")
    public void user_login() {

        TutorialsNinjaHook.driver.findElement(By.xpath("//span[text()='My Account']")).click();
        TutorialsNinjaHook.driver.findElement(By.linkText("Login")).click();
        TutorialsNinjaHook.driver.findElement(By.id("input-email")).sendKeys(email);
        TutorialsNinjaHook.driver.findElement(By.id("input-password")).sendKeys("test123");
        TutorialsNinjaHook.driver.findElement(By.xpath("//input[@value='Login']")).click();
        System.out.println("Login Passed");
    }

    @And("User search product")
    public void user_search_product() {

        WebElement search = TutorialsNinjaHook.driver.findElement(By.name("search"));
        search.clear();
        search.sendKeys("iphone");

        TutorialsNinjaHook.driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        System.out.println("Search Passed");
    }

    @And("User add product to cart")
    public void user_add_product_to_cart() {

        TutorialsNinjaHook.driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]")).click();
        System.out.println("Add To Cart Passed");
    }

    @And("User remove product from cart")
    public void user_remove_product_from_cart() throws InterruptedException {

        Thread.sleep(2000);
        WebElement cart = TutorialsNinjaHook.driver.findElement(By.id("cart-total"));
        cart.click();
        Thread.sleep(1000);

        WebElement remove = TutorialsNinjaHook.driver.findElement(By.xpath("//i[@class='fa fa-times']"));
        remove.click();

        System.out.println("Remove Button Clicked");
        System.out.println("Remove Cart Passed");
    }

    @Then("User logout")
    public void user_logout() {

        TutorialsNinjaHook.driver.findElement(By.xpath("//span[text()='My Account']")).click();
        System.out.println("Logout button clicked");
        TutorialsNinjaHook.driver.findElement(By.linkText("Logout")).click();
        System.out.println("Logout Passed");
    }
}