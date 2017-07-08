Feature: Deathstar Addition

  Scenario: Add a single Deathstar

    Given There are two deathstars in the Galaxy
    When I add a Deathstar to the DeathStar Service
    Then I should get three deathstars

  Scenario: Fail to Add a single Deathstar

    Given There are fifty deathstars in the Galaxy
    When I add a Deathstar to the DeathStar Service
    Then I should get an TooManyDeathStarsError