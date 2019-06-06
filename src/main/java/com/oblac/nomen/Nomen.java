package com.oblac.nomen;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Random name generator.
 */
public class Nomen {

	protected List<Supplier<String>> template = new ArrayList<>();

	protected final Supplier<String> ADJECTIVES = () -> valueOf(Adjectives.LIST);
	protected final Supplier<String> COLORS = () -> valueOf(Colors.LIST);
	protected final Supplier<String> PEOPLE = () -> valueOf(People.LIST);
	protected final Supplier<String> POKEMON = () -> valueOf(Pokemon.LIST);
	protected final Supplier<String> SUPERB = () -> valueOf(Superb.LIST);

	protected String space = "-";
	protected String separator = "_";
	protected Casing casing = Casing.LOWERCASE;

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
		separator();
		template.add(ADJECTIVES);
		return this;
	}

	public Nomen literal(final String literal) {
		separator();
		template.add(() -> literal);
		return this;
	}

	/**
	 * Uses random color name.
	 */
	public Nomen color() {
		separator();
		template.add(COLORS);
		return this;
	}

	/**
	 * Uses random person name.
	 */
	public Nomen person() {
		separator();
		template.add(PEOPLE);
		return this;
	}

	/**
	 * Uses pokemon name.
	 */
	public Nomen pokemon() {
		separator();
		template.add(POKEMON);
		return this;
	}

	/**
	 * Uses random superb name.
	 */
	public Nomen superb() {
		separator();
		template.add(SUPERB);
		return this;
	}

	/**
	 * Defines the separator between the names.
	 */
	public Nomen withSeparator(String separator) {
		this.separator = separator;
		return this;
	}

	/**
	 * Defines the space replacement string.
	 */
	public Nomen withSpace(String space) {
		this.space = space;
		return this;
	}

	/**
	 * Defines one of the casings.
	 */
	public Nomen withCasing(Casing casing) {
		this.casing = casing;
		return this;
	}

	/**
	 * Uses count value if greater then zero.
	 */
	public Nomen count(int startValue) {
		final AtomicInteger counter = new AtomicInteger(startValue);
		template.add(() -> String.valueOf(counter.getAndIncrement()));
		return this;
	}

	/**
	 * Generates name based on given template.
	 */
	public String get() {
		String name = template.stream().map(Supplier::get).collect(Collectors.joining());

		name = replace(name, " ", space);

		return name;
	}


	/**
	 * Returns short random name that consist of an adjective and human name.
	 */
	public static String randomName() {
		return Nomen.est().adjective().person().get();
	}

	/**
	 * Returns short random name that consist of an adjective, human name and
	 * optional count.
	 */
	public static String randomName(int no) {
		return Nomen.est().adjective().person().count(no).get();
	}

	/**
	 * Force usage of separator.
	 */
	public Nomen separator() {
		if (!template.isEmpty()) {
			template.add(() -> separator);
		}
		return this;
	}

	/**
	 * Stolen from Jodd (http://jodd.org).
	 */
	private static String replace(String s, String sub, String with) {
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1) {
			return s;
		}
		int sLen = s.length();
		StringBuilder buf = new StringBuilder(sLen + with.length());
		do {
			buf.append(s, c, i);
			buf.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < sLen) {
			buf.append(s, c, sLen);
		}
		return buf.toString();
	}

	/**
	 * Returns random string.
	 * @param list array of strings
	 * @return random string from given array
	 */
	private String valueOf(String... list) {
		int index = RND.nextInt(list.length);

		return casing.apply(list[index]);
	}

	private static final Random RND = new SecureRandom();
}