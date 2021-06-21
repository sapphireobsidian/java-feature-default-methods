package demo;

public class Barbarian implements Adventurer {

	@Override
	public String name() {
		return "Conan";
	}

	@Override
	public String board(Mount mount) {
		return String.format("%s boarding %s", this.getClass().getCanonicalName(), mount.getName());
	}

}


