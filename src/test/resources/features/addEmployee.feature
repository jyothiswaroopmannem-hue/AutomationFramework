Feature: Employee Management
  @smoke @login @regression
  Scenario Outline: Login with valid credentials

    Given user is on login page
    When user enters email "<email>"
    When user enters password "<password>"
    And user click on login button
    Then user should be logged in and see the dashboard

    Examples:
      | email | password |
      |  jyothiswaroop123@optimworks.com     |     Swaroop@123     |

  @regression
  Scenario Outline: Add employee with valid details
    Given user is logged into the application "<mail>" "<pass>"
    And user navigates to employee page
    And user clicks on add employee button
    When user enters employee details "<firstname>" "<lastname>" "<Empid>" "<email>" "<role>" "<qualification>" "<gender>" "<bloodgroup>" "<reportingto>" "<password>" "<dob>" "<joiningdate>" "<department>" "<mobilenumber>" "<designation>" "<salary>" "<location>"
    And user clicks on add button
    Then employee should be added successfully

    Examples:
      | mail | pass | firstname | lastname | Empid | email | role | qualification | gender | bloodgroup | reportingto | password | dob | joiningdate | department | mobilenumber | designation | salary | location |
      |  jyothiswaroop123@optimworks.com     |     Swaroop@123     |           swarr   |   manne  | EMPO | @optimwork.com |Admin| Degree|Male|    A+|    jyothiswaroop123@optimworks.com      |Swaroop@123|12-02-2003|25-02-2026|ECE|9347001988|Test Engineer|35000|Hyderabad|
      |  jyothiswaroop123@optimworks.com     |     Swaroop@123     |           pavan   |   dama  | EMPO | @optimwork.com |Admin| Degree|Male|    A+|    jyothiswaroop123@optimworks.com      |Swaroop@123|12-02-2003|25-02-2026|ECE|9347001988|Test Engineer|35000|Hyderabad|
      |  jyothiswaroop123@optimworks.com     |     Swaroop@123     |           kali   |   path  | EMPO | @optimwork.com |Admin| Degree|Male|    A+|    jyothiswaroop123@optimworks.com      |Swaroop@123|12-02-2003|25-02-2026|ECE|9347001988|Test Engineer|35000|Hyderabad|
      |  jyothiswaroop123@optimworks.com     |     Swaroop@123     |           krish   |   bora  | EMPO | @optimwork.com |Admin| Degree|Male|    A+|    jyothiswaroop123@optimworks.com      |Swaroop@123|12-02-2003|25-02-2026|ECE|9347001988|Test Engineer|35000|Hyderabad|


