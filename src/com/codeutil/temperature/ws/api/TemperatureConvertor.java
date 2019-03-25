package com.codeutil.temperature.ws.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/temperature")
public class TemperatureConvertor {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TemperatureResponse changeTemperature(TemperatureRequest request) {
		TemperatureResponse response = new TemperatureResponse();
		double calculatedTemperature = request.sourceDestUnit.getCalculatedTemperature(request.temperatureValue);
		response.temperatureValue=calculatedTemperature;
		return response;
	}
}
