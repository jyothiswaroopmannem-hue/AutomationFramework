Feature: Employee Management with Excel data
  @smoke @login @regression
  Scenario: Login with valid credentials from Excel

    Given user is on login page
    When user enters credentials from Excel
    And user click on login button
    Then user should be logged in and see the dashboard

  @regression
  Scenario: Add employee with valid details from Excel
    Given user is logged into the application from Excel
    And user navigates to employee page
    And user clicks on add employee button
    When user enters employee details from Excel
    And user clicks on add button
    Then employee should be added successfully