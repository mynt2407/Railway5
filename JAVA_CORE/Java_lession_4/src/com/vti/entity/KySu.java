package com.vti.entity;

import java.util.Scanner;

public class KySu extends CanBo {
	private String trainingIndustry;

	// Cach 1:

	public KySu(String name, byte age, String sex, String trainingIndustry) {
		super(name, age, sex);
		this.trainingIndustry = trainingIndustry;
	}
	
	// cach 2: Scanner

	public KySu() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào công việc phân công: ");
		this.trainingIndustry = scanner.nextLine();
	}

	public String getTrainingIndustry() {
		return trainingIndustry;
	}



	@Override
	public String toString() {
		String result = super.toString();
		result += "Cap bac: " + trainingIndustry + "\n";
		return result;
	}
}
