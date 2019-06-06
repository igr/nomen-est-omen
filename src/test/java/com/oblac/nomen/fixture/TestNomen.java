package com.oblac.nomen.fixture;

import com.oblac.nomen.Nomen;

/**
 * Test version.
 */
public class TestNomen extends Nomen {

	@Override
	public Nomen adjective() {
		separator();
		super.template.add(() -> "adj");
		return this;
	}

	@Override
	public Nomen color() {
		separator();
		super.template.add(() -> "col");
		return this;
	}

	@Override
	public Nomen person() {
		separator();
		super.template.add(() -> "person");
		return this;
	}

	@Override
	public Nomen pokemon() {
		separator();
		super.template.add(() -> "pokemon");
		return this;
	}

	@Override
	public Nomen superb() {
		separator();
		super.template.add(() -> "sup");
		return this;
	}
}
