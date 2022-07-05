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
		//Employee can submit a request for reimbursement

		//Employee can see the status of their current and past requests/reimbursements
			
		//Employee can update their reimbursement request to include their grade/presentation

		//A Finance Manager can view all reimbursement requests

		//A Finance Manager can approve or reject reimbursement requests

		// A FM can update the status of a reimbursement request once the Employee
		//has submitted their grade/presentation



		RequestDAO rd = new RequestDAO();
		EmployeeController ec = new EmployeeController(new EmployeeServices(new EmployeeDAO()));
		RequestController rc = new RequestController(new RequestServices(new RequestDAO()));
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			//config.enableCorsForOrigin("http://localhost:8081");
			//	config.addStaticFiles("/public/html", Location.CLASSPATH);
		});

		app.start(8081);

		app.routes(() -> {
			//Employee can login to app using their credentials
			path("/login", () -> { //http://localhost:8081/login/
				post(ec::loginEmployee);
			});
			path("getSession", () -> {
				get(ctx -> {
					//once set, we can access that session attribute
					Employee loggedInEmployee = ctx.sessionAttribute("loggedInEmployee");
					System.out.println(loggedInEmployee);
				});
			});
			path("/logout", () -> {
				delete(ctx -> {
					//invalidating session so loggedInEmployee is null
					ctx.req.getSession(false).invalidate();
				});
			});
			path("/employee", () -> { //http://localhost:8081/employee
				get(ec::getAllEmployees);
				post(ec::createNewEmployee);
				
				path("/{empId}", () -> { //http://localhost:8081/employee/10
					get(ec::getEmployeeById);
				});
				// delete(ec::deleteEmployee);
				// put(ec::UpdateEmployee);
				// patch(ec::updatePassword);
				path("/request", () -> { //http://localhost:8081/employee/1/request
					get(ctx -> {
						int empId = Integer.parseInt(ctx.pathParam("empId"));
						List<Request> requests = rd.getRequestStatusByEmployeeId(empId);
						ctx.status(200);
						ctx.json(requests);
					});
					path("/{requestId}", () -> { //http://localhost:8081/employee/1/request/2
						patch(RequestController::markRequestAsComplete);
					});

				});
//		});
					//Exception Mapping
				app.exception(Exception.class, (e, ctx) -> {
				    ctx.status(404);
				    ctx.result("<h1>Employee not found</h1>");
				});
		//		//Error Mapping
		//		app.error(404, ctx -> {ctx.result("You typed the URL incorrectly");});
		//		//Test End points that will not be in the final application
		//		app.get("/test", ctx -> {
		//			ctx.status(200);
		//			String name = ctx.queryParam("name");
		//			ctx.result("Test successful! Hello " + name);
		//		});
		//		
		//		app.get("/bodystring",ctx -> {
		//			
		//			String body = ctx.body();
		//			System.out.println("Body: " + body);
		//			String[] split = body.split(":");
		//			 
		//			 for (String s : split) {
		//				 System.out.println(s);
		//			 }
		//			
		//		});
		//	});
		});
		});
}
}