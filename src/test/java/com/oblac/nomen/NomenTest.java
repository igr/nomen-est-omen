package com.oblac.nomen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NomenTest {

	@Test
	public void testShortName() {
		String name = new TestNomen().adjective().person().count().get();
		assertEquals("jodd_jodd", name);
	}

	@Test
	public void testShortName_withCount() {
		String name = new TestNomen().adjective().person().count().withCount(1).get();
		assertEquals("jodd_jodd1", name);
	}

	@Test
	public void testUsage() {
		String name = Nomen.est().adjective().superb().person().pokemon().get();
		assertNotNull(name);

		Nomen uidgen = Nomen.est().adjective().superb().person().pokemon();
		assertNotNull(uidgen.get());
	}

}
