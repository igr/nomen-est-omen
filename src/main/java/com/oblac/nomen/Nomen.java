package com.oblac.nomen;

import com.oblac.nomen.data.Adjectives;
import com.oblac.nomen.data.Animals;
import com.oblac.nomen.data.Colors;
import com.oblac.nomen.data.Nouns;
import com.oblac.nomen.data.People;
import com.oblac.nomen.data.Pokemon;
import com.oblac.nomen.data.Superb;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Random name generator.
 */
public class Nomen {

	protected LinkedList<Supplier<String>> template = new LinkedList<>();

	protected final Supplier<String> ADJECTIVES = () -> randomValueFrom(Adjectives.LIST);
	protected final Supplier<String> ANIMALS = () -> randomValueFrom(Animals.LIST);
	protected final Supplier<String> COLORS = () -> randomValueFrom(Colors.LIST);
	protected final Supplier<String> NOUNS = () -> randomValueFrom(Nouns.LIST);
	protected final Supplier<String> PEOPLE = () -> randomValueFrom(People.LIST);
	protected final Supplier<String> POKEMON = () -> randomValueFrom(Pokemon.LIST);
	protected final Supplier<String> SUPERB = () -> randomValueFrom(Superb.LIST);

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
	 * Appends an adjective.
	 */
	public Nomen adjective() {
		template.add(ADJECTIVES);
		return this;
	}

	/**
	 * Appends literal value.
	 */
	public Nomen literal(final String literal) {
		template.add(() -> literal);
		return this;
	}

	public Nomen random(final List<String> strings) {
		template.add(() -> randomValueFrom(strings));
		return this;
	}
	public Nomen random(final String... strings) {
		template.add(() -> randomValueFrom(strings));
		return this;
	}

	/**
	 * Appends color name.
	 */
	public Nomen color() {
		template.add(COLORS);
		return this;
	}

	/**
	 * Appends person name.
	 */
	public Nomen person() {
		template.add(PEOPLE);
		return this;
	}

	/**
	 * Uses pokemon name.
	 */
	public Nomen pokemon() {
		template.add(POKEMON);
		return this;
	}

	/**
	 * Appends pokemon name.
	 */
	public Nomen animal() {
		template.add(ANIMALS);
		return this;
	}

	/**
	 * Append a noun.
	 */
	public Nomen noun() {
		template.add(NOUNS);
		return this;
	}

	/**
	 * Appends a superb name.
	 */
	public Nomen superb() {
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
	 * Appends a count.
	 */
	public Nomen count(int startValue) {
		final AtomicInteger counter = new AtomicInteger(startValue);

		if (template.isEmpty()) {
			template.add(() -> String.valueOf(counter.getAndIncrement()));
		}
		else {
			final Supplier lastSupplier = template.removeLast();
			template.add(() ->  lastSupplier.get() + String.valueOf(counter.getAndIncrement()));
		}

		return this;
	}

	/**
	 * Generates name based on given template.
	 */
	public String get() {
		return template.stream()
			.map(Supplier::get)
			.map(s -> casing.apply(s))
			.map(s -> replace(s, " ", space))
			.collect(Collectors.joining(separator));
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
	private String randomValueFrom(String... list) {
		final int index = RND.nextInt(list.length);

		return list[index];
	}
	private String randomValueFrom(List<String> list) {
		final int index = RND.nextInt(list.size());

		return list.get(index);
	}

	private static final Random RND = new Random();
}