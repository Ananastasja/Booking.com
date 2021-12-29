Feature: Search on Booking.com

  Scenario: Search by city criteria
    Given User is looking for hotels in 'Minsk' city
    When User does search
    Then Hotel 'Hampton by Hilton Minsk City Centre' should be on the first page

  Scenario Outline: Search by different cities criteria
    Given User is looking for hotels in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page

    Examples:
      | City  | Hotel                                     |
      | Minsk | Hampton by Hilton Minsk City Centre       |
      | Brest | Hampton by Hilton Brest                   |
      | Gomel | Квартира в центре города возле ЖД вокзала |
    