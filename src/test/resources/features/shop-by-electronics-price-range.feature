Feature: Shop by electronics price
  Scenario Outline: Shop products by price range
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on "<started price>"-"<final price>" RON electronics price
    Then All products are in "<started price>"-"<final price>" range

    Examples:
      | started price | final price |
      | 0,00          | 99,99       |
      | 100,00        | 199,99      |
