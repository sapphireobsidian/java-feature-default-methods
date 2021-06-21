package demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

// Virtual extension or defender methods
// declare a non-abstract method inside the interface
// diamond problem
// should not be the first option
public class TryFeatureDefaultMethod {

	public static void main(String[] args) {
		
		tryDefaultMethodInIterableForEach();
		
		tryDefaultMethodInCollectionStream();
		
		tryDefaultMethod();

		tryOverrideDefaultMethod();
		
		tryOverrideDefaultMethodToResolveDiamondProblem();

		tryRedeclareDefaultMethodAsAbstractOnChildInterface();
		
		tryOverrideDefaultMethodOnChildInterface();
		
		tryImplementAbstractMethodFromMultipleInterfaces();
		
	}
	
	// Default Method in Iterable For Each
	private static  void tryDefaultMethodInIterableForEach() {
		System.out.println("> TryDefaultMethod (Iterable)");
		{
			List<String> list = Arrays.asList("apple", "orange", "kiwi");
			Iterable<String> iterable = list;
			iterable.forEach(System.out::print);
			System.out.println();
			list.forEach(System.out::print);
			System.out.println();
		}
		{
			Iterable<String> iterable = Arrays.asList("apple", "orange", "kiwi");
			Consumer<String> consumer = System.out::print;
	        for (String str : iterable) { consumer.accept(str); }
		}
		{
			Iterable<String> iterable = Arrays.asList("apple", "orange", "kiwi");
	        for (String str : iterable) { System.out.print(str); }
		}

	}
	
	// Default Method in Collection Stream
	private static  void tryDefaultMethodInCollectionStream() {
		System.out.println("> TryDefaultMethod (CollectionStream)");
		Collection<String> collection = Arrays.asList("apple", "orange", "kiwi");
		collection.stream().forEach(System.out::print);
		System.out.println();
		StreamSupport.stream(collection.spliterator(), false).forEach(System.out::print);
		System.out.println();
	}
	
	// Calls default method embark
	private static  void tryDefaultMethod() {
		System.out.println("> TryDefaultMethod");
		Journey journey = new Journey("The Phoenix on the Sword");
		Adventurer adventurer = new Barbarian();
		adventurer.embark(journey);
	}
	
	// Overrides default method embark on implementing class Rogue
	private static  void tryOverrideDefaultMethod() {
		System.out.println("> TryOverrideDefaultMethod");
		Journey journey = new Journey("The Phoenix on the Sword");
		Adventurer adventurer = new Rogue();
		adventurer.embark(journey);
	}
	
	// Priest inherits both embark on Adventurer and Voyager resulting in Diamond Problem.
	// Problem is resolved by specifying which embark to use via Voyager.super.embark(journey);
	private static  void tryOverrideDefaultMethodToResolveDiamondProblem() {
		System.out.println("> TryOverrideDefaultMethodToResolveDiamondProblem");
		Journey journey = new Journey("The Phoenix on the Sword");
		Adventurer adventurer = new Priest();
		adventurer.embark(journey);
		Voyager voyager = new Priest();
		voyager.embark(journey);
	}

	// Redeclare default method to abstract virtual method
	private static  void tryRedeclareDefaultMethodAsAbstractOnChildInterface() {
		System.out.println("> TryRedeclareDefaultMethodAsAbstractOnChildInterface");
		Journey journey = new Journey("Neptune's Gold");
		SpaceAdventurer adventurer = new Astronaut();
		adventurer.embark(journey);
	}
	
	// Override default method in extending Interface
	private static  void tryOverrideDefaultMethodOnChildInterface() {
		System.out.println("> TryOverrideDefaultMethodOnChildInterface");
		Inn inn = new Inn("Tavern Pluto");
		Adventurer adventurer = new Priest();
		adventurer.lodge(inn);
		SpaceAdventurer spaceadventurer = new Astronaut();
		spaceadventurer.lodge(inn);
	}

	private static void tryImplementAbstractMethodFromMultipleInterfaces() {
		System.out.println("> TryImplementAbstractMethodFromMultipleInterfaces");
		Mount mount = new Mount("Camel");
		Adventurer adventurer = new Priest();
		System.out.println(adventurer.board(mount));
	}
}
