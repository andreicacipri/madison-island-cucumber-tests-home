Feature: Shop by electronics type
  Scenario: Check number of products applying black filters
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on color "Black" filter
    Then With color "Black"filter are exactly"8"products

