package com.oblac.nomen.fixture;

import com.oblac.nomen.Nomen;

/**
 * Test version.
 */
public class TestNomen extends Nomen {

	@Override
	public Nomen adjective() {
		super.template.add(rnd -> "adj");
		return this;
	}

	@Override
	public Nomen color() {
		super.template.add(rnd -> "col");
		return this;
	}

	@Override
	public Nomen person() {
		super.template.add(rnd -> "person");
		return this;
	}

	@Override
	public Nomen pokemon() {
		super.template.add(rnd -> "pokemon");
		return this;
	}

	@Override
	public Nomen superb() {
		super.template.add(rnd -> "sup");
		return this;
	}

	@Override
	public Nomen superhero() {
		super.template.add(rnd -> "Mrs BAT Marvel III");
		return this;
	}
}
