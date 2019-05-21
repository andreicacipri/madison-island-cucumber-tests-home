Feature: Shop by electronics type
  Scenario: Check number of products applying charcoal filters
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on color "Charcoal" filter
    Then With color "Charcoal"filter are exactly"2"products

