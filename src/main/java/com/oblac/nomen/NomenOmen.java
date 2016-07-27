package com.oblac.nomen;

/**
 * Names runtime, generator.
 */
public class NomenOmen extends Nomen {

	private final Nomen nomen;
	private int count;

	NomenOmen(Nomen nomen) {
		this.nomen = nomen;
	}

	/**
	 * Defines runtime variable.
	 */
	@Override
	public NomenOmen withCount(int count) {
		this.count = count;
		return this;
	}

	/**
	 * Generates name based on given template.
	 */
	@Override
	public String get() {
		char[] chars = nomen.template.toCharArray();
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
				case MACRO_S:
					source = Superb.LIST;
					break;
				case MACRO_COUNT:
					if (count > 0) {
						out.append(count);
					}
					break;
				default:
					throw new IllegalArgumentException("Bad boy!");
			}

			if (source != null) {
				if (ndx > 0) {
					out.append(nomen.separator);
				}
				out.append(nomen.random(source));
			}

			ndx++;
		}

		String name = out.toString();

		name = replace(name, " ", nomen.space);

		return name;
	}

	public String replace(String s, String sub, String with) {
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1) {
			return s;
		}
		int sLen = s.length();
		StringBuilder buf = new StringBuilder(sLen + with.length());
		do {
			buf.append(s.substring(c, i));
			buf.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < sLen) {
			buf.append(s.substring(c, sLen));
		}
		return buf.toString();
	}

}
