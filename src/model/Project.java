package model;

public class Project {

	private String title;
	private String description;
	private Lecturer coordinator;
	
	public Project() {
	}

	public Project(String title, String description, Lecturer coordinator) {
		this.title = title;
		this.description = description;
		this.coordinator = coordinator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Lecturer getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Lecturer coordinator) {
		this.coordinator = coordinator;
	}
	
}
