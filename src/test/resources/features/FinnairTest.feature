Feature: Test Store\Update Finnair Flights to DB
#  @my-new-test
  Scenario: Store\Update Finnair Flights to DB
    Given I load google page
    Given I accept cookies if present
    Given I google the "Finnair" Page
    Given I accept cookies on Finnair if present
    Given I go to the Destination Page
    Then I store to db new flight to 4 cities or flight with updated prices
