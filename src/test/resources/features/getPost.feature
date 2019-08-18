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
		|4    | eve.holt@reqres.in      |Eve     |Holt  |
		|5    | charles.morris@reqres.in|Charles |Morris|
	    |6    |tracey.ramos@reqres.in   |Tracey  |Ramos |
	    
	    
	   #Fetching multiple Elements from json body with Jsonpath
Scenario: validating all first_name of employees from json body 
	Given GET employees "https://reqres.in/api/users?page=2"
		|Eve     |
		|Charles |
	    |Tracey  |
	    
	   #reading JSON File and sending Put request Update a Employee details
#Scenario: Update Employee details
#	Given Get updated employees details json file "C:\\Users\\mukesh\\workspace\\RestAssuredWithCucumber\\src\\test\\resources\\JsonFiles\\emp.json"
#	Then  send PUT request "https://reqres.in/api/users/2" and validate it