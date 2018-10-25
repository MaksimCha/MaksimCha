@smokeTest
Feature: Different Elements Page tests

  Scenario: Different Elements Page Interface test
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user name is PITER CHAILOVSKII value
    And 4 pictures are displayed on the Home Page
    And 4 texts are displayed under pictures respectively
    And 2 texts are displayed
    When I click Service subcategory in the header
    Then 8 options are displayed in dropdown
    When I click Different Elements Page category
    Then The browser title is Different Elements Page
    And 4 checkboxes are displayed on the Different Elements Page
    And 4 radiobuttons are displayed on the Different Elements Page
    And dropdown are displayed on the Different Elements Page
    And 2 buttons are displayed on the Different Elements Page
    And right section are displayed on the Different Elements Page
    And left section are displayed on the Different Elements Page
    When I select checkBoxes
    |0    |Water|
    |2    |Wind |
