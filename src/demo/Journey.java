package demo;

public class Journey {

	private String name;

	public Journey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Journey [name=" + name + "]";
	}

}
