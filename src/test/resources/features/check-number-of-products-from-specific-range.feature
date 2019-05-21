Feature: Shop by electronics type
  Scenario Outline: check number of products from specific range
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on "<started price>"-"<final price>" price range
    Then In the "<started price>"-"<final price>" price range are exactly "<number of products>" products

    Examples:
      | started price | final price | number of products |
      | 0,00          | 99,99       | 4                  |
      | 100,00        | 199,99      | 5                  |
