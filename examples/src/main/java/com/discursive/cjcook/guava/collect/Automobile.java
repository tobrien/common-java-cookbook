package com.discursive.cjcook.guava.collect;

public class Automobile {

	private String make;
	private String model;
	private Integer milesPerGallon;

	public Automobile() {
	}

	public Automobile(String make, String model, Integer milesPerGallon) {
		this.make = make;
		this.model = model;
		this.milesPerGallon = milesPerGallon;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getMilesPerGallon() {
		return milesPerGallon;
	}

	public void setMilesPerGallon(Integer milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}

	@Override
	public String toString() {
		return "Automobile [make=" + make + ", milesPerGallon="
				+ milesPerGallon + ", model=" + model + "]";
	}
	
}
