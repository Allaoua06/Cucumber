@TutorialsNinjaLogin
  Feature: Login functionality of ToturialsNinja

//Background:  Commen step(s) for this feature file present in all scenarios


    @ValidCredentials
    Scenario Outline: Login with valid credentials
      Given User navigates to login page
      And User enters valid email <email>
      And User enters valid password <password>
      When User click in the Login button
      Then User is redirected to Accountpage
      Examples:
        |   email                 |    password   |
        |seleniumpanda@gmail.com  | Selenium@123  |
        |seleniumpanda1@gmail.com | Selenium@123  |
        |seleniumpanda2@gmail.com | Selenium@123  |
        |seleniumpanda3@gmail.com | Selenium@123  |
        |seleniumpanda4@gmail.com | Selenium@123  |
        |seleniumpanda5@gmail.com | Selenium@123  |

    @InvalidCredentials
    Scenario: Login with invalid credentials
      Given User navigates to login page
      And User enters invalid email "seleniumpanda@gmailll.com"
      And User enters invalid password "Selenium@10023"
      When User click in the Login button
      Then User gets warning message about credentials mismatch

    @ValidEmailInvalidPassword
    Scenario: Login with valid email and invalid password
      Given User navigates to login page
      And User enters invalid email "seleniumpanda@gmail.com"
      And User enters invalid password "Selenium@10023"
      When User click in the Login button
      Then User gets warning message about credentials mismatch

    @InalidEmailvalidPassword
    Scenario: Login with valid email and invalid password
      Given User navigates to login page
      And User enters invalid email "seleiumpanda@gmailll.com"
      And User enters invalid password "Selenium@123"
      When User click in the Login button
      Then User gets warning message about credentials mismatch

    @NoCredentials
    Scenario: Login with no credentials
      Given User navigates to login page
      When User click in the Login button
      Then User gets warning message about credentials mismatch







