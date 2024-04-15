Feature: Test Finnair page functionality

  @severity=critical
  Scenario: Store\Update Finnair Flights to DB
    Given I load google page
    Given I accept cookies if present
    Given I google the "Finnair" Page
    Given I accept cookies on Finnair if present
    Given I go to the Destination Page
    Then I store to db new flight of 4 cities or flight with updated prices


  @severity=minor
  Scenario: Check search result on the Finnair page
    Given I load google page
    Given I accept cookies if present
    Given I google the "Finnair" Page
    Given I accept cookies on Finnair if present
    When I try to search "barcelona"
    Then I check that there is "barcelona" in the url

    @severity=normal
    Scenario: Check error messages on the login modal
      Given I load google page
      Given I accept cookies if present
      Given I google the "Finnair" Page
      Given I accept cookies on Finnair if present
      When I try to login without credentials
      Then I see error messges below inputs
