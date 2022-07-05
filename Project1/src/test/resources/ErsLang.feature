Feature: LoginPage Login Link works
	
	Scenario: The Representative Login Link works
	
	Given the employee is on the ERS login page
	When the employee clicks on the login button as a Representative
	Then the title of the web page should be ERS Employee Home Page
	
	Scenario: The Finance Manager Login Link Works
	
	Given the employee is on the ERS login page
	When the employee clicks on the login button as a Finance Manager
	Then the title of the web page should be ERS Finance Manager Home Page