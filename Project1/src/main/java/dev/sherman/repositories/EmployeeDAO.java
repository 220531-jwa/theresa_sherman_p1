package dev.sherman.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.sherman.models.Employee;
import dev.sherman.utils.ConnectionUtil;


public class EmployeeDAO {
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	//CRUD Methods
	
	public Employee createEmployee(Employee e) {
		
		String sql = "insert into employee values (default, ?, ?, ?, ?, ?, ?) returning *";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  e.getRole());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getRebalance());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Employee(
					rs.getInt("emp_id"),
					rs.getString("emp_role"),
					rs.getString("emp_firstname"),
					rs.getString("emp_lastname"),
					rs.getString("emp_username"),
					rs.getString("emp_password"),
					rs.getString("re_balance")
					);
				}
		} catch (SQLException q) {
			q.printStackTrace();
		}
		
		return null;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employee = new ArrayList<>();
		String sql = "select * from ers.employee";
		
		try (Connection conn = cu.getConnection()){
			//prepare our statement using the connection object
			PreparedStatement ps = conn.prepareStatement(sql);
			//execute our statement and store the result set in a reference variable
			ResultSet rs = ps.executeQuery();
			//iterate over the result set, to get the values stored in each column and creating a Java Object with them
			while(rs.next()){
				int empId = rs.getInt("emp_id");
				String role = rs.getString("emp_role");
				String firstName = rs.getString("emp_firstname");
				String lastName = rs.getString("emp_lastname");
				String username = rs.getString("emp_username");
				String password = rs.getString("emp_password");
				String reBalance = rs.getString("re_balance");
				
				Employee e = new Employee(empId, role, firstName, lastName, username, password, reBalance);
				
				employee.add(e);
			}
			return employee;
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return null;
	}
	
	public Employee getEmployeeById(int empId) {
	
		String sql = "select * from ers.employee where employee.emp_id = ?";
		
		try (Connection conn = cu.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Employee(
						rs.getInt("emp_id"),
						rs.getString("emp_role"),
						rs.getString("emp_firstname"),
						rs.getString("emp_lastname"),
						rs.getString("emp_username"),
						rs.getString("emp_password"),
						rs.getString("re_balance")
						);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	public Employee getEmployeeByUsername(String username) {
		String sql = "select * from ers.employee where emp_username = ?";
	
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(4, username);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Employee(
						rs.getInt("emp_id"),
						rs.getString("emp_role"),
						rs.getString("emp_firstname"),
						rs.getString("emp_lastname"),
						rs.getString("emp_username"),
						rs.getString("emp_password"),
						rs.getString("re_balance")
						);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
public void updateEmployee(Employee eChange) {
		
		String sql = "update ers.employee set emp_role = ?, emp_firstname = ?, emp_lastname = ?, emp_username = ?, emp_password = ?, re_balance = ? where emp_id = ? returning *";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, eChange.getRole());
			ps.setString(2, eChange.getFirstName());
			ps.setString(3, eChange.getLastName());
			ps.setString(4, eChange.getUsername());
			ps.setString(5, eChange.getPassword());
			ps.setString(6, eChange.getRebalance());
			ps.setInt(7, eChange.getEmpId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployee(int empId) {
		String sql = "delete from ers.employee where emp_id = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee updateEmployeePassword(int empId, String password) {
		
		String sql = "update ers.employee set emp_password = ? where emp_id = ? returning *";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Employee(
						rs.getInt("empId"),
						rs.getString("role"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("reBalance")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}