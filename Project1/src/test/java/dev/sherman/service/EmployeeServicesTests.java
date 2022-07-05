package dev.sherman.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.sherman.models.Employee;
import dev.sherman.repositories.EmployeeDAO;
import dev.sherman.services.EmployeeServices;

@ExtendWith(MockitoExtension.class) 
public class EmployeeServicesTests {
	
	//an instance of the class that we are testing - a REAL instance
	@InjectMocks
	private static EmployeeServices employeeServices;
	
	//since we want to test only the functionality of the UserServices class
	//we will Mock any dependencies that class relies on
	@Mock
	private static EmployeeDAO employeeDaoMock;
	
	
//	@BeforeEach
//	public void setupEach() {
//		employeeServices = new EmployeeServices();
//	}
	
	
	@Test
	public void loginWithValidInput() {
		
		Employee mockEmployee = new Employee(1, "Representative", "Debbie", "Balmer", "dbalmer", "debbiepass", "1000.00");
		
		when(employeeDaoMock.getEmployeeByUsername(anyString()))
			.thenReturn(mockEmployee);
		
		Employee loggedInEmployee = employeeServices.login("username", "password");
		
		assertEquals(mockEmployee, loggedInEmployee);
		
		
	}
	
	@Test 
	public void should_ReturnAllEmployees() {
		//given - precondition -> 3 users in the DB
		List<Employee> employeeMock = new ArrayList<>();
		employeeMock.add(new Employee(2, "Representative", "Donald", "Richardson", "drichardson", "donaldpass", "1000"));
		employeeMock.add(new Employee(3, "Representative", "Joseph", "Cornett", "jcornett", "josephpass", "1000"));
		employeeMock.add(new Employee(4, "Representative", "Ronald", "Mcdonald", "rmcdonald", "ronaldpass", "1000"));
		//when - actual functionality we are testing -> EmployeeServices getAllEmployees method is called 
		when(employeeDaoMock.getAllEmployees()).thenReturn(employeeMock);
		//then - when we assert the results -> It should return all employees
		assertEquals(employeeMock, employeeServices.getAllEmployees());
	}
	
	@Test
	public void loginWithInvalidUsernameShouldReturnNull() {
		
		when(employeeDaoMock.getEmployeeByUsername(anyString()))
		.thenReturn(null);
	
		Employee loggedInEmployee = employeeServices.login("username", "password");
		
		assertEquals(null, loggedInEmployee);
	}
	
	
	@Test
	public void loginWithValidUsernameInvalidShouldReturnNull() {
		
		Employee mockEmployee = new Employee(1, "Representative", "Debbie", "Balmer", "dbalmer", "debbiepass", "1000");
		
		when(employeeDaoMock.getEmployeeByUsername(anyString()))
		.thenReturn(mockEmployee);
	
		Employee loggedInEmployee = employeeServices.login("username", "password");
		
		assertEquals(null, loggedInEmployee);
	}
}