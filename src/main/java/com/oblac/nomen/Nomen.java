package com.oblac.nomen;

import java.util.Random;

/**
 * Random name generator.
 */
public class Nomen {

	private static final char MACRO_A = 'A';
	private static final char MACRO_C = 'C';
	private static final char MACRO_P = 'P';
	private static final char MACRO_COUNT = '.';

	private String template = "";
	private String separator = "_";

	/**
	 * Starts with name building.
	 */
	public static Nomen est() {
		return new Nomen();
	}

	/**
	 * Uses random adjective.
	 */
	public Nomen adjective() {
		template += MACRO_A;
		return this;
	}

	/**
	 * Uses random color name.
	 */
	public Nomen color() {
		template += MACRO_C;
		return this;
	}

	/**
	 * Uses random person name.
	 */
	public Nomen person() {
		template += MACRO_P;
		return this;
	}

	/**
	 * Defines the separator.
	 */
	public Nomen separator(String separator) {
		this.separator = separator;
		return this;
	}

	/**
	 * Uses count value if greater then zero.
	 */
	public Nomen count() {
		template += MACRO_COUNT;
		return this;
	}

	/**
	 * Generates name based on given template.
	 */
	public String get() {
		return get(0);
	}

	/**
	 * Generates name based on given template.
	 */
	public String get(int no) {
		char[] chars = template.toCharArray();
		StringBuilder out = new StringBuilder();

		int ndx = 0;

		for (char c : chars) {
			String[] source = null;

			switch (c) {
				case MACRO_A:
					source = Adjectives.LIST;
					break;
				case MACRO_C:
					source = Colors.LIST;
					break;
				case MACRO_P:
					source = People.LIST;
					break;
				case MACRO_COUNT:
					if (no > 0) {
						out.append(no);
					}
					break;
				default:
					throw new IllegalArgumentException("No!");
			}

			if (source != null) {
				if (ndx > 0) {
					out.append(separator);
				}
				out.append(random(source));
			}

			ndx++;
		}

		return out.toString();
	}

	/**
	 * Returns short random name that consist of an adjective and human name.
	 */
	public static String randomName() {
		return randomName(0);
	}

	/**
	 * Returns short random name that consist of an adjective, human name and
	 * optional count.
	 */
	public static String randomName(int no) {
		return Nomen.est().adjective().person().count().get(no);
	}

	/**
	 * Returns random string.
	 * @param list array of strings
	 * @return random string from given array
	 */
	protected String random(String... list) {
		int index = rnd.nextInt(list.length);

		return list[index];
	}

	private static final Random rnd = new Random();
}