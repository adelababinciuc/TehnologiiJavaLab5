package model;

public class Project {

	private String title;
	private String description;
	private String coordinator;
	
	public Project() {
	}

	public Project(String title, String description, String coordinator) {
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

	public String getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}
	
}
