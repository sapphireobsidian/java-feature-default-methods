package demo;

import java.util.Objects;

public interface SpaceAdventurer extends Adventurer {

	// Redeclare Adventure.embark default method as abstract
	void embark(Journey journey);
	
	// Override Adventure.embark default method
	default void lodge(Inn inn) {
		Objects.requireNonNull(inn);
		System.out.println(String.format("%s is floating on %s", this.name(), inn.getName()));
	}
	
}


