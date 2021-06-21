package demo;

import java.util.Objects;

public class Mount {

	private String name;

	public Mount(String name) {
		Objects.requireNonNull(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Mount [name=" + name + "]";
	}

}
