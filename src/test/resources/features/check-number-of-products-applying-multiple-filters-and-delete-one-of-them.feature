Feature: Shop by electronics type
  Scenario: check number of products applying multiple filters and then delete one of them
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on "Accessories" electronics type filter
    And I click on "0,00"-"99,99" price range
    And I delete one filter
    Then After that there are exactly 4 products

