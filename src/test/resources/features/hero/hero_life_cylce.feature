Feature: Hero life cycle

  Scenario: I create a Hero
    Given Javier is on the tour of heroes life cycle page
    When he logs in
    Then the profile picture can be seen
    When he adds a Hero
    Then the hero can be seen

  Scenario: I delete a Hero
    Given Javier is on the tour of heroes life cycle page
    And he has a Hero
    When he logs in
    Then the profile picture can be seen
    When he removes the Hero
    Then the Hero can no longer be seen