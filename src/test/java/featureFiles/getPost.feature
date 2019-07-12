Feature: test social account  

Scenario: test list of user on friendbook
    Given send GET request "https://reqres.in/api/users?page=2"
    Then then responce code should be 200
    Then veryfy total pages are 4