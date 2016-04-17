package com.oblac.nomen;

import java.util.Random;

/**
 * Random name generator.
 */
public class Nomen {

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
	 */
	protected static String random(String... list) {
		int index = rnd.nextInt(list.length);

		return list[index];
	}

	private static final Random rnd = new Random();
}