package dev.sherman.models;

public class Employee {

	private int empId;
	private String role;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String reBalance;
	
	public Employee() {
		super();
	}
	
	public Employee(int empId, String role, String firstName, String lastName,
			String username, String password, String reBalance) {
				super();
				this.empId = empId;
				this.role = role;
				this.firstName = firstName;
				this.lastName = lastName;
				this.username = username;
				this.password = password;
				this.reBalance = reBalance;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRebalance() {
		return reBalance;
	}

	public void setRebalance(String reBalance) {
		this.reBalance = reBalance;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", role=" + role + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", rebalance=" + reBalance + "]";
	}
	
}
