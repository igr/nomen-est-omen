package com.oblac.nomen;

import java.util.function.Function;

public enum Casing {
	UPPERCASE(String::toUpperCase),
	CAPITALIZE(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()),
	LOWERCASE(String::toLowerCase);

	private final Function<String, String> casingFunction;
	Casing(Function<String, String> casingFunction) {
		this.casingFunction = casingFunction;
	}

	public String apply(String value) {
		return casingFunction.apply(value);
	}
}
