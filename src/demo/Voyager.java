package demo;

import java.util.Objects;

public interface Voyager {
	
	String board(Mount mount);

	default void embark(Journey journey) {
		Objects.requireNonNull(journey);
		System.out.println(String.format("Voyager '%s' embarking on %s", this.getClass().getCanonicalName(), journey.getName()));
	}

}



