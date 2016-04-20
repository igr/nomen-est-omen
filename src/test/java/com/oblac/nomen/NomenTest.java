package com.oblac.nomen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NomenTest {

	@Test
	public void testShortName() {
		String name = new TestNomen().adjective().person().count().get();
		assertEquals("jodd_jodd", name);
	}

	@Test
	public void testShortName_withCount() {
		String name = new TestNomen().adjective().person().count().get(1);
		assertEquals("jodd_jodd1", name);
	}

}
