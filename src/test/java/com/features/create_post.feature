Feature: Create a new Post

  Scenario: Create post with valid payload
    Given I have a valid Post payload
    When I send a POST request to "/posts"
    Then I should receive status code 201
    And the response should contain the same title
