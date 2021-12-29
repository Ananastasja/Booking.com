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

  Scenario Outline: Search by different cities and matching it with rating
    Given User is looking for hotels in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page
    And the hotel '<Hotel>' should have the rating '<Rating>'

    Examples:
      | City      | Hotel                         | Rating |
      | Berlin    | KPM Hotel & Residences        | 9,3    |
      | Munich    | NH Collection München Bavaria | 8,5    |
      | Barcelona | Ayre Hotel Rosellón           | 8,7    |
      | Prague    | Hotel Leon D´Oro              | 8,9    |
      | Paris     | Le Pigalle Hotel              | 8,7    |