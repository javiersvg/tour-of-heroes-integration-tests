Feature: Login on the tour of heroes

  Scenario: Login on the tour of heroes home page
    Given Javier is on the tour of heroes home page
    When he logs in
    Then the profile picture can be seen