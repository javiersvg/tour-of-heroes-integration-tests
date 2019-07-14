Feature: Search by keyword

  @manual
  Scenario: Searching for a term
    Given Sergey is on the DuckDuckGo home page
    When he searches for "cucumber"
    Then all the result titles should contain the word "cucumber"