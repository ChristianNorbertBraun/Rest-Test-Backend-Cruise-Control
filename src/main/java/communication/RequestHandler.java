package communication;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import logic.StatusPicker;
import resources.CruiseControl;


@Path("/cruiseControl")
public class RequestHandler {


	
	@POST
	@Produces("application/json")
	public Response turnOffTracking(CruiseControl cc){
		cc.turnOff();
		StatusPicker sp = new StatusPicker(cc);
		Response resp = sp.attachLinks(Response.ok(cc));
		return resp;
	}

	
	@POST
	@Path("/on")
	@Produces("application/json")
	public Response turnOnTracking(CruiseControl cc){
		cc.pause();
		StatusPicker sp = new StatusPicker(cc);
		Response resp = sp.attachLinks(Response.ok(cc));
		return resp;
	}
	
	@POST
	@Path("/control")
	@Produces("application/json")
	public Response startControl(CruiseControl cc){
		cc.control();
		StatusPicker sp = new StatusPicker(cc);
		Response resp = sp.attachLinks(Response.ok(cc).header("comment", cc.checkSpeed()));
		return resp;
	}
	
	@POST
	@Path("/inc")
	@Produces("application/json")
	public Response increaseCeiling(CruiseControl cc){
		cc.increaseCeiling();
		StatusPicker sp = new StatusPicker(cc);
		Response resp = sp.attachLinks(Response.ok(cc).header("comment", cc.checkSpeed()));
		return resp;
	}
	
	@POST
	@Path("/dec")
	@Produces("application/json")
	public Response decreaseCeiling(CruiseControl cc){
		cc.decreaseCeiling();
		StatusPicker sp = new StatusPicker(cc);
		Response resp = sp.attachLinks(Response.ok(cc).header("comment", cc.checkSpeed()));
		return resp;
	}
	
	
	

}
