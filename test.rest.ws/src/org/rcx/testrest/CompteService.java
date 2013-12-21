package org.rcx.testrest;
 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/compte")
public class CompteService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		
		if(msg == null){
			
		}
 
		String output = "Jersey repond : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@PUT
	@Path("/{param}")
	public Response saveMsg(@PathParam("param") String msg) {
 
		String output = "Jersey repond : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@DELETE
	@Path("/{param}")
	public Response deleteMsg(@PathParam("param") String msg) {
 
		String output = "Jersey repond : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 
}
