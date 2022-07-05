package dev.sherman.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.sherman.models.Request;
import dev.sherman.utils.ConnectionUtil;

public class RequestDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	//CRUD Methods

	public List<Request> getRequestStatusByEmployeeId(int empId){
		List<Request> requests = new ArrayList<>();

		String sql = "select r.request_id, r.req_date, r.req_status from ers.employees_requests er"
				+ " left join employee e on er.emp_id = e.emp_id" 
				+ " left join request r on er.request_id = r.request_id"
				+ " where e.emp_id = 9";
		//try with resources - auto-closes any resources we need without a finally block
		try (Connection conn = cu.getConnection()){

			//prepare our statement using the connection object
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			//execute our statement and store the result set in a reference variable
			ResultSet rs = ps.executeQuery();
			//iterate over the result set, to get the values stored in each column and 
			//creating a Java Object with them
			while(rs.next()){
				requests.add(new Request(
						rs.getInt("request_id"),
						rs.getString("req_date"),
						rs.getString("req_status"),
						rs.getInt("completion_proof"),
						rs.getInt("event_date"),
						rs.getInt("event_time"),
						rs.getString("event_location"),
						rs.getString("event_desc"),
						rs.getInt("event_cost"),
						rs.getString("event_type"),
						rs.getString("work_just"),
						rs.getInt("proj_reim"),
						rs.getString("event_gradereq"),
						rs.getString("event_gradeformat"),
						rs.getInt("emp_id")
						));

			}
			return requests;

		} catch (SQLException e) {
		}
		return null;
	}
	public Request getRequestById(int empId, int requestId) {
		String sql = "select * from employees_requests er"
				+ "left join employees e on er.emp_id = e.id"
				+ "left join requests r on er.request_id = r.id"
				+ "where emp_id = ?"
				+ "and request_id = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.setInt(2, requestId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Request(rs.getInt("request_id"),
						rs.getString("req_date"),
						rs.getString("req_status"),
						rs.getInt("completion_proof"),
						rs.getInt("event_date"),
						rs.getInt("event_time"),
						rs.getString("event_location"),
						rs.getString("event_desc"),
						rs.getInt("event_cost"),
						rs.getString("event_type"),
						rs.getString("work_just"),
						rs.getInt("proj_reim"),
						rs.getString("event_gradereq"),
						rs.getString("event_gradeformat"),
						rs.getInt("emp_id")
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateRequestMarkAsComplete(int empId, int requestId) {

		String sql = "update employees_requests set is_complete = true where employee_id = ? and request_id = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.setInt(2, requestId);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}


