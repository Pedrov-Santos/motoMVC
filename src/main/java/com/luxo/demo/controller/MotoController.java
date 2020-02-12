package com.luxo.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.luxo.demo.model.CadastroMoto;
import com.luxo.demo.model.StatusAno;
import com.luxo.demo.model.StatusTitulo;
import com.luxo.demo.repository.Motos;

@Controller

public class MotoController {
	
	@Autowired
	private Motos motos;
	
	@RequestMapping("/moto")
	private ModelAndView moto() {
		
		ModelAndView mv =  new ModelAndView("Motos");
		mv.addObject(new CadastroMoto());
		return mv;
		
		
	}
	
	@RequestMapping(value = "/moto" ,method = RequestMethod.POST)
	public ModelAndView salvar(@Validated CadastroMoto novaMoto, Errors errors) {
		ModelAndView mv =  new ModelAndView("Motos");
		
		if(errors.hasErrors()) {
			return mv ;
		}
		
		mv.addObject("mensagem", "Moto salva");
		motos.save(novaMoto);
		return mv;
	}
	
	@RequestMapping("/agencia")
	public ModelAndView ListarTodasMotos() {
		List<CadastroMoto> todasMotos = motos.findAll();
		ModelAndView mv = new ModelAndView("Agencia");
		mv.addObject("motos", todasMotos);
		return mv;
	}
	
	@ModelAttribute("todosAnos")
	public List<StatusAno> todosAnos(){
		return Arrays.asList(StatusAno.values()) ;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		
		return Arrays.asList(StatusTitulo.values());
	}

}
