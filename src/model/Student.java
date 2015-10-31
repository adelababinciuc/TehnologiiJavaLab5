package model;

public class Student {

	private String id;
	private String name;
	private String cnp;
	private String placeOfBirth;
	
	public Student() {
	}

	public Student(String id, String name, String cnp, String placeOfBirth) {
		this.id = id;
		this.name = name;
		this.cnp = cnp;
		this.placeOfBirth = placeOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
