package com.discursive.cjcook.guava.collect;

import com.google.common.collect.MapConstraint;

public class PersonConstraint implements MapConstraint<String, Person> {

	@Override
	public void checkKeyValue(String key, Person value) {
		String regex = "^(?!000)([0-6]\\d{2}|7([0-6]\\d|7[012]))([ -]?)"
				+ "(?!00)\\d\\d\\3(?!0000)\\d{4}$";

		if (!key.matches(regex)) {
			throw new IllegalArgumentException(
					"Key not a valid Social Security Number");
		}

		if (value == null) {
			throw new IllegalArgumentException("Person cannot be null");
		} else if (value != null
				&& (value.getFirstName() == null || value.getLastName() == null)) {
			throw new IllegalArgumentException(
					"Person must have a non-empty first and last name");
		}
	}

}
