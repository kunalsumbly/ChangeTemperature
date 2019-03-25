package com.codeutil.temperature.ws.api;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

public class TemperatureRequest {
	public TemperatureUnits sourceDestUnit;
	public double temperatureValue;

	public static void main(String[] args) throws JsonbException, FileNotFoundException {
		TemperatureRequest var =  new TemperatureRequest();
		var.sourceDestUnit= TemperatureUnits.CELSIUS_FARENHEIT;
		var.temperatureValue=100.99;
		Jsonb jsonb = JsonbBuilder.create();
		jsonb.toJson(var, new FileOutputStream("/home/diyuser2/source_backup/book.json"));
	}
}
