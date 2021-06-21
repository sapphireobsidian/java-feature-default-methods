package demo;

public class Astronaut implements SpaceAdventurer {

	@Override
	public String name() {
		return "Martin";
	}

	@Override
	public void embark(Journey journey) {
		System.out.println(String.format("Astronaut warping to %s", journey.getName()));
	}

	@Override
	public String board(Mount mount) {
		return String.format("%s boarding %s", this.getClass().getCanonicalName(), mount.getName());
	}

}
