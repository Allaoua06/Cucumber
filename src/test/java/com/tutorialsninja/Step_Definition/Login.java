package com.tutorialsninja.Step_Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Login  {
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
    }

    @Given("User navigates to login page")
    public void User_navigates_to_login_page() throws InterruptedException {


        Thread.sleep(2000);
        driver.findElement(By.linkText("Login")).click();
    }

    @And("^User enters valid email (.+)$")
    public void User_enters_valid_email(String validEmailText){
        driver.findElement(By.id("input-email")).sendKeys(validEmailText);
    }

    @And("^User enters valid password (.+)$")
    public void User_enters_valid_password(String validPasswordText){
        driver.findElement(By.id("input-password")).sendKeys(validPasswordText);
    }

    @When("User click in the Login button")
    public void User_click_in_the_Login_button(){
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("User is redirected to Accountpage")
    public void User_is_redirected_to_Accountpage() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    @And("User enters invalid email {string}")
    public void user_enters_invalid_mail(String invalidEmailText) {
        driver.findElement(By.id("input_email")).sendKeys(invalidEmailText);
    }

    @And("User enters invalid password {string}")
    public void user_enters_invalid_password(String invalidPasswordText) {
        driver.findElement(By.id("input_password")).sendKeys(invalidPasswordText);
    }

    @Then("User gets warning message about credentials mismatch")
    public void User_gets_warning_message_about_credentials_mismatch(){
        String expectedWarningMessage = "alert alert-danger alert-dismissible";
        String actualWarningMessage = driver.findElement(By.xpath("//div[@class ='alert alert-danger alert-dismissible']")).getText();
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
