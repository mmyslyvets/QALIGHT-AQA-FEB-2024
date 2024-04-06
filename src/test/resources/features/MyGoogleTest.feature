Feature: Test API DB Google integration
#  @my-new-test
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

#  Scenario: Search Random Person in Google
#    Given I reqeust a random person from API
#    Given I store random person from API in my DB
#    Given I load "https://google.com/"
#    Given I click "accept_cookies_xpath"
#    When I set element "search_input_xpath" text to "some_name"
#    When I click "search_button_xpath"
#    Then I can see at least 3 "headers_with_text_xpath" elements