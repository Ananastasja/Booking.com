Feature: Rent a car on booking.com

  Scenario: Search for cars by city criteria
    Given User is looking for cars in 'Minsk' city
    When User does car search
    Then The map with locations is displayed

