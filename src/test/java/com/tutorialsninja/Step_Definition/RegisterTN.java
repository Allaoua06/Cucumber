package com.tutorialsninja.Step_Definition;

import com.util.utile.emailTimeStamp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Map;

public class RegisterTN {
   public WebDriver driver;

   @Before
   public void setup(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://tutorialsninja.com/demo");
       driver.findElement(By.linkText("My Account")).click();
   }

   @Given("user navigate to the registerPage")
    public void user_navigate_to_the_registerPage(){
       driver.findElement(By.linkText("Register")).click();
   }

    @And("user enters mondatory fields")
    public void userEntersMondatoryFields(DataTable datatable) {
        Map<String, String> dataMap= datatable.asMap(String.class,String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(emailTimeStamp.emailStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephoe"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmPass"));

    }

    @And("user clicks on privacy policy checkbox")
    public void userClicksOnPrivacyPolicyCheckbox() {
        driver.findElement(By.name("agree")).click();
    }

    @When("user clicks on continue button")
    public void userClicksOnContinueButton() {
       driver.findElement(By.xpath("//input[@class ='btn btn-primary']")).click();
    }

    @Then("user is re-directed to the AccountSuccessPage")
    public void userIsReDirectedToTheAccountSuccessPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id ='content']/h1")).isDisplayed());
    }





    @And("^user enters firstName (.+)$")
    public void user_enters_firstName(String firstnametext) {
        driver.findElement(By.id("input-firstname")).sendKeys(firstnametext);
    }

    @And("^user enters lastName (.+)$")
    public void user_enters_LastName(String lastnameText) {
       driver.findElement(By.id("input-lastname")).sendKeys(lastnameText);
    }

    @And("^user enters telephone (.+)$")
    public void user_enters_Telephone(String telephoneText) {
       driver.findElement(By.id("input-telephone")).sendKeys(telephoneText);
    }

    @And("^user enters password (.+)$")
    public void user_enters_password(String passwordText) {
       driver.findElement(By.id("input-password")).sendKeys(passwordText);
    }

    @And("^user enters confirmPassword (.+)$")
    public void user_enters_confirmPassword(String confirmpasswordText) {
       driver.findElement(By.id("input-confirm")).sendKeys(confirmpasswordText);
    }

    @And("user selects Yes subscribe button")
    public void user_selects_Yes_subscribe_button() {
       driver.findElement(By.xpath("//input[@name ='newslatter' and @value ='1']")).click();
    }

    @And("user enters mondatory fields whith existing email")
    public void userEntersMondatoryFields_whith_existing_email(DataTable datatable) {
        Map<String, String> dataMap= datatable.asMap(String.class,String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephoe"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmPass"));

    }

    @Then("user gets a warning error message of duplicate email")
    public void user_gets_a_warning_error_message_of_duplicate_email(){
       String actualWarningMessage= driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
       String expectedWarningMessage = "";
    }


    @Then("user gets a warning error message of the incorrect confirm paddword")
    public void user_gets_a_warning_error_message_Of_the_incorrect_confirm_paddword() {
    }

    @Then("user gets a warning message for every fields")
    public void userGetsAWarningMessageForEveryFields() {
    }
}
