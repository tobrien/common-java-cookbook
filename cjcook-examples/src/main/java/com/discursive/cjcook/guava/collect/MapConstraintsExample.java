package com.discursive.cjcook.guava.collect;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.MapConstraints;

public class MapConstraintsExample {

	public static void main(String[] args) {
		Person bill = new Person("Bill", "Clinton", "012-68-4378");
		Person nancy = new Person("Nancy", null, "(212) 232-2332");
		Person richard = new Person("Richard", "Coasby", "000-00-0000");

		Map<String, Person> people = MapConstraints.constrainedMap(
				new HashMap<String, Person>(), new PersonConstraint());

		for (Person person : new Person[] { bill, nancy, richard }) {
			try {
				System.out.printf("Adding %s to Constrained Map\n", person
						.getFirstName());
				people.put(person.getSsn(), person);
				System.out.printf("SUCCESS Added %s\n", person.getFirstName());
			} catch (IllegalArgumentException e) {
				System.out.printf("FAILURE Error adding person to Map: %s\n", e
						.getMessage());
			}

		}
	}

}
