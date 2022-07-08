package dev.sherman.controller;



import dev.sherman.services.RequestServices;
import dev.sherman.models.Request;
import io.javalin.http.Context;
public class RequestController {
	
		private static RequestServices rs;
		
		public RequestController(RequestServices rs) {
			this.rs= rs;
		}
		
		public void createRequest(Context ctx) {
			//	log.info("Creating a new request");
				ctx.status(201);
				Request requestFromEmployeeBody = ctx.bodyAsClass(Request.class);
				Request r = rs.createRequest(requestFromEmployeeBody); // unmarshalling
				ctx.json(r);
			}
		
		public static void markRequestAsComplete(Context ctx) {
//			Request r = ctx.bodyAsClass(Request.class);
//			int empId = r.getEmpId();
//			int requestId = r.getRequestId();
			int empId = Integer.parseInt(ctx.pathParam("empId"));
			int requestId = Integer.parseInt(ctx.pathParam("requestId"));
			RequestServices.markAsComplete(empId, requestId);
			
			ctx.status(204);
		}

	}

