Feature: test social account 
      #send GET request
Scenario: test list of user on friendbook site
	Given send GET request "https://reqres.in/api/users?page=2" 
	Then then responce code should be 200 
	Then veryfy total pages are 4 
	
	#Sending a post request
Scenario: adding a user in DB 
Given send post request "https://reqres.in/api/users" and responce code should be 201
		|name | morpheus|
		|job  | leader  |
	
	  
	   #validate complex json body with json to pojo class maping
Scenario: validating json body 
	Given send GET request "https://reqres.in/api/users?page=2" and get all user details in json body then validate it
		|7    |michael.lawson@reqres.in  |Michael |Lawson  |
		|8    |lindsay.ferguson@reqres.in|Lindsay |Ferguson|
	    |9    |tobias.funke@reqres.in    |Tobias  |Funke   |
	    
	    
	   #Fetching multiple Elements from json body with Jsonpath
Scenario: validating all first_name of employees from json body 
	Given GET employees "https://reqres.in/api/users?page=2"
		|Michael |
		|Lindsay |
	    |Tobias  |
	    |Byron   |
	    |George  |
	    |Rachel  |
	    
	   #reading JSON File and sending Put request Update a Employee details
Scenario: Update Employee details
	Given Get updated employees details json file "C:\\Users\\mukesh\\workspace\\RestAssuredWithCucumber\\src\\test\\resources\\jsonDataSet\\emp.json"
	Then  send PUT request "https://reqres.in/api/users/2" and validate it
	
	 #reading data from excel files
Scenario Outline: Data Driven with excel and data sets
   When I am on the amps mainscreen
   Then I input username and passwords with excel row"<row_index>" dataset

    Examples:
    | row_index  |
    | 1          |
    | 2          |
    | 3          |
    | 4          |