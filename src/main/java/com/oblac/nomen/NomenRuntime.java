package com.oblac.nomen;


public class NomenRuntime extends Nomen {

	private final Nomen nomen;
	private int count;

	NomenRuntime(Nomen nomen) {
		this.nomen = nomen;
	}

	@Override
	public NomenRuntime withCount(int count) {
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

		return out.toString();
	}

}
