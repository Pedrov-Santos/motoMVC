package com.luxo.demo.model;

public enum StatusAno {

	A(2010),
	B(2011),
	C(2012),
	D(2013),
	E(2014),
	F(2015),
	G(2016),
	H(2017),
	I(2018),
	J(2019),
	K(2020),
	L(2021);
	
	private int ano;
	
	 StatusAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	
}
