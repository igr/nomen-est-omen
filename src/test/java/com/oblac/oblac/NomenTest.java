package com.oblac.oblac;

import com.oblac.nomen.Nomen;

public class NomenTest {

	public void testShortName() {
		String name = Nomen.randomShortName();

		assert name.contains("_");
	}
}
