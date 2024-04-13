Feature: Test API DB Google integration

  @severity=critical
  Scenario Outline: Search Random Person in Google
    Given I request <count> random persons from API as "mob1"
    Given I store group "mob1" in my DB
    Given I pick a random person from DB as "random_guy"
    Given I load google page
    Given I accept cookies if present
    When I google for person with alias "random_guy"
    Then I can see name of person with alias "random_guy" in search results
    Examples:
      | count |
      | 2     |
      | 3     |

  @severity=minor
  Scenario: Search Random Person in Google
    Given I load "https://google.com/"
    Given I click button with selector GOOGLE_COOKIES_BTNS with index 3
    When I set text for element GOOGLE_SEARCH_INPUT to "Ben Affleck"
    When I send key ENTER to GOOGLE_SEARCH_INPUT element
    Then I can see at least 3 GOOGLE_SEARCH_HEADERS elements containing text "Ben Affleck"


  @severity=trivial
  Scenario: Read List and Map
    Given I read from data table as List:
    |a|
    |b|
    |c|
    |d|
    |e|

