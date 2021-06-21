package demo;

import java.util.Objects;

public interface Adventurer {

	String name();
	
	String board(Mount mount);
	
	default void embark(Journey journey) {
		Objects.requireNonNull(journey);
		System.out.println(String.format("%s embarking on %s", this.name(), journey.getName()));
	}
	
	default void lodge(Inn inn) {
		Objects.requireNonNull(inn);
		System.out.println(String.format("%s is resting on %s", this.name(), inn.getName()));
	}
	
	static void validate(Journey journey) {
		Objects.requireNonNull(journey);
		if (journey.getName().length() < 3) {
			throw new IllegalArgumentException("Journey Name must be at least 3 characters.");
		}
	}

}

