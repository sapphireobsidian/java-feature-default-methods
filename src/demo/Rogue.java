package demo;

public class Rogue implements Adventurer {

	@Override
	public String name() {
		return "Xara";
	}

	@Override
	public void embark(Journey journey) {
		System.out.println(String.format("Rouge '%s' shadow stepping on %s", this.name(), journey.getName()));
	}

	@Override
	public String board(Mount mount) {
		return String.format("%s boarding %s", this.getClass().getCanonicalName(), mount.getName());
	}

}
