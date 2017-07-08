Feature: Deathstar Retrieval

    Scenario: Get a single Deathstar

      Given There are two deathstars in the Galaxy
      When I call the Deathstar Service
      Then I should get two deathstars

  Scenario: Get all Deathstars

    Given There are two deathstars in the Galaxy
    When I call the Deathstar Service
    Then I should get all deathstars