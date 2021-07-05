package com.oblac.nomen;

public enum Casing {
	UPPERCASE,
	CAPITALIZE,
	LOWERCASE;

	public String apply(String value) {
		switch (this) {
			case UPPERCASE: {
				return value.toUpperCase();
			}
			case CAPITALIZE: {
				return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
			}
			case LOWERCASE: {
				return value.toLowerCase();
			}
		}

		return null;
	}
}
