package model;

public class Student {

	private int id;
	private String name;
	private String cnp;
	private String placeOfBirth;
	
	public Student() {
	}

	public Student(int id, String name, String cnp, String placeOfBirth) {
		this.id = id;
		this.name = name;
		this.cnp = cnp;
		this.placeOfBirth = placeOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	
	
}
