package com.luxo.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(@Validated CadastroMoto novaMoto, Errors errors , RedirectAttributes attributes) {
		ModelAndView mv =  new ModelAndView("Motos");
		
		if(errors.hasErrors()) {
			return "Motos" ;
		}
		
		mv.addObject("mensagem", "Moto salva");

		motos.save(novaMoto);
		attributes.addFlashAttribute("mensagem", "Moto Salva com sucesso!!!");

		return "redirect:/moto";
	}
	
	@RequestMapping( value = "/agencia")
	public ModelAndView ListarTodasMotos() {
		List<CadastroMoto> todasMotos = motos.findAll();
		ModelAndView mv = new ModelAndView("Agencia");
		mv.addObject("motos", todasMotos);
		return mv;
	}
	
	@RequestMapping("/motoEdicao/{codigo}")
	public ModelAndView editar(@PathVariable ("codigo") Long codigo) {
		ModelAndView mv = new ModelAndView("Motos");
		Optional<CadastroMoto> moto = motos.findById(codigo);
		mv.addObject(moto.get());
		return mv ;
	}
	

	
	@RequestMapping(value = "/agencia/delete/{codigo}", method = RequestMethod.GET)
	public String excluir(@PathVariable Long codigo) {
			motos.deleteById(codigo);
	
		return "redirect:/agencia";
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
