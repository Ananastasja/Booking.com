Feature: Rent a car on booking.com

  Scenario: Search for cars by city criteria
    Given User is looking for cars in 'Minsk' city
    When User does car search
    Then The map with locations is displayed

    //тест для практики, но проблема в том, что бывает пишет, что кнопка disabled почему-то и соответственно не находит карту
