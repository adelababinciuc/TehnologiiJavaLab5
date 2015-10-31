package model;

public class Lecturer {

	private String name;
	private String specialization;
	
	public Lecturer() {
	}

	public Lecturer(String name, String specialization) {

		this.name = name;
		this.specialization = specialization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
}
