package com.discursive.cjcook.guava.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Constraints;

public class ConstraintsExample {

	public static void main(String[] args) {

		Automobile camry = new Automobile("Toyota", "Camry", 34);
		Automobile hummer = new Automobile("Hummer", "H2", 8);
		Automobile forrester = new Automobile("Subaru", "Forrester", 22);

		List<Automobile> efficientCars = Constraints.constrainedList(
				new ArrayList<Automobile>(), new MPGConstraint(30));
		for (Automobile car : new Automobile[] { camry, hummer, forrester }) {
			try {
				efficientCars.add(car);
				System.out.printf(
						"Added a %s %s to the Efficient Cars List.\n", car
								.getMake(), car.getModel());
			} catch (IllegalArgumentException e) {
				System.out.printf(
						"I'm sorry, but a %s %s is not efficient enough.\n",
						car.getMake(), car.getModel());
			}
		}
	}

}
