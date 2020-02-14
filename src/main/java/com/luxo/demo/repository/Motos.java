package com.luxo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxo.demo.model.CadastroMoto;

public interface Motos extends JpaRepository<CadastroMoto, Long> {


}
