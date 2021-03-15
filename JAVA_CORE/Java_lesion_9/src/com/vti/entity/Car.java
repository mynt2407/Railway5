package com.vti.entity;

public class Car {
	String name;
	String type;

	public Car(String name, String type) {

		this.name = name;
		this.type = type;
	}

	public class Enginer {
		String engineType;

		public Enginer(String engineType) {
			this.engineType = engineType;
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}

	}

}
