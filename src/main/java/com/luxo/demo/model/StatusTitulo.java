package com.luxo.demo.model;

public enum StatusTitulo {
		
	VENDIDA("Vendida"),
	PARAVENDA("ParaVenda");
	
	private String descricao;
	
	StatusTitulo(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	
}

