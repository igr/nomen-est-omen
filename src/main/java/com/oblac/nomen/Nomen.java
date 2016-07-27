package com.oblac.nomen;

import java.util.Random;

/**
 * Random name generator.
 */
public class Nomen {

	protected static final char MACRO_A = 'A';
	protected static final char MACRO_C = 'C';
	protected static final char MACRO_P = 'P';
	protected static final char MACRO_S = 'S';
	protected static final char MACRO_COUNT = '.';

	protected String template = "";
	protected String space = "-";
	protected String separator = "_";

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

	public Nomen superb() {
		template += MACRO_S;
		return this;
	}

	/**
	 * Defines the separator between the names.
	 */
	public Nomen separator(String separator) {
		this.separator = separator;
		return this;
	}

	/**
	 * Defines the space replacement string.
	 */
	public Nomen space(String space) {
		this.space = space;
		return this;
	}

	/**
	 * Uses count value if greater then zero.
	 */
	public Nomen count() {
		template += MACRO_COUNT;
		return this;
	}

	public Nomen withCount(int count) {
		return new NomenOmen(this).withCount(count);
	}

	/**
	 * Generates name based on given template.
	 */
	public String get() {
		return new NomenOmen(this).get();
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
		return Nomen.est().adjective().person().count().withCount(no).get();
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