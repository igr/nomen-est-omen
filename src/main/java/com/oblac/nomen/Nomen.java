package com.oblac.nomen;

import java.util.Random;

/**
 * Random name generator.
 */
public class Nomen {

	/**
	 * Returns short random name that consist of an adjective and human name.
	 */
	public static String randomShortName() {
		return randomShortName(0);
	}
	public static String randomShortName(int no) {
		String name = random(Adjectives.LIST) + '_' + random(People.LIST);

		if (no > 0) {
			name += no;
		}

		return name;
	}

	/**
	 * Returns longer random name that consist of an adjective, color and human name.
	 */
	public static String randomName() {
		return randomName(0);
	}
	public static String randomName(int no) {
		String name = random(Adjectives.LIST) + '_' + random(Colors.LIST) + '_' + random(People.LIST);

		if (no > 0) {
			name += no;
		}

		return name;
	}

	/**
	 * Returns random string.
	 * @param list array of strings
	 * @return random string from given array
	 */
	protected static String random(String... list) {
		int index = rnd.nextInt(list.length);

		return list[index];
	}

	private static final Random rnd = new Random();
}