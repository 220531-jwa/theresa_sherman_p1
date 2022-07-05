package dev.sherman.controller;


import java.util.List;
//import java.util.logging.LogManager;

import dev.sherman.models.Employee;
import dev.sherman.services.EmployeeServices;
import io.javalin.http.Context;


public class EmployeeController {
	
	private EmployeeServices es;
	
	public EmployeeController(EmployeeServices es) {
		this.es = es;
	}
	
	
	public void loginEmployee(Context ctx) {
		Employee e = ctx.bodyAsClass(Employee.class);
		Employee loggedInEmployee = es.login(e.getUsername(), e.getPassword());
		if (e != null) {
			// Setting Session Attribute
			ctx.sessionAttribute("loggedInEmployee", loggedInEmployee);
//			log.info("Session Attribute Set for Employee " + loggedInEmployee);
		}
		ctx.json(loggedInEmployee);
	}

	public void getAllEmployees(Context ctx) {
//		log.info("GET Request received at endpoint/employee");
		ctx.status(200);
		List<Employee> employee = es.getAllEmployees();
		ctx.json(employee);
	}
	
	public void createNewEmployee(Context ctx) {
	//	log.info("Creating a new employee");
		ctx.status(201);
		Employee employeeFromRequestBody = ctx.bodyAsClass(Employee.class);
		Employee e = es.createEmployee(employeeFromRequestBody); // unmarshalling
		ctx.json(e);
	}
	
	public void getEmployeeById(Context ctx) {
		int empId = Integer.parseInt(ctx.pathParam("empId"));
		Employee e = null;
		try {
			e = es.getEmployeeById(empId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		if (e != null) {
			ctx.status(200);
			ctx.json(e);
		} else {
	//log.error("Employee with id of " + empId + " attempted to login, but does not exist.");
			ctx.status(404);
		}
		
	}
	public void deleteEmployee(Context ctx) {
		int empId = Integer.parseInt(ctx.pathParam("id"));
		es.deleteEmployee(empId);
	}
	
	public void updateEmployee(Context ctx) {
		Employee eChanged = ctx.bodyAsClass(Employee.class); //unmarshalling
		System.out.println("updateEmployee -= " + eChanged);
		es.updateEmployee(eChanged);
	}
	public void updatePassword(Context ctx) {
		int empId = Integer.parseInt(ctx.pathParam("id"));
		Employee e = ctx.bodyAsClass(Employee.class); // {"password": "newPassword"}
		System.out.println(e.getPassword());
		es.updatePassword(empId, e.getPassword());
	}
}