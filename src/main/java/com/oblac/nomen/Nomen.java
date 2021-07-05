package com.oblac.nomen;

import com.oblac.nomen.data.Adjectives;
import com.oblac.nomen.data.Animals;
import com.oblac.nomen.data.Colors;
import com.oblac.nomen.data.Nouns;
import com.oblac.nomen.data.People;
import com.oblac.nomen.data.Pokemon;
import com.oblac.nomen.data.Superb;
import com.oblac.nomen.data.Superheroes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Random name generator.
 */
public class Nomen {
	protected LinkedList<Callable<String>> template = new LinkedList<>();

	protected final Callable<String> ADJECTIVES = () -> randomValueFrom(Adjectives.LIST);
	protected final Callable<String> ANIMALS = () -> randomValueFrom(Animals.LIST);
	protected final Callable<String> COLORS = () -> randomValueFrom(Colors.LIST);
	protected final Callable<String> NOUNS = () -> randomValueFrom(Nouns.LIST);
	protected final Callable<String> PEOPLE = () -> randomValueFrom(People.LIST);
	protected final Callable<String> POKEMON = () -> randomValueFrom(Pokemon.LIST);
	protected final Callable<String> SUPERB = () -> randomValueFrom(Superb.LIST);
	protected final Callable<String> SUPERHERO = () -> randomValueFrom(Superheroes.LIST);

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
	 * Appends super-hero name.
	 */
	public Nomen superhero() {
		template.add(SUPERHERO);
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
			final Callable<String> lastSupplier = template.removeLast();
			template.add(() -> lastSupplier.call() + counter.getAndIncrement());
		}

		return this;
	}

	/**
	 * Generates name based on given template.
	 */
	public String get() {
		try {
			ArrayList<String> stringArrayList = new ArrayList<>();
			for (Callable<String> callable : template) {
				String result = fixSpaces(casing.apply(callable.call()));
				stringArrayList.add(result);
			}

			int arraySize = stringArrayList.size();
			StringBuilder stringBuilder = new StringBuilder();

			for(int i = 0; i < arraySize; i++) {
				stringBuilder.append(stringArrayList.get(i));
				if(i < arraySize - 1) {
					stringBuilder.append(separator);
				}
			}

			return stringBuilder.toString();
		} catch (Exception ex) {
			// Ignored
		}

		return null;
	}

	/**
	 * Fix spaces.
	 */
	private String fixSpaces(String name) {
		return replace(name, " ", space);
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