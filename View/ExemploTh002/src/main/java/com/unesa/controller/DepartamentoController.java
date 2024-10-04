package com.unesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unesa.model.Departamento;
import com.unesa.model.DepartamentoRepository;

@Controller
public class DepartamentoController {
	
	@Autowired
	DepartamentoRepository repositorio;

	@GetMapping("/departamentos")
    public String obterTodos(Model model) {
        model.addAttribute("departamentos", repositorio.findAll());
        return "deptolist";
    }
	
	@GetMapping("/departamentos/excluir")
    public String excluir(Model model, Integer idDepto) {
		try {
		   repositorio.deleteById(idDepto);
		}catch(Exception ex){
		   model.addAttribute("mensagem", 
				   "Erro ao remover departamento. "+
		           "Verifique se não há funcionários associados.");
		   return "home";
		}
        model.addAttribute("departamentos", repositorio.findAll());
        return "deptolist";
    }

	@GetMapping("/departamentos/cadastro")
    public String cadastrar(Model model) {
        model.addAttribute("depto", new Departamento());
        return "deptodata";
    }
	
	@PostMapping("/departamentos/cadastro")
    public String cadastrar(Model model,
    	          @ModelAttribute("depto") Departamento depto) {
		repositorio.save(depto);
        model.addAttribute("departamentos", repositorio.findAll());
        return "deptolist";
    }
	
	@GetMapping("/departamentos/cadastro/{idDepto}")
    public String cadastrar(Model model, 
    		      @PathVariable Integer idDepto) {
		Departamento depto = repositorio.findById(idDepto).get();
        model.addAttribute("depto", depto);
        return "deptodata";
    }

}
