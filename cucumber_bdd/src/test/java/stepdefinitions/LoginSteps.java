package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;

    @Given("login page should be open in default browser")
    public void login_page_should_be_open_in_default_browser() {

        driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/");

        driver.manage().window().maximize();

        System.out.println("Browser Opened");
    }

    @When("click on username field and add valid user username")
    public void click_on_username_field_and_add_valid_user_username() {

        System.out.println("Username Entered");
    }

    @When("then click on password button and enter valid password")
    public void then_click_on_password_button_and_enter_valid_password() {

        System.out.println("Password Entered");
    }

    @When("now click on submit button")
    public void now_click_on_submit_button() {

        System.out.println("Submit Button Clicked");
    }

    @Then("login successfully and redirect to home page")
    public void login_successfully_and_redirect_to_home_page() {

        System.out.println("Login Successful");
    }

    @After
    public void closeBrowser() {

        // driver.quit();

    }
    

}