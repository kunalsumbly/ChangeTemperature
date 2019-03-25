package com.codeutil.temperature.ws.api;

public enum TemperatureUnits {

	CELSIUS_KELVIN("CELSIUS", "KELVIN", new IChangeTemperature() {

		@Override
		public double changeTemperature(double inputValue) {
			return inputValue + 273.15;
		}

	}),

	CELSIUS_FARENHEIT("CELSIUS", "FARENHEIT", new IChangeTemperature() {

		@Override
		public double changeTemperature(double inputValue) {
			return inputValue * 9 / 5 + 32;
		}

	}),

	KELVIN_CELSIUS("KELVIN", "CELSIUS", new IChangeTemperature() {

		@Override
		public double changeTemperature(double inputValue) {
			// TODO Auto-generated method stub
			return inputValue - 273.15;
		}

	}),

	KELVIN_FARENHEIT("KELVIN", "FARENHEIT", new IChangeTemperature() {

		@Override
		public double changeTemperature(double inputValue) {
			return (inputValue - 273.15) * 9 / 5 + 32;
		}
	}),

	FARENHEIT_KELVIN("FARENHEIT", "KELVIN", new IChangeTemperature() {

		@Override
		public double changeTemperature(double inputValue) {
			return (inputValue - 32) * 5 / 9 + 273.15;
		}
	}),

	FARENHEIT_CELSIUS("FARENHEIT", "CELSIUS", new IChangeTemperature() {

		@Override
		public double changeTemperature(double inputValue) {
			return (inputValue - 32) * 5 / 9;
		}
	});

	private String sourceUnit;
	private String destUnit;
	private IChangeTemperature calculator;

	TemperatureUnits(){
		
	}
	
	TemperatureUnits(String sourceUnit, String destUnit, IChangeTemperature calculator) {
		this.sourceUnit = sourceUnit;
		this.destUnit = destUnit;
		this.calculator = calculator;
	}

	public String getSourceUnit() {
		return this.sourceUnit;
	}

	public String getDestinationUnit() {
		return this.destUnit;
	}

	public TemperatureUnits getEnumBySourceDestUnit(String sourceUnit, String destUnit) {
		return TemperatureUnits.valueOf(sourceUnit + "_" + destUnit);
	}

	public double getCalculatedTemperature(double inputValue) {
		return calculator.changeTemperature(inputValue);
	}

	public static void main(String[] args) {
		TemperatureUnits valueOf = TemperatureUnits.valueOf("CELSIUS" + "_" + "FARENHEIT");
		System.out.println(valueOf.name());
		double changeTemperature = valueOf.getCalculatedTemperature(35.67);
		System.out.println(changeTemperature);
	}

}
