package dev.sherman.services;

import dev.sherman.models.Request;
import dev.sherman.repositories.RequestDAO;

public class RequestServices {
	
private static RequestDAO rd;

public RequestServices(RequestDAO rd) {
	this.rd = rd;
}

	public static void markAsComplete(int empId, int requestId) {

		Request r = rd.getRequestById(empId, requestId);
		if (r != null) {
			rd.updateRequestMarkAsComplete(empId, requestId);
		}	
	
	}
	//create new request
	public Request createRequest(Request r) {
		Request createdRequest = rd.createRequest(r);
		return createdRequest;
}
	}

