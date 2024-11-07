 @TuturialsNinjaRegister
   Feature: Register functionality of TutorialsNInja Application

     @MandatoryFields
     Scenario: Register with mandatory fields
       Given user navigate to the registerPage
       And   user enters mondatory fields
       | firstName        |  Selenium       |
       | lastName         |  Panda          |
       | telephone        |  987654321      |
       | password         |  Selenium@123   |
       | confirmpassword  |  Selenium@123   |

       And   user clicks on privacy policy checkbox
       When  user clicks on continue button
       Then  user is re-directed to the AccountSuccessPage

     @AllFields
       Scenario Outline: Register with mandatory fields
         Given user navigate to the registerPage
         And   user enters firstName <fristName>
         And   user enters lastName  <lastName>
         And   user enters telephone <telephone>
         And   user enters password  <password>
         And   user enters confirmPassword <confirmpassword>
         And   user selects Yes subscribe button
         And   user clicks on privacy policy checkbox
         When  user clicks on continue button
         Then  user is re-directed to the AccountSuccessPage
         Examples:
           | firstName   |  lastName |  telephone  | password   | confirmpassword  |
           |   Selenium  | Panda     | 987654321   |Selenium@123| Selenium@123     |
           |   Selenium1 | Panda1    | 987654321   |Selenium@123| Selenium@123     |
           |   Selenium2 | Panda2    | 987654321   |Selenium@123| Selenium@123     |
           |   Selenium3 | Panda3    | 987654321   |Selenium@123| Selenium@123     |
           |   Selenium4 | Panda4    | 987654321   |Selenium@123| Selenium@123     |
           |   Selenium5 | Panda5    | 987654321   |Selenium@123| Selenium@123     |

     @DuplicateEmail
     Scenario: Register with existing email
       Given  user navigate to the registerPage
       And   user enters mondatory fields whith existing email
         | firstName        |  Selenium               |
         | lastName         |  Panda                  |
         | email            | Seleniumpanda@gmail.com |
         | telephone        |  987654321              |
         | password         |  Selenium@123           |
         | confirmpassword  |  Selenium@123           |
       And   user clicks on privacy policy checkbox
       When  user clicks on continue button
       Then  user gets a warning error message of duplicate email

     @IncorectConfirmPassword
     Scenario: Register with incorect confirme password
       Given  user navigate to the registerPage
       And   user enters mondatory fields with incorrect confirm password
         | firstName        |  Selenium               |
         | lastName         |  Panda                  |
         | telephone        |  987654321              |
         | password         |  Selenium@123           |
         | confirmpassword  |  Selenium@123           |
       And   user clicks on privacy policy checkbox
       When  user clicks on continue button
       Then  user gets a warning error message of the incorrect confirm password

     @NoFields
     Scenario: Register with mandatory fields
       Given user navigate to the registerPage
       When  user clicks on continue button
       Then  user gets a warning message for every fields