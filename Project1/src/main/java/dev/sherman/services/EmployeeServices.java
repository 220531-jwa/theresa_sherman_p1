package dev.sherman.services;

import java.util.List;

import dev.sherman.models.Employee;
import dev.sherman.repositories.EmployeeDAO;

public class EmployeeServices {

	private static EmployeeDAO employeeDao;

		public EmployeeServices(EmployeeDAO employeeDao) {
			this.employeeDao = employeeDao;
	}
	
	//login
	public Employee login(String username, String password) {
	
		Employee e = employeeDao.getEmployeeByUsername(username);
		if (e != null) {
			if(e.getPassword().equals(password)) {
				return e;
			}
		}
		return null;
	}
	public Employee updatePassword(int empid, String password) {
		// could add code to check if that employee exists
		return employeeDao.updateEmployeePassword(empid, password);
	}
	
	// register/create employee
	public Employee createEmployee(Employee e) {
		Employee createdEmployee = employeeDao.createEmployee(e);
		return createdEmployee;
	}
	//get all employees
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	//Getting an employee by their employee ID
	public Employee getEmployeeById(int empId) throws Exception {
		// this is where you could put some business logic 
		// for example checking if the User returned by userDao.getUserById(id) is null 
		Employee e = employeeDao.getEmployeeById(empId);
		
		if (e == null) {
			throw new Exception("Employee with that ID not found");
		}
		
		return e;
	}

	//Delete an employee
	public void deleteEmployee(int empid) {
		employeeDao.deleteEmployee(empid);
	}



	public void updateEmployee(Employee eChanged) {
	
		
	}

}
