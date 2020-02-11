package com.luxo.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;


@Entity
public class CadastroMoto {
	
	@NotEmpty(message = "Descrição obrigatoria.")
	@Size( max = 60, message = "A descrição não pode conter mais de 60 caracteres")
	private String modelo;
	
	
	private StatusAno ano;
	
	@NotNull(message = "Valor não pode ser nulo.")
	@DecimalMin(value = "0.01", message ="Valor minimo R$ 0,01.")
	@DecimalMax(value = "999999999.99", message ="Valor máximo é de R$ 999.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorVenda;
	
	@Enumerated(EnumType.STRING)
	private StatusTitulo status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public StatusAno getAno() {
		return ano;
	}

	public void setAno(StatusAno ano) {
		this.ano = ano;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public StatusTitulo getStatus() {
		return status;
	}

	public void setStatus(StatusTitulo status) {
		this.status = status;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
}
