package com.oblac.nomen;

import com.oblac.nomen.fixture.TestNomen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class NomenTest {

	@Test
	void testShortName() {
		String name = new TestNomen().adjective().person().count().get();
		assertEquals("jodd_jodd", name);
	}

	@Test
	void testShortName_withCount() {
		String name = new TestNomen().adjective().person().count().withCount(1).get();
		assertEquals("jodd_jodd1", name);
	}

	@Test
	void testUsage() {
		String name = Nomen.est().adjective().superb().person().pokemon().get();
		assertNotNull(name);

		Nomen uidgen = Nomen.est().adjective().superb().person().pokemon();
		assertNotNull(uidgen.get());
	}

}
