package com.oblac.nomen.fixture;

import com.oblac.nomen.Nomen;

/**
 * Test version.
 */
public class TestNomen extends Nomen {

	@Override
	protected String random(String... list) {
		return "jodd";
	}
}
