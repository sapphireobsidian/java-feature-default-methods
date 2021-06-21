package demo;

// Inherits both Adventurer.embark and Voyager.embark causing ambiguity / Diamond Problem
// This class implements an override that designates Voyager.embark as the method to use, thereby resolving the conflict.
public class Priest implements Adventurer, Voyager {

	@Override
	public String name() {
		return "Athelstan";
	}

	// Duplicate default methods named embark with the parameters (Journey) and (Journey) are inherited from the types Voyager and Adventurer
	@Override
	public void embark(Journey journey) {
		Voyager.super.embark(journey);
	}

	@Override
	public String board(Mount mount) {
		return String.format("%s boarding %s", this.getClass().getCanonicalName(), mount.getName());
	}

}



