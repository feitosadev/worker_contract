package model.entities;

public class Department {

	private String name;
	
	public Department() {
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}