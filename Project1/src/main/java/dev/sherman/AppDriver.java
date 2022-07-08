package dev.sherman;

import java.util.List;

import dev.sherman.controller.EmployeeController;
import dev.sherman.controller.RequestController;
import dev.sherman.models.Employee;
import dev.sherman.models.Request;
import dev.sherman.repositories.EmployeeDAO;
import dev.sherman.repositories.RequestDAO;
import dev.sherman.services.EmployeeServices;
import dev.sherman.services.RequestServices;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.*;

public class AppDriver {

	public static void main(String[] args) {

		RequestDAO rd = new RequestDAO();
		EmployeeController ec = new EmployeeController(new EmployeeServices(new EmployeeDAO()));
		RequestController rc = new RequestController(new RequestServices(new RequestDAO()));
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			// config.enableCorsForOrigin("http://localhost:8082");
			config.addStaticFiles("/public", Location.CLASSPATH);
		});

		app.start(8082);

		app.routes(() -> {
			// Employee can login to app using their credentials
			path("/login", () -> { // http://localhost:8082/login/
				post(ec::loginEmployee);
			});
			
				path("/logout", () -> {
					delete(ctx -> {
						// invalidating session so loggedInEmployee is null
						ctx.req.getSession(false).invalidate();
					});
				});

				// Employee can submit a request for reimbursement
				path("/employee/{empid}/newrequest", () -> { // http://localhost:8082/employee/{empId}/newrequest
					post(rc::createRequest);
					// path("/{reqId}", () -> { //http://localhost:8082/request/3
				});
				// });

				// A Finance Manager can approve or reject(update) reimbursement request

			
//			path("/logout", () -> {
//				delete(ctx -> {
//					// invalidating session so loggedInEmployee is null
//					ctx.req.getSession(false).invalidate();
//				});
//			});
			path("/employee", () -> { // http://localhost:8081/employee
				get(ec::getAllEmployees);
				post(ec::createNewEmployee);
				path("/{empId}", () -> { // http://localhost:8081/employee/10
					get(ec::getEmployeeById);
				});
				
//				 put(ec::UpdateEmployee);
				
				path("/request", () -> { // http://localhost:8081/employee/1/request
					get(ctx -> {
						int empId = Integer.parseInt(ctx.pathParam("empId"));
						List<Request> requests = rd.getRequestStatusByEmployeeId(empId);
						ctx.status(200);
						ctx.json(requests);
					});
					path("/{requestId}", () -> { // http://localhost:8081/employee/1/request/2
						patch(RequestController::markRequestAsComplete);
					});

				});
			
	});
});
}
}
				
//				path("/getSession", () -> {
//					get(ctx -> {
//						// once set, we can access that session attribute
//						Employee loggedInEmployee = ctx.sessionAttribute("loggedInEmployee");
//						System.out.println(loggedInEmployee);
//					});
////		});
//				// Exception Mapping
//				app.exception(Exception.class, (e, ctx) -> {
//					ctx.status(404);
//					ctx.result("<h1>Employee not found</h1>");
//				});
//				
//			
//
