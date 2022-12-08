Start app - ```mvn spring-boot:run```  
This is REST API to get public holdays and create personal by id.
1. Public holidays - /holidays/public
    - \+ {countryCode}/isHoliday/{date} (GB/isHoliday/2023-01-01) - check if date is holiday
    - \+ {countryCode}/year/{year} (GB/year/2022) - get all holidays of specific year in specific country
    - \+ {countryCode}/date/{date} (GB/date/2022-01-01) -  get holiday of specific date in specific country
2. Personal holidays - /holidays/private
    - \+ /{id}/isHoliday/{date} - check if day is your personal holiday
    - \+ /{id}/date/{date} - get holiday at specific date
    - \+ /{id}/year/{year} - get all holidays of concrete year
    - \+ /{id} - POST request with body ```
    {
      "userId": 1,
      "date": "2022-12-12",
      "name": "Trip"
      }``` and Content-Type - application/json ()
    - \+ /{id}/date/{date} - DELETE request