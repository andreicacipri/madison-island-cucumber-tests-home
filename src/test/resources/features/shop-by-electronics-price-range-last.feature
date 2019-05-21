Feature: Shop by electronics price
  Scenario: Shop products by last price range
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on "400,00" RON and above electronics price
    Then All products are in "400,00" RON and above range


