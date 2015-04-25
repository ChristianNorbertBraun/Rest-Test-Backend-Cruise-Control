package logic;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import resources.CruiseControl;
import status.Status;

public class StatusPicker {

	private CruiseControl resource;
	
	public StatusPicker(CruiseControl cc){
		this.resource = cc;
	}
	
	public Response attachLinks(ResponseBuilder resp){
		String[][] links = getUrlForStatus();
		
		for(int i = 0; i < links.length; ++i){
			resp.link(links[i][0], links[i][1]);
		}
		return resp.build();
	}
	
	private  String[][] getUrlForStatus(){
		if(resource.getCurrentCeiling() * resource.getCurrentSpeed()* resource.getLastCeiling() == -1){
			return Status.OFF;
		}
		else if(resource.getCurrentCeiling() * resource.getCurrentSpeed()* resource.getLastCeiling() == resource.getCurrentSpeed()){
			return Status.ON;
		}
		else if(resource.getCurrentSpeed() * resource.getCurrentCeiling()* resource.getLastCeiling() < 0){
			return Status.ON;
		}
		else{
			return Status.CONTROL;
		}
		
	}
	
}
