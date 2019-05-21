Feature: Shop by electronics type
  Scenario: check number of products from 400+range
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on "400,00" and above price range
    Then In the "400,00" and above price range are exactly "2" products

