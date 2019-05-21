Feature: Shop by electronics type
  Scenario Outline:: Check number of products applying different filters
    Given I open the homepage
    And I move the mouse on Home&Decor and then on Electronics page and click
    And I click on "<filter>" electronics type filter
    Then With "<filter>"filter are exactly"<number of products>"products

    Examples:
      | filter               |  number of products |
      | Accessories          | 4                   |
      | Camera               | 2                   |
      | Media Players        | 2                   |
      | Speakers + Earphones | 3                   |