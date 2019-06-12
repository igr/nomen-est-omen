package com.oblac.nomen;

import com.oblac.nomen.fixture.TestNomen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class NomenTest {

	@Test
	void testShortName() {
		String name = new TestNomen().adjective().person().get();
		assertEquals("adj_person", name);
	}

	@Test
	void testShortName_count() {
		Nomen nomen = new TestNomen().adjective().person().count(1);

		assertEquals("adj_person1", nomen.get());
		assertEquals("adj_person2", nomen.get());
	}

	@Test
	void testShortName_withSeparator() {
		String name = new TestNomen().adjective().person().withSeparator("-").get();
		assertEquals("adj-person", name);
	}

	@Test
	void testLiteral() {
		String name = new TestNomen().adjective().literal("xxxx").person().color().get();
		assertEquals("adj_xxxx_person_col", name);
	}

	@Test
	void testUsage() {
		String name = new TestNomen().adjective().superb().person().pokemon().get();
		assertEquals("adj_sup_person_pokemon", name);

		Nomen uidgen = new TestNomen().adjective().superb().person().pokemon();
		assertEquals("adj_sup_person_pokemon", uidgen.get());
	}

	@Test
	void testUppercase() {
		String name = new TestNomen().adjective().superb().person().pokemon().withCasing(Casing.UPPERCASE).get();
		assertEquals("ADJ_SUP_PERSON_POKEMON", name);
	}

	@Test
	void testCapitalize() {
		String name = new TestNomen().adjective().superb().person().pokemon().withCasing(Casing.CAPITALIZE).get();
		assertEquals("Adj_Sup_Person_Pokemon", name);
	}

	@Test
	void testLowercase() {
		String name = new TestNomen().adjective().superb().person().pokemon().withCasing(Casing.LOWERCASE).get();
		assertEquals("adj_sup_person_pokemon", name);
	}

	@Test
	void testReal() {
		String name = Nomen.est().adjective().superb().person().pokemon().withCasing(Casing.LOWERCASE).get();
		assertNotNull(name);
	}

}
