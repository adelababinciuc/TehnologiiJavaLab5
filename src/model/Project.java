package model;

public class Project {

	private int id;
	private String title;
	private String description;
	private int coordinator;
	
	public Project() {
	}

	public Project(int id, String title, String description, int coordinator) {
		this.title = title;
		this.description = description;
		this.coordinator = coordinator;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
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

	public int getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(int coordinator) {
		this.coordinator = coordinator;
	}
	
}
